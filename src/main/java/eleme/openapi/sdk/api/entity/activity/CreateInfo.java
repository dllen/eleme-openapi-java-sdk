package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateInfo{

    /**
     * 店铺Id
     */
    private Long shopId;
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    
    /**
     * 代金券活动名称
     */
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 代金券活动类型
     */
    private CouponActivityType type;
    public CouponActivityType getType() {
        return type;
    }
    public void setType(CouponActivityType type) {
        this.type = type;
    }
    
    /**
     * 代金券优惠
     */
    private CouponBenefit benefit;
    public CouponBenefit getBenefit() {
        return benefit;
    }
    public void setBenefit(CouponBenefit benefit) {
        this.benefit = benefit;
    }
    
    /**
     * 代金券活动条件
     */
    private Condition condition;
    public Condition getCondition() {
        return condition;
    }
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    
}