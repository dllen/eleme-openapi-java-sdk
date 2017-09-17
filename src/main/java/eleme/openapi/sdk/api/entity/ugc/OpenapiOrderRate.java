package eleme.openapi.sdk.api.entity.ugc;

import eleme.openapi.sdk.api.enumeration.ugc.*;
import eleme.openapi.sdk.api.entity.ugc.*;
import java.util.*;
import java.math.BigDecimal;

public class OpenapiOrderRate{

    /**
     * 评论编号
     */
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * 店铺编号
     */
    private String shopId;
    public String getShopId() {
        return shopId;
    }
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
    
    /**
     * 评价分数
     */
    private Integer rating;
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    /**
     * 评价内容
     */
    private String rateContent;
    public String getRateContent() {
        return rateContent;
    }
    public void setRateContent(String rateContent) {
        this.rateContent = rateContent;
    }
    
    /**
     * 点评时间
     */
    private Date ratedAt;
    public Date getRatedAt() {
        return ratedAt;
    }
    public void setRatedAt(Date ratedAt) {
        this.ratedAt = ratedAt;
    }
    
    /**
     * 订单商品评论
     */
    private List<OpenapiItemRate> itemRates;
    public List<OpenapiItemRate> getItemRates() {
        return itemRates;
    }
    public void setItemRates(List<OpenapiItemRate> itemRates) {
        this.itemRates = itemRates;
    }
    
    /**
     * 订单回复评论
     */
    private OpenapiRateReply orderRateReply;
    public OpenapiRateReply getOrderRateReply() {
        return orderRateReply;
    }
    public void setOrderRateReply(OpenapiRateReply orderRateReply) {
        this.orderRateReply = orderRateReply;
    }
    
    /**
     * 订单标签
     */
    private OpenapiRateTag rateTag;
    public OpenapiRateTag getRateTag() {
        return rateTag;
    }
    public void setRateTag(OpenapiRateTag rateTag) {
        this.rateTag = rateTag;
    }
    
}