package eleme.openapi.sdk.api.entity.ugc;

import eleme.openapi.sdk.api.enumeration.ugc.*;
import eleme.openapi.sdk.api.entity.ugc.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OpenapiItemRate{

    /**
     * 商品评论编号
     */
    private String itemRateId;
    public String getItemRateId() {
        return itemRateId;
    }
    public void setItemRateId(String itemRateId) {
        this.itemRateId = itemRateId;
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
     * 菜品编号
     */
    private String itemId;
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    /**
     * 商品名称
     */
    private String itemName;
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
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
    @JsonFormat(locale = "zh" , timezone="GMT+8")
    private Date ratedAt;
    public Date getRatedAt() {
        return ratedAt;
    }
    public void setRatedAt(Date ratedAt) {
        this.ratedAt = ratedAt;
    }
    
    /**
     * 图片URL
     */
    private List<String> pictures;
    public List<String> getPictures() {
        return pictures;
    }
    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
    
    /**
     * 订单回复评论
     */
    private OpenapiRateReply rateReply;
    public OpenapiRateReply getRateReply() {
        return rateReply;
    }
    public void setRateReply(OpenapiRateReply rateReply) {
        this.rateReply = rateReply;
    }
    
}