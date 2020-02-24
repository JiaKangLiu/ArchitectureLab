package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.User;
import cn.edu.ncu.architecture.lab.service.UserService;
import cn.edu.ncu.architecture.lab.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@Controller
@RequestMapping("/api/User")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object register(@RequestBody Map<String, Object> body) {
        if (body.containsKey("username") && body.containsKey("password")) {
            String username = (String) body.get("username");
            String password = (String) body.get("password");

            boolean result = userService.register(username, password);

            return success("success");
        } else {
            return failed(0, "register failed");
        }
    }

    /**
     * 用户登录
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object login(@RequestBody Map<String, Object> body) {
        if (body.containsKey("username") && body.containsKey("password")) {
            String username = (String) body.get("username");
            String password = (String) body.get("password");

            User user = userService.checkUser(username, password);

            if (user == null) {
                return failed(0, "username or password incorrect");
            }

            String token = userService.generateToken(user);

            return success("success", token);
        } else {
            return failed(0, "register failed");
        }
    }
}
