package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.entity.finance.*;
import eleme.openapi.sdk.api.enumeration.finance.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 金融服务
 */
@Service("eleme.finance")
public class FinanceService extends BaseNopService {
    public FinanceService(Config config,Token token) {
        super(config, token, FinanceService.class);
    }

    /**
     * 查询商户余额,返回可用余额和总余额
     *
     * @param shopId 饿了么店铺Id
     * @return 商户余额
     * @throws ServiceException 服务异常
     */
    public OQueryBalanceResponse queryBalance(int shopId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shopId", shopId);
        return call("eleme.finance.queryBalance", params);
    }

    /**
     * 查询余额流水,有流水改动的交易
     *
     * @param request 查询条件
     * @return 余额流水
     * @throws ServiceException 服务异常
     */
    public OBalanceLogResponse queryBalanceLog(OQueryBalanceLogRequest request) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("request", request);
        return call("eleme.finance.queryBalanceLog", params);
    }
}
