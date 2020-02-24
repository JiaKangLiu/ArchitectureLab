package cn.edu.ncu.architecture.lab.service;

import cn.edu.ncu.architecture.lab.model.User;

public interface UserService {
    /**********管理员接口***********/
    boolean register(String username,String password);
    String generateToken(User user);
    User verifyToken(String token);
    User checkUser(String username, String password);
}
