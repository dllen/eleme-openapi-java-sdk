package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.response.OAuthResponse;

import java.util.HashMap;
import java.util.Map;

@Service("eleme.order")
public class OrderService extends BaseNopService {
    public OrderService(OAuthResponse oAuthResponse) {
        super(oAuthResponse, OrderService.class);
    }

    public OOrder getOrder(String orderId) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }
}
