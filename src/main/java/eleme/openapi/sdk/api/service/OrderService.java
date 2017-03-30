package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.entity.order.ODeliveryRecord;
import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.enumeration.order.OInvalidateType;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.order")
public class OrderService extends BaseNopService {
    public OrderService(Token oAuthResponse) {
        super(oAuthResponse, OrderService.class);
    }

    /**
     * 获取订单
     */
    public OOrder getOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 批量获取订单
     */
    public Map<String,OOrder> mgetOrders(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call(params);
    }

    /**
     * 确认订单
     */
    public OOrder confirmOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 取消订单
     */
    public OOrder cancelOrder(String orderId, OInvalidateType type, String remark) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("type", type);
        params.put("remark", remark);
        return call(params);
    }

    /**
     * 同意退单/取消单
     */
    public OOrder agreeRefund(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 不同意退单/取消单
     */
    public OOrder disagreeRefund(String orderId, String reason) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("reason", reason);
        return call(params);
    }

    /**
     * 获取订单配送记录
     */
    public List<ODeliveryRecord> getDeliveryStateRecord(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 批量获取订单最新配送记录
     */
    public Map<String,ODeliveryRecord> batchGetDeliveryStates(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call(params);
    }
}
