package com.it.controller;

import com.it.pojo.User;
import com.it.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        try {
            // 验证密码和确认密码是否一致
            if (!request.getPassword().equals(request.getConfirmPassword())) {
                return ResponseEntity.badRequest().body(new ResponseResult(false, "两次输入的密码不一致"));
            }
            
            // 创建User对象
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            // 根据角色设置role字段
            user.setRole(request.getRole());
            // 设置默认状态
            user.setStatus("active");
            
            // 调用service层注册
            userService.register(user);
            
            return ResponseEntity.ok(new ResponseResult(true, "注册成功"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseResult(false, "注册失败：" + e.getMessage()));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request) {
        try {
            // 调用service层登录
            User user = userService.login(request.getUsername(), request.getPassword(), request.getRole());

            // 生成token（这里简化处理，实际项目中应该使用JWT等方式）
            String token = "token_" + System.currentTimeMillis();

            // 返回符合前端预期格式的响应
            return ResponseEntity.ok(new LoginResponse(200, "登录成功", user, token));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new LoginResponse(400, e.getMessage(), null, null));
        }
    }




    
    // 注册请求参数类，用于接收前端的注册请求参数
    @Data
    static class UserRegisterRequest {
        private String username;
        private String password;
        private String confirmPassword;
        private String role;
    }
    // 响应结果类，用于封装后端的响应结果
    @Data
    static class ResponseResult {
        private boolean success;
        private String message;
        
        public ResponseResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }
    // 登录请求参数类
    @Data
    static class UserLoginRequest {
        private String username;
        private String password;
        private String role;
    }

    // 登录响应结果类，符合前端预期格式
    @Data
    static class LoginResponse {
        private int code;
        private String msg;
        private User data;
        private String token;

        public LoginResponse(int code, String msg, User data, String token) {
            this.code = code;
            this.msg = msg;
            this.data = data;
            this.token = token;
        }
    }

}