&emsp;&emsp;正如Spring Web MVC框架所做的那样，Spring体系结构的大多数部分都支持国际化。<code>DispatcherServlet</code>可以使用客户端的语言环境自动解析消息。这是通过<code>LocaleResolver</code>对象完成的。

&emsp;&emsp;当接收到一个请求时，<code>DispatcherServlet</code>会查找locale解析器，如果找到了一个后就会用它设置locale。通过调用<code>RequestContext.getLocale()</code>方法，你可以获取被locale解析器解析过的locale。

&emsp;&emsp;除了自动的语言环境解析之外，您还可以在处理程序映射上添加一个拦截器（有关处理程序映射拦截器的更多信息，请参见拦截），以在特定情况下（例如，基于请求中的参数）更改语言环境。

&emsp;&emsp;语言环境解析器和拦截器在<code>org.springframework.web.servlet.i18n</code>包中定义，并以常规方式在应用程序上下文中进行配置。 Spring包含以下locale解析器。

* Time Zone

&emsp;&emsp;除了获取客户端的locale外，知道其时区通常也很有用。<code>LocaleContextResolver</code>接口提供了对<code>LocaleResolver</code>的扩展，该扩展使解析器可以提供更丰富的LocaleContext，其中可能包含时区信息。

&emsp;&emsp;如果可以的话，可以使用<code>RequestContext.getTimeZone()</code>方法获取用户的<code>TimeZone</code>。通过Spring的<code>ConversionService</code>注册的处理日期/时间<code>Converter</code>和<code>Formatter</code>对象都会使用这个Time zone信息。

* Header Resolver

&emsp;&emsp;这个Locale解析器会检查由客户端(比如web浏览器)发送的请求头<code>accept-language</code>。通常，这个请求头包含了客户端操作系统的locale。注意这个解析器不支持时区信息。

* Cookie Resoler

&emsp;&emsp;这个Locale解析器会检查客户端可能存在的<code>Cookie</code>，查看它是否指定了<code>Locale</code>或者<code>TimeZone</code>。如果是这样，他就会使用它的详细信息。通过设置这个解析器的属性，可以指定cookie的名称还有最长期限。一下示例定义了<code>CookieLocaleResolver</code>:

```xml
<bean id="localeResolver" class="org.springframework.web.servlet.i18n.CookieLocaleResolver">

    <property name="cookieName" value="clientlanguage"/>

    <!-- in seconds. If set to -1, the cookie is not persisted (deleted when browser shuts down) -->
    <property name="cookieMaxAge" value="100000"/>

</bean>
```
&emsp;&emsp;下表展示了<code>CookieLocaleResolver</code>的属性信息

|Property|Default|Description|
|-|-|-|
|cookieName|类名+LOCALE|cookie的名字|
|cookieMaxAgen|Servlet容器默认值|客户单cookie持久化最长时间，为<code>-1</code>的话表示不持久化，浏览器关闭之前一直可用|
|cookiePath|/|将cookie的可见性限制为网站的特定部分，如果指定了<code>cookiePath</code>，这个cookie只对这个路径和它的子路径起作用|

* Session Resolver

&emsp;&emsp;通过<code>SessionLocaleResolver</code>，您可以从可能与用户请求关联的会话中检索<code>Locale</code>和<code>TimeZone</code>。 与<code>CookieLocaleResolver</code>相比，此策略将本地选择的locale设置存储在Servlet容器的<code>HttpSession</code>中。 结果，这些设置对于每个会话都是临时的，因此在每个会话终止时会丢失。

&emsp;&emsp;请注意，与外部会话管理机制（例如Spring Session项目）没有直接关系。 该<code>SessionLocaleResolver</code>针对当前<code>HttpServletRequest</code>评估并修改相应的<code>HttpSession</code>属性。

* Locale Interceptor

&emsp;&emsp;您可以通过将<code>LocaleChangeInterceptor</code>添加到<code>HandlerMapping</code>定义之一来启用locale更改。 它检测请求中的参数并相应地更改语言环境，在调度程序的应用程序上下文中在<code>LocaleResolver</code>上调用<code>setLocale</code>方法。 下一个示例显示对包含名为<code>siteLanguage</code>的参数的所有<code>*.view</code>资源的调用现在会更改语言环境。 因此，例如，对URL的请求https://www.sf.net/home.view?siteLanguage=nl会将站点语言更改为荷兰语。 以下示例显示如何拦截locale：

```xml
<bean id="localeChangeInterceptor"
        class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
    <property name="paramName" value="siteLanguage"/>
</bean>

<bean id="localeResolver"
        class="org.springframework.web.servlet.i18n.CookieLocaleResolver"/>

<bean id="urlMapping"
        class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
    <property name="interceptors">
        <list>
            <ref bean="localeChangeInterceptor"/>
        </list>
    </property>
    <property name="mappings">
        <value>/**/*.view=someController</value>
    </property>
</bean>
```