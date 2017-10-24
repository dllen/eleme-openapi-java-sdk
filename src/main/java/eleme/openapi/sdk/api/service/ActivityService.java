package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.activity.*;
import eleme.openapi.sdk.api.enumeration.activity.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * 活动服务
 */
@Service("eleme.activity")
public class ActivityService extends BaseNopService {
    public ActivityService(Config config,Token token) {
        super(config, token, ActivityService.class);
    }

    /**
     * 创建代金券活动
     *
     * @param createInfo 创建代金券活动的结构体
     * @return 创建好的代金券活动Id
     * @throws ServiceException 服务异常
     */
    public Long createCouponActivity(CreateInfo createInfo) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("createInfo", createInfo);
        return call("eleme.activity.coupon.createCouponActivity", params);
    }

    /**
     * 向指定用户发放代金券
     *
     * @param shopId 店铺Id
     * @param couponActivityId 代金券活动Id
     * @param mobiles 需要发放代金券的用户手机号列表
     * @return 代金券发放结果：key(手机号)，value(成功或失败信息)
     * @throws ServiceException 服务异常
     */
    public Map<String,String> giveOutCoupons(Long shopId, Long couponActivityId, List<String> mobiles) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("couponActivityId", couponActivityId);
        params.put("mobiles", mobiles);
        return call("eleme.activity.coupon.giveOutCoupons", params);
    }

    /**
     * 分页查询店铺代金券活动信息
     *
     * @param shopId 店铺Id
     * @param couponActivityType 代金券活动类型
     * @param activityStatus 活动状态
     * @param pageNo 页码（第几页）
     * @param pageSize 每页数量
     * @return 代金券活动信息列表
     * @throws ServiceException 服务异常
     */
    public List<OCouponActivity> queryCouponActivities(Long shopId, CouponActivityType couponActivityType, OActivityStatus activityStatus, Integer pageNo, Integer pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("couponActivityType", couponActivityType);
        params.put("activityStatus", activityStatus);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        return call("eleme.activity.coupon.queryCouponActivities", params);
    }

    /**
     * 分页查询店铺代金券领取详情
     *
     * @param shopId 店铺Id
     * @param couponActivityId 代金券活动Id
     * @param couponStatus 代金券状态
     * @param pageNo 页码（第几页）
     * @param pageSize 每页数量
     * @return 代金券领取详情
     * @throws ServiceException 服务异常
     */
    public ReceivedCouponDetail queryReceivedCouponDetails(Long shopId, Long couponActivityId, CouponStatus couponStatus, Integer pageNo, Integer pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("couponActivityId", couponActivityId);
        params.put("couponStatus", couponStatus);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        return call("eleme.activity.coupon.queryReceivedCouponDetails", params);
    }

    /**
     * 通过店铺Id查询该店铺被邀约的美食活动
     *
     * @param shopId 店铺Id
     * @return 店铺的邀约活动信息列表
     * @throws ServiceException 服务异常
     */
    public List<OActivityDetail> queryInvitedFoodActivities(Long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call("eleme.activity.food.queryInvitedFoodActivities", params);
    }

    /**
     * 报名美食活动
     *
     * @param activityId 活动Id
     * @param activityApplyInfo 活动报名信息
     * @return 报名结果（true表示操作成功）
     * @throws ServiceException 服务异常
     */
    public Boolean applyFoodActivity(Long activityId, ActivityApplyInfo activityApplyInfo) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("activityApplyInfo", activityApplyInfo);
        return call("eleme.activity.food.applyFoodActivity", params);
    }

    /**
     * 通过店铺Id和活动Id分页查询店铺已报名的美食活动
     *
     * @param activityId 活动Id
     * @param shopId 店铺Id
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @return 该活动中所报名菜品的信息
     * @throws ServiceException 服务异常
     */
    public List<OActivityFoodApplyResult> queryFoodActivities(Long activityId, Long shopId, Long pageNo, Long pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("shopId", shopId);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        return call("eleme.activity.food.queryFoodActivities", params);
    }

    /**
     * 修改美食活动的菜品库存
     *
     * @param activityId 活动Id
     * @param shopId 店铺Id
     * @param itemId 菜品Id
     * @param stock 库存
     * @return 报名结果（true表示操作成功）
     * @throws ServiceException 服务异常
     */
    public Boolean updateFoodActivityItemStock(Long activityId, Long shopId, Long itemId, Long stock) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("shopId", shopId);
        params.put("itemId", itemId);
        params.put("stock", stock);
        return call("eleme.activity.food.updateFoodActivityItemStock", params);
    }

    /**
     * 取消参与了美食活动的菜品
     *
     * @param activityId 活动Id
     * @param shopId 店铺Id
     * @param itemId 菜品Id
     * @return 报名结果（true表示操作成功）
 该接口目前只支持限量抢购活动
     * @throws ServiceException 服务异常
     */
    public Boolean offlineFoodActivityItem(Long activityId, Long shopId, Long itemId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("shopId", shopId);
        params.put("itemId", itemId);
        return call("eleme.activity.food.offlineFoodActivityItem", params);
    }

    /**
     * 作废店铺与美食活动的关联关系
     *
     * @param activityId 活动Id
     * @param shopId 店铺Id
     * @return 报名结果（true表示操作成功）
 该接口目前只支持限量抢购活动
     * @throws ServiceException 服务异常
     */
    public Boolean unbindFoodActivity(Long activityId, Long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("shopId", shopId);
        return call("eleme.activity.food.unbindFoodActivity", params);
    }

    /**
     * 查询店铺邀约活动信息
     *
     * @param shopId 店铺Id
     * @return 店铺的邀约活动信息列表
     * @throws ServiceException 服务异常
     */
    public List<OActivityDetail> getInvitedActivityInfos(Long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call("eleme.activity.flash.getInvitedActivityInfos", params);
    }

    /**
     * 报名限量抢购活动
     *
     * @param activityId 活动Id
     * @param activityApplyInfo 活动报名信息
     * @return 报名结果（true表示操作成功）
     * @throws ServiceException 服务异常
     */
    public Boolean applyFlashActivity(Long activityId, ActivityApplyInfo activityApplyInfo) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("activityApplyInfo", activityApplyInfo);
        return call("eleme.activity.flash.applyFlashActivity", params);
    }

    /**
     * 通过店铺Id和活动Id分页查询报名详情
     *
     * @param activityId 活动Id
     * @param shopId 店铺Id
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @return 该活动中所报名菜品的信息
     * @throws ServiceException 服务异常
     */
    public List<OActivityFoodApplyResult> getActivityApplyInfos(Long activityId, Long shopId, Long pageNo, Long pageSize) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("shopId", shopId);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        return call("eleme.activity.flash.getActivityApplyInfos", params);
    }

    /**
     * 修改活动菜品库存
     *
     * @param activityId 活动Id
     * @param shopId 店铺Id
     * @param itemId 菜品Id
     * @param stock 库存
     * @return 报名结果（true表示操作成功）
     * @throws ServiceException 服务异常
     */
    public Boolean updateActivityItemStock(Long activityId, Long shopId, Long itemId, Long stock) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("shopId", shopId);
        params.put("itemId", itemId);
        params.put("stock", stock);
        return call("eleme.activity.flash.updateActivityItemStock", params);
    }

    /**
     * 取消活动菜品
     *
     * @param activityId 活动Id
     * @param shopId 店铺Id
     * @param itemId 菜品Id
     * @return 报名结果（true表示操作成功）
     * @throws ServiceException 服务异常
     */
    public Boolean offlineFlashActivityItem(Long activityId, Long shopId, Long itemId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("shopId", shopId);
        params.put("itemId", itemId);
        return call("eleme.activity.flash.offlineFlashActivityItem", params);
    }

    /**
     * 作废店铺与活动的关联关系
     *
     * @param activityId 活动Id
     * @param shopId 店铺Id
     * @return 报名结果（true表示操作成功）
     * @throws ServiceException 服务异常
     */
    public Boolean invalidShopActivity(Long activityId, Long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("shopId", shopId);
        return call("eleme.activity.flash.invalidShopActivity", params);
    }
}
