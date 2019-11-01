package com.jerry.springboot_mongodb_test1.dao;

import com.jerry.springboot_mongodb_test1.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
 public Page<User> findByUserNameLike(String username, Pageable pageable);
}
