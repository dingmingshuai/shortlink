package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.UserDO;
import com.nageoffer.shortlink.admin.dto.req.UserLoginReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:UserService
 * Description:
 * 用户接口层
 * @Author DubPAN
 * @Create2024/5/18 16:12
 * @Version 1.0
 */
public interface UserService extends IService <UserDO> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 用户实体
     */
    UserRespDTO getUserByUsername (String username);

    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return 用户存在返回 True
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     *
     * @param requestParam 注册用户请求参数
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 根据用户名修改用户
     * @param requestparam 注册用户请求参数
     */
    void update(UserUpdateReqDTO requestparam);

    /**
     * 用户登录
     * @param requestParam 用户登录请求参数
     * @return 用户登录返回参数
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 检查用户是否登录
     * @param token 用户登录token
     * @param username 用户名
     * @return 用户登录标识
     */
    Boolean checkLogin(String username,String token);

     /**
     * 用户退出
     * @param username
     * @param token
     * @return void 退出直接抛异常，让全局异常拦截器拦截
     */
    void logout(String username, String token);
}
