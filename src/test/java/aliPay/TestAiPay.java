package aliPay;//package aliPay;
//
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.request.AlipayTradePayRequest;
//import com.alipay.api.response.AlipayTradePayResponse;
//
//public class TestAiPay {
//    public static void main(String[] args){
//
//        //商户注册的app_id
//        String app_id = "2017071007705223";
//        String seller_id = "2088021273428911";
//        //商户生成的私钥
//        String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDM2oB7EHajKdxwkpsU7wlIdOp6nYlXJFR51+MWzVNyanzGmEo02xblqGB4JaV0rDOcKbrHWC9J3nBgAuzWFBU8EIhYWR+op2hYdjANb4gTl/o4rKskK+BcrQBzXyb/K1RoLYt9xVJNE/BME1lVSt4e5x+mEvmV3jWEuAYjcvzXu4sMNO8Ew/QptLAdOQvgat2TZl4EYnbNPz40GXpR5aFvr///KCyIc82HecloFFNdDBVCvmfc1uNAIJOrTdhkw2E4RjdS+7ucLgeHhjgRTDn4+iYZxqBIp3gueLsOy8YWwhp5xzH0xrfkxmO07NlIrcXlFGXqnEbUJcx51rvHuqe7AgMBAAECggEAZxmxgD6Q9x2ibKXcl3SW33i4am3PKaSHP6uAB4Hfdb5SfkE3V9LMe1l68/0+gLIKZ5Y5AwtHAY6KUEgomrYQ2eIYPR7d6CwZQCx7kseHXRUoQk3k9JeAnCQWDfrdzZ8pJCWIBwzAlzppvmAenebIVBVOwG7cXqkvllRoAn9k8c3yRjrfip+P43/QvW3J/eAklr+dO6rIQOyIpdHFHtDcovYjuaUFVTuXR3udbQfhnI6JCwDw8KDZ28DvEeDAH351q0+Y8eDhbXgvr0VHIunIuWDSEoaRx7CuF73PptqeKbLrT1y9Ff/7TYgrFXWV2NtdJE9jyg1P8KW0qL5fUb5aAQKBgQD9SWe+sPrsQkQUtH5Uasa1ASkFF6iYXMqAE/+e/wZ8W1P8yzlVghbXW8Nlukg7AeUyVZxoIbGEeubYbkpJaa8t9fQsCY4SEu3n0OOLKIMUkp361XEp5eLuVLPLgXzyv9QSHiW9CxkByR86iAcyAQ0nfEvIbVqZ/uyqus4hgbqGYQKBgQDPDEbnY9+sq0a5m0hZnK4DA9VAnyy0z0shNDMa1oUGQLuUjxOLIeyav9ajcOg7ltHnIvM2yxbiPigTYqRrhmvk8u18d3xKPVz0wDiTI+ORiY2wzE65JZbbX1uyWz7EZ3/oLV9rdCnh9p62M6jnLufqGbT+ZtVPtnHHiltuX9krmwKBgQCo5C2dZf2rVHR5KfGi8KAXSfLERoZRMm6FANDOgFcezPcv9YMBlYENkU61ooVPc3AVJCjq9qycHieX4dL/KM165Cowwx5MxvqEPTG9NQJS0YEuJO0UdwneyfQpmupqI6eRfTDE4YWHP0jnipThrvnKfoM53lEvpmDBZ1bT2OE7gQKBgFOJdoohh7uZF14Hwvc0+hiJUV9TWaxR/tQUxZHMf7t4Hrbfy1jVhSsiv60N/wUb4vDI7yxqYH9D6NN5dzFS+PFU+nC/nMwvWfP+IlVro4Oy5hIxPIoDGozEOrEJk5eW0sqQk/E82zEqWfrVeQ5dpICVgqsqPmJ9EAccUauEzJCFAoGAKP3e8X/3f4YVHHprWXQdI90wdreZs14ab9XXpVorKP0kSkUj22VZ2pCBVp6UfqQtz5JxcH/RJJsE20iG1jtCvznz+0EESfGU5Xnzqe5BH59WiymAQpRdrRJVgJNLfYr3n6MAL96swuPsF8AjCwSzt1v15KPeSSNcG2/Yq+4vmGs=";
//        //支付宝公钥
//        String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgJMhJfGtEm/Br6ryOciVf7QSukz1yqzfYd+a5eYvxAtu3cfuQ1JNM5potW+FyofYG/hO9IiYe9MqLwcLUKj7P9LYwS8z/SYsidv0AHZc1AawsVaAzKmC+zye1hqetY0QE6/bv0k+H1Q9ljZEEtRvUI5xZ6Rd6E7YfuPll+B7bN9Ti0neAPxSLP+qG29C87fBEHoNbf56+ClqIEl4f06Oc+7kSuQ9KNbj9kZkn/TgLtA/gagZy5CyoOJDiGAemGwBjlIdNl19vEmC0VEPylhGgPMS7F8NjBtONOCh2R5nh9sjgNZeS8uwBwYPC3rw6Kkr7t6RnR1hSu20UYfkxrc7vwIDAQAB";
//
//
//
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",app_id,private_key,"json","GBK",alipay_public_key,"RSA2");
//        AlipayTradePayRequest request = new AlipayTradePayRequest();
//        String out_trade_no = "aiPay201712101252";
//        request.setBizContent("{" +
//                "\"out_trade_no\":\"aiPay201712101252\"," +
//                "\"scene\":\"bar_code\"," +
//                "\"auth_code\":\"285528555645388832\"," +
//                "\"product_code\":\"FACE_TO_FACE_PAYMENT\"," +
//                "\"subject\":\"测试ali支付\"," +
//                "\"buyer_id\":\"2088202954065786\"," +
//                "\"seller_id\":\"2088021273428911\"," +
//                "\"total_amount\":0.01," +
//                "\"discountable_amount\":0.00," +
//                "\"body\":\"测试ali支付\","+
//                "\"goods_detail\":[{" +
//                "\"goods_id\":\"apple-01\"," +
//                "\"goods_name\":\"ipad\"," +
//                "\"quantity\":1," +
//                "\"price\":2000," +
//                "\"goods_category\":\"34543238\"," +
//                "\"body\":\"测试ali支付\"," +
//                "\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
//                "}]," +
//                "\"operator_id\":\"yx_001\"," +
//                "\"store_id\":\"NJ_001\"," +
//                "\"terminal_id\":\"NJ_T_001\"," +
//                "\"extend_params\":{" +
//                "\"sys_service_provider_id\":\"2088511833207846\"" +
//                "}," +
//                "\"timeout_express\":\"90m\"" +
//                "}");
//
//        AlipayTradePayResponse response = null;
//        try {
//            response = alipayClient.execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//        if(response.isSuccess()){
//            System.out.println("调用成功");
//        } else {
//            System.out.println("调用失败");
//        }
//    }
//}
