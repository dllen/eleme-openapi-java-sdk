package eleme.openapi.sdk.api.enumeration.order;

public enum OOrderDetailGroupType {
    /**
     * 正常的菜品
     */
    normal("normal"), 
    
    /**
     * 配送费等
     */
    extra("extra"), 
    
    /**
     * 折扣,如红包,满减等
     */
    discount("discount");
    

    private String orderDesc;
    OOrderDetailGroupType(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}