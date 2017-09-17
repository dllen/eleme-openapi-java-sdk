package eleme.openapi.sdk.api.enumeration.activity;

public enum OActivityStatus {
    /**
     * 未开始
     */
    PENDING("PENDING"), 
    
    /**
     * 进行中
     */
    ACTIVATED("ACTIVATED"), 
    
    /**
     * 已结束
     */
    EXPIRED("EXPIRED"), 
    
    /**
     * 已作废
     */
    INVALID("INVALID");
    

    private String activityDesc;
    OActivityStatus(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}