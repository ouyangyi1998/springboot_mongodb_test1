# springboot_mongodb_test1
- springboot+mongodb+分页查询
- 在springboot2.0中MongoRepostiory(jpa)的方法改变了
   - 不能使用findOne()进行搜索
   - 可以用findById().orElse()或者findById().get()
   - UserRepository.findById(id).orElse(null)查询为空,返回NULL
   - 用repository.findById(id).get()查询为空会报错
- 导入Page<User> findByUserNameLike(String username,Pageable pageable)对于模糊查询进行控制(jpa自带的模板Like)
- 注解开发(SpringMVC)
   - @ResponseStatus()对于异常进行捕捉，reason返回自定义异常信息
   - @PostMapping(consumes=MediaType.XXX)对于注入数据进行控制
   - @RequestBody() 输入为json数据
- ExampleMatcher matcher=ExampleMatcher.matching().withIgnorePaths() 新建匹配器
   
改变Null值处理方式
- public ExampleMatcher withNullHandler(NullHandler nullHandler)
- public ExampleMatcher withIncludeNullValues()
- public ExampleMatcher withIgnoreNullValues()
产生效果：
改变配置项nullHandler，分别设为：指定值、INCLUDE（包括）、IGNORE（忽略）。

改变默认字符串匹配方式
public ExampleMatcher withStringMatcher(StringMatcher defaultStringMatcher)
产生效果：
改变配置项defaultStringMatcher，设为指定值。

 
改变默认大小写忽略方式。
public ExampleMatcher withIgnoreCase()
public ExampleMatcher withIgnoreCase(boolean defaultIgnoreCase)
产生效果：
改变配置项defaultIgnoreCase，分别设为：true，指定值。

 

向“忽略属性列表”中添加属性。
public ExampleMatcher withIgnorePaths(String... ignoredPaths)
产生效果：
改变配置项ignoredPaths，向列表中添加一个或多个属性。
