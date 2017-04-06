package eleme.openapi.demo;

import eleme.openapi.sdk.api.entity.product.OItemIdWithSpecIds;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.ProductService;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.ArrayList;
import java.util.List;

public class OAuthClientDemo {

    // 设置是否沙箱环境
    private static final boolean isSandbox = false;
    // 设置APPKEY
    private static final String key = "kskFkyn4Kb";
    // 设置APPSECRET
    private static final String secret = "5afbd840d6ac9bb836d325fa41628273";
    // 初始化OAuthClient
    private OAuthClient client = OAuthClient.INSTANCE;

    static {
        // 初始化全局配置工具
        //203983896
//        OverallContext overallContext = new OverallContext(isSandbox, key, secret);
        //203984252
        OverallContext overallContext = new OverallContext(true, "orpiSPZphl", "2620115fc8e1bcb2074d16e46c7115f5");
    }

    public static void main(String[] args) {
        OAuthClientDemo demo = new OAuthClientDemo();
//        demo.clientTokenTest();
//        demo.serverOAuthCodeTest();
        demo.serverTokenTest();
//        demo.serverRefreshTokenTest();
    }


    /**
     * 客户端(个人)获取Token
     */
    private void clientTokenTest() {
        Token token = client.getTokenInClientCredentials();
        if (token.isSuccess()) {
            System.out.println(token);
        }else{
            System.out.println("code: " + token.getError());
            System.out.println("desc: " + token.getError_description());
        }
    }

    /**
     * 服务端(企业)获取授权URL
     */
    private void serverOAuthCodeTest() {
        String redirect_uri = "https://localhost:8899";
        String scope = "all";
        String state = "xyz";
        String authUrl = client.getAuthUrl(redirect_uri, scope, state);
        System.out.println(authUrl);
    }

    /**
     * 授权码(企业)模式获取Token
     *
     */
    private void serverTokenTest() {
        String autoCode = "b78a0878c76bf38c41ab6104ebc75e18";
        String redirect_uri = "https://localhost:8899/demo";
        Token token = client.getTokenByCode(autoCode, redirect_uri);
        if (token.isSuccess()) {
            System.out.println(token);
        }else{
            System.out.println("code: " + token.getError());
            System.out.println("desc: " + token.getError_description());
        }
    }

    /**
     * 授权码(企业)模式刷新Token
     *
     */
    private void serverRefreshTokenTest() {
        String refreshTokenStr = "331dc23101c75d827d17541365b736cf";
        Token token = client.getTokenByRefreshToken(client.getToken().getRefreshToken());
        if (token.isSuccess()) {
            System.out.println(token);
        }else{
            System.out.println("code: " + token.getError());
            System.out.println("desc: " + token.getError_description());
        }
    }

    private void testService() throws ServiceException {
        ProductService product = new ProductService(null);
        List<OItemIdWithSpecIds> specIds = new ArrayList<OItemIdWithSpecIds>();
        OItemIdWithSpecIds oItemIdWithSpecIds = new OItemIdWithSpecIds();
        oItemIdWithSpecIds.setItemId(27970000058L);
        List<Long> itemSpecIds = new ArrayList<Long>();
        itemSpecIds.add(72970000221L);
        itemSpecIds.add(72970000222L);
        itemSpecIds.add(72970000225L);
        oItemIdWithSpecIds.setItemSpecIds(itemSpecIds);
        specIds.add(oItemIdWithSpecIds);

        product.batchFillStock(specIds);

    }
}
