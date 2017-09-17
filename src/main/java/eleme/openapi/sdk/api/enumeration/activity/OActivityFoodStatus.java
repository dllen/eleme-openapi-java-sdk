package eleme.openapi.sdk.api.enumeration.activity;

public enum OActivityFoodStatus {
    /**
     * 活动未开始
     */
    UN_ACTIVE("UN_ACTIVE"), 
    
    /**
     * 活动中
     */
    ACTIVE("ACTIVE"), 
    
    /**
     * 活动已过期
     */
    EXPIRED("EXPIRED"), 
    
    /**
     * 活动暂停
     */
    PAUSE("PAUSE"), 
    
    /**
     * 活动作废
     */
    TERMINATED("TERMINATED");
    

    private String activityDesc;
    OActivityFoodStatus(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}