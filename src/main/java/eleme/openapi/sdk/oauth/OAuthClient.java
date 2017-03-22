package eleme.openapi.sdk.oauth;

import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.impl.DefaultIOAuthClient;
import eleme.openapi.sdk.oauth.impl.ServerOAuthCodeImpl;
import eleme.openapi.sdk.oauth.request.ClientTokenRequest;
import eleme.openapi.sdk.oauth.request.ServerRefreshTokenRequest;
import eleme.openapi.sdk.oauth.request.ServerTokenRequest;
import eleme.openapi.sdk.oauth.response.OAuthResponse;
import eleme.openapi.sdk.utils.PropertiesUtils;

import java.util.HashMap;
import java.util.Map;

public class OAuthClient {

    private IOAuthClient ioAuthClient = null;

    private static Map<String, String> tokenMap = new HashMap<String, String>();

    private static class OAuthClientHolder {
        private static final OAuthClient INSTANCE = new OAuthClient();
    }

    private OAuthClient() {
    }

    public static final OAuthClient getInstance() {
        return OAuthClientHolder.INSTANCE;
    }

    /**
     * 客户端授权模式获取Token
     *
     * @return Token信息
     * @throws OAuthException 获取ToKen异常信息
     */
    public OAuthResponse getTokenInClientCredentials() throws OAuthException {
        ioAuthClient = new DefaultIOAuthClient(OverallContext.getOauthTokenUrl());
        ClientTokenRequest oAuthRequest = new ClientTokenRequest();
        OAuthResponse token = ioAuthClient.execute(oAuthRequest);
        setTokenInfo(token);
        return token;
    }

    /**
     * 构造授权URL
     *
     * @param redirect_uri 重定向地址
     * @param scope        申请的权限范围
     * @param state        客户端当前状态
     * @return 授权URL
     * @throws OAuthException 获取ToKen异常信息
     */
    public String getAuthUrl(String redirect_uri, String scope, String state) throws OAuthException {
        ServerOAuthCodeImpl serverOAuthCode = new ServerOAuthCodeImpl(
                OverallContext.getOauthCodeUrl(),
                OverallContext.getApp_key());
        return serverOAuthCode.getAuthUrl(redirect_uri,
                scope,
                state);
    }

    /**
     * 授权码模式获取Token
     *
     * @param authCode     授权码
     * @param redirect_uri 重定向地址
     * @return Token信息
     * @throws OAuthException 获取ToKen异常信息
     */
    public OAuthResponse getTokenByCode(String authCode, String redirect_uri) throws OAuthException {
        ioAuthClient = new DefaultIOAuthClient(OverallContext.getOauthTokenUrl());
        ServerTokenRequest serverTokenRequest = new ServerTokenRequest();
        serverTokenRequest.setCode(authCode);
        serverTokenRequest.setRedirectUri(redirect_uri);
        OAuthResponse token = ioAuthClient.execute(serverTokenRequest);
        setTokenInfo(token);
        return token;
    }

    /**
     * 刷新Token
     *
     * @param refreshToken
     * @return Token信息
     * @throws OAuthException 获取ToKen异常信息
     */
    public OAuthResponse getTokenByRefreshToken(String refreshToken) throws OAuthException {
        ioAuthClient = new DefaultIOAuthClient(OverallContext.getOauthTokenUrl());
        ServerRefreshTokenRequest refreshTokenRequest = new ServerRefreshTokenRequest();
        refreshTokenRequest.setRefreshToken(refreshToken);
        OAuthResponse token = ioAuthClient.execute(refreshTokenRequest);
        setTokenInfo(token);
        return token;
    }

    /**
     * 已获取Token信息后使用
     *
     * @return
     * @throws OAuthException
     */
    public OAuthResponse getToken() throws OAuthException {
        String access_token = PropertiesUtils.getPropValueByKey("access_token");
        String token_type = PropertiesUtils.getPropValueByKey("token_type");
        String expires_in = PropertiesUtils.getPropValueByKey("expires_in");
        String refresh_token = PropertiesUtils.getPropValueByKey("refresh_token");
        if (access_token.isEmpty()) {
            throw new OAuthException("access_token is null");
        }
        OAuthResponse token = new OAuthResponse();
        token.setAccessToken(access_token);
        token.setTokenType(token_type);
        token.setExpires(Long.valueOf(expires_in));
        token.setRefreshToken(refresh_token);
        return token;
    }

    private static void setTokenInfo(OAuthResponse token) {
        if (token.isSuccess()) {
            tokenMap.put("access_token", token.getAccessToken());
            tokenMap.put("token_type", token.getTokenType());
            tokenMap.put("expires_in", String.valueOf(token.getExpires()));
            tokenMap.put("refresh_token", token.getRefreshToken());
            PropertiesUtils.setProps(tokenMap);
        }
    }
}
