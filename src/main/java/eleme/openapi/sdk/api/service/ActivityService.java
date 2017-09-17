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
