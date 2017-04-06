package eleme.openapi.sdk.api.service;

import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.base.BaseNopService;
import eleme.openapi.sdk.api.entity.message.OMessage;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.config.OverallContext;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eleme.message")
public class MessageService extends BaseNopService {
    public MessageService(OverallContext context, Token token) {
        super(context, token, MessageService.class);
    }

    public List<String> getNonReachedMessages(int appId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", appId);
        return call(params);
    }

    public List<OMessage> getNonReachedOMessages(int appId) throws ServiceException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", appId);
        return call(params);
    }
}
