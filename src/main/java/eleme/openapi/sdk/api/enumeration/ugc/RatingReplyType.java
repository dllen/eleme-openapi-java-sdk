package eleme.openapi.sdk.api.enumeration.ugc;

public enum RatingReplyType {
    /**
     * 订单
     */
    ORDER("ORDER"), 
    
    /**
     * 菜品
     */
    ITEM("ITEM");
    

    private String ugcDesc;
    RatingReplyType(String ugcDesc) {
        this.ugcDesc = ugcDesc;
    }
}