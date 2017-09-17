package eleme.openapi.sdk.api.enumeration.ugc;

public enum ReplyType {
    /**
     * 订单
     */
    ORDER("ORDER"), 
    
    /**
     * 菜品
     */
    GOODS("GOODS");
    

    private String ugcDesc;
    ReplyType(String ugcDesc) {
        this.ugcDesc = ugcDesc;
    }
}