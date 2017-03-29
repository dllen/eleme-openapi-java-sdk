import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.response.Token;
import org.junit.Before;

public class Test {

    private OAuthClient client = OAuthClient.INSTANCE;

    @Before
    public void before() {
        //设置基础信息
        //Client
        try {
            //个人
//            OverallContext context = new OverallContext(true, "wYO4C8ZLzB", "852d028e8af1a1a93019c38351da175c4bc9ecce");
            //企业
//            OverallContext context = new OverallContext(true, "orpiSPZphl", "2620115fc8e1bcb2074d16e46c7115f5");
            OverallContext context = new OverallContext(false, "kskFkyn4Kb", "5afbd840d6ac9bb836d325fa41628273");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Server
    }

    /**
     * 客户端(个人)获取Token
     *
     * @throws OAuthException
     */
    public void clientTokenTest() throws OAuthException {
        Token execute = client.getTokenInClientCredentials();
        if (execute.isSuccess()) {
            System.out.println(execute);
        } else {
            System.out.println(execute.getError());
            System.out.println(execute.getError_description());
        }
    }

    /**
     * 服务端(企业)获取授权URL
     *
     * @throws OAuthException
     */
    @org.junit.Test
    public void serverOAuthCodeTest() throws OAuthException {
        String redirect_uri = "https://69d94230.ngrok.io";
        String scope = "all";
        String state = "xyz";
        String authUrl = client.getAuthUrl(redirect_uri, scope, state);
        System.out.println(authUrl);
    }

    /**
     * 授权码(企业)模式获取Token
     *
     * @throws OAuthException
     */
    @org.junit.Test
    public void serverTokenTest() throws OAuthException {
        String autoCode = "feb88471de7aa6f8c7289bcc73d93903";
        String redirect_uri = "https://69d94230.ngrok.io";
        Token o1 = client.getTokenByCode(autoCode, redirect_uri);

        if (o1.isSuccess()) {
            System.out.println(o1);
        } else {
            System.out.println(o1.getError());
            System.out.println(o1.getError_description());
        }
    }

    /**
     * 授权码(企业)模式刷新Token
     *
     * @throws OAuthException
     */
    @org.junit.Test
    public void serverRefreshTokenTest() throws OAuthException {
        String refreshTokenStr = "331dc23101c75d827d17541365b736cf";
        Token o1 = client.getTokenByRefreshToken(client.getToken().getRefreshToken());
        if (o1.isSuccess()) {
            System.out.println(o1);
        } else {
            System.out.println(o1.getError());
            System.out.println(o1.getError_description());
        }
    }

    public void getApiTest() throws OAuthException, ServiceException {
        //129338804
        //生产test
        //37993774
//        Token o1 = client.getTokenByCode(authCode, redirect_uri);
//        Token o1 = client.getTokenInClientCredentials();
        Token o1 = client.getToken();
        if (o1.isSuccess()) {
            System.out.println(o1.toString());
//            OrderService o = new OrderService(o1);
//            OOrder order = o.getOrder("1200897830718471331");
//            System.out.println(order);

//            UserService u = new UserService(o1);
//            OUser user = u.getUser();
//            System.out.println(user.getUserName());

        } else {
            System.out.println(o1.getError());
            System.out.println(o1.getError_description());
        }
    }

}
