package eleme.openapi.sdk.config;

import eleme.openapi.sdk.utils.StringUtils;

public class OverallContext {

    private static boolean isInit = false;

    private static String app_key;
    private static String app_secret;
    private static String oauthCodeUrl;
    private static String oauthTokenUrl;
    private static String apiUrl;
    private static ElemeSdkLogger elemeSdkLogger;

    public OverallContext(boolean isSandbox, String appKey, String appSecret)  {
        if (StringUtils.areNotEmpty(appKey, appKey)) {
            isInit = true;
            System.out.println("init OverallContext ...");
        } else {
            System.out.println("appKey and appSecret is required.");
        }
        app_key = appKey;
        app_secret = appSecret;
        if (isSandbox) {
            oauthCodeUrl = BasicURL.OAuth.SANDBOX_AUTHORIZE;
            oauthTokenUrl = BasicURL.OAuth.SANDBOX_TOKEN;
            apiUrl = BasicURL.OpenApi.SANDBOX_Api;
        } else {
            oauthCodeUrl = BasicURL.OAuth.PRODUCTION_AUTHORIZE;
            oauthTokenUrl = BasicURL.OAuth.PRODUCTION_TOKEN;
            apiUrl = BasicURL.OpenApi.PRODUCTION_Api;
        }
    }

    public void setLog(ElemeSdkLogger elemeSdkLogger) {
        OverallContext.elemeSdkLogger = elemeSdkLogger;
    }

    public static ElemeSdkLogger getElemeSdkLogger(){
        return OverallContext.elemeSdkLogger;
    }

    public static void setOauthCodeUrl(String oauthCodeUrl)  {
        check();
        OverallContext.oauthCodeUrl = oauthCodeUrl;
    }

    public static void setOauthTokenUrl(String oauthTokenUrl)  {
        check();
        OverallContext.oauthTokenUrl = oauthTokenUrl;
    }

    public static void setApiUrl(String apiUrl)  {
        check();
        OverallContext.apiUrl = apiUrl;
    }

    public static String getOauthCodeUrl()  {
        check();
        return oauthCodeUrl;
    }

    public static String getOauthTokenUrl()  {
        check();
        return oauthTokenUrl;
    }

    public static String getApiUrl()  {
        check();
        return apiUrl;
    }

    public static String getApp_key()  {
        check();
        return app_key;
    }

    public static String getApp_secret()  {
        check();
        return app_secret;
    }

    private static void check()  {
        if (!isInit) System.out.println("OverallContext is not initialized");
    }
}
