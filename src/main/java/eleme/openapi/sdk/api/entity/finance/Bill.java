package eleme.openapi.sdk.api.entity.finance;

import eleme.openapi.sdk.api.enumeration.finance.*;
import eleme.openapi.sdk.api.entity.finance.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Bill{

    /**
     * 饿了么店铺id
     */
    private long shopId;
    public long getShopId() {
        return shopId;
    }
    public void setShopId(long shopId) {
        this.shopId = shopId;
    }
    
    /**
     * 账单日期
     */
    @JsonFormat(locale = "zh" , timezone="GMT+8")
    private Date billDate;
    public Date getBillDate() {
        return billDate;
    }
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
    
    /**
     * 入账日期
     */
    @JsonFormat(locale = "zh" , timezone="GMT+8")
    private Date checkoutDate;
    public Date getCheckoutDate() {
        return checkoutDate;
    }
    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    
    /**
     * 本期账单收入
     */
    private BigDecimal income;
    public BigDecimal getIncome() {
        return income;
    }
    public void setIncome(BigDecimal income) {
        this.income = income;
    }
    
    /**
     * 本期订单支出
     */
    private BigDecimal expense;
    public BigDecimal getExpense() {
        return expense;
    }
    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }
    
    /**
     * 本期抵扣欠款金额
     */
    private BigDecimal deductAmount;
    public BigDecimal getDeductAmount() {
        return deductAmount;
    }
    public void setDeductAmount(BigDecimal deductAmount) {
        this.deductAmount = deductAmount;
    }
    
    /**
     * 入账金额
     */
    private BigDecimal checkoutAmount;
    public BigDecimal getCheckoutAmount() {
        return checkoutAmount;
    }
    public void setCheckoutAmount(BigDecimal checkoutAmount) {
        this.checkoutAmount = checkoutAmount;
    }
    
    /**
     * 剩余欠款
     */
    private BigDecimal dueAmount;
    public BigDecimal getDueAmount() {
        return dueAmount;
    }
    public void setDueAmount(BigDecimal dueAmount) {
        this.dueAmount = dueAmount;
    }
    
}