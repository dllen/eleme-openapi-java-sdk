package eleme.openapi.sdk.config;

import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.utils.StringUtils;

public class OverallContext {

    private static boolean isInit = false;

    private static String app_key;
    private static String app_secret;
    private static String oauthCodeUrl;
    private static String oauthTokenUrl;
    private static String apiUrl;

    public OverallContext(boolean sandbox, String appKey, String appSecret) throws OAuthException {
        if (StringUtils.areNotEmpty(appKey, appKey)) {
            isInit = true;
            System.out.println("init...");
        } else {
            throw new OAuthException("appKey and appSecret is required.");
        }
        app_key = appKey;
        app_secret = appSecret;
        if (sandbox) {
            oauthCodeUrl = BasicURL.OAuth.SANDBOX_AUTHORIZE;
            oauthTokenUrl = BasicURL.OAuth.SANDBOX_TOKEN;
            apiUrl = BasicURL.OpenApi.SANDBOX_Api;
        } else {
            oauthCodeUrl = BasicURL.OAuth.PRODUCTION_AUTHORIZE;
            oauthTokenUrl = BasicURL.OAuth.PRODUCTION_TOKEN;
            apiUrl = BasicURL.OpenApi.PRODUCTION_Api;
        }
    }

    public static void setOauthCodeUrl(String oauthCodeUrl) throws OAuthException {
        check();
        OverallContext.oauthCodeUrl = oauthCodeUrl;
    }

    public static void setOauthTokenUrl(String oauthTokenUrl) throws OAuthException {
        check();
        OverallContext.oauthTokenUrl = oauthTokenUrl;
    }

    public static void setApiUrl(String apiUrl) throws OAuthException {
        check();
        OverallContext.apiUrl = apiUrl;
    }

    public static String getOauthCodeUrl() throws OAuthException {
        check();
        return oauthCodeUrl;
    }

    public static String getOauthTokenUrl() throws OAuthException {
        check();
        return oauthTokenUrl;
    }

    public static String getApiUrl() throws OAuthException {
        check();
        return apiUrl;
    }

    public static String getApp_key() throws OAuthException {
        check();
        return app_key;
    }

    public static String getApp_secret() throws OAuthException {
        check();
        return app_secret;
    }

    private static void check() throws OAuthException {
        if (!isInit) throw new OAuthException("OverallContext is not initialized");
    }
}
