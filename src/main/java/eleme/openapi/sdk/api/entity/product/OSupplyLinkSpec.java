package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import eleme.openapi.sdk.api.entity.product.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OSupplyLinkSpec{

    /**
     * 支持冷链的属性名
     */
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 支持冷链的属性值
     */
    private List<String> value;
    public List<String> getValue() {
        return value;
    }
    public void setValue(List<String> value) {
        this.value = value;
    }
    
}