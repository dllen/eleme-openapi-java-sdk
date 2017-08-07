package eleme.openapi.sdk.api.entity.finance;

import eleme.openapi.sdk.api.enumeration.finance.*;
import eleme.openapi.sdk.api.entity.finance.*;
import java.util.*;
import java.math.BigDecimal;

public class BranchQuery{

    /**
     * 查询日期闭合区间
     */
    private DateRange range;
    public DateRange getRange() {
        return range;
    }
    public void setRange(DateRange range) {
        this.range = range;
    }
    
    /**
     * 分页
     */
    private Paging paging;
    public Paging getPaging() {
        return paging;
    }
    public void setPaging(Paging paging) {
        this.paging = paging;
    }
    
}