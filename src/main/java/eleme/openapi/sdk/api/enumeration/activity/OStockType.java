package eleme.openapi.sdk.api.enumeration.activity;

public enum OStockType {
    /**
     * 总库存
     */
    ALL("ALL"), 
    
    /**
     * 每日库存
     */
    DAILY("DAILY");
    

    private String activityDesc;
    OStockType(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}