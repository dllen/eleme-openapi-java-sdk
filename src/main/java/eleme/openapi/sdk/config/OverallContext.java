package eleme.openapi.sdk.config;

import eleme.openapi.sdk.utils.StringUtils;

public class OverallContext {

    public static boolean isInit = false;

    public static String app_key;
    public static String app_secret;
    public static String oauthCodeUrl;
    public static String oauthTokenUrl;
    public static String apiUrl;

    public OverallContext(boolean sandbox, String appKey, String appSecret) {
        if (StringUtils.areNotEmpty(appKey, appKey)) {
            isInit = true;
            return;
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
}
