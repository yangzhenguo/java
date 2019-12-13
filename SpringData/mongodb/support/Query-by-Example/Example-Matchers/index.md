&emsp;&emsp;Example不限于默认设置。您可以使用ExampleMatcher为字符串匹配，空值处理和特定于属性的设置指定自己的默认值，如以下示例所示：
```java
Person person = new Person();
person.setFirstname("Dave");

ExampleMatcher matcher = ExampleMatcher.matching()
  .withIgnorePaths("lastname")
  .withIncludeNullValues()
  .withStringMatcherEnding();

Example<Person> example = Example.of(person, matcher);
```
&emsp;&emsp;默认情况下，ExampleMatcher期望Probe上设置的所有值都匹配。如果要获取与隐式定义的任何谓词匹配的结果，请使用ExampleMatcher.matchingAny（）。
&emsp;&emsp;您可以为单个属性（例如“名字”和“姓氏”，或者对于嵌套属性，“address.city”）指定行为。 您可以使用匹配选项和区分大小写对其进行调整，如以下示例所示：
```java
ExampleMatcher matcher = ExampleMatcher.matching()
  .withMatcher("firstname", endsWith())
  .withMatcher("lastname", startsWith().ignoreCase());
}
```