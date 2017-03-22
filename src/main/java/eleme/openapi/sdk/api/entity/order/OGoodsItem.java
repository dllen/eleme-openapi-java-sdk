package eleme.openapi.sdk.api.entity.order;

import eleme.openapi.sdk.api.enumeration.order.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OGoodsItem{

    /**
     * 商品Id
     */
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    
    /**
     * 商品名称
     */
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * 订单中商品项的标识
     */
    private long categoryId;
    public long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    
    /**
     * 商品单价
     */
    private double price;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    
    /**
     * 商品数量
     */
    private int quantity;
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    /**
     * 总价
     */
    private double total;
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    
}