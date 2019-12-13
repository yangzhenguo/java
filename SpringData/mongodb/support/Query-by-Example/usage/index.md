&emsp;&emsp;QBE的api包含三部分:
* Probe: 真正的Example，它是填充了字段的域对象
* ExampleMatcher: ExampleMatcher包含有关如何匹配特定字段的详细信息。可以在多个示例中重复使用它。
* Example: 一个Example由Probe和ExampleMatcher组成。它用于创建查询。
&emsp;&emsp;QBE也适用于这几种情况:
* 使用一组静态或动态约束来查询数据存储。
* 频繁重构域对象，而不必担心破坏现有查询。
* 独立于基础数据存储API进行工作。
&emsp;&emsp;QBE也有一些局限：
* 不支持嵌套或分组属性约束，例如<code>firstname =？0或（firstname =？1和lastname =？2）</code>
* 仅支持字符串的开始/包含/结束/正则表达式匹配，以及其他属性类型的完全匹配。
&emsp;&emsp;在开始使用QBE之前，您需要具有一个域对象。首先，为您的存储库创建一个接口，如以下示例所示：
```java
public class Person {

  @Id
  private String id;
  private String firstname;
  private String lastname;
  private Address address;

  // … getters and setters omitted
}
```
&emsp;&emsp;前面的示例显示了一个简单的域对象。您可以使用它来创建一个Example。默认情况下，具有空值的字段将被忽略，并且使用存储特定的默认值来匹配字符串。可以使用工厂方法或使用ExampleMatcher构建示例。Example是不可修改的。以下清单显示了一个简单的示例：
```java
Person person = new Person();
person.setFirstname("Dave");

Example<Person> example = Example.of(person);         
```
&emsp;&emsp;最好在存储库中执行Example。为此，让您的存储库接口扩展QueryByExampleExecutor <T>。 以下清单显示了QueryByExampleExecutor接口的摘录：
```java
public interface QueryByExampleExecutor<T> {

  <S extends T> S findOne(Example<S> example);

  <S extends T> Iterable<S> findAll(Example<S> example);

  // … more functionality omitted.
}
```