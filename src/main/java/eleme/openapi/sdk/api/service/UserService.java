package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.user.*;
import eleme.openapi.sdk.api.enumeration.user.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.user")
public class UserService extends BaseNopService {
    public UserService(Config config,Token token) {
        super(config, token, UserService.class);
    }

    /**
     * 获取商户账号信息
     *
     * @return OUser
     * @throws ServiceException
     */
    public OUser getUser() throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        return call(params);
    }
}
