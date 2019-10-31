package com.hand.iot.demojpa.controller;


import com.hand.iot.demojpa.entity.User;
import com.hand.iot.demojpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    public  UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    /**
     *
     * spring-data-jpa连接数据库
     * @Param name
     * @Param id
     * @Param age
     */


    //查看所有用户列表
   @GetMapping
    public List<User> findAllUser(){
       return userRepository.findAll();
   }

   //查询指定id的用户
   @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
       return userRepository.findById(id);
   }

   //增加用户
   @PostMapping
    public User creatUser(@RequestBody @Validated User user, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           throw new IllegalArgumentException(bindingResult.toString());
       }
       return userRepository.save(user);
   }

   //更新用户信息（修改）
   @PutMapping
    public User updateUser(@RequestBody User user){
       return userRepository.save(user);
   }

   //删除用户
    @Transactional
    @DeleteMapping("/{id}")
     public void delete(@PathVariable Integer id){
       userRepository.deleteById(id);
    }
}
