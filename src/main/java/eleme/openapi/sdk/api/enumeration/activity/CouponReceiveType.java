package eleme.openapi.sdk.api.enumeration.activity;

public enum CouponReceiveType {
    /**
     * 每人一张
     */
    ONE_PER_PERSON("ONE_PER_PERSON"), 
    
    /**
     * 每人每天一张
     */
    ONE_PER_PERSON_PER_DAY("ONE_PER_PERSON_PER_DAY");
    

    private String activityDesc;
    CouponReceiveType(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}