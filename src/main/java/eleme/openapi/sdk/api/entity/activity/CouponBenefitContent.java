package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CouponBenefitContent{

    /**
     * 固定金额
     */
    private Double fixed;
    public Double getFixed() {
        return fixed;
    }
    public void setFixed(Double fixed) {
        this.fixed = fixed;
    }
    
    /**
     * 随机金额上限
     */
    private Double ceil;
    public Double getCeil() {
        return ceil;
    }
    public void setCeil(Double ceil) {
        this.ceil = ceil;
    }
    
    /**
     * 随机金额下限
     */
    private Double floor;
    public Double getFloor() {
        return floor;
    }
    public void setFloor(Double floor) {
        this.floor = floor;
    }
    
}