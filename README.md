# springboot+mongodb+分页模糊查询
***
### 在springboot2.0中MongoRepostiory(jpa)中
   - 不能使用findOne()进行搜索
   - 可以用findById().orElse()或者findById().get()
   - UserRepository.findById(id).orElse(null)查询为空,返回NULL
   - 用repository.findById(id).get()查询为空会报错
### 注解开发(SpringMVC)
   - @ResponseStatus()对于异常进行捕捉，reason返回自定义异常信息
   - @PostMapping(consumes=MediaType.XXX)对于注入数据进行控制
   - @RequestBody() 输入为json数据
### 对于匹配器操作  
- ExampleMatcher matcher=ExampleMatcher.matching() 新建匹配器
***
改变Null值处理方式
- public ExampleMatcher withNullHandler(NullHandler nullHandler)
- public ExampleMatcher withIncludeNullValues()
- public ExampleMatcher withIgnoreNullValues()
- 产生效果：
- 改变配置项nullHandler，分别设为：
- 指定值
- INCLUDE（包括）
- IGNORE（忽略）。

改变默认字符串匹配方式
- public ExampleMatcher withStringMatcher(StringMatcher defaultStringMatcher)
- 产生效果：
- 改变配置项defaultStringMatcher，设为：
- 指定值。

改变默认大小写忽略方式
- public ExampleMatcher withIgnoreCase()
- public ExampleMatcher withIgnoreCase(boolean defaultIgnoreCase)
- 产生效果：
- 改变配置项defaultIgnoreCase，分别设为：
- true
- 指定值。

向“忽略属性列表”中添加属性
- public ExampleMatcher withIgnorePaths(String... ignoredPaths)
- 产生效果：
- 改变配置项ignoredPaths：
- 向列表中添加一个或多个属性。
***
### 模糊分页查询
- 导入Page<User> findByUserNameLike(String username,Pageable pageable)对于模糊查询进行控制
- 对于模糊分页查询,在url中输入pagenumber，pagesize，keywords进行查询
   - 设置最小页数和最小页面显示内容 
   - PageRequest pageres=PageRequest.of(pagenumber-1,pagesize)实现分页
   - userRepository.findAll(example,pageres) 注入分页信息和匹配信息
   - userRepository.findByUserNameLike(keywords,pageres) 注入模糊信息和分页信息
- 以上都在postman中测试通过。。。
