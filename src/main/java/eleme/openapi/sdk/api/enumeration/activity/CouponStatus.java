package eleme.openapi.sdk.api.enumeration.activity;

public enum CouponStatus {
    /**
     * 未使用
     */
    UNUSED("UNUSED"), 
    
    /**
     * 已使用
     */
    USED("USED"), 
    
    /**
     * 已过期
     */
    EXPIRED("EXPIRED"), 
    
    /**
     * 作废
     */
    ABANDON("ABANDON"), 
    
    /**
     * 使用后被作废(订单被无效)
     */
    ABANDON_AFTER_USED("ABANDON_AFTER_USED");
    

    private String activityDesc;
    CouponStatus(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}