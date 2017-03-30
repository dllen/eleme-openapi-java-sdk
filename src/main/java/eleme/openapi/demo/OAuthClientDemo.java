package eleme.openapi.demo;

import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.response.Token;

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
        OverallContext overallContext = new OverallContext(isSandbox, key, secret);
    }

    public static void main(String[] args) {
        OAuthClientDemo demo = new OAuthClientDemo();
//        demo.clientTokenTest();
//        demo.serverOAuthCodeTest();
//        demo.serverTokenTest();
        demo.serverRefreshTokenTest();
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
        String redirect_uri = "https://69d94230.ngrok.io";
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
        String autoCode = "feb88471de7aa6f8c7289bcc73d93903";
        String redirect_uri = "https://69d94230.ngrok.io";
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
}
