package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.entity.product.OCategory;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.entity.product.OItemIdWithSpecIds;
import eleme.openapi.sdk.api.enumeration.product.OItemCreateProperty;
import eleme.openapi.sdk.api.enumeration.product.OItemUpdateProperty;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.product")
public class ProductService extends BaseNopService {
    public ProductService(OverallContext overallContext, Token token) {
        super(overallContext, token, ProductService.class);
    }

    public Map<Long, OItem> getItemsByCategoryId(long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    public OItem getItem(long itemId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        return call(params);
    }

    public Map<Long, OItem> batchGetItems(List<Long> itemIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        return call(params);
    }

    public OItem createItem(long categoryId, Map<OItemCreateProperty, Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("properties", properties);
        return call(params);
    }

    public Map<Long, OItem> batchCreateItems(long categoryId, List<Map<OItemCreateProperty, Object>> items) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("items", items);
        return call(params);
    }

    public OItem updateItem(long itemId, long categoryId, Map<OItemUpdateProperty, Object> properties) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        params.put("categoryId", categoryId);
        params.put("properties", properties);
        return call(params);
    }

    public void batchFillStock(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    public void batchClearStock(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    public void batchOnShelf(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    public void batchOffShelf(List<OItemIdWithSpecIds> specIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("specIds", specIds);
        call(params);
    }

    public OItem removeItem(long itemId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemId", itemId);
        return call(params);
    }

    public Map<Long, OItem> batchRemoveItems(List<Long> itemIds) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemIds", itemIds);
        return call(params);
    }

    public List<OCategory> getShopCategories(long shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call(params);
    }

    public OCategory getCategory(long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    public OCategory createCategory(long shopId, String name, String description) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        params.put("name", name);
        params.put("description", description);
        return call(params);
    }

    public OCategory updateCategory(long categoryId, String name, String description) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("name", name);
        params.put("description", description);
        return call(params);
    }

    public OCategory removeCategory(long categoryId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return call(params);
    }

    public String uploadImage(String image) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("image", image);
        return call(params);
    }

    public String uploadImageWithRemoteUrl(String url) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("url", url);
        return call(params);
    }

    public String getUploadedUrl(String hash) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hash", hash);
        return call(params);
    }
}
