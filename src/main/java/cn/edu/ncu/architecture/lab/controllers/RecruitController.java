package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.Recruit;
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
@RequestMapping("/api/Recruit")
public class RecruitController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取一条英才招聘记录
     * @return "json"
     */
    @RequestMapping(value = "/getRecruit",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getRecruit(Integer id) {
        Recruit recruit = labService.getRecruit(id);

        if (recruit != null)
            return success("success", recruit);
        else
            return failed(404, "not found");
    }

    /**
     * 添加一条英才招聘记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addRecruit",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addRecruit(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Recruit recruit = new Recruit();
        recruit.setTime(new Date());
        recruit.setPublisher(publisher.asText());
        recruit.setTitle(title.asText());
        recruit.setContent(content.asText());
        labService.addRecruit(recruit);

        return success("success");
    }

    /**
     * 修改一条英才招聘记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateRecruit",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateRecruit(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Recruit recruit = new Recruit();
        recruit.setId(id.asInt());
        recruit.setTime(new Date());
        recruit.setPublisher(publisher.asText());
        recruit.setTitle(title.asText());
        recruit.setContent(content.asText());
        labService.updateRecruit(recruit);
        return success("success");
    }

    /**
     * 删除一条英才招聘记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteRecruit",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteRecruit(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteRecruit(id.asInt()));
    }

}