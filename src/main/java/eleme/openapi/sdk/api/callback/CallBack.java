package eleme.openapi.sdk.api.callback;

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
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.response.OAuthResponse;
import eleme.openapi.sdk.utils.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class CallBack {
    private static Gson gson = new Gson();

    private static OAuthClient client = OAuthClient.getInstance();

    static {
        try {
            //个人
//            OverallContext context = new OverallContext(true, "wYO4C8ZLzB", "852d028e8af1a1a93019c38351da175c4bc9ecce");
            //企业
            new OverallContext(true, "whjJ8amGkn", "ff318ec51ab4d2c179fe603f90a4dbb83fd5d3cb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        startServer(8899);
//        System.out.println(rtnHtml());
    }

    private static void startServer(Integer port) throws IOException {
        InetSocketAddress address = new InetSocketAddress(port);
        HttpServer server = HttpServer.create(address, 0);
        server.createContext("/callback", new MyHandler());
        server.createContext("/index", new Demo());
        server.createContext("/getInfo", new Shop());
        server.setExecutor(null);
        server.start();
        System.out.println("server start at: " + address.getAddress() + ":" + address.getPort());
    }

    static class Shop implements HttpHandler{
        @Override
        public void handle(HttpExchange t) throws IOException {
            if (t.getRequestMethod().equals("POST")) {
                InputStream is = t.getRequestBody();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                String line;
                String body = "";
                while ((line = in.readLine()) != null) {
                    body += line;
                }
                GetInfoRequest request = gson.fromJson(body, GetInfoRequest.class);
                String shopId = request.getShopId();
                ResponseResult result = new ResponseResult();
                ResponseResult.Result rResult = new ResponseResult.Result();
                try {
                    ShopService shopService = new ShopService(client.getToken());
                    OShop shop = shopService.getShop(Long.valueOf(shopId));
                    rResult.setShopName(shop.getName());
                    result.setResult(rResult);
                    String resultJson = gson.toJson(result);
                    response(t,resultJson);
                } catch (OAuthException e) {
                    e.printStackTrace();
                    try {
                        rResult.setOAuthUrl(client.getAuthUrl("","",""));
                        result.setResult(rResult);
                        String resultJson = gson.toJson(result);
                        response(t,resultJson);
                    } catch (OAuthException e1) {
                        e1.printStackTrace();
                    }
                } catch (ServiceException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Demo implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String query = t.getRequestURI().getQuery();
            String initHtml = rtnHtml();
            if (StringUtils.isEmpty(query)) {
                response(t, initHtml);
            }
            Map<String, String> stringStringMap = queryToMap(t.getRequestURI().getQuery());
            String code = stringStringMap.get("code");
            if (StringUtils.isEmpty(code)){
                response(t, initHtml);
            }

            OAuthClient client = OAuthClient.getInstance();
            long userId = 0L;
            String shopName = null;
            try {
                OAuthResponse tokenByCode = client.getTokenByCode(code, "https://428fa4ed.ngrok.io");
                UserService userService = new UserService(tokenByCode);
                System.out.println(userService.getUser().getUserName());
                userId = userService.getUser().getUserId();
                shopName = userService.getUser().getAuthorizedShops().get(0).getName();
            } catch (OAuthException e) {
                e.printStackTrace();
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

    static class MyHandler implements HttpHandler {
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
                String body = "";
                while ((line = in.readLine()) != null) {
                    body += line;
                }

                OMessage message = gson.fromJson(body, OMessage.class);
                if (!CallbackValidationUtil.isValidMessage(message)) {
                    throw new Exception("invalid post data : " + body);
                }
                //type=10的消息，调用确认订单接口完成接单流程
                if (message.getType() == 10) {
                    OrderService orderService = new OrderService(client.getToken());
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

    private static class ResponseResult{
        private Result result;

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        static class Result{
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

    private static class GetInfoRequest{
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
