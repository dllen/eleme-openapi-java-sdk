package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OFoodQuantityLimit{

    /**
     * 菜品的最小数量限制
     */
    private Integer minLimit;
    public Integer getMinLimit() {
        return minLimit;
    }
    public void setMinLimit(Integer minLimit) {
        this.minLimit = minLimit;
    }
    
    /**
     * 报名菜品的最大数量限制
     */
    private Integer maxLimit;
    public Integer getMaxLimit() {
        return maxLimit;
    }
    public void setMaxLimit(Integer maxLimit) {
        this.maxLimit = maxLimit;
    }
    
}