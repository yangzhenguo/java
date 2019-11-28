# 使用Spring Validator接口校验

&emsp;&emsp;Spring具有<code>Validator</code>接口，它可用于验证对象。<code>Validator</code>接口通过使用Errors对象来工作，以便验证器在验证的时候将错误信息报告给Errors对象。

考虑下面小数据对象示例:
```java
public class Person {

    private String name;
    private int age;

    // the usual getters and setters...
}
```

&emsp;&emsp;下面的示例通过实现<code>org.springframework.validation.Validator</code>接口的以下两个方法来提供<code>Person<code>类的验证行为：
* <code>support（Class）</code>：此<code>Validator</code>可以验证提供的<code>Class</code>的实例吗？

* <code>validate（Object，org.springframework.validation.Errors）</code>：验证给定的对象，并在发生验证错误的情况下，向给定的<code>Errors</code>对象注册这些对象。

实现<code>Validator</code>非常简单，尤其是当您知道Spring Framework也提供的<code>ValidationUtils</code>帮助器类时。 以下示例实现了用于<code>Person</code>实例的<code>Validator</code>：
```java
public class PersonValidator implements Validator {

    /**
     * This Validator validates only Person instances
     */
    public boolean supports(Class clazz) {
        return Person.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Person p = (Person) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "negativevalue");
        } else if (p.getAge() > 110) {
            e.rejectValue("age", "too.darn.old");
        }
    }
}
```
&emsp;&emsp;<code>ValidationUtils</code>类的<code>static</code>方法<code>rejectIfEmpty</code>用于拒绝<code>name</code>属性(如果该属性为<code>null</code>或为空字符串).看看它除了提供上面显示的示例外还提供了什么功能。


&emsp;&emsp;虽然可以实现单个<code>Validator</code>类来验证复合对象中的每个嵌套对象，但最好在其自己的<code>Validator</code>实现中封装对象的每个嵌套类的验证逻辑。一个复合对象的简单示例是<code>Customer</code>，它由两个<code>String</code>属性(first name和second name)和一个复杂<code>Addrss</code>对象组成。<code>Address</code>对象可以独立于<code>Customer</code>对象使用，因此实现了不同的<code>AddressValidator</code>。如果希望<code>CustomerValidator</code>重用<code>AddressValidator</code>类中包含的逻辑而不是求助于复制粘贴，则可以在<code>CustomerValidator</code>中依赖注入或实例化一个<code>AddressValidator</code>，如下示例所示:
```java
public class CustomerValidator implements Validator {

    private final Validator addressValidator;

    public CustomerValidator(Validator addressValidator) {
        if (addressValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is " +
                "required and must not be null.");
        }
        if (!addressValidator.supports(Address.class)) {
            throw new IllegalArgumentException("The supplied [Validator] must " +
                "support the validation of [Address] instances.");
        }
        this.addressValidator = addressValidator;
    }

    /**
     * This Validator validates Customer instances, and any subclasses of Customer too
     */
    public boolean supports(Class clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "field.required");
        Customer customer = (Customer) target;
        try {
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(this.addressValidator, customer.getAddress(), errors);
        } finally {
            errors.popNestedPath();
        }
    }
}
```
&emsp;&emsp;验证错误将报告传递给验证器的<code>Errors</code>对象，对于Spring Web MVC，可以使用<code>&lt;spring: bind/&gt;</code>标签检查错误消息，但也可以自行检查<code>Errors</code>对象。有关它提供的方法的更多信息可以在javadoc中查找。
