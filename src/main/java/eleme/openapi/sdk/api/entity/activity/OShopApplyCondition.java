package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OShopApplyCondition{

    /**
     * 所有商户能报名
     */
    private Boolean allShopCanApply;
    public Boolean getAllShopCanApply() {
        return allShopCanApply;
    }
    public void setAllShopCanApply(Boolean allShopCanApply) {
        this.allShopCanApply = allShopCanApply;
    }
    
    /**
     * 星火计划商户能报名
     */
    private Boolean sparkShopCanApply;
    public Boolean getSparkShopCanApply() {
        return sparkShopCanApply;
    }
    public void setSparkShopCanApply(Boolean sparkShopCanApply) {
        this.sparkShopCanApply = sparkShopCanApply;
    }
    
    /**
     * 蜂鸟商户能报名
     */
    private Boolean beeBirdShopCanApply;
    public Boolean getBeeBirdShopCanApply() {
        return beeBirdShopCanApply;
    }
    public void setBeeBirdShopCanApply(Boolean beeBirdShopCanApply) {
        this.beeBirdShopCanApply = beeBirdShopCanApply;
    }
    
}