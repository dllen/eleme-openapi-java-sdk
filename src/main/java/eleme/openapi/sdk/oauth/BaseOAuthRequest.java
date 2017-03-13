package eleme.openapi.sdk.oauth;

import eleme.openapi.sdk.config.Constants;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.response.ErrorResponse;
import eleme.openapi.sdk.utils.Base64;
import eleme.openapi.sdk.utils.EleHashMap;

import java.util.Map;

public abstract class BaseOAuthRequest<T extends ErrorResponse> implements OAuthRequest<T> {

    protected Map<String, String> headerMap; // HTTP请求头参数
    protected Map<String, String> bodyMap; // HTTP Body参数
    protected EleHashMap customParams; // 自定义表单参数
    protected OverallContext context = OverallContext.getInstance();

    protected void setAuthorization(String appKey, String appSecret) {
        String headOauthKey = Constants.HEAD_OAUTH_KEY;
        this.putHeaderParam(headOauthKey, this.getBasic(appKey, appSecret));
    }

    public void putHeaderParam(String key, String value) {
        if (headerMap == null) {
            headerMap = new EleHashMap();
        }
        this.headerMap.put(key, value);
    }

    public void putBodyParam(String key, String value) {
        if (bodyMap == null) {
            bodyMap = new EleHashMap();
        }
        this.bodyMap.put(key, value);
    }

    private String getBasic(String appKey, String appSecret) {
        StringBuilder sb = new StringBuilder();
        StringBuilder basicContent = new StringBuilder();
        basicContent.append(appKey).append(":").append(appSecret);
        String encodeToString = Base64.encodeToString(basicContent.toString().getBytes(), false);
        sb.append("Basic").append(" ").append(encodeToString);
        return sb.toString();
    }
}
