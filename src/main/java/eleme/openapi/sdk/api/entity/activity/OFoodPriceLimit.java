package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OFoodPriceLimit{

    /**
     * 菜品原价最低限制
     */
    private BigDecimal minPrice;
    public BigDecimal getMinPrice() {
        return minPrice;
    }
    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }
    
    /**
     * 菜品原价最高限制
     */
    private BigDecimal maxPrice;
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }
    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
    
}