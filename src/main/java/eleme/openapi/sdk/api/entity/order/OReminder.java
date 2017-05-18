package eleme.openapi.sdk.api.entity.order;

import eleme.openapi.sdk.api.enumeration.order.*;
import eleme.openapi.sdk.api.entity.order.*;
import java.util.*;
public class OReminder{

    /**
     * 催单id
     */
    private long reminderId;
    public long getReminderId() {
        return reminderId;
    }
    public void setReminderId(long reminderId) {
        this.reminderId = reminderId;
    }
    
    /**
     * 订单id
     */
    private String orderId;
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
}