package com.kk.demo.controller;

import com.kk.demo.entity.UserEntity;
import com.kk.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    //,consumes="application/json"
    @RequestMapping(value ="/list" ,method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();//userJps.findAll()方法就是SpringDataJPA为我们提供的内置方法
    }

    //http://localhost:8080/user/save?name=cocoa
    @RequestMapping(value = "save",method = RequestMethod.GET,params = { "name","age" })
    public UserEntity save(@RequestParam(value = "name")String name,@RequestParam(value = "age")int age,@RequestParam(value = "address")String addr){
        UserEntity u = new UserEntity();
        u.setName(name);
        u.setAge(age);
        u.setAddress(addr);
        return userJPA.save(u);
    }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
