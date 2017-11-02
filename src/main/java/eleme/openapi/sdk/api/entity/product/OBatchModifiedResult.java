package eleme.openapi.sdk.api.entity.product;

import eleme.openapi.sdk.api.enumeration.product.*;
import eleme.openapi.sdk.api.entity.product.*;
import java.util.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OBatchModifiedResult{

    /**
     * ID类型
     */
    private IdType type;
    public IdType getType() {
        return type;
    }
    public void setType(IdType type) {
        this.type = type;
    }
    
    /**
     * 操作成功的ID列表
     */
    private List<Long> modifications;
    public List<Long> getModifications() {
        return modifications;
    }
    public void setModifications(List<Long> modifications) {
        this.modifications = modifications;
    }
    
    /**
     * 操作失败的ID以及失败原因列表
     */
    private List<OBatchModifiedFailure> failures;
    public List<OBatchModifiedFailure> getFailures() {
        return failures;
    }
    public void setFailures(List<OBatchModifiedFailure> failures) {
        this.failures = failures;
    }
    
}