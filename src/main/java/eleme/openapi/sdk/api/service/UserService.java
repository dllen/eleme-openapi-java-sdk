package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.entity.user.OUser;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.HashMap;
import java.util.Map;

@Service("eleme.user")
public class UserService extends BaseNopService {
    public UserService(Token oAuthResponse) {
        super(oAuthResponse, UserService.class);
    }

    /**
     * 获取商户账号信息
     */
    public OUser getUser() throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        return call(params);
    }
}