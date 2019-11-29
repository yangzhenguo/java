&emsp;&emsp;<code>org.springframework.web.multipart</code>包中的<code>MultipartResolver</code>是用来进行解析包含文件上传的multipart请求的。它有两个实现类，一个是基于[Commons FileUpload](https://jakarta.apache.org/commons/fileupload)的实现，另一个是基于Servlet3.0multipart请求的解析。
&emsp;&emsp;要开启对multipart处理的功能，你需要在<code>DispatcherServlet</code>中声明一个名字叫<code>multipartResolver</code>的<MultipartResolver</code>的bean。<code>DispatcherServlet</code>会自动检测到它并让其处理捕获到的请求。当接收到一个content-type为<code>multipart/form-data</code>的POST请求时，这个解析器会解析请求内容并把<code>HttpServletRequest</code>包装成<code>MultipartHttpServletRequest</code>，这样就能访问到解析后的parts，并把他们暴露为请求参数。
### Apache Commons <code>FileUpload</code>
&emsp;&emsp;要想使用Apache Commons的<code>FileUpload</code>，你得配置一个名称叫<code>multipartResolver</code>的<code>CommonsMultipartResolver</code>。并且还需要在classpath中加入<code>commons-fileupload</code>依赖。
### Servlet 3.0
&emsp;&emsp;如果要使用Servlet3.0来解析multipart，需要配置servlet容器来开启此功能，如下:
* JavaConfig, 在Servlet的registration上设置<code>MultipartConfigElement</code>
* <code>web.xml</code>, 在资源描述符中添加<code>&lt;multipart-config&gt;</code>元素下面的示例展示了如何在Servlet的registration上添加<code>MultipartConfigElement</code>:

```java
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // ...

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // Optionally also set maxFileSize, maxRequestSize, fileSizeThreshold
        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
    }

}
```
&emsp;&emsp;这个Servlet3.0的配置做好后你就可以声明一个名字叫<code>multipartResolver</code>的<code>StandardServletMultipartResolver</code>的bean