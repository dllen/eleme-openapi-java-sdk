package eleme.openapi.sdk.api.enumeration.activity;

public enum OCategoryType {
    /**
     * 早餐
     */
    BREAKFAST("BREAKFAST"), 
    
    /**
     * 晚餐
     */
    DINNER("DINNER"), 
    
    /**
     * 下午茶
     */
    AFTERNOON_TEA("AFTERNOON_TEA"), 
    
    /**
     * 夜宵
     */
    SUPPER("SUPPER"), 
    
    /**
     * 商超便利
     */
    MARKET_CONVENIENT("MARKET_CONVENIENT"), 
    
    /**
     * 午餐
     */
    LUNCH("LUNCH");
    

    private String activityDesc;
    OCategoryType(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}