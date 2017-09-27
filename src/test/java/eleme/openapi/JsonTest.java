package eleme.openapi;

import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.entity.other.OMessage;
import eleme.openapi.sdk.utils.JacksonUtils;

public class JsonTest {

    public static void main(String[] args) {

        /**
         * 测试Jackson 转换时间会多一天的问题
         * 通过设置 objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")); 解决
         */
        String s = "{\"requestId\":\"200005573145842090\",\"type\":10,\"appId\":95784565,\"message\":\"{\\\"id\\\":\\\"3012966986714717290\\\",\\\"orderId\\\":\\\"3012966986714717290\\\",\\\"address\\\":\\\"启光艾加大厦上海市静安区延长中路581号3楼\\\",\\\"createdAt\\\":\\\"2017-09-27T18:12:10\\\",\\\"activeAt\\\":\\\"2017-09-27T18:12:10\\\",\\\"deliverFee\\\":0.0,\\\"deliverTime\\\":null,\\\"description\\\":\\\"\\\",\\\"groups\\\":[{\\\"name\\\":\\\"1号篮子\\\",\\\"type\\\":\\\"normal\\\",\\\"items\\\":[{\\\"id\\\":623050784,\\\"skuId\\\":238364002730,\\\"name\\\":\\\"柠檬红茶-小杯\\\",\\\"categoryId\\\":1,\\\"price\\\":0.01,\\\"quantity\\\":1,\\\"total\\\":0.01,\\\"additions\\\":[],\\\"newSpecs\\\":[{\\\"name\\\":\\\"规格\\\",\\\"value\\\":\\\"小杯\\\"}],\\\"attributes\\\":[],\\\"extendCode\\\":\\\"\\\",\\\"barCode\\\":\\\"\\\",\\\"weight\\\":1.0,\\\"userPrice\\\":0.0,\\\"shopPrice\\\":0.0,\\\"vfoodId\\\":606979105},{\\\"id\\\":623052833,\\\"skuId\\\":238366100906,\\\"name\\\":\\\"柠檬绿茶\\\",\\\"categoryId\\\":1,\\\"price\\\":20.09,\\\"quantity\\\":2,\\\"total\\\":40.18,\\\"additions\\\":[],\\\"newSpecs\\\":[],\\\"attributes\\\":[],\\\"extendCode\\\":\\\"\\\",\\\"barCode\\\":\\\"\\\",\\\"weight\\\":1.0,\\\"userPrice\\\":0.0,\\\"shopPrice\\\":0.0,\\\"vfoodId\\\":606976851}]},{\\\"name\\\":\\\"其它费用\\\",\\\"type\\\":\\\"extra\\\",\\\"items\\\":[{\\\"id\\\":-70000,\\\"skuId\\\":-1,\\\"name\\\":\\\"餐盒\\\",\\\"categoryId\\\":102,\\\"price\\\":0.01,\\\"quantity\\\":1,\\\"total\\\":0.01,\\\"additions\\\":[],\\\"newSpecs\\\":null,\\\"attributes\\\":null,\\\"extendCode\\\":\\\"\\\",\\\"barCode\\\":\\\"\\\",\\\"weight\\\":null,\\\"userPrice\\\":0.0,\\\"shopPrice\\\":0.0,\\\"vfoodId\\\":0}]}],\\\"invoice\\\":null,\\\"book\\\":false,\\\"onlinePaid\\\":true,\\\"railwayAddress\\\":null,\\\"phoneList\\\":[\\\"18512177992\\\"],\\\"shopId\\\":150128203,\\\"shopName\\\":\\\"外卖整合平台测试店铺\\\",\\\"daySn\\\":1,\\\"status\\\":\\\"unprocessed\\\",\\\"refundStatus\\\":\\\"noRefund\\\",\\\"userId\\\":66995398,\\\"totalPrice\\\":39.7,\\\"originalPrice\\\":40.2,\\\"consignee\\\":\\\"杜(女士)\\\",\\\"deliveryGeo\\\":\\\"121.44945005,31.26895993\\\",\\\"deliveryPoiAddress\\\":\\\"启光艾加大厦上海市静安区延长中路581号3楼\\\",\\\"invoiced\\\":false,\\\"income\\\":40.2,\\\"serviceRate\\\":0.0,\\\"serviceFee\\\":-0.0,\\\"hongbao\\\":-0.5,\\\"packageFee\\\":0.01,\\\"activityTotal\\\":-0.0,\\\"shopPart\\\":-0.0,\\\"elemePart\\\":-0.0,\\\"downgraded\\\":false,\\\"vipDeliveryFeeDiscount\\\":0.0,\\\"openId\\\":\\\"\\\",\\\"secretPhoneExpireTime\\\":null,\\\"orderActivities\\\":[],\\\"invoiceType\\\":null,\\\"taxpayerId\\\":\\\"\\\",\\\"coldBoxFee\\\":0.0}\",\"shopId\":150128203,\"timestamp\":1506507130645,\"signature\":\"F77C85FD237239C2B3CB074D1887587E\",\"userId\":411391574328276013}";

        String message = JacksonUtils.json2pojo(s, OMessage.class).getMessage();
        System.out.println(message);

        OOrder order = JacksonUtils.json2pojo(message,OOrder.class);

        System.out.println(JacksonUtils.obj2json(order));


    }
}
