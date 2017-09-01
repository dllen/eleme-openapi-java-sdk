package eleme.openapi.sdk.api.enumeration.activity;

public enum OFoodStockType {
    /**
     * 总库存
     */
    ALL("ALL"), 
    
    /**
     * 每日库存
     */
    DELAY("DELAY");
    

    private String activityDesc;
    OFoodStockType(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}