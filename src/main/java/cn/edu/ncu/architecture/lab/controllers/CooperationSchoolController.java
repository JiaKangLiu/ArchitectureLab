package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.CooperationSchool;
import cn.edu.ncu.architecture.lab.utils.BaseController;
import cn.edu.ncu.architecture.lab.service.LabService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Controller
@RequestMapping("/api/School")
public class CooperationSchoolController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取一条校企合作记录
     * @return "json"
     */
    @RequestMapping(value = "/getSchool",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getSchool(Integer id) {
        CooperationSchool cooperationSchool = labService.getSchool(id);

        if (cooperationSchool != null)
            return success("success", cooperationSchool);
        else
            return failed(404, "not found");
    }

    /**
     * 获取所有的校企合作记录
     * @return "json"
     */
    @RequestMapping(value = "/getAllSchools",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getAllSchols(){
        return success("success",labService.getAllSchools());
    }

    /**
     * 添加一条校企合作记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addSchool",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addSchool(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        CooperationSchool cooperationSchool = new CooperationSchool();
        cooperationSchool.setTime(new Date());
        cooperationSchool.setPublisher(publisher.asText());
        cooperationSchool.setTitle(title.asText());
        cooperationSchool.setContent(content.asText());
        labService.addSchool(cooperationSchool);

        return success("success");
    }

    /**
     * 修改一条校企合作记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateSchool",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateSchool(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        CooperationSchool cooperationSchool = new CooperationSchool();
        cooperationSchool.setId(id.asInt());
        cooperationSchool.setTime(new Date());
        cooperationSchool.setPublisher(publisher.asText());
        cooperationSchool.setTitle(title.asText());
        cooperationSchool.setContent(content.asText());
        labService.updateSchool(cooperationSchool);
        return success("success");
    }

    /**
     * 删除一条校企合作记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteSchool",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteSchool(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteSchool(id.asInt()));
    }

}