package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.order.*;
import eleme.openapi.sdk.api.enumeration.order.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单服务
 */
@Service("eleme.order")
public class OrderService extends BaseNopService {
    public OrderService(Config config,Token token) {
        super(config, token, OrderService.class);
    }

    /**
     * 获取订单
     *
     * @param orderId 订单Id
     * @return 订单
     * @throws ServiceException 服务异常
     */
    public OOrder getOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 批量获取订单
     *
     * @param orderIds 订单Id的列表
     * @return 订单列表
     * @throws ServiceException 服务异常
     */
    public Map<String,OOrder> mgetOrders(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call(params);
    }

    /**
     * 确认订单
     *
     * @param orderId 订单Id
     * @return 订单
     * @throws ServiceException 服务异常
     */
    public OOrder confirmOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 取消订单
     *
     * @param orderId 订单Id
     * @param type 取消原因
     * @param remark 备注说明
     * @return 订单
     * @throws ServiceException 服务异常
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
     *
     * @param orderId 订单Id
     * @return 订单
     * @throws ServiceException 服务异常
     */
    public OOrder agreeRefund(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 不同意退单/取消单
     *
     * @param orderId 订单Id
     * @param reason 商家不同意退单原因
     * @return 订单
     * @throws ServiceException 服务异常
     */
    public OOrder disagreeRefund(String orderId, String reason) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("reason", reason);
        return call(params);
    }

    /**
     * 获取订单配送记录
     *
     * @param orderId 订单Id
     * @return 配送记录列表
     * @throws ServiceException 服务异常
     */
    public List<ODeliveryRecord> getDeliveryStateRecord(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 批量获取订单最新配送记录
     *
     * @param orderIds 订单Id列表
     * @return 订单配送记录
     * @throws ServiceException 服务异常
     */
    public Map<String,ODeliveryRecord> batchGetDeliveryStates(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call(params);
    }

    /**
     * 配送异常或者物流拒单后选择自行配送
     *
     * @param orderId 订单Id
     * @return 订单
     * @throws ServiceException 服务异常
     */
    public OOrder deliveryBySelf(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }

    /**
     * 配送异常或者物流拒单后选择不再配送
     *
     * @param orderId 订单Id
     * @return 订单
     * @throws ServiceException 服务异常
     */
    public OOrder noMoreDelivery(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call(params);
    }
}
