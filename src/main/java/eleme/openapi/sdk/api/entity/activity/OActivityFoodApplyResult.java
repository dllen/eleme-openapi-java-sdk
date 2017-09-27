package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OActivityFoodApplyResult{

    /**
     * 菜品Id
     */
    private Long itemId;
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    
    /**
     * 菜品名称
     */
    private String foodName;
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    
    /**
     * 分类Id
     */
    private Long categoryId;
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    /**
     * 菜品所属店铺Id
     */
    private Long shopId;
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    
    /**
     * 菜品在活动中的状态
     */
    private OActivityFoodStatus activityFoodStatus;
    public OActivityFoodStatus getActivityFoodStatus() {
        return activityFoodStatus;
    }
    public void setActivityFoodStatus(OActivityFoodStatus activityFoodStatus) {
        this.activityFoodStatus = activityFoodStatus;
    }
    
    /**
     * 活动库存
     */
    private OActivityFoodStock activityFoodStock;
    public OActivityFoodStock getActivityFoodStock() {
        return activityFoodStock;
    }
    public void setActivityFoodStock(OActivityFoodStock activityFoodStock) {
        this.activityFoodStock = activityFoodStock;
    }
    
    /**
     * 菜品的审核状态
     */
    private OAuditStatus auditStatusEnum;
    public OAuditStatus getAuditStatusEnum() {
        return auditStatusEnum;
    }
    public void setAuditStatusEnum(OAuditStatus auditStatusEnum) {
        this.auditStatusEnum = auditStatusEnum;
    }
    
    /**
     * 计算后的活动价格
     */
    private BigDecimal activityPrice;
    public BigDecimal getActivityPrice() {
        return activityPrice;
    }
    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }
    
    /**
     * 上下架状态
     */
    private OSaleStatus saleStatus;
    public OSaleStatus getSaleStatus() {
        return saleStatus;
    }
    public void setSaleStatus(OSaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }
    
    /**
     * 审核原因
     */
    private String auditComment;
    public String getAuditComment() {
        return auditComment;
    }
    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }
    
}