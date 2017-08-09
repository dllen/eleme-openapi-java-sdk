package eleme.openapi.sdk.api.entity.finance;

import eleme.openapi.sdk.api.enumeration.finance.*;
import eleme.openapi.sdk.api.entity.finance.*;
import java.util.*;
import java.math.BigDecimal;

public class HeadQuery{

    /**
     * 入账日期
     */
    private Date checkoutDate;
    public Date getCheckoutDate() {
        return checkoutDate;
    }
    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
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