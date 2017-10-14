package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ReceivedCouponDetail{

    /**
     * 店铺已发券的数量
     */
    private Integer giveOutCount;
    public Integer getGiveOutCount() {
        return giveOutCount;
    }
    public void setGiveOutCount(Integer giveOutCount) {
        this.giveOutCount = giveOutCount;
    }
    
    /**
     * 代金券领取详情列表
     */
    private List<CouponUsedInfo> couponUsedInfos;
    public List<CouponUsedInfo> getCouponUsedInfos() {
        return couponUsedInfos;
    }
    public void setCouponUsedInfos(List<CouponUsedInfo> couponUsedInfos) {
        this.couponUsedInfos = couponUsedInfos;
    }
    
}