import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.OrderService;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.IOAuthClient;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.impl.DefaultIOAuthClient;
import eleme.openapi.sdk.oauth.impl.ServerOAuthCodeImpl;
import eleme.openapi.sdk.oauth.parser.Converter;
import eleme.openapi.sdk.oauth.parser.JsonConverter;
import eleme.openapi.sdk.oauth.request.ClientTokenRequest;
import eleme.openapi.sdk.oauth.request.ServerRefreshTokenRequest;
import eleme.openapi.sdk.oauth.request.ServerTokenRequest;
import eleme.openapi.sdk.oauth.response.OAuthResponse;
import org.junit.Before;

public class Test {

    private IOAuthClient IOAuthClient = null;


    @Before
    public void before() {
        //设置基础信息
        //Client
        OverallContext context = new OverallContext(true, "wYO4C8ZLzB", "852d028e8af1a1a93019c38351da175c4bc9ecce");
        //Server
//      OverallContext context = new OverallContext(true, "whjJ8amGkn", "ff318ec51ab4d2c179fe603f90a4dbb83fd5d3cb");


    }

    @org.junit.Test
    public void clientTokenTest() throws OAuthException {
        IOAuthClient = new DefaultIOAuthClient(OverallContext.oauthTokenUrl);
        ClientTokenRequest oAuthRequest = new ClientTokenRequest();
        OAuthResponse execute = IOAuthClient.execute(oAuthRequest);
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
                OverallContext.oauthCodeUrl,
                OverallContext.app_key);
        String authUrl = serverOAuthCode.getAuthUrl("https://www.baidu.com",
                "all",
                "xyz");
        System.out.println(authUrl);
    }

    @org.junit.Test
    public void serverTokenTest() throws OAuthException {
        String autoCode = "0a952a361cdf0e18b7da3762b443f373";
        IOAuthClient = new DefaultIOAuthClient(OverallContext.oauthTokenUrl);
        ServerTokenRequest serverTokenRequest = new ServerTokenRequest();
        serverTokenRequest.setCode(autoCode);
        serverTokenRequest.setRedirectUri("https://www.baidu.com");
        OAuthResponse o1 = IOAuthClient.execute(serverTokenRequest);
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
        IOAuthClient = new DefaultIOAuthClient(OverallContext.oauthTokenUrl);
        ServerRefreshTokenRequest refreshTokenRequest = new ServerRefreshTokenRequest();
        refreshTokenRequest.setRefreshToken(refreshTokenStr);
        OAuthResponse o2 = IOAuthClient.execute(refreshTokenRequest);
        System.out.println(o2);
    }


    @org.junit.Test
    public void getOrderApiTest() throws OAuthException, ServiceException {
        //129338804
        String autoCode = "9223d7dc069bf7c31d21ccbdb17de08f";
        IOAuthClient = new DefaultIOAuthClient(OverallContext.oauthTokenUrl);
        ServerTokenRequest serverTokenRequest = new ServerTokenRequest();
        serverTokenRequest.setCode(autoCode);
        serverTokenRequest.setRedirectUri("https://www.baidu.com");
        OAuthResponse o1 = IOAuthClient.execute(serverTokenRequest);
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
