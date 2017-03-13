package eleme.openapi.sdk.oauth.request;

import eleme.openapi.sdk.oauth.BaseOAuthRequest;
import eleme.openapi.sdk.oauth.response.OAuthResponse;

import java.util.Map;

public class ClientTokenRequest extends BaseOAuthRequest<OAuthResponse> {

    public Class<OAuthResponse> getResponseClass() {
        return OAuthResponse.class;
    }

    public Map<String, String> getHeaderMap() {
        setAuthorization(context.getApp_key(), context.getApp_secret());
        return super.headerMap;
    }

    public Map<String, String> getBodyMap() {
        putBodyParam("grant_type", "client_credentials");
        return super.bodyMap;
    }

    public Map<String, String> getBodyMap(String appKey) {
        return null;
    }
}
