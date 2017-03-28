# JAVA SDK 接入指南 & CHANGELOG

## API接入指南
  1. 检查Java版本 java >= 1.6
  2. 初始化OverallContext类
   - 构造参数一(isSandbox): true(沙箱环境),false(生产环境)
   - 构造参数二(key): 当前环境下APP对应的KEY
   - 构造参数三(secret): 当前环境下APP对应的SECRET

## API调用代码示例

### 企业应用

  - 第一步 设置全局配置工具类

```java
    OverallContext context = new OverallContext(ture, "key", "secret");
```

  - 第二步 创建OAuthClient对象

```java
    OAuthClient oAuthClient = OAuthClient.INSTANCE;
```

  - 第三步 获取生成授权url

```java
    String authUrl = oAuthClient.getAuthUrl(callbackUrl, scope, state);
```

  - 第四步 在授权url中同意授权后，会跳转到CALLBACK_URL的页面，在通过链接上的参数，获取授权码code

  - 第五步 通过code获取Token对象，要注意的是，此token在有效期内可重复使用，请将其全局保存，不要每次接口调用前申请一次Token

```java
    Token token = oAuthClient.getTokenByCode(code, redirectUrl);
```

  - 第六步 实例化一个资源服务并注入token，例如店铺服务

```java
    ShopService shopService = new ShopService(token);
```

  - 第七步 调用接口，获取资源数据

```java
    OShop shop = shopService.getShop(12345);
```

  - 第八步 如果token过期，通过refreshToken换取新的token

```java
    Token freshToken = oAuthClient.getTokenByRefreshToken(token.getToken().getRefreshToken(), scope);
```

### 个人应用

  - 第一步 创建OAuthClient对象

```java
    OAuthClient oAuthClient = OAuthClient.INSTANCE;
```

  - 第二步 获取Token对象，要注意的是，此token在有效期内可重复使用，请将其全局保存，不要每次接口调用前申请一次Token

```java
    Token token = oAuthClient.getTokenInClientCredentials();
```

  - 第三步 实例化一个资源服务并注入token，例如店铺服务

```java
    ShopService shopService = new ShopService(token);
```

  - 第四步 调用接口，获取资源数据

```java
    OShop shop = shopService.getShop(12345l);
```
