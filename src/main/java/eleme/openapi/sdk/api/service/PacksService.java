package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.packs.*;
import eleme.openapi.sdk.api.enumeration.packs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * 签约服务
 */
@Service("eleme.packs")
public class PacksService extends BaseNopService {
    public PacksService(Config config,Token token) {
        super(config, token, PacksService.class);
    }

    /**
     * 查询店铺当前生效合同类型
     *
     * @param shopId 店铺id
     * @return 当前店铺生效的服务包合同类型名称
     * @throws ServiceException 服务异常
     */
    public ShopContract getEffectServicePackContract(Long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call("eleme.packs.getEffectServicePackContract", params);
    }
}
