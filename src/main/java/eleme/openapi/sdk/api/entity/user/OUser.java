package eleme.openapi.sdk.api.entity.user;

import eleme.openapi.sdk.api.enumeration.user.*;
import eleme.openapi.sdk.api.entity.user.*;
import java.util.*;
import java.time.LocalDateTime;

public class OUser{

    /**
     * 商户Id
     */
    private long userId;
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    /**
     * 商户账号名称
     */
    private String userName;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * 授权的店铺列表
     */
    private List<OAuthorizedShop> authorizedShops;
    public List<OAuthorizedShop> getAuthorizedShops() {
        return authorizedShops;
    }
    public void setAuthorizedShops(List<OAuthorizedShop> authorizedShops) {
        this.authorizedShops = authorizedShops;
    }
    
}