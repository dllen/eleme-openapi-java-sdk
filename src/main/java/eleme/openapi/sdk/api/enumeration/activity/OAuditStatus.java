package eleme.openapi.sdk.api.enumeration.activity;

public enum OAuditStatus {
    /**
     * 审核通过
     */
    PASS("PASS"), 
    
    /**
     * 审核拒绝
     */
    REFUSE("REFUSE"), 
    
    /**
     * 待审核
     */
    PENDING("PENDING");
    

    private String activityDesc;
    OAuditStatus(String activityDesc) {
        this.activityDesc = activityDesc;
    }
}