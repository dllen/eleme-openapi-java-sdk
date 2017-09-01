package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;

public class OActivityFoodStock{

    /**
     * 库存类型
     */
    private OStockType stockType;
    public OStockType getStockType() {
        return stockType;
    }
    public void setStockType(OStockType stockType) {
        this.stockType = stockType;
    }
    
    /**
     * 最大库存（总库存）
     */
    private Integer maxStock;
    public Integer getMaxStock() {
        return maxStock;
    }
    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }
    
    /**
     * 每日库存
     */
    private Integer dailyStock;
    public Integer getDailyStock() {
        return dailyStock;
    }
    public void setDailyStock(Integer dailyStock) {
        this.dailyStock = dailyStock;
    }
    
    /**
     * 当前活动库存
     */
    private Integer activityStock;
    public Integer getActivityStock() {
        return activityStock;
    }
    public void setActivityStock(Integer activityStock) {
        this.activityStock = activityStock;
    }
    
}