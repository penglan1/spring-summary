# spring配置文件
使用maven搭建项目时，如果想要在写spring配置文件时有提示，步骤如下：
① 配置xml的schema
   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans
             http://www.springframework.org/schema/beans/spring-beans.xsd">
      
   </beans>
   ```
② 添加依赖
   ```xml
    <!--添加spring beans-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>5.2.4.RELEASE</version>
    </dependency>
   ```
   
# Inner Class
> If you want to configure a bean definition for a static nested class, you have to use the binary
  name of the nested class.  
  For example, if you have a class called Foo in the com.example package, and this Foo class has a
  static nested class called Bar, the value of the 'class' attribute on a bean definition would
  be…  
  com.example.Foo$Bar  
  Notice the use of the $ character in the name to separate the nested class name from the outer
  class name.
  
# Dependencies Injection
> Dependency injection (DI) is a process whereby objects define their dependencies, that is, the other
  objects they work with, only through constructor arguments, arguments to a factory method, or
  properties that are set on the object instance after it is constructed or returned from a factory
  method. The container then injects those dependencies when it creates the bean. This process is
  fundamentally the inverse, hence the name Inversion of Control (IoC), of the bean itself controlling
  the instantiation or location of its dependencies on its own by using direct construction of classes,
  or the Service Locator pattern.
  
# ApplicationContext
> This potentially delayed visibility of some configuration issues is why ApplicationContext implementations by
  default pre-instantiate singleton beans. At the cost of some upfront time and memory to create
  these beans before they are actually needed, you discover configuration issues when the
  ApplicationContext is created, not later. You can still override this default behavior so that singleton
  beans will lazy-initialize, rather than be pre-instantiated.
  
# 配置文件须知
* 使用构造函数将依赖注入时，如果没有配置index索引属性来说明个参数的位置，则一律都是不确定的，又容器自动匹配，如果不存在有起义的两个或
  多个函数，则可以成功的注入依赖，否则需要通过增加index的方式来进一步的排除异议，确定函数的签名。
  
* idref和ref的区别
  > 实际上，idref注入的只是目标bean的id，而不是目标bean的实例，同时使用idref容器在部署的时候还会验证这个名称是否存在，就相当
    于是一个验证功能。
  
  > idref和ref的作用的完全不同的，ref是对bean的对象实例的引用，ref同样有两种方式<ref bean=""/>和<ref parent=""/>,bean属
    性的值可以同目标bean的id属性相同，也可以同目标bean的name属性中任何一个值相同。parent则引用的是父文件中的bean，使用场景
    主要是在代理配置的情况下。
      
  > 注意：The local attribute on the ref element is no longer supported in the 4.0 beans xsd
  
# Bean(Factory)PostProcessor
> As with BeanPostProcessors , you typically do not want to configure
  BeanFactoryPostProcessors for lazy initialization. If no other bean references a
  Bean(Factory)PostProcessor, that post-processor will not get instantiated at all.
  Thus, marking it for lazy initialization will be ignored, and the
  Bean(Factory)PostProcessor will be instantiated eagerly even if you set the default-
  lazy-init attribute to true on the declaration of your <beans /> element.
  
## PropertySourcesPlaceholderConfigurer 和 PropertyOverrideConfigurer 的区别
1. PropertySourcesPlaceholderConfigurer可以使用多个，但是多个之间只是合并关系，先被执行的值就先被确定，后面执行的就
   只能是和之前的合并，说白了就是后面执行的只能替补前面没有的。
2. PropertyOverrideConfigurer也可以使用多个，每一个都可以替换到之前已经存在了的，先后执行的次序之间只有后者覆盖前者的
   关系，没有任何合并关系。

# Annotation-based Injection
> Annotation injection is performed before XML injection, thus the latter
  configuration will override the former for properties wired through both
  approaches.
  
```xml
<context:annotation-config/>

<!-- 
1.如果想使用@ Resource 、@ PostConstruct、@ PreDestroy等注解就必须声明CommonAnnotationBeanPostProcessor。

2.如果想使用@PersistenceContext注解，就必须声明PersistenceAnnotationBeanPostProcessor的Bean。

3.如果想使用@Autowired注解，那么就必须事先在 Spring 容器中声明 AutowiredAnnotationBeanPostProcessor的Bean。

4.如果想使用 @Required的注解，就必须声明RequiredAnnotationBeanPostProcessor的Bean。

<context:annotation-config/>的使用，可以隐式的向Spring容器注册以上4个BeanPostProcessor。

注意：注册这4个 BeanPostProcessor的作用，就是为了你的系统能够识别相应的注解并对其进行相应的处理。
-->

```
```xml
<context:component-scan base-package="com.**"/>

<!--
Spring给我们提供了context:annotation-config 的简化的配置方式，自动帮助你完成声明，并且还自动搜索@Component , @Controller , @Service , @Repository等标注的类。

context:component-scan除了具有context:annotation-config的功能之外，context:component-scan还可以在指定的package下扫描以及注册javabean 。还具有自动将带有@component,@service,@Repository等注解的对象注册到spring容器中的功能。

因此当使用 context:component-scan 后，就可以将 context:annotation-config移除。
-->
```

## @primary
  
## @Autowired
> Marks a constructor, field, setter method, or config method as to be autowired by
  Spring's dependency injection facilities. This is an alternative to the JSR-330
  {@link javax.inject.Inject} annotation, adding required-vs-optional semantics.

> Fields are injected right after construction of a bean, before any config methods
  are invoked. Such a config field does not have to be public.
  
## @Qualifier 和 @Resource
> Letting qualifier values select against target bean names, within the type-matching
  candidates, doesn’t even require a @Qualifier annotation at the injection point. If
  there is no other resolution indicator (e.g. a qualifier or a primary marker), for a
  non-unique dependency situation, Spring will match the injection point name (i.e.
  field name or parameter name) against the target bean names and choose the
  same-named candidate, if any.
  
> That said, if you intend to express annotation-driven injection by name, do not
  primarily use @Autowired, even if is capable of selecting by bean name among type-
  matching candidates. Instead, use the JSR-250 @Resource annotation, which is
  semantically defined to identify a specific target component by its unique name,
  with the declared type being irrelevant for the matching process. @Autowired has
  rather different semantics: 
  
  **After selecting candidate beans by type, the specified
  String qualifier value will be considered within those type-selected candidates
  only, e.g. matching an "account" qualifier against beans marked with the same
  qualifier label.**
  
> For beans that are themselves defined as a collection/map or array type, @Resource
  is a fine solution, referring to the specific collection or array bean by unique name.
  That said, as of 4.3, collection/map and array types can be matched through
  Spring’s @Autowired type matching algorithm as well, as long as the element type
  information is preserved in @Bean return type signatures or collection inheritance
  hierarchies. In this case, qualifier values can be used to select among same-typed
  collections, as outlined in the previous paragraph.
  
> As of 4.3, @Autowired also considers self references for injection, i.e. references back
  to the bean that is currently injected. Note that self injection is a fallback; regular
  dependencies on other components always have precedence. In that sense, self
  references do not participate in regular candidate selection and are therefore in
  particular never primary; on the contrary, they always end up as lowest
  precedence. In practice, use self references as a last resort only, e.g. for calling
  other methods on the same instance through the bean’s transactional proxy:
  Consider factoring out the affected methods to a separate delegate bean in such a
  scenario. Alternatively, use @Resource which may obtain a proxy back to the
  current bean by its unique name.
  
> @Autowired applies to fields, constructors, and multi-argument methods, allowing
  for narrowing through qualifier annotations at the parameter level. By contrast,
  @Resource is supported only for fields and bean property setter methods with a
  single argument. As a consequence, stick with qualifiers if your injection target is a
  constructor or a multi-argument method.
  
## @Resource
> @Resource takes a name attribute, and by default Spring interprets that value as the bean name to be
  injected. 

> If no name is specified explicitly, the default name is derived from the field name or setter method.
  In case of a field, it takes the field name; in case of a setter method, it takes the bean property name.
  So the following example is going to have the bean with name "movieFinder" injected into its setter
  method:
  ```java
  public class SimpleMovieLister {
      private MovieFinder movieFinder;
      @Resource
      public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
      }
  }
  ```

> In the exclusive case of @Resource usage with no explicit name specified, and similar to @Autowired,
  @Resource finds a primary type match instead of a specific named bean and resolves well-known
  resolvable dependencies: the BeanFactory, ApplicationContext, ResourceLoader,
  ApplicationEventPublisher, and MessageSource interfaces.

> Thus in the following example, the customerPreferenceDao field first looks for a bean named
  customerPreferenceDao, then falls back to a primary type match for the type
  CustomerPreferenceDao. The "context" field is injected based on the known resolvable dependency
  type ApplicationContext.
  ```java
  public class MovieRecommender {
      @Resource
      private CustomerPreferenceDao customerPreferenceDao;
      @Resource
      private ApplicationContext context;  //容器会自动注入自己
      public MovieRecommender() {
      }
      // ...
  }
```

某个博客关于@Resource的解释：
```cfml
工作原理：
  当spring容器启动的时候，
  ApplicationContext ctx = new FileSystemXmlApplicationContext("sss.xml");
  spring容器会创建纳入spring容器管理的bean.分别为person和student; 
  spring容器会解析配置文件，会解析到<context:annotation-config/> 会在纳入spring的bean范围内查找属性上是否存在
  注解@Resource(name="student")
       * 如果存在：
           * 继续解析@Resource有没有name属性
               * 如果没有name属性
                         就会在所属的属性上，把属性的名称解析出来。会让属性的名称和spring中的bean中的id进行匹配
                                   如果匹配成功，则把spring容器中相应的对象赋值给该属性
                                   如果匹配失败，则按照类型(Class)进行匹配
               * 如果有name属性
                         就会解析name属性的值，把这个值和spring容器中的bean的id进行匹配
                               如果匹配成功，则把spring容器中的相应的对象赋值给该属性
                               如果匹配失败，则直接报错
         
       * 如果不存在：
              不做任何事情
              
xml注入属性和注解注入属性的写法的对比：
    xml : 书写比较麻烦，但是效率比较高(直接在配置文件里面全有啦)
    注解：书写比较简单，但是效率比较低(一遍遍的扫描)
注解的写法只适合引用
```

## @PostConstruct and @PreDestroy

## @Component
> @Component is
  a generic stereotype for any Spring-managed component. @Repository, @Service, and @Controller are
  specializations of @Component for more specific use cases, for example, in the persistence, service,
  and presentation layers, respectively. Therefore, you can annotate your component classes with
  94 @Component, but by annotating them with @Repository, @Service, or @Controller instead, your classes
  are more properly suited for processing by tools or associating with aspects. For example, these
  stereotype annotations make ideal targets for pointcuts. It is also possible that @Repository, @Service,
  and @Controller may carry additional semantics in future releases of the Spring Framework. Thus,
  if you are choosing between using @Component or @Service for your service layer, @Service is clearly
  the better choice. Similarly, as stated above, @Repository is already supported as a marker for
  automatic exception translation in your persistence layer.