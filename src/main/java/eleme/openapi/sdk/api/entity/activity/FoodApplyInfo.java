package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FoodApplyInfo{

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
     * 报名的菜品库存
     */
    private Integer stock;
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
}