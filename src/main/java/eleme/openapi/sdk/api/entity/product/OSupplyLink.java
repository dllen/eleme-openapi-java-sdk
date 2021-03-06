package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import eleme.openapi.sdk.api.entity.product.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OSupplyLink{

    /**
     * 链路类型
     */
    private Integer type;
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    
    /**
     * 支持该链路类型的属性
     */
    private List<OSupplyLinkSpec> minorSpec;
    public List<OSupplyLinkSpec> getMinorSpec() {
        return minorSpec;
    }
    public void setMinorSpec(List<OSupplyLinkSpec> minorSpec) {
        this.minorSpec = minorSpec;
    }
    
}