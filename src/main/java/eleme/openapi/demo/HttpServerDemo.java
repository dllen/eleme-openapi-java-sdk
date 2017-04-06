package eleme.openapi.demo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import eleme.openapi.sdk.utils.EleHttpsServer;
import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.entity.other.OMessage;
import eleme.openapi.sdk.api.entity.shop.OShop;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.json.gson.Gson;
import eleme.openapi.sdk.api.service.OrderService;
import eleme.openapi.sdk.api.service.ShopService;
import eleme.openapi.sdk.api.service.UserService;
import eleme.openapi.sdk.api.utils.CallbackValidationUtil;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.utils.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class HttpServerDemo {

    private static Gson gson = new Gson();

    // 设置是否沙箱环境
    private static final boolean isSandbox = true;
    // 设置APPKEY
    private static final String key = "kskFkyn4Kb";
    // 设置APPSECRET
    private static final String secret = "5afbd840d6ac9bb836d325fa41628273";
    // 初始化OAuthClient
    private static OAuthClient client = null;

    private static OverallContext context = null;

    static {
        // 初始化全局配置工具
        /*OverallContext overallContext = new OverallContext(
                isSandbox,
                "whjJ8amGkn",
                "ff318ec51ab4d2c179fe603f90a4dbb83fd5d3cb");*/

        context = new OverallContext(isSandbox, key, secret);
        client = new OAuthClient(context);
    }

    public static void main(String[] args) {
        try {
            start(8899);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start(Integer port) throws IOException {
        com.sun.net.httpserver.HttpsServer server = EleHttpsServer.createServer(port);
        if (server != null) {
            server.createContext("/demo", new DemoHandler());
            server.createContext("/api", new ApiHandler());
            server.createContext("/getInfo", new Shop());
            server.setExecutor(null);
            server.start();
        }
    }

    static class Shop implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            if (t.getRequestMethod().equals("POST")) {
                InputStream is = t.getRequestBody();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuilder body = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    body.append(line);
                }
                GetInfoRequest request = gson.fromJson(body.toString(), GetInfoRequest.class);
                String shopId = request.getShopId();
                ResponseResult result = new ResponseResult();
                ResponseResult.Result rResult = new ResponseResult.Result();
                try {
                    if (client.getToken() == null || !client.getToken().isSuccess()) {
                        rResult.setOAuthUrl(client.getAuthUrl("https://localhost:8899/demo", "all", "123"));
                        result.setResult(rResult);
                        String resultJson = gson.toJson(result);
                        response(t, resultJson);
                        return;
                    }
                    ShopService shopService = new ShopService(context,client.getToken());
                    OShop shop = shopService.getShop(Long.valueOf(shopId));
                    rResult.setShopName(shop.getName());
                    result.setResult(rResult);
                    String resultJson = gson.toJson(result);
                    response(t, resultJson);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class DemoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String query = t.getRequestURI().getQuery();
            String initHtml = rtnHtml();
            if (StringUtils.isEmpty(query)) {
                response(t, initHtml);
                return;
            }
            Map<String, String> stringStringMap = queryToMap(t.getRequestURI().getQuery());
            String code = stringStringMap.get("code");
            if (StringUtils.isEmpty(code)) {
                response(t, initHtml);
                return;
            }

            long userId = 0L;
            String shopName = null;
            try {
                Token token = client.getTokenByCode(code, "https://localhost:8899");
                if (!token.isSuccess()) {
                    System.out.println(token.getError());
                    System.out.println(token.getError_description());
                }
                UserService userService = new UserService(context,token);
                System.out.println(userService.getUser().getUserName());
                userId = userService.getUser().getUserId();
                shopName = userService.getUser().getAuthorizedShops().get(0).getName();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            String responseHtml = initHtml.replace("{{ userId }}", String.valueOf(userId)).replace("{{ shopName }}", shopName);
            System.out.println(initHtml);
            response(t, responseHtml);
        }
    }


    private static void response(HttpExchange t, String responseMsg) {
        try {
            t.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseMsg.getBytes().length);
            OutputStream os = t.getResponseBody();
            os.write(responseMsg.getBytes("UTF-8"));
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ApiHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            int code = 200;
            String response = "ok";
            try {
                if ("GET".equals(t.getRequestMethod())) {
                    return;
                }
                InputStream is = t.getRequestBody();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuilder body = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    body.append(line);
                }
                OMessage message = gson.fromJson(body.toString(), OMessage.class);
                if (!CallbackValidationUtil.isValidMessage(message, secret)) {
                    throw new Exception("invalid post data : " + body);
                }
                //type=10的消息，调用确认订单接口完成接单流程
                if (message.getType() == 10) {
                    OrderService orderService = new OrderService(context,client.getToken());
                    OMessage.Message msg = gson.fromJson(message.getMessage(), OMessage.Message.class);
                    OOrder oOrder = orderService.confirmOrder(msg.getOrder_id());
                }
            } catch (Exception e) {
                e.printStackTrace();
                code = 500;
                response = e.getMessage();
            } finally {
                Map<String, String> responseMap = new HashMap<String, String>();
                responseMap.put("message", response);
                String message = gson.toJson(responseMap);
                t.sendResponseHeaders(code, message.length());
                OutputStream os = t.getResponseBody();
                os.write(message.getBytes());
                os.close();
            }
        }
    }

    private static String rtnHtml() throws IOException {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("page/index.html");
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = resourceAsStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }

    /**
     * returns the url parameters in a map
     *
     * @param query
     * @return map
     */
    private static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }

    private static class ResponseResult {
        private ResponseResult.Result result;

        public ResponseResult.Result getResult() {
            return result;
        }

        public void setResult(ResponseResult.Result result) {
            this.result = result;
        }

        static class Result {
            private String OAuthUrl;
            private String shopName;

            public String getOAuthUrl() {
                return OAuthUrl;
            }

            public void setOAuthUrl(String OAuthUrl) {
                this.OAuthUrl = OAuthUrl;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }
        }
    }

    private static class GetInfoRequest {
        private String userId;
        private String shopId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
        }
    }

}
