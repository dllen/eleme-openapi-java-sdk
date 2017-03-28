package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.api.entity.shop.*;
import eleme.openapi.sdk.api.enumeration.shop.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.shop")
public class ShopService extends BaseNopService {
    public ShopService(Token oAuthResponse) {
        super(oAuthResponse, ShopService.class);
    }

    /**
     * 查询店铺信息
     */
    public OShop getShop(long shopId) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call(params);
    }

    /**
     * 更新店铺基本信息
     */
    public OShop updateShop(long shopId, Map<OShopProperty,Object> properties) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("properties", properties);
        return call(params);
    }

    /**
     * 批量获取店铺简要
     */
    public Map<Long,OSimpleShop> mgetShopStatus(List<Long> shopIds) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopIds", shopIds);
        return call(params);
    }
}
