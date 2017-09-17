package eleme.openapi.sdk.api.enumeration.activity;

public enum OSaleStatus {
    /**
     * 上架
     */
    ON_SALE("ON_SALE"), 
    
    /**
     * 下架
     */
    OFF_SALE("OFF_SALE");
    

    private String activityDesc;
    OSaleStatus(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}