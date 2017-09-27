package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OEffectiveCondition{

    /**
     * 新用户
     */
    private Boolean newUser;
    public Boolean getNewUser() {
        return newUser;
    }
    public void setNewUser(Boolean newUser) {
        this.newUser = newUser;
    }
    
    /**
     * 仅在线支付
     */
    private Boolean onlinePayment;
    public Boolean getOnlinePayment() {
        return onlinePayment;
    }
    public void setOnlinePayment(Boolean onlinePayment) {
        this.onlinePayment = onlinePayment;
    }
    
    /**
     * 饿了么会员
     */
    private Boolean elemeVip;
    public Boolean getElemeVip() {
        return elemeVip;
    }
    public void setElemeVip(Boolean elemeVip) {
        this.elemeVip = elemeVip;
    }
    
    /**
     * 与美食活动同享
     */
    private Boolean shareWithSkuActivity;
    public Boolean getShareWithSkuActivity() {
        return shareWithSkuActivity;
    }
    public void setShareWithSkuActivity(Boolean shareWithSkuActivity) {
        this.shareWithSkuActivity = shareWithSkuActivity;
    }
    
    /**
     * 与店铺活动同享
     */
    private Boolean shareWithShopActivity;
    public Boolean getShareWithShopActivity() {
        return shareWithShopActivity;
    }
    public void setShareWithShopActivity(Boolean shareWithShopActivity) {
        this.shareWithShopActivity = shareWithShopActivity;
    }
    
    /**
     * 和其它活动同享
     */
    private Boolean shareWithOthers;
    public Boolean getShareWithOthers() {
        return shareWithOthers;
    }
    public void setShareWithOthers(Boolean shareWithOthers) {
        this.shareWithOthers = shareWithOthers;
    }
    
}