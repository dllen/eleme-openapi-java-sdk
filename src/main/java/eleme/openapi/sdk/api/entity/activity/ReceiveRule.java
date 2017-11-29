package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ReceiveRule{

    /**
     * 代金券的领取类型（每人一张,每人每天一张）
     */
    private CouponReceiveType type;
    public CouponReceiveType getType() {
        return type;
    }
    public void setType(CouponReceiveType type) {
        this.type = type;
    }
    
    /**
     * 代金券的领取数量（暂时只支持每次领取一张）
     */
    private Integer quantity;
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}