package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.entity.shop.OShop;
import eleme.openapi.sdk.api.entity.shop.OSimpleShop;
import eleme.openapi.sdk.api.enumeration.shop.OShopProperty;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.shop")
public class ShopService extends BaseNopService {
    public ShopService(OverallContext context, Token token) {
        super(context,token, ShopService.class);
    }

    public OShop getShop(long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call(params);
    }

    public OShop updateShop(long shopId, Map<OShopProperty,Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("properties", properties);
        return call(params);
    }

    public Map<Long,OSimpleShop> mgetShopStatus(List<Long> shopIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopIds", shopIds);
        return call(params);
    }
}
