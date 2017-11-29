package eleme.openapi.sdk.api.entity.finance;

import eleme.openapi.sdk.api.enumeration.finance.*;
import eleme.openapi.sdk.api.entity.finance.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FinanceOrders{

    /**
     * 订单数
     */
    private int count;
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    
    /**
     * 订单列表
     */
    private List<FinanceOrder> orders;
    public List<FinanceOrder> getOrders() {
        return orders;
    }
    public void setOrders(List<FinanceOrder> orders) {
        this.orders = orders;
    }
    
}