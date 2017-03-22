package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.OAuthException;
import eleme.openapi.sdk.oauth.response.OAuthResponse;
import eleme.openapi.sdk.api.entity.product.*;
import eleme.openapi.sdk.api.enumeration.product.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.product")
public class ProductService extends BaseNopService {
    public ProductService(OAuthResponse oAuthResponse) {
        super(oAuthResponse, ProductService.class);
    }

    /**
     * 获取一个分类下的所有商品
     */
    public Map<Long,OItem> getItemsByCategoryId(long categoryId) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    /**
     * 查询商品详情
     */
    public OItem getItem(long itemId) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        return call(params);
    }

    /**
     * 批量查询商品详情
     */
    public Map<Long,OItem> batchGetItems(List<Long> itemIds) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        return call(params);
    }

    /**
     * 添加商品
     */
    public OItem createItem(long categoryId, Map<OItemCreateProperty,Object> properties) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("properties", properties);
        return call(params);
    }

    /**
     * 批量添加商品
     */
    public Map<Long,OItem> batchCreateItems(long categoryId, List<Map<OItemCreateProperty,Object>> items) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("items", items);
        return call(params);
    }

    /**
     * 更新商品
     */
    public OItem updateItem(long itemId, long categoryId, Map<OItemUpdateProperty,Object> properties) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        params.put("categoryId", categoryId);
        params.put("properties", properties);
        return call(params);
    }

    /**
     * 批量置满库存
     */
    public void batchFillStock(List<OItemIdWithSpecIds> specIds) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    /**
     * 批量沽清库存
     */
    public void batchClearStock(List<OItemIdWithSpecIds> specIds) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    /**
     * 批量上架商品
     */
    public void batchOnShelf(List<OItemIdWithSpecIds> specIds) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    /**
     * 批量下架商品
     */
    public void batchOffShelf(List<OItemIdWithSpecIds> specIds) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    /**
     * 删除商品
     */
    public OItem removeItem(long itemId) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        return call(params);
    }

    /**
     * 批量删除商品
     */
    public Map<Long,OItem> batchRemoveItems(List<Long> itemIds) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        return call(params);
    }

    /**
     * 查询店铺商品分类
     */
    public List<OCategory> getShopCategories(long shopId) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call(params);
    }

    /**
     * 查询商品分类详情
     */
    public OCategory getCategory(long categoryId) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    /**
     * 添加商品分类
     */
    public OCategory createCategory(long shopId, String name, String description) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("name", name);
        params.put("description", description);
        return call(params);
    }

    /**
     * 更新商品分类
     */
    public OCategory updateCategory(long categoryId, String name, String description) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("name", name);
        params.put("description", description);
        return call(params);
    }

    /**
     * 删除商品分类
     */
    public OCategory removeCategory(long categoryId) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    /**
     * 上传图片，返回图片的hash值
     */
    public String uploadImage(String image) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("image", image);
        return call(params);
    }

    /**
     * 通过远程URL上传图片，返回图片的hash值
     */
    public String uploadImageWithRemoteUrl(String url) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("url", url);
        return call(params);
    }

    /**
     * 获取上传文件的访问URL，返回文件的Url地址
     */
    public String getUploadedUrl(String hash) throws ServiceException, OAuthException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hash", hash);
        return call(params);
    }
}
