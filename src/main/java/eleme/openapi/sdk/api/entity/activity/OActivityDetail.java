package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OActivityDetail{

    /**
     * 活动Id
     */
    private Long activityId;
    public Long getActivityId() {
        return activityId;
    }
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
    
    /**
     * 活动名称
     */
    private String activityName;
    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    
    /**
     * 活动类型
     */
    private OActivityType activityTypeEnum;
    public OActivityType getActivityTypeEnum() {
        return activityTypeEnum;
    }
    public void setActivityTypeEnum(OActivityType activityTypeEnum) {
        this.activityTypeEnum = activityTypeEnum;
    }
    
    /**
     * 活动状态
     */
    private OActivityStatus activityStatus;
    public OActivityStatus getActivityStatus() {
        return activityStatus;
    }
    public void setActivityStatus(OActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }
    
    /**
     * 菜品数量限制
     */
    private OFoodQuantityLimit foodQuantityLimit;
    public OFoodQuantityLimit getFoodQuantityLimit() {
        return foodQuantityLimit;
    }
    public void setFoodQuantityLimit(OFoodQuantityLimit foodQuantityLimit) {
        this.foodQuantityLimit = foodQuantityLimit;
    }
    
    /**
     * 菜品库存限制
     */
    private OFoodStockLimit foodStockLimit;
    public OFoodStockLimit getFoodStockLimit() {
        return foodStockLimit;
    }
    public void setFoodStockLimit(OFoodStockLimit foodStockLimit) {
        this.foodStockLimit = foodStockLimit;
    }
    
    /**
     * 活动价格
     */
    private BigDecimal activityPrice;
    public BigDecimal getActivityPrice() {
        return activityPrice;
    }
    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }
    
    /**
     * 平台补贴
     */
    private BigDecimal platformSubsidy;
    public BigDecimal getPlatformSubsidy() {
        return platformSubsidy;
    }
    public void setPlatformSubsidy(BigDecimal platformSubsidy) {
        this.platformSubsidy = platformSubsidy;
    }
    
    /**
     * 菜品原价限制
     */
    private OFoodPriceLimit foodPriceLimit;
    public OFoodPriceLimit getFoodPriceLimit() {
        return foodPriceLimit;
    }
    public void setFoodPriceLimit(OFoodPriceLimit foodPriceLimit) {
        this.foodPriceLimit = foodPriceLimit;
    }
    
    /**
     * 餐盒费限制
     */
    private BigDecimal packagePrice;
    public BigDecimal getPackagePrice() {
        return packagePrice;
    }
    public void setPackagePrice(BigDecimal packagePrice) {
        this.packagePrice = packagePrice;
    }
    
    /**
     * 新品限制
     */
    private Boolean newProduct;
    public Boolean getNewProduct() {
        return newProduct;
    }
    public void setNewProduct(Boolean newProduct) {
        this.newProduct = newProduct;
    }
    
    /**
     * 最高起送价限制
     */
    private BigDecimal maxStartDispatchPrice;
    public BigDecimal getMaxStartDispatchPrice() {
        return maxStartDispatchPrice;
    }
    public void setMaxStartDispatchPrice(BigDecimal maxStartDispatchPrice) {
        this.maxStartDispatchPrice = maxStartDispatchPrice;
    }
    
    /**
     * 最高配送费限制
     */
    private BigDecimal maxDispatchPrice;
    public BigDecimal getMaxDispatchPrice() {
        return maxDispatchPrice;
    }
    public void setMaxDispatchPrice(BigDecimal maxDispatchPrice) {
        this.maxDispatchPrice = maxDispatchPrice;
    }
    
    /**
     * 品类
     */
    private OCategoryType categoryTypeEnum;
    public OCategoryType getCategoryTypeEnum() {
        return categoryTypeEnum;
    }
    public void setCategoryTypeEnum(OCategoryType categoryTypeEnum) {
        this.categoryTypeEnum = categoryTypeEnum;
    }
    
    /**
     * 报名日期
     */
    private OApplyDate applyDate;
    public OApplyDate getApplyDate() {
        return applyDate;
    }
    public void setApplyDate(OApplyDate applyDate) {
        this.applyDate = applyDate;
    }
    
    /**
     * 活动日期及时间
     */
    private OActivityDateTime activityDateTime;
    public OActivityDateTime getActivityDateTime() {
        return activityDateTime;
    }
    public void setActivityDateTime(OActivityDateTime activityDateTime) {
        this.activityDateTime = activityDateTime;
    }
    
    /**
     * 报名条件
     */
    private OShopApplyCondition shopApplyCondition;
    public OShopApplyCondition getShopApplyCondition() {
        return shopApplyCondition;
    }
    public void setShopApplyCondition(OShopApplyCondition shopApplyCondition) {
        this.shopApplyCondition = shopApplyCondition;
    }
    
    /**
     * 生效条件
     */
    private OEffectiveCondition effectiveCondition;
    public OEffectiveCondition getEffectiveCondition() {
        return effectiveCondition;
    }
    public void setEffectiveCondition(OEffectiveCondition effectiveCondition) {
        this.effectiveCondition = effectiveCondition;
    }
    
}