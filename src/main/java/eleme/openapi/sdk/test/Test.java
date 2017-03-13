package eleme.openapi.sdk.test;

import eleme.openapi.sdk.conf.OverallContext;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        OverallContext context = OverallContext.getInstance();
        context.setApp_key("aaaaaa");
        System.out.println(context);
        OverallContext context1 = OverallContext.getInstance();
        System.out.println(context1.getApp_key());
        System.out.println(context1);


    }

    private static void test() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(methodName);
        System.out.println(Arrays.asList(Thread.currentThread().getStackTrace()));
    }


}
