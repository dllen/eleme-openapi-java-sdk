# JAVA SDK 接入指南 & CHANGELOG

## API接入指南
  1. JAVA version >= 1.6
  2. 创建Config配置类，填入key，secret和sandbox参数
  3. 使用sdk提供的接口进行开发调试
  4. 上线前将Config中$sandbox值设为false以及填入正式环境的key和secret

## Maven 引入SDK
```xml
<dependency>
    <groupId>me.ele.openapi</groupId>
    <artifactId>eleme-openapi-sdk</artifactId>
    <version>1.0.1</version>
</dependency>
```
## 基本用法
```java
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.api.service.ShopService;

//实例化一个配置类
Config config = new Config(true, "app_key", "app_secret");

//使用config和token对象，实例化一个服务对象
ShopService shopService = new ShopService(config,token);

//调用服务方法，获取资源
OShop shop = shopService.getShop(12345L);

```

## 获取Token
- 企业应用与个人应用的token获取方法略有不同。

- 实际使用过程中，在token获取成功后，该token可以使用较长一段时间，需要缓存起来，请勿每次请求都重新获取token。

> 企业应用

```java
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.oauth.OAuthClient;

//实例化一个配置类
Config config = new Config(true, "app_key", "app_secret");

//使用config对象，实例化一个授权类
OAuthClient client = new OAuthClient(config);

//根据OAuth2.0中的对应state，scope和callback_url，获取授权URL
String authUrl = client.getAuthUrl(redirect_uri, scope, state);

```
商家打开授权URL，同意授权后，跳转到您的回调页面，并返回code

```java
//通过授权得到的code，以及正确的callback_url，获取token
Token token = client.getTokenByCode(autoCode, redirect_uri);
```
> 个人应用

```java
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.oauth.OAuthClient;

//实例化一个配置类
Config config = new Config(true, "app_key", "app_secret");

//使用config对象，实例化一个授权类
OAuthClient client = new OAuthClient(config);

//使用授权类获取token
Token token = client.getTokenInClientCredentials();

```

> 刷新token

- 如果token过期，通过refresh_token换取新的token

```java
//实例化一个配置类
Config config = new Config(true, "app_key", "app_secret");

//使用config对象，实例化一个授权类
OAuthClient client = new OAuthClient(config);

//根据refreshToken,刷新token
Token token = client.getTokenByRefreshToken(refreshToken);

```



## Demo使用方法

该demo主要用来演示企业应用的授权流程和展示应用信息
