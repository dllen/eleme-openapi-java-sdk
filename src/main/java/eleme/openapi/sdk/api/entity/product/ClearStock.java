package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import eleme.openapi.sdk.api.entity.product.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClearStock{

    /**
     * 店铺ID
     */
    private Long shopId;
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    
    /**
     * 商品ID
     */
    private List<Long> itemIds;
    public List<Long> getItemIds() {
        return itemIds;
    }
    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
    
}