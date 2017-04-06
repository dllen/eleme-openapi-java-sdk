package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.entity.order.ODeliveryRecord;
import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.enumeration.order.OInvalidateType;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.order")
public class OrderService extends BaseNopService {
    public OrderService(OverallContext context, Token token) {
        super(context, token, OrderService.class);
    }

    public OOrder getOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    public Map<String, OOrder> mgetOrders(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call(params);
    }

    public OOrder confirmOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    public OOrder cancelOrder(String orderId, OInvalidateType type, String remark) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("type", type);
        params.put("remark", remark);
        return call(params);
    }

    public OOrder agreeRefund(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    public OOrder disagreeRefund(String orderId, String reason) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("reason", reason);
        return call(params);
    }

    public List<ODeliveryRecord> getDeliveryStateRecord(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    public Map<String, ODeliveryRecord> batchGetDeliveryStates(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call(params);
    }
}
