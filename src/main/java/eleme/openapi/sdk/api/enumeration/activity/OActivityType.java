package eleme.openapi.sdk.api.enumeration.activity;

public enum OActivityType {
    /**
     * 限量抢购活动
     */
    FLASH_ACTIVITY("FLASH_ACTIVITY");
    

    private String activityDesc;
    OActivityType(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}