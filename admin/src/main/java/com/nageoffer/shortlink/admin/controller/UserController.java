package com.nageoffer.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.common.convention.result.Results;
import com.nageoffer.shortlink.admin.dto.resp.UserActualRespDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import com.nageoffer.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UserController
 * Description:
 * 用户管理控制层
 * @Author DubPAN
 * @Create2024/5/18 14:26
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor//@RequiredArgsConstructor是Lombok的一个注解，简化对@Autowired书写,使用构造器注入
public class UserController {
    //1、声明的变量必须加上final修饰，加入final表示为常量，初始化得时候必须注入（@RequiredArgsConstructor）
    //2、基于构造方法为属性赋值，容器通过调用类的构造方法将其进行依赖注入
    private final UserService userService;//使用构造器注入Bean

    /**
     *根据用户名查询用户
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result <UserRespDTO>getUserByUsername(@PathVariable("username") String username){
        return Results.success(userService.getUserByUsername(username));

    }

    /**
     *根据用户名查询用户无脱敏信息
     */
    @GetMapping("/api/shortlink/v1/actual/user/{username}")
    public Result <UserActualRespDTO>getActualUserByUsername(@PathVariable("username") String username){
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username),UserActualRespDTO.class));
    }
}
