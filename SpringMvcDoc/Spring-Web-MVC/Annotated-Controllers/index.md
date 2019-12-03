&emsp;&emsp;Spring MVC提供了一个基于注释的编程模型，其中@<code>Controller</code>和@<code>RestController</code>组件使用注释来表达请求映射，请求输入，异常处理等。 带注释的控制器具有灵活的方法签名，无需扩展基类或实现特定的接口。 以下示例展示了由注释定义的控制器：

```java
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String handle(Model model) {
        model.addAttribute("message", "Hello World!");
        return "index";
    }
}
```

&emsp;&ems;在前面的示例中，该方法接受<code>Model</code>并以<code>String</code>的形式返回视图名称，但是还存在许多其他选项，本章稍后将对其进行说明。
