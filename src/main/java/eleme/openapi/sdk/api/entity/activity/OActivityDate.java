package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OActivityDate{

    /**
     * 活动开始日期
     */
    @JsonFormat(locale = "zh" , timezone="GMT+8")
    private Date beginDate;
    public Date getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    
    /**
     * 活动结束日期
     */
    @JsonFormat(locale = "zh" , timezone="GMT+8")
    private Date endDate;
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}