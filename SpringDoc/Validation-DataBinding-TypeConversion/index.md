* [使用Spring Validator接口校验](Validation-by-Using-Spring-Validator-Interface.md)
* [将Code解析为错误消息](Resolving-Codes2Error-Messages.md)

# 校验、数据绑定和类型转换

&emsp;&emsp;在业务逻辑中进行数据校验既有利又有弊，Spring提供了一种校验(及数据绑定)设计，这种设计包含了校验和数据绑定两者。具体来说，数据校验不应耦合到web层，并且它应该易于本地化和在任何可用的验证器中可插拔。基于这点，Spring引入了<code>Validator</code>接口，该接口是基础接口，并且在应用的各个层都非常有用。

&emsp;&emsp;数据绑定用于把用户输入内容(比如参数等)动态绑定到应用程序的Model。Spring提供了一个名称叫<code>DataBinder</code>的类来做这个工作。<code>Validator</code>接口和<code>DataBinder</code>类组成了<code>validatio</code>包，这个包主要用于MVC框架，它也可以用在其他地方。

&emsp;&emsp;<code>BeanWrapper</code>接口是Spring框架中的基本概念，并在很多地方会用到。你可能不会直接用到它，但是基于这是一个参考文档，所以我们认为有必要解释一下。我们将会在本章介绍它，因为尝试将数据绑定到对象时最有可能用到它。

&emsp;&emsp;Spring的<code>DataBinder</code>和较低级别的<code>BeanWrapper</code>都使用<code>PropertyEditorSupport</code>实现来解析和格式化属性值。<code>PropertyEditor</code>接口和<code>PropertyEditorSupport</code>类是JavaBeans规范的一部分，本章还会对此说明。Spring3引入了提供常规的类型转换工具的<code>core.convert</code>包和用于格式化UI属性值的<code>format</code>包。你可以将这些包用作<code>PropertyEditorSupport</code>实现类的替代方案。本章还将对此进行讨论。

### JSR-303/JSR-349 Bean Validation

&emsp;&emsp;从Spring4.0开始，Spring框架Bean Validation 1.0(JSR-303)和Bean Validation 1.1(JSR-349)来提供设置支持，并使它们适应Spring的<code>Validator</code>接口。<br/>

&emsp;&emsp;应用程序可以选择在全局一次性启用Bean Validation(如Spring Validation中所述), 并将其专用于所有验证需求。<br/>

&emsp;&emsp;应用程序还可以为每个<code>DataBinder</code>实例注册其他Spring <code>Validator</code>实例，如 [配置<code>DataBinder</code>](jfj.md)所述<br/>
