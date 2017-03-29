package eleme.openapi.sdk.api.enumeration.product;

public enum OItemUpdateProperty {
    /**
     * String 商品名称|必选|"白切鸡"
     */
    name("name"), 
    /**
     * String 商品描述|可选|"香脆可口，外焦里嫩"
     */
    description("description"), 
    /**
     * String 图片imageHash|可选|"3077080f760e7bf0fc985e23dd3e36e2"
     */
    imageHash("imageHash"), 
    /**
     * OLabel 标签属性集合|可选|{"isFeatured":0,"isGum":0,"isNew":1,"isSpicy":1}
     */
    labels("labels"), 
    specs("specs");

    private String productDesc;
    OItemUpdateProperty(String productDesc) {
        this.productDesc = productDesc;
    }
}