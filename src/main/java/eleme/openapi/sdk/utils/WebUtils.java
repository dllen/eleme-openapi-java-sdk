package eleme.openapi.sdk.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import eleme.openapi.sdk.api.exception.*;
import eleme.openapi.sdk.api.protocol.ErrorPayload;
import eleme.openapi.sdk.api.protocol.ResponsePayload;
import eleme.openapi.sdk.config.Constants;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.oauth.response.Token;

import javax.net.ssl.*;
import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.zip.GZIPInputStream;

public abstract class WebUtils {

    private static final String DEFAULT_CHARSET = Constants.CHARSET_UTF8;
    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";
    static {
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    }
    private static class DefaultTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
    }

    public static String doPost(Config context, String url, Map<String, String> params, int connectTimeout, int readTimeout)
            throws IOException {
        return doPost(context, url, params, DEFAULT_CHARSET, connectTimeout, readTimeout);
    }

    public static String doPost(Config context, String url, Map<String, String> params, String charset, int connectTimeout,
                                int readTimeout) throws IOException {
        return doPost(context, url, params, charset, connectTimeout, readTimeout, null);
    }

    public static String doPost(Config context, String url,
                                Map<String, String> params,
                                String charset,
                                int connectTimeout,
                                int readTimeout,
                                Map<String, String> headerMap) throws IOException {
        String ctype = "application/x-www-form-urlencoded;charset=" + charset;
        String query = buildQuery(params, charset);
        setLogInfo(context, "request: " + query);

        byte[] content = {};
        if (query != null) {
            content = query.getBytes(charset);
        }
        return _doPost(context, url, ctype, content, connectTimeout, readTimeout, headerMap);
    }

    @Deprecated
    public static String doPost(Config context, String url, String ctype, byte[] content, int connectTimeout, int readTimeout)
            throws IOException {
        return _doPost(context, url, ctype, content, connectTimeout, readTimeout, null);
    }

    private static String _doPost(Config context, String url, String ctype, byte[] content, int connectTimeout, int readTimeout,
                                  Map<String, String> headerMap) throws IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        try {
            conn = getConnection(new URL(url), METHOD_POST, ctype, headerMap);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            out = conn.getOutputStream();
            out.write(content);
            rsp = getResponseAsString(conn);
        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        setLogInfo(context, "response: " + rsp);
        return rsp;
    }


    private static byte[] getTextEntry(String fieldName, String fieldValue, String charset) throws IOException {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data;name=\"");
        entry.append(fieldName);
        entry.append("\"\r\nContent-Type:text/plain\r\n\r\n");
        entry.append(fieldValue);
        return entry.toString().getBytes(charset);
    }

    private static byte[] getFileEntry(String fieldName, String fileName, String mimeType, String charset)
            throws IOException {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data;name=\"");
        entry.append(fieldName);
        entry.append("\";filename=\"");
        entry.append(fileName);
        entry.append("\"\r\nContent-Type:");
        entry.append(mimeType);
        entry.append("\r\n\r\n");
        return entry.toString().getBytes(charset);
    }

    public static String doGet(String url, Map<String, String> params) throws IOException {
        return doGet(url, params, DEFAULT_CHARSET);
    }

    public static String doGet(String url, Map<String, String> params, String charset) throws IOException {
        HttpURLConnection conn = null;
        String rsp = null;

        try {
            String ctype = "application/x-www-form-urlencoded;charset=" + charset;
            String query = buildQuery(params, charset);
            conn = getConnection(buildGetUrl(url, query), METHOD_GET, ctype, null);
            rsp = getResponseAsString(conn);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return rsp;
    }

    private static HttpURLConnection getConnection(URL url, String method, String ctype, Map<String, String> headerMap) throws IOException {
        HttpURLConnection conn = null;
        if ("https".equals(url.getProtocol())) {
            SSLContext ctx = null;
            try {
                ctx = SSLContext.getInstance("TLS");
                ctx.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager()}, new SecureRandom());
            } catch (Exception e) {
                throw new IOException(e);
            }
            HttpsURLConnection connHttps = (HttpsURLConnection) url.openConnection();
            connHttps.setSSLSocketFactory(ctx.getSocketFactory());
            connHttps.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;// 默认都认证通过
                }
            });
            conn = connHttps;
        } else {
            conn = (HttpURLConnection) url.openConnection();
        }

        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
        conn.setRequestProperty("Content-Type", ctype);
        conn.setRequestProperty("Accept-Encoding", "gzip");
        conn.setRequestProperty("User-Agent","eleme-openapi-java-sdk");
        if (headerMap != null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return conn;
    }

    private static URL buildGetUrl(String strUrl, String query) throws IOException {
        URL url = new URL(strUrl);
        if (StringUtils.isEmpty(query)) {
            return url;
        }

        if (StringUtils.isEmpty(url.getQuery())) {
            if (strUrl.endsWith("?")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "?" + query;
            }
        } else {
            if (strUrl.endsWith("&")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "&" + query;
            }
        }

        return new URL(strUrl);
    }

    public static String buildQuery(Map<String, String> params, String charset) throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuilder query = new StringBuilder();
        Set<Map.Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (StringUtils.areNotEmpty(name, value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }

                query.append(name).append("=").append(URLEncoder.encode(value, charset));
            }
        }

        return query.toString();
    }

    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        String charset = getResponseCharset(conn.getContentType());
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), charset, conn);
        } else {
            String msg = getStreamAsString(es, charset, conn);
            if (StringUtils.isEmpty(msg)) {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                return msg;
            }
        }
    }

    private static String getStreamAsString(InputStream stream, String charset, HttpURLConnection conn) throws IOException {
        try {
            Reader reader = null;
            if ("gzip".equals(conn.getContentEncoding())) {
                reader = new InputStreamReader(new GZIPInputStream(stream), charset);
            } else {
                reader = new InputStreamReader(stream, charset);
            }

            StringBuilder response = new StringBuilder();
            final char[] buff = new char[1024];
            int read = 0;
            while ((read = reader.read(buff)) > 0) {
                response.append(buff, 0, read);
            }

            return response.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private static String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;

        if (!StringUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtils.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }

        return charset;
    }


    public static String decode(String value) {
        return decode(value, DEFAULT_CHARSET);
    }


    public static String encode(String value) {
        return encode(value, DEFAULT_CHARSET);
    }


    public static String decode(String value, String charset) {
        String result = null;
        if (!StringUtils.isEmpty(value)) {
            try {
                result = URLDecoder.decode(value, charset);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }


    public static String encode(String value, String charset) {
        String result = null;
        if (!StringUtils.isEmpty(value)) {
            try {
                result = URLEncoder.encode(value, charset);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }


    public static Map<String, String> splitUrlQuery(String query) {
        Map<String, String> result = new HashMap<String, String>();

        String[] pairs = query.split("&");
        if (pairs != null && pairs.length > 0) {
            for (String pair : pairs) {
                String[] param = pair.split("=", 2);
                if (param != null && param.length == 2) {
                    result.put(param[0], param[1]);
                }
            }
        }

        return result;
    }

    public static <T> T call(Config context, String action,
                             Map<String, Object> parameters,
                             Token token,
                             Type type
    ) throws ServiceException {
        final long timestamp = System.currentTimeMillis() / 1000;
        final String appKey = context.getApp_key();
        String secret = context.getApp_secret();
        String accessToken = token.getAccessToken();
        String requestId = UUID.randomUUID().toString().toLowerCase();

        System.out.println("requestId: "+ requestId);
        Map<String, Object> requestPayload = new HashMap<String, Object>();
        requestPayload.put("nop", "1.0.0");
        requestPayload.put("id", requestId);
        requestPayload.put("action", action);
        requestPayload.put("token", accessToken);

        Map<String, Object> metasHashMap = new HashMap<String, Object>();
        metasHashMap.put("app_key", appKey);
        metasHashMap.put("timestamp", timestamp);

        requestPayload.put("metas", metasHashMap);
        requestPayload.put("params", parameters);
        String signature = SignatureUtil.generateSignature(appKey, secret, timestamp, action, accessToken, parameters);
        requestPayload.put("signature", signature);

        String requestJson = JSON.toJSONString(requestPayload, SerializerFeature.WriteDateUseDateFormat);
        ResponsePayload responsePayload = doRequest(context, requestJson);

        setLogInfo(context, "request: " + requestJson);
        if (responsePayload != null && null != responsePayload.getError()) {
            ServiceException serviceException = toException(responsePayload.getError());
            if (serviceException != null) {
                setLogError(context, "error: " + serviceException.getMessage());
                throw serviceException;
            }
            throw new ServerErrorException();
        }
        if (type == void.class)
            return null;
        String s2 = JSON.toJSONString(responsePayload.getResult(),SerializerFeature.WriteDateUseDateFormat);
        return JSON.parseObject(s2, type);
    }

    private static ResponsePayload doRequest(Config context, String requestJson) {
        try {
            String response = doPost(context, context.getApiUrl(), "application/json; charset=utf-8", requestJson.getBytes(Constants.CHARSET_UTF8), 15000, 30000);
            setLogInfo(context, "response: " + response);
            return JSON.parseObject(response, ResponsePayload.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ServiceException toException(ErrorPayload error) throws ServiceException {
        String code = error.getCode();
        String message = error.getMessage();
        if ("ACCESS_DENIED".equals(code))
            return new AccessDeniedException(message);
        if ("EXCEED_LIMIT".equals(code))
            return new ExceedLimitException(message);
        if ("INVALID_SIGNATURE".equals(code))
            return new InvalidSignatureException(message);
        if ("INVALID_TIMESTAMP".equals(code))
            return new InvalidTimestampException(message);
        if ("METHOD_NOT_ALLOWED".equals(code))
            return new MethodNotAllowedException(message);
        if ("PERMISSION_DENIED".equals(code))
            return new PermissionDeniedException(message);
        if ("UNAUTHORIZED".equals(code))
            return new UnauthorizedException(message);
        if ("VALIDATION_FAILED".equals(code))
            return new ValidationFailedException(message);
        if (error.getCode().startsWith("BIZ_")) {
            return new BusinessException(error.getCode(), error.getMessage());
        }
        return null;
    }

    private static void setLogInfo(Config context, String msg) {
        if (null != context.getElemeSdkLogger()) {
            context.getElemeSdkLogger().info(msg);
        }
    }

    private static void setLogError(Config context, String msg) {
        if (null != context.getElemeSdkLogger()) {
            context.getElemeSdkLogger().error(msg);
        }
    }
}
