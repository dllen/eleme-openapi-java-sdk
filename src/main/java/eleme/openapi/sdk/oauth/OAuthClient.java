package eleme.openapi.sdk.oauth;

import eleme.openapi.sdk.oauth.response.ErrorResponse;

public interface OAuthClient {
    <T extends ErrorResponse> T execute(OAuthRequest<T> request) throws OAuthException;
}
