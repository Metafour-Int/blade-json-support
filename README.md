# blade-json-support

Blade JSON 扩展支持，Blade 版本在 `2.0.5-BETA2` 或更高。

## 使用

引入依赖

```xml
<dependency>
    <groupId>com.bladejava</groupId>
    <artifactId>blade-fastjson-support</artifactId>
    <version>0.0.1</version>
<dependency>
```

配置 JSON 支持

```java
JsonKit.jsonSupprt(new FastJsonSupport());
```

