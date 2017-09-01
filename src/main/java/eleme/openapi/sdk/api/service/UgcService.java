package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.ugc.*;
import eleme.openapi.sdk.api.enumeration.ugc.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * 订单评论服务
 */
@Service("eleme.ugc")
public class UgcService extends BaseNopService {
    public UgcService(Config config,Token token) {
        super(config, token, UgcService.class);
    }

    /**
     * 获取指定订单的评论
     *
     * @param orderId 订单id
     * @return 评论信息
     * @throws ServiceException 服务异常
     */
    public OpenapiOrderRate getOrderRateByOrderId(String orderId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        return call("eleme.ugc.getOrderRateByOrderId", params);
    }

    /**
     * 获取指定订单的评论
     *
     * @param orderIds 订单id
     * @return  评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiOrderRate> getOrderRatesByOrderIds(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call("eleme.ugc.getOrderRatesByOrderIds", params);
    }

    /**
     * 获取未回复的评论
     *
     * @param orderIds 订单id
     * @return 未回复的评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiOrderRate> getUnreplyOrderRatesByOrderIds(List<String> orderIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        return call("eleme.ugc.getUnreplyOrderRatesByOrderIds", params);
    }

    /**
     * 获取指定店铺的评论
     *
     * @param shopId  餐厅id
     * @param startTime   开始时间,只能查询最近90天的数据
     * @param endTime   结束时间
     * @param offset 页面偏移量
     * @param pageSize 页面大小
     * @return 评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiOrderRate> getOrderRatesByShopId(String shopId, Date startTime, Date endTime, int offset, int pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        return call("eleme.ugc.getOrderRatesByShopId", params);
    }

    /**
     * 获取指定店铺的评论
     *
     * @param shopIds 店铺id
     * @param startTime   开始时间,只能查询最近90天的数据
     * @param endTime   结束时间
     * @param offset 页面偏移量
     * @param pageSize 页面大小
     * @return  评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiOrderRate> getOrderRatesByShopIds(List<String> shopIds, Date startTime, Date endTime, int offset, int pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopIds", shopIds);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        return call("eleme.ugc.getOrderRatesByShopIds", params);
    }

    /**
     * 获取未回复的评论
     *
     * @param shopIds 店铺id
     * @param startTime   开始时间,只能查询最近90天的数据
     * @param endTime   结束时间
     * @param offset 页面偏移量
     * @param pageSize 页面大小
     * @return   未回复的评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiOrderRate> getUnreplyOrderRatesByShopIds(List<String> shopIds, Date startTime, Date endTime, int offset, int pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopIds", shopIds);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        return call("eleme.ugc.getUnreplyOrderRatesByShopIds", params);
    }

    /**
     * 获取店铺的满意度评价信息
     *
     * @param shopId  餐厅id
     * @param score 满意度,取值范围为1~5，1为最不满意，5为非常满意
     * @param startTime   开始时间,只能查询最近90天的数据
     * @param endTime   结束时间
     * @param offset 页面偏移量
     * @param pageSize 页面大小
     * @return  评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiOrderRate> getOrderRatesByShopAndRating(String shopId, int score, Date startTime, Date endTime, int offset, int pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("score", score);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        return call("eleme.ugc.getOrderRatesByShopAndRating", params);
    }

    /**
     * 获取单个商品的评论
     *
     * @param itemId  商品id
     * @param startTime   开始时间,只能查询最近90天的数据
     * @param endTime   结束时间
     * @param offset 页面偏移量
     * @return  评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiItemRate> getItemRatesByItemId(String itemId, Date startTime, Date endTime, int offset) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("offset", offset);
        return call("eleme.ugc.getItemRatesByItemId", params);
    }

    /**
     * 获取多个商品的评论
     *
     * @param itemIds 商品id
     * @param startTime   开始时间,只能查询最近90天的数据
     * @param endTime   结束时间
     * @param offset 页面偏移量
     * @param pageSize 页面大小
     * @return  评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiItemRate> getItemRatesByItemIds(List<String> itemIds, Date startTime, Date endTime, int offset, int pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        return call("eleme.ugc.getItemRatesByItemIds", params);
    }

    /**
     * 获取多个商品未回复的评论
     *
     * @param itemIds 店铺id
     * @param startTime   开始时间,只能查询最近90天的数据
     * @param endTime   结束时间
     * @param offset 页面偏移量
     * @param pageSize 页面大小
     * @return 未回复的评论信息
     * @throws ServiceException 服务异常
     */
    public List<OpenapiItemRate> getUnreplyItemRatesByItemIds(List<String> itemIds, Date startTime, Date endTime, int offset, int pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        return call("eleme.ugc.getUnreplyItemRatesByItemIds", params);
    }

    /**
     * 回复指定类型的评论
     *
     * @param rateId 评论编号
     * @param replyType 评论类型
     * @param reply 回复的内容
     * @throws ServiceException 服务异常
     */
    public void replyRateByRateId(String rateId, ReplyType replyType, String reply) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("rateId", rateId);
        params.put("replyType", replyType);
        params.put("reply", reply);
        call("eleme.ugc.replyRateByRateId", params);
    }

    /**
     * 回复指定类型的评论
     *
     * @param rateIds  评论编号
     * @param replyType 评论类型
     * @param reply 回复的内容
     * @throws ServiceException 服务异常
     */
    public void replyRateByRateIds(List<String> rateIds, ReplyType replyType, String reply) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("rateIds", rateIds);
        params.put("replyType", replyType);
        params.put("reply", reply);
        call("eleme.ugc.replyRateByRateIds", params);
    }

    /**
     * 回复订单未回复的评论
     *
     * @param orderId 订单id
     * @param reply 回复内容
     * @throws ServiceException 服务异常
     */
    public void replyRateByOrderId(String orderId, String reply) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("reply", reply);
        call("eleme.ugc.replyRateByOrderId", params);
    }

    /**
     * 批量回复订单未回复的评论
     *
     * @param orderIds 订单id
     * @param reply 回复信息
     * @throws ServiceException 服务异常
     */
    public void replyCommentByOrderIds(List<String> orderIds, String reply) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderIds", orderIds);
        params.put("reply", reply);
        call("eleme.ugc.replyCommentByOrderIds", params);
    }

    /**
     * 回复商品回复的评论
     *
     * @param itemId 商品id
     * @param reply 回复内容
     * @param startTime   开始时间,只能查询最近90天的数据
     * @param endTime   结束时间
     * @throws ServiceException 服务异常
     */
    public void replyRatesByItemId(String itemId, String reply, Date startTime, Date endTime) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        params.put("reply", reply);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        call("eleme.ugc.replyRatesByItemId", params);
    }

    /**
     * 回复多个商品评论
     *
     * @param itemIds 商品d
     * @param reply 回复信息
     * @param startTime 开始时间,只能查询最近90天的数据
     * @param endTime 结束时间
     * @throws ServiceException 服务异常
     */
    public void replyRatesByItemIds(List<String> itemIds, String reply, Date startTime, Date endTime) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        params.put("reply", reply);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        call("eleme.ugc.replyRatesByItemIds", params);
    }
}
