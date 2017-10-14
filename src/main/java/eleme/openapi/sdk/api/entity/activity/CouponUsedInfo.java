package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CouponUsedInfo{

    /**
     * 用户id
     */
    private Long userId;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
     * 用户名
     */
    private String userName;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * 用户手机号
     */
    private String mobile;
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    /**
     * 手机有效性
     */
    private Boolean mobileValid;
    public Boolean getMobileValid() {
        return mobileValid;
    }
    public void setMobileValid(Boolean mobileValid) {
        this.mobileValid = mobileValid;
    }
    
    /**
     * 订单ID（字符串）
     */
    private String orderIdStr;
    public String getOrderIdStr() {
        return orderIdStr;
    }
    public void setOrderIdStr(String orderIdStr) {
        this.orderIdStr = orderIdStr;
    }
    
    /**
     * 代金券使用状态
     */
    private CouponStatus couponStatus;
    public CouponStatus getCouponStatus() {
        return couponStatus;
    }
    public void setCouponStatus(CouponStatus couponStatus) {
        this.couponStatus = couponStatus;
    }
    
}