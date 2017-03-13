package eleme.openapi.sdk.conf;

public class OverallContext {
    private static class OverallContextHolder {
        private static final OverallContext INSTANCE = new OverallContext();
    }

    private OverallContext() {
    }

    public static final OverallContext getInstance() {
        return OverallContextHolder.INSTANCE;
    }

    private boolean sandbox;
    private String app_key;
    private String app_secret;
    private String oauthCodeUrl;
    private String oauthTokenUrl;
    private String apiUrl;

    public boolean isSandbox() {
        return sandbox;
    }

    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getApp_secret() {
        return app_secret;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret;
    }

    public String getOauthCodeUrl() {
        return oauthCodeUrl;
    }

    public void setOauthCodeUrl(String oauthCodeUrl) {
        this.oauthCodeUrl = oauthCodeUrl;
    }

    public String getOauthTokenUrl() {
        return oauthTokenUrl;
    }

    public void setOauthTokenUrl(String oauthTokenUrl) {
        this.oauthTokenUrl = oauthTokenUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
