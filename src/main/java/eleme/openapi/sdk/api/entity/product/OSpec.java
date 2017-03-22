package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OSpec{

    /**
     * 规格Id
     */
    private long specId;
    public long getSpecId() {
        return specId;
    }
    public void setSpecId(long specId) {
        this.specId = specId;
    }

    
    /**
     * 名称
     */
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * 商品价格
     */
    private double price;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    
    /**
     * 库存量
     */
    private int stock;
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    /**
     * 最大库存量
     */
    private int maxStock;
    public int getMaxStock() {
        return maxStock;
    }
    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    
    /**
     * 包装费
     */
    private double packingFee;
    public double getPackingFee() {
        return packingFee;
    }
    public void setPackingFee(double packingFee) {
        this.packingFee = packingFee;
    }

    
    /**
     * 是否上架
     */
    private int onShelf;
    public int getOnShelf() {
        return onShelf;
    }
    public void setOnShelf(int onShelf) {
        this.onShelf = onShelf;
    }

    
}