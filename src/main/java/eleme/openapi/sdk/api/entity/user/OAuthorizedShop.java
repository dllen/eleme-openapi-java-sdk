package eleme.openapi.sdk.api.entity.user;

import eleme.openapi.sdk.api.enumeration.user.*;
import eleme.openapi.sdk.api.entity.user.*;
import java.util.*;
import java.math.BigDecimal;

public class OAuthorizedShop{

    /**
     * 店铺Id
     */
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * 店铺名称
     */
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}