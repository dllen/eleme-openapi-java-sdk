package eleme.openapi.sdk.api.enumeration.product;

public enum IdType {
    /**
     * 商品ID
     */
    ITEM_ID("ITEM_ID"), 
    
    /**
     * 规格ID
     */
    SPEC_ID("SPEC_ID"), 
    
    /**
     * 分类ID
     */
    CATEGORY_ID("CATEGORY_ID");
    

    private String productDesc;
    IdType(String productDesc) {
        this.productDesc = productDesc;
    }
}