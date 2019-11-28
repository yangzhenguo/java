# 将Code解析为错误消息

&emsp;&emsp;前边我们已经讨论了数据绑定和验证。本节讨论与验证错误对应的输出消息。在上一节展示的示例中我们拒绝了<code>name</code>和<code>age</code>字段。如果我们想通过使用<code>MessageSource</code>输出错误消息，我们可以使用拒绝字段时提供的错误代码(本例中是'name'和'age')来实现。当你调用(直接或间接，比如使用<code>ValidationUtils</code>类)<code>Errors</code>接口的<code>rejectValue</code>或其他<code>reject</code>方法中的一个时，底层实现不仅注册您传入的Code，而且也会注册许多额外的错误Code。<code>MessageCodeResolver</code>决定了<code>Errors</code>接口注册了哪些Code，默认情况下，使用<code>DefaultMessageCodesResolver</code>，它不仅用您提供的Code注册消息，而且还包含传递给<code>reject</code>方法的字段名消息。因此，如果您使用<code>rejectValue("age", "too.darn.old")</code>来reject一个字段，除了<code>too.darn.old</code>外，Spring还会注册<code>too.darn.old.age</code>和<code>too.darn.old.age.int</code>(第一个包含字段名称，第二个包含字段类型)。这样做是为了方便开发人员在定位错误消息时提供帮助

&emsp;&emsp;有关<code>MessageCodesResolver</code>和默认策略的更多信息，可以分别在<code>MessageCodesResolver</code>和<code>DefaultMessageCodesResolver</code>中找到。
