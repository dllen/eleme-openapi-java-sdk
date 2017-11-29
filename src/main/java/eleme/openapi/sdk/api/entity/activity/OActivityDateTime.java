package eleme.openapi.sdk.api.entity.activity;

import eleme.openapi.sdk.api.enumeration.activity.*;
import eleme.openapi.sdk.api.entity.activity.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OActivityDateTime{

    /**
     * 活动有效日期段
     */
    private OActivityDate activityDate;
    public OActivityDate getActivityDate() {
        return activityDate;
    }
    public void setActivityDate(OActivityDate activityDate) {
        this.activityDate = activityDate;
    }
    
    /**
     * 活动有效时间段，默认为[00:00:00.000 - 23:59:59.999]
     */
    private OActivityTime activityTime;
    public OActivityTime getActivityTime() {
        return activityTime;
    }
    public void setActivityTime(OActivityTime activityTime) {
        this.activityTime = activityTime;
    }
    
    /**
     * 活动有效工作日，默认为[1,2,3,4,5,6,7]
     */
    private List<Integer> weekdays;
    public List<Integer> getWeekdays() {
        return weekdays;
    }
    public void setWeekdays(List<Integer> weekdays) {
        this.weekdays = weekdays;
    }
    
}