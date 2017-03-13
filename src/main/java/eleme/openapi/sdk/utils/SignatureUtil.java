package eleme.openapi.sdk.utils;

import eleme.openapi.sdk.utils.json.JSONWriter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class SignatureUtil {
    public static String generateSignature(String appKey, String secret, long timestamp, String action, String token, Map<String, Object> parameters) {
        final Map<String, Object> sorted = new TreeMap();
        JSONWriter jsonWriter = new JSONWriter();

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        sorted.put("app_key", appKey);
        sorted.put("timestamp", timestamp);
        StringBuffer string = new StringBuffer();
        for (Map.Entry<String, Object> entry : sorted.entrySet()) {
            string.append(entry.getKey() + "=" + jsonWriter.write(entry.getValue()));
        }

        String splice = String.format("%s%s%s%s", action, token, string, secret);

        System.out.println("splice: " + splice);

        String calculatedSignature = md5(splice);
        return calculatedSignature.toUpperCase();
    }

    public static String md5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignore) {
        }
        md.update(str.getBytes());

        byte byteData[] = md.digest();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
            buffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

        return buffer.toString();
    }

}
