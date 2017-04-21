package eleme.openapi.sdk.api.entity.order;

import eleme.openapi.sdk.api.enumeration.order.*;
import eleme.openapi.sdk.api.entity.order.*;
import java.util.*;
public class OGroupItemAttribute{

    /**
     * 属性名称
     */
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 属性值
     */
    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
}