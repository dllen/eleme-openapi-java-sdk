package eleme.openapi.sdk.oauth;

import eleme.openapi.sdk.oauth.response.ErrorResponse;

import java.util.Map;

/**
 * 请求接口
 */
public interface OAuthRequest<T extends ErrorResponse> {

    /**
     * 获取具体响应实现类的定义。
     */
    public Class<T> getResponseClass() throws OAuthException;

    public Map<String, String> getHeaderMap() throws OAuthException;

    public Map<String, String> getBodyMap() throws OAuthException;

}
