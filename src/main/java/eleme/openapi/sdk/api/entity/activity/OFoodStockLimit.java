package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OFoodStockLimit{

    /**
     * 菜品库存类型
     */
    private OFoodStockType foodStockTypeEnum;
    public OFoodStockType getFoodStockTypeEnum() {
        return foodStockTypeEnum;
    }
    public void setFoodStockTypeEnum(OFoodStockType foodStockTypeEnum) {
        this.foodStockTypeEnum = foodStockTypeEnum;
    }
    
    /**
     * 总库存
     */
    private Integer allStock;
    public Integer getAllStock() {
        return allStock;
    }
    public void setAllStock(Integer allStock) {
        this.allStock = allStock;
    }
    
    /**
     * 每日最小库存
     */
    private Integer minStock;
    public Integer getMinStock() {
        return minStock;
    }
    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }
    
    /**
     * 每日最大库存
     */
    private Integer maxStock;
    public Integer getMaxStock() {
        return maxStock;
    }
    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }
    
}