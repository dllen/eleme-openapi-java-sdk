package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import eleme.openapi.sdk.api.entity.product.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OBatchModifiedFailure{

    /**
     * 批量操作失败的ID
     */
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * 操作失败Code
     */
    private ModifiedErrorCode code;
    public ModifiedErrorCode getCode() {
        return code;
    }
    public void setCode(ModifiedErrorCode code) {
        this.code = code;
    }
    
    /**
     * 失败原因
     */
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}