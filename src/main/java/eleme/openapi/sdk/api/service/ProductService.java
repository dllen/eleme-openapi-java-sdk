package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.product.*;
import eleme.openapi.sdk.api.enumeration.product.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品服务
 */
@Service("eleme.product")
public class ProductService extends BaseNopService {
    public ProductService(Config config,Token token) {
        super(config, token, ProductService.class);
    }

    /**
     * 获取一个分类下的所有商品
     *
     * @param categoryId 商品分类Id
     * @return Map<Long,OItem>
     * @throws ServiceException
     */
    public Map<Long,OItem> getItemsByCategoryId(long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    /**
     * 查询商品详情
     *
     * @param itemId 商品Id
     * @return OItem
     * @throws ServiceException
     */
    public OItem getItem(long itemId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        return call(params);
    }

    /**
     * 批量查询商品详情
     *
     * @param itemIds 商品Id的列表
     * @return Map<Long,OItem>
     * @throws ServiceException
     */
    public Map<Long,OItem> batchGetItems(List<Long> itemIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        return call(params);
    }

    /**
     * 添加商品
     *
     * @param categoryId 商品分类Id
     * @param properties 商品属性
     * @return OItem
     * @throws ServiceException
     */
    public OItem createItem(long categoryId, Map<OItemCreateProperty,Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("properties", properties);
        return call(params);
    }

    /**
     * 批量添加商品
     *
     * @param categoryId 商品分类Id
     * @param items 商品属性的列表
     * @return Map<Long,OItem>
     * @throws ServiceException
     */
    public Map<Long,OItem> batchCreateItems(long categoryId, List<Map<OItemCreateProperty,Object>> items) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("items", items);
        return call(params);
    }

    /**
     * 更新商品
     *
     * @param itemId 商品Id
     * @param categoryId 商品分类Id
     * @param properties 商品属性
     * @return OItem
     * @throws ServiceException
     */
    public OItem updateItem(long itemId, long categoryId, Map<OItemUpdateProperty,Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        params.put("categoryId", categoryId);
        params.put("properties", properties);
        return call(params);
    }

    /**
     * 批量置满库存
     *
     * @param specIds 商品及商品规格的列表
     * @return void
     * @throws ServiceException
     */
    public void batchFillStock(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    /**
     * 批量沽清库存
     *
     * @param specIds 商品及商品规格的列表
     * @return void
     * @throws ServiceException
     */
    public void batchClearStock(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    /**
     * 批量上架商品
     *
     * @param specIds 商品及商品规格的列表
     * @return void
     * @throws ServiceException
     */
    public void batchOnShelf(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    /**
     * 批量下架商品
     *
     * @param specIds 商品及商品规格的列表
     * @return void
     * @throws ServiceException
     */
    public void batchOffShelf(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    /**
     * 删除商品
     *
     * @param itemId 商品Id
     * @return OItem
     * @throws ServiceException
     */
    public OItem removeItem(long itemId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        return call(params);
    }

    /**
     * 批量删除商品
     *
     * @param itemIds 商品Id的列表
     * @return Map<Long,OItem>
     * @throws ServiceException
     */
    public Map<Long,OItem> batchRemoveItems(List<Long> itemIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        return call(params);
    }

    /**
     * 批量更新商品库存
     *
     * @param specStocks 商品以及规格库存列表
     * @return void
     * @throws ServiceException
     */
    public void batchUpdateSpecStocks(List<OItemIdWithSpecStock> specStocks) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specStocks", specStocks);
        call(params);
    }

    /**
     * 设置商品排序
     *
     * @param categoryId 商品分类Id
     * @param itemIds 商品Id列表
     * @return void
     * @throws ServiceException
     */
    public void setItemPositions(Long categoryId, List<Long> itemIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("itemIds", itemIds);
        call(params);
    }

    /**
     * 查询店铺商品分类
     *
     * @param shopId 店铺Id
     * @return List<OCategory>
     * @throws ServiceException
     */
    public List<OCategory> getShopCategories(long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call(params);
    }

    /**
     * 查询商品分类详情
     *
     * @param categoryId 商品分类Id
     * @return OCategory
     * @throws ServiceException
     */
    public OCategory getCategory(long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    /**
     * 添加商品分类
     *
     * @param shopId 店铺Id
     * @param name 商品分类名称，长度需在50字以内
     * @param description 商品分类描述，长度需在50字以内
     * @return OCategory
     * @throws ServiceException
     */
    public OCategory createCategory(long shopId, String name, String description) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("name", name);
        params.put("description", description);
        return call(params);
    }

    /**
     * 更新商品分类
     *
     * @param categoryId 商品分类Id
     * @param name 商品分类名称，长度需在50字以内
     * @param description 商品分类描述，长度需在50字以内
     * @return OCategory
     * @throws ServiceException
     */
    public OCategory updateCategory(long categoryId, String name, String description) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("name", name);
        params.put("description", description);
        return call(params);
    }

    /**
     * 删除商品分类
     *
     * @param categoryId 商品分类Id
     * @return OCategory
     * @throws ServiceException
     */
    public OCategory removeCategory(long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    /**
     * 设置分类排序
     *
     * @param shopId 饿了么店铺Id
     * @param categoryIds 需要排序的分类Id
     * @return void
     * @throws ServiceException
     */
    public void setCategoryPositions(Long shopId, List<Long> categoryIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("categoryIds", categoryIds);
        call(params);
    }

    /**
     * 上传图片，返回图片的hash值
     *
     * @param image 文件内容base64编码值
     * @return String
     * @throws ServiceException
     */
    public String uploadImage(String image) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("image", image);
        return call(params);
    }

    /**
     * 通过远程URL上传图片，返回图片的hash值
     *
     * @param url 远程Url地址
     * @return String
     * @throws ServiceException
     */
    public String uploadImageWithRemoteUrl(String url) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("url", url);
        return call(params);
    }

    /**
     * 获取上传文件的访问URL，返回文件的Url地址
     *
     * @param hash 图片hash值
     * @return String
     * @throws ServiceException
     */
    public String getUploadedUrl(String hash) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hash", hash);
        return call(params);
    }
}
