# springboot_mongodb_test1
- springboot+mongodb+分页查询
- 在springboot2.0中MongoRepostiory(jpa)的方法改变了
   - 不能使用findOne(),进行搜索
   - 可以使用findById().orElse()或者findById().get()
   - UserRepository.findById(id).orElse(null) 用这个,查询为空返回NULL,用repository.findById(id).get()查询为空会报错
- 导入Page<User> findByUserNameLike(String username,Pageable pageable);
