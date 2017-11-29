package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CouponBenefit{

    /**
     * 代金券优惠类型
     */
    private CouponBenefitType couponBenefitType;
    public CouponBenefitType getCouponBenefitType() {
        return couponBenefitType;
    }
    public void setCouponBenefitType(CouponBenefitType couponBenefitType) {
        this.couponBenefitType = couponBenefitType;
    }
    
    /**
     * 代金券优惠内容
     */
    private CouponBenefitContent benefitContent;
    public CouponBenefitContent getBenefitContent() {
        return benefitContent;
    }
    public void setBenefitContent(CouponBenefitContent benefitContent) {
        this.benefitContent = benefitContent;
    }
    
}