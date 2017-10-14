package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Condition{

    /**
     * 使用门槛（满足多少元可以用）
     */
    private Double threshold;
    public Double getThreshold() {
        return threshold;
    }
    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }
    
    /**
     * 有效时长（券有效期）
     */
    private Integer duration;
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    /**
     * 发放规则
     */
    private GiveOutRule giveOutRule;
    public GiveOutRule getGiveOutRule() {
        return giveOutRule;
    }
    public void setGiveOutRule(GiveOutRule giveOutRule) {
        this.giveOutRule = giveOutRule;
    }
    
    /**
     * 领取规则
     */
    private ReceiveRule receiveRule;
    public ReceiveRule getReceiveRule() {
        return receiveRule;
    }
    public void setReceiveRule(ReceiveRule receiveRule) {
        this.receiveRule = receiveRule;
    }
    
    /**
     * 代金券活动开始及结束时间
     */
    private OActivityDate activityDate;
    public OActivityDate getActivityDate() {
        return activityDate;
    }
    public void setActivityDate(OActivityDate activityDate) {
        this.activityDate = activityDate;
    }
    
}