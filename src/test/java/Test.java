import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.entity.user.OUser;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.OrderService;
import eleme.openapi.sdk.api.service.UserService;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.response.OAuthResponse;
import org.junit.Before;

public class Test {

    private OAuthClient client = OAuthClient.getInstance();

    @Before
    public void before() {
        //设置基础信息
        //Client
        try {
            //个人
//            OverallContext context = new OverallContext(true, "wYO4C8ZLzB", "852d028e8af1a1a93019c38351da175c4bc9ecce");
            //企业
            OverallContext context = new OverallContext(true, "whjJ8amGkn", "ff318ec51ab4d2c179fe603f90a4dbb83fd5d3cb");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Server
    }

    @org.junit.Test
    public void clientTokenTest() throws OAuthException {
        OAuthResponse execute = client.getTokenInClientCredentials();
        if (execute.isSuccess()) {
            System.out.println(execute);
        } else {
            System.out.println(execute.getError());
            System.out.println(execute.getError_description());
        }
    }

    @org.junit.Test
    public void serverOAuthCodeTest() throws OAuthException {
        String redirect_uri = "https://www.baidu.com";
        String scope = "all";
        String state = "xyz";
        String authUrl = client.getAuthUrl(redirect_uri, scope, state);
        System.out.println(authUrl);
    }

    public void serverTokenTest() throws OAuthException {
        String autoCode = "0a952a361cdf0e18b7da3762b443f373";
        String redirect_uri = "https://www.baidu.com";
        OAuthResponse o1 = client.getTokenByCode(autoCode, redirect_uri);

        if (o1.isSuccess()) {
            System.out.println(o1);
        } else {
            System.out.println(o1.getError());
            System.out.println(o1.getError_description());
        }
    }

    public void serverRefreshTokenTest() throws OAuthException {
        String refreshTokenStr = "331dc23101c75d827d17541365b736cf";
        OAuthResponse o1 = client.getTokenByRefreshToken(refreshTokenStr);

        if (o1.isSuccess()) {
            System.out.println(o1);
        } else {
            System.out.println(o1.getError());
            System.out.println(o1.getError_description());
        }
    }

    @org.junit.Test
    public void getOrderApiTest() throws OAuthException, ServiceException {
        //129338804
        String authCode = "06f41cbfe305afb1bfbf925459e7fcc2";
        String redirect_uri = "https://www.baidu.com";
//        OAuthResponse o1 = client.getTokenByCode(authCode, redirect_uri);
//        OAuthResponse o1 = client.getTokenInClientCredentials();
        OAuthResponse o1 = client.getToken();
        if (o1.isSuccess()) {
            System.out.println(o1.toString());
            OrderService o = new OrderService(o1);
            OOrder order = o.getOrder("1200897830718471331");
            System.out.println(order);


            UserService u = new UserService(o1);
            OUser user = u.getUser();
            System.out.println(user.getUserName());

        } else {
            System.out.println(o1.getError());
            System.out.println(o1.getError_description());
        }
    }


    public void jsonTest() throws OAuthException {

    }
}
