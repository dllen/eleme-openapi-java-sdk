package eleme.openapi.sdk.api.enumeration.activity;

public enum CouponActivityType {
    /**
     * 自营销定向代金券
     */
    SELF_DIRECTIONAL_COUPON("SELF_DIRECTIONAL_COUPON");
    

    private String activityDesc;
    CouponActivityType(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}