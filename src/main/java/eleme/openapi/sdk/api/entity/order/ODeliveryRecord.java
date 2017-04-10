package eleme.openapi.sdk.api.entity.order;

import eleme.openapi.sdk.api.enumeration.order.*;
import eleme.openapi.sdk.api.entity.order.*;
import java.util.*;
import java.time.LocalDateTime;

public class ODeliveryRecord{

    /**
     * 订单Id
     */
    private String orderId;
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    /**
     * 运单主状态
     */
    private OState state;
    public OState getState() {
        return state;
    }
    public void setState(OState state) {
        this.state = state;
    }
    
    /**
     * 运单子状态
     */
    private OSubState subState;
    public OSubState getSubState() {
        return subState;
    }
    public void setSubState(OSubState subState) {
        this.subState = subState;
    }
    
    /**
     * 配送员姓名
     */
    private String deliverName;
    public String getDeliverName() {
        return deliverName;
    }
    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }
    
    /**
     * 配送员手机号
     */
    private String deliverPhone;
    public String getDeliverPhone() {
        return deliverPhone;
    }
    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone;
    }
    
    /**
     * 记录创建时间
     */
    private LocalDateTime createdAt;
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}