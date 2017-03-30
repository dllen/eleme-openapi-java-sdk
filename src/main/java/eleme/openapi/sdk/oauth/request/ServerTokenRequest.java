package eleme.openapi.sdk.oauth.request;

import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.BaseOAuthRequest;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.Map;

public class ServerTokenRequest extends BaseOAuthRequest<Token> {
    private String code;
    private String redirectUri;

    public Class<Token> getResponseClass() {
        return Token.class;
    }

    public Map<String, String> getHeaderMap()  {
        setAuthorization(OverallContext.getApp_key(), OverallContext.getApp_secret());
        return super.headerMap;
    }

    public Map<String, String> getBodyMap()  {
        putBodyParam("grant_type", "authorization_code");
        putBodyParam("code", this.code);
        putBodyParam("redirect_uri", this.redirectUri);
        putBodyParam("client_id", OverallContext.getApp_key());
        return super.bodyMap;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}
