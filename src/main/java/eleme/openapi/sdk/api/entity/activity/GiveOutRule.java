package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class GiveOutRule{

    /**
     * 代金券的发放类型（限定总量（总库存）,每天限量（每日库存））
     */
    private OStockType type;
    public OStockType getType() {
        return type;
    }
    public void setType(OStockType type) {
        this.type = type;
    }
    
    /**
     * 要发放的代金券数量
     */
    private Integer quantity;
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}