package eleme.openapi.demo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.entity.other.OMessage;
import eleme.openapi.sdk.api.entity.shop.OShop;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.json.gson.Gson;
import eleme.openapi.sdk.api.service.OrderService;
import eleme.openapi.sdk.api.service.ShopService;
import eleme.openapi.sdk.api.service.UserService;
import eleme.openapi.sdk.api.utils.CallbackValidationUtil;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.utils.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class HttpServerDemo {

    private static Gson gson = new Gson();

    private static Config config = null;

    private static Token token = null;

    private static OAuthClient client = null;
    // 设置是否沙箱环境
    private static final boolean isSandbox = true;

    // 设置APP KEY
    private static final String key = "your app key";

    // 设置APP SECRET
    private static final String secret = "your app secret";

    // 回调地址
    private static String callbackUrl = "your callback url";

    private static String scope = "all";

    private static String state = "";

    static {
        config = new Config(isSandbox, key, secret);
        client = new OAuthClient(config);
        token = client.getTokenByCode("", "");
    }

    public static void main(String[] args) {
        try {
            start(8899);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start(Integer port) throws IOException {
        InetSocketAddress address = new InetSocketAddress(port);
        HttpServer server = HttpServer.create(address, 0);
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
                    if (token == null || !token.isSuccess()) {
                        rResult.setOAuthUrl(client.getAuthUrl(callbackUrl, scope, state));
                        result.setResult(rResult);
                        String resultJson = gson.toJson(result);
                        response(t, resultJson);
                        return;
                    }
                    ShopService shopService = new ShopService(config, token);
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
                Token token = client.getTokenByCode(code, callbackUrl);
                if (!token.isSuccess()) {
                    System.out.println(token.getError());
                    System.out.println(token.getError_description());
                }
                UserService userService = new UserService(config, token);
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
            OMessage oMessage = null;
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
                oMessage = gson.fromJson(body.toString(), OMessage.class);
                if (!CallbackValidationUtil.isValidMessage(oMessage, secret)) {
                    throw new Exception("invalid post data : " + body);
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

                //type=10的消息，调用确认订单接口完成接单流程
                if (null != oMessage && oMessage.getType() == 10) {
                    OrderService orderService = new OrderService(config, token);
                    OMessage.Message msg = gson.fromJson(oMessage.getMessage(), OMessage.Message.class);
                    try {
                        OOrder oOrder = orderService.confirmOrder(msg.getOrder_id());
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    private static String rtnHtml() throws IOException {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("page/demo.html");
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
