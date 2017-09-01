package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;

public class ActivityApplyInfo{

    /**
     * 报名的店铺Id
     */
    private Long shopId;
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    
    /**
     * 报名的菜品信息
     */
    private List<FoodApplyInfo> foodApplyInfos;
    public List<FoodApplyInfo> getFoodApplyInfos() {
        return foodApplyInfos;
    }
    public void setFoodApplyInfos(List<FoodApplyInfo> foodApplyInfos) {
        this.foodApplyInfos = foodApplyInfos;
    }
    
}