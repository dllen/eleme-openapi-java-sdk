package eleme.openapi.sdk.api.enumeration.activity;

public enum CouponBenefitType {
    /**
     * 固定金额
     */
    FIXED_AMOUNT("FIXED_AMOUNT"), 
    
    /**
     * 随机金额
     */
    RANDOM_AMOUNT("RANDOM_AMOUNT");
    

    private String activityDesc;
    CouponBenefitType(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}