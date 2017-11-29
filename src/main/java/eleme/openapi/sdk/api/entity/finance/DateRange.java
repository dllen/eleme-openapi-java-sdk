package eleme.openapi.sdk.api.entity.finance;

import eleme.openapi.sdk.api.enumeration.finance.*;
import eleme.openapi.sdk.api.entity.finance.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class DateRange{

    /**
     * 入账开始时间
     */
    @JsonFormat(locale = "zh" , timezone="GMT+8")
    private Date start;
    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    
    /**
     * 入账结束时间
     */
    @JsonFormat(locale = "zh" , timezone="GMT+8")
    private Date end;
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
    
}