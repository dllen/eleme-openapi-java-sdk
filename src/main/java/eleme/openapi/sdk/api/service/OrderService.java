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
        return call("eleme.order.getOrder", params);
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
        return call("eleme.order.mgetOrders", params);
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
        return call("eleme.order.confirmOrder", params);
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
        return call("eleme.order.cancelOrder", params);
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
        return call("eleme.order.agreeRefund", params);
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
        return call("eleme.order.disagreeRefund", params);
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
        return call("eleme.order.getDeliveryStateRecord", params);
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
        return call("eleme.order.batchGetDeliveryStates", params);
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
        return call("eleme.order.deliveryBySelf", params);
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
        return call("eleme.order.noMoreDelivery", params);
    }

    /**
     * 订单确认送达
     *
     * @param orderId 订单ID
     * @return 订单
     * @throws ServiceException 服务异常
     */
    public OOrder receivedOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call("eleme.order.receivedOrder", params);
    }

    /**
     * 回复催单
     *
     * @param remindId 催单Id
     * @param type 回复类别
     * @param content 回复内容,如果type为custom,content必填,回复内容不能超过30个字符
     * @throws ServiceException 服务异常
     */
    public void replyReminder(String remindId, ReplyReminderType type, String content) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("remindId", remindId);
        params.put("type", type);
        params.put("content", content);
        call("eleme.order.replyReminder", params);
    }

    /**
     * 获取指定订单菜品活动价格.
     *
     * @param orderId 订单Id
     * @return 菜品价格信息
     * @throws ServiceException 服务异常
     */
    public Map<String,OCommodity> getCommodities(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call("eleme.order.getCommodities", params);
    }

    /**
     * 批量获取订单菜品活动价格
     *
     * @param orderIds 订单Id列表
     * @return 每个订单菜品价格信息
     * @throws ServiceException 服务异常
     */
    public Map<String,Map<String,OCommodity>> mgetCommodities(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call("eleme.order.mgetCommodities", params);
    }

    /**
     * 获取订单退款信息
     *
     * @param orderId 订单Id
     * @return 订单退款信息
     * @throws ServiceException 服务异常
     */
    public ORefundOrder getRefundOrder(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call("eleme.order.getRefundOrder", params);
    }

    /**
     * 批量获取订单退款信息
     *
     * @param orderIds 订单Id列表
     * @return 每个订单的退款信息
     * @throws ServiceException 服务异常
     */
    public Map<String,ORefundOrder> mgetRefundOrders(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call("eleme.order.mgetRefundOrders", params);
    }

    /**
     * 取消呼叫配送
     *
     * @param orderId 订单Id
     * @throws ServiceException 服务异常
     */
    public void cancelDelivery(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        call("eleme.order.cancelDelivery", params);
    }

    /**
     * 呼叫配送
     *
     * @param orderId 订单Id
     * @param fee 小费,1-8之间的整数
     * @throws ServiceException 服务异常
     */
    public void callDelivery(String orderId, Integer fee) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("fee", fee);
        call("eleme.order.callDelivery", params);
    }
}
