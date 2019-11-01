package com.jerry.springboot_mongodb_test1.controller;

import com.jerry.springboot_mongodb_test1.dao.UserRepository;
import com.jerry.springboot_mongodb_test1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping(value = "/{id}")
    public User readUserById(@PathVariable("id")String id)
    {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/name/{name}")
    public User readUserByName(@PathVariable("name")String name)
    {
        User user=new User();
        user.setUserName(name);
        ExampleMatcher matcher=ExampleMatcher.matching().withIgnorePaths("age","createDate");
        Example<User> example=Example.of(user,matcher);
        return userRepository.findOne(example).get();
    }

    @GetMapping(value = "/page/{pageNumber}/pagesize/{pageSize}/name/{name}")
    public Page<User> readUsersByPage(@PathVariable("pageNumber")int pageNumber,@PathVariable("pageSize")int pageSize,@PathVariable("name")String name)
    {
        User user=new User();
        user.setUserName(name);
        ExampleMatcher matcher=ExampleMatcher.matching().withIgnorePaths("age","createDate");
        Example<User> example=Example.of(user,matcher);
        if(pageNumber<1)
        {
            pageNumber=1;
        }else if(pageSize==0)
        {
            pageSize=2;
        }
        PageRequest pageRequest=PageRequest.of(pageNumber-1,pageSize);
        return userRepository.findAll(example,pageRequest);
    }
    @GetMapping
    public List<User>readUsers()
    {
        Order order=new Order(Sort.Direction.ASC,"age");
       Sort sort=Sort.by(order);
       return userRepository.findAll(sort);

    }
    @GetMapping(value = "/page/{pageNumber}/pagesize/{pageSize}/keyword/{keyWords}")
    public Page<User> readUsersByKeywords(@PathVariable("pageNumber")int pageNumber,@PathVariable("pageSize")int pageSize,@PathVariable("keyWords")String keyWords)
    {
        if(keyWords==null)
        {
            keyWords="";
        }
        if (pageNumber<1)
        {
            pageNumber=1;
        }else if (pageSize==0)
        {
            pageSize=3;
        }
        PageRequest pageRequest=PageRequest.of(pageNumber-1,pageSize);
        return userRepository.findByUserNameLike(keyWords,pageRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable("id")String id)
    {
        userRepository.deleteById(id);
    }
}
