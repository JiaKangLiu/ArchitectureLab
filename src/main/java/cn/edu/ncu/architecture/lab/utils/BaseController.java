package cn.edu.ncu.architecture.lab.utils;

import cn.edu.ncu.architecture.lab.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    @Resource
    protected HttpServletRequest request;

    protected User getUser() {
        return (User) request.getAttribute("user");
    }

    protected Object success(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 1);
        map.put("message", msg);

        return map;
    }

    protected Object success(String msg, Object data) {
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>) success(msg);
        map.put("data", data);

        return map;
    }

    protected ResponseEntity<Object> failed(Integer status, String msg, HttpStatus httpStatus) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("message", msg);

        return new ResponseEntity<Object>(map, httpStatus);
    }

    protected Object failed(Integer status, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("message", msg);

        return map;
    }
}
