package eleme.openapi.sdk.oauth.request;

import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.BaseOAuthRequest;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.Map;

public class ServerRefreshTokenRequest extends BaseOAuthRequest<Token> {

    private String refreshToken;

    public Class<Token> getResponseClass() {
        return Token.class;
    }

    public Map<String, String> getHeaderMap() throws OAuthException {
        setAuthorization(OverallContext.getApp_key(), OverallContext.getApp_secret());
        return super.headerMap;
    }

    public Map<String, String> getBodyMap() throws OAuthException {
        putBodyParam("grant_type", "refresh_token");
        putBodyParam("refresh_token", this.refreshToken);
        return super.bodyMap;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
