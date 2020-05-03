# SpringMVC项目步骤
## 1. 配前端控制器DispatcherServlet


# ContextLoaderListener
查看父类ContextLoader的源码。
> The created application context will be registered into the ServletContext under
  the attribute name {@link WebApplicationContext#ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE}
  and subclasses are free to call the {@link #closeWebApplicationContext} method on
  container shutdown to close the application context.
  
个人理解：
    当ContextLoaderListener这个ContextListener监听器执行以后，会将Web ApplicationContext放置在ServletContext的
键值名为ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE的属性当中。
    当初始化DispatcherServlet时，它可以检测ServletContext中的ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE这个属性是否
有值，从而确定是否需要设置Root Web ApplicationContext.

# @ModelAttribute注解
## 在**方法定义上**使用@ModelAttribute注解
执行任何Handler中的任何方法之前，首先执行所有标记了@ModelAttribute注解的方法。
1. 如果方法有返回值：执行完该方法之后，会在ImplicitModel（**最终其键值对会保存到request对象中**）中添加一个键值对，键名称为:
    * 情况一：如果在@ModelAttribute中使用了属性name，则name的值即为键名称。
    * 情况二：如果在@ModelAttribute中没有使用属性name指定键名称，则使用返回值类型的类名首字母小写值作为键名称。
2. 如果方法没有返回值，但在方法的参数中使用了Model类型参数或者Map类型参数。则只要调用model或者map添加键值对即可。
（注意：map中的数据最终会汇聚到ImplicitModel中）

## 在**方法入参前**使用@ModelAttribute注解
* 如果执行方法的参数之前使用了@ModelAttribute注解，则使用该注解中name属性值指定的对应的对象传递给该参数。如果没
有使用name属性，则情况和下面的类似。
* 如果没有使用@ModelAttribute注解，则使用该参数类型的首字母小写的名称作为键名来获取目标键值对象。

## 使用@ModelAttribute修饰方法中的参数，执行方法时，获取目标参数值的过程
解析请求处理器的目标参数时，实际上该目标参数来源于WebDataBinder对象的target属性，获取目标对象过程如下：
  1. 创建WebDataBinder对象：
     * 确定键名：根据上面的《在**方法入参前**使用@ModelAttribute注解》来确定键名称。
     * 确定键值对象：
         * 首先在ImplicitModel中查找键名对应的键值，若找到了，则OK。
         * 若没有找到，则验证当前Handler是否使用了@SessionAttributes进行修饰。若使用了，则尝试从Session中获取键名所对应的
         键值对象属性。若Session没有对应额属性值，则抛出异常；若没有使用，或者SessionAttributes中没有键名所对应的键值对象，
         则通过反射创建POJO对象。
     * **Spring MVC将表单请求中的对应的属性值赋值给WebDataBinder对象中的键值对象对应的属性**（这里是直接进行赋值，所以有可能
     将之前设置的键值对象的某些属性值直接覆盖掉了。例如使用@ModelAttribute注解标记的方法生成的键值对象。）
     * **Spring会把WebDataBinder中的键值对顺便也添加到ImplicitModel中，进而传到request域对象中**。
     * 最后将WebDataBinder的目标键值对象作为参数传递给目标方法中的入参。

# SpringMVC跨服务器上传

# 对静态资源的拦截
**spring mvc对静态资源的拦截是在映射之后的，如果没有找到匹配的映射，才会继续找是否有对应的静态资源**。