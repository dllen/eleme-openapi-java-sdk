package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import eleme.openapi.sdk.api.entity.product.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OItemIdWithSpecStock{

    /**
     * 商品Id
     */
    private long itemId;
    public long getItemId() {
        return itemId;
    }
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
    
    /**
     * 商品规格Id以及对应的库存
     */
    private Map<Long,Integer> stockMap;
    public Map<Long,Integer> getStockMap() {
        return stockMap;
    }
    public void setStockMap(Map<Long,Integer> stockMap) {
        this.stockMap = stockMap;
    }
    
}