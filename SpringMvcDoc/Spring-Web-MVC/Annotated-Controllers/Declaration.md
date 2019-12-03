&emsp;&emsp;你可以通过使用Servlet的<code>WebApplicationContext</code>中定义的标准Spring bean定义来定义控制器bean，@<code>Controller</code>构造型允许自动检测，与Spring对在类路径中检测@<code>Component</code>类并为其自动注册Bean定义的常规支持保持一致。 它还充当带注释类的构造型，表明其作为Web组件的作用。

&emsp;&emsp;要启用对@<code>Controller</code> bean的自动检测，可以将组件扫描添加到Java配置中，如以下示例所示：

```java
@Configuration
@ComponentScan("org.example.web")
public class WebConfig {

    // ...
}
```

&emsp;&emsp;下面的示例显示与前面的示例等效的XML配置：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="org.example.web"/>

    <!-- ... -->

</beans>
```

&emsp;&emsp;@<code>RestController</code>是一个组合注解，其本身使用@<code>Controller</code>和@<code>ResponseBody</code>进行了元注释，以指示一个控制器，其每个方法都继承了类型级别的@<code>ResponseBody<code>注解，因此直接将其写入响应主体（与视图分辨率相对应）并使用 HTML模板。


