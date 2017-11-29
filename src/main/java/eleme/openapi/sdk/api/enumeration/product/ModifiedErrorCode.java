package eleme.openapi.sdk.api.enumeration.product;

public enum ModifiedErrorCode {
    /**
     * 超出参数长度限制
     */
    OVERFLOW_PARAM_LENGTH_LIMIT("OVERFLOW_PARAM_LENGTH_LIMIT"), 
    
    /**
     * 无效参数
     */
    INVALID_PARAMETER("INVALID_PARAMETER"), 
    
    /**
     * 商品未找到
     */
    ITEM_NOT_FOUND("ITEM_NOT_FOUND"), 
    
    /**
     * 商品不能操作(如存在活动等)
     */
    ITEM_CAN_NOT_OPERATE("ITEM_CAN_NOT_OPERATE"), 
    
    /**
     * 商品和规格关系错误 (如传入规格id对应的规格不在其商品id对应的商品里)
     */
    SKU_RELATION_ITEM_ERROR("SKU_RELATION_ITEM_ERROR"), 
    
    /**
     * 无权操作
     */
    PERMISSION_DENIED("PERMISSION_DENIED"), 
    
    /**
     * 库存设值不合法(如库存小于0，库存设值大于默认库存)
     */
    STOCK_INVALID("STOCK_INVALID"), 
    
    /**
     * 规格未找到
     */
    SKU_NOT_FOUND("SKU_NOT_FOUND"), 
    
    /**
     * 其他业务逻辑错误(如更新的商品当前库存不能大于商品最大库存等)
     */
    SERVICE_ERROR("SERVICE_ERROR");
    

    private String productDesc;
    ModifiedErrorCode(String productDesc) {
        this.productDesc = productDesc;
    }
}