import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.OrderService;
import eleme.openapi.sdk.conf.OverallContext;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.impl.DefaultOAuthClient;
import eleme.openapi.sdk.oauth.impl.ServerOAuthCodeImpl;
import eleme.openapi.sdk.oauth.parser.Converter;
import eleme.openapi.sdk.oauth.parser.JsonConverter;
import eleme.openapi.sdk.oauth.request.ClientTokenRequest;
import eleme.openapi.sdk.oauth.request.ServerRefreshTokenRequest;
import eleme.openapi.sdk.oauth.request.ServerTokenRequest;
import eleme.openapi.sdk.oauth.response.OAuthResponse;
import org.junit.Before;

public class Test {

    private OAuthClient oAuthClient = null;
    //设置基础信息
    private OverallContext context = OverallContext.getInstance();

    @Before
    public void before() {
        //Client
//        context.setApp_key("wYO4C8ZLzB");
//        context.setApp_secret("852d028e8af1a1a93019c38351da175c4bc9ecce");

        //Server
        context.setApp_key("whjJ8amGkn");
        context.setApp_secret("ff318ec51ab4d2c179fe603f90a4dbb83fd5d3cb");
        context.setOauthTokenUrl("https://open-api-sandbox-shop.alpha.elenet.me/token");
        context.setApiUrl("https://open-api-sandbox-shop.alpha.elenet.me/api/v1/");
    }

    @org.junit.Test
    public void clientTokenTest() throws OAuthException {
        oAuthClient = new DefaultOAuthClient(
                "https://open-api-sandbox-shop.alpha.elenet.me/token");
        ClientTokenRequest oAuthRequest = new ClientTokenRequest();
        OAuthResponse execute = oAuthClient.execute(oAuthRequest);
        if (execute.isSuccess()) {
            System.out.println(execute);
        } else {
            System.out.println(execute.getError());
            System.out.println(execute.getError_description());
        }
    }

    @org.junit.Test
    public void serverOAuthCodeTest() throws OAuthException {
        ServerOAuthCodeImpl serverOAuthCode = new ServerOAuthCodeImpl(
                "https://open-api-sandbox-shop.alpha.elenet.me/authorize",
                "whjJ8amGkn");
        String authUrl = serverOAuthCode.getAuthUrl("https://www.baidu.com",
                "all",
                "xyz");
        System.out.println(authUrl);
    }

    @org.junit.Test
    public void serverTokenTest() throws OAuthException {
        String autoCode = "0a952a361cdf0e18b7da3762b443f373";
        oAuthClient = new DefaultOAuthClient(
                "https://open-api-sandbox-shop.alpha.elenet.me/token");
        ServerTokenRequest serverTokenRequest = new ServerTokenRequest();
        serverTokenRequest.setCode(autoCode);
        serverTokenRequest.setRedirectUri("https://www.baidu.com");
        OAuthResponse o1 = oAuthClient.execute(serverTokenRequest);
        if (o1.isSuccess()) {
            System.out.println(o1);
        } else {
            System.out.println(o1.getError());
            System.out.println(o1.getError_description());
        }
    }

    @org.junit.Test
    public void serverRefreshTokenTest() throws OAuthException {
        String refreshTokenStr = "331dc23101c75d827d17541365b736cf";
        oAuthClient = new DefaultOAuthClient(
                "https://open-api-sandbox-shop.alpha.elenet.me/token");
        ServerRefreshTokenRequest refreshTokenRequest = new ServerRefreshTokenRequest();
        refreshTokenRequest.setRefreshToken(refreshTokenStr);
        OAuthResponse o2 = oAuthClient.execute(refreshTokenRequest);
        System.out.println(o2);
    }


    @org.junit.Test
    public void getOrderApiTest() throws OAuthException, ServiceException {
        //129338804
        String autoCode = "9223d7dc069bf7c31d21ccbdb17de08f";
        oAuthClient = new DefaultOAuthClient(
                "https://open-api-sandbox-shop.alpha.elenet.me/token");
        ServerTokenRequest serverTokenRequest = new ServerTokenRequest();
        serverTokenRequest.setCode(autoCode);
        serverTokenRequest.setRedirectUri("https://www.baidu.com");
        OAuthResponse o1 = oAuthClient.execute(serverTokenRequest);
        if (o1.isSuccess()) {
            System.out.println(o1.toString());
            OrderService o = new OrderService(o1);
            OOrder order = o.getOrder("101926455156368216");
        } else {
            System.out.println(o1.getError());
            System.out.println(o1.getError_description());
        }
    }


    @org.junit.Test
    public void jsonTest() throws OAuthException {
        Converter converter = new JsonConverter();

        OAuthResponse oAuthResponse = converter.toResponse(
                "{\"access_token\":\"49c6d624dfaaf53f426d09b6a28617ff\", \"token_type\":\"bearer\", \"expires_in\":86400, \"refresh_token\":\"f0a2cf99245383e2a9acfd7d21d74198\"}",
                OAuthResponse.class);

        System.out.println(oAuthResponse);
    }

}
