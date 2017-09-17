package eleme.openapi.sdk.api.entity.ugc;

import eleme.openapi.sdk.api.enumeration.ugc.*;
import eleme.openapi.sdk.api.entity.ugc.*;
import java.util.*;
import java.math.BigDecimal;

public class OpenapiRateReply{

    /**
     * 回复编号
     */
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
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
     * 回复内容
     */
    private String content;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * 回复人姓名
     */
    private String replierName;
    public String getReplierName() {
        return replierName;
    }
    public void setReplierName(String replierName) {
        this.replierName = replierName;
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
     * 点评类型
     */
    private RatingReplyType rateType;
    public RatingReplyType getRateType() {
        return rateType;
    }
    public void setRateType(RatingReplyType rateType) {
        this.rateType = rateType;
    }
    
}