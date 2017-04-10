package eleme.openapi.sdk.api.enumeration.product;

public enum OItemUpdateProperty {
    /**
     * 商品名称
     */
    name("name"), 
    
    /**
     * 商品描述
     */
    description("description"), 
    
    /**
     * 图片imageHash
     */
    imageHash("imageHash"), 
    
    /**
     * 标签属性集合
     */
    labels("labels"), 
    
    /**
     * 规格
     */
    specs("specs"), 
    
    /**
     * 售卖时间
     */
    sellingTime("sellingTime"), 
    
    /**
     * 属性
     */
    attributes("attributes");
    

    private String productDesc;
    OItemUpdateProperty(String productDesc) {
        this.productDesc = productDesc;
    }
}