package eleme.openapi.sdk.api.enumeration.activity;

public enum OActivityStatus {
    /**
     * 已批准(包括未开始、进行中和已结束)
     */
    APPROVED("APPROVED"), 
    
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