[toc]

## logback功能
### 将error日志和普通打印打印分开
- 在appender中增加过滤器
```xml
    <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
        <level>WARN</level>
    </filter>
```
### 设置日志文件大小和时效
- TimeBasedRollingPolicy 升级为 SizeAndTimeBasedRollingPolicy
- fileNamePattern需要增加.%i用于文件分割
- maxHistory为最多保留天数
- totalSizeCap为日志容量;防止日志占用服务器太多资源

### 区分不同的环境
- 如果使用<root>标签则代表所有环境统一,也可以根据不同的环境设置不同的打印方式
如:
```xml
 <springProfile name = "dev">
        <root level="info" additivity="false">
            <appender-ref ref="console-local" />
            <appender-ref ref="ALL" />
            <appender-ref ref="ERROR_FILE" />
        </root>
    </springProfile>
```
- 注意自定义后不可在使用<root>标签会造成日志会打印两份
### 链路追踪
- @see org.slf4j.MDC
- MDC在logback中用%X可以获取；假设有代码：
```java
MDC.put("tid", UUIDUtils.getUUID());
```
则可以在logback中用%X{tid} 获取到该值 ， 这样便于链路追踪的日志打印
