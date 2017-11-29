package eleme.openapi.sdk.api.enumeration.product;

public enum OCategoryType {
    /**
     * 普通分类
     */
    NORMAL("NORMAL"), 
    
    /**
     * 必点分类
     */
    REQUIRED("REQUIRED"), 
    
    /**
     * 可单独下单分类
     */
    INDEPENDENT("INDEPENDENT");
    

    private String productDesc;
    OCategoryType(String productDesc) {
        this.productDesc = productDesc;
    }
}