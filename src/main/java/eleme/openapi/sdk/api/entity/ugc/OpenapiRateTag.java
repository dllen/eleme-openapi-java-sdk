package eleme.openapi.sdk.api.entity.ugc;

import eleme.openapi.sdk.api.enumeration.ugc.*;
import eleme.openapi.sdk.api.entity.ugc.*;
import java.util.*;
import java.math.BigDecimal;

public class OpenapiRateTag{

    /**
     * 评论编号
     */
    private String rateId;
    public String getRateId() {
        return rateId;
    }
    public void setRateId(String rateId) {
        this.rateId = rateId;
    }
    
    /**
     * 订单编号
     */
    private String orderId;
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    /**
     * 标签信息
     */
    private String tags;
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    
    /**
     * 标签信息
     */
    private List<String> tagList;
    public List<String> getTagList() {
        return tagList;
    }
    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
    
    /**
     * 店铺Id
     */
    private String shopId;
    public String getShopId() {
        return shopId;
    }
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
    
}