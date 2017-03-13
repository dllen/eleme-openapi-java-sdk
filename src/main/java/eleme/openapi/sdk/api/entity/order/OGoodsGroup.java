package eleme.openapi.sdk.api.entity.order;


import eleme.openapi.sdk.api.enumeration.order.OOrderDetailGroupType;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分组(蓝子)
 */
public class OGoodsGroup {
    /**
     * 分组名称||"1号篮子"
     */
    private String name = "";

    /**
     * 分组类型||"normal"
     */
    private OOrderDetailGroupType type;

    /**
     * 商品信息的列表||"[{"categoryId":1123123,"id":2341123,"name":"奶茶","price":10.0,"quantity":30,"total":300.0}]"
     */
    private List<OGoodsItem> items = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OOrderDetailGroupType getType() {
        return type;
    }

    public void setType(OOrderDetailGroupType type) {
        this.type = type;
    }

    public List<OGoodsItem> getItems() {
        return items;
    }

    public void setItems(List<OGoodsItem> items) {
        this.items = items;
    }
}
