package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.Introduction;
import cn.edu.ncu.architecture.lab.service.LabService;
import cn.edu.ncu.architecture.lab.utils.BaseController;
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
@RequestMapping("/api/Introduction")
public class IntroductionController extends BaseController {

    @Autowired
    LabService labService;

    /**
     * 查询相应id的实验室简介
     * @return "json"
     */
    @RequestMapping(value = "/getIntroductionById",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getIntroductionById(Integer id){
        Introduction introduction = labService.getIntroductionById(id);

        if (introduction != null)
            return success("success", introduction);
        else
            return failed(404, "not found");
    }

    /**
     * 修改相应id的实验室简介
     * @return "json"
     */
    @RequestMapping(value = "/updateIntroduction",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object updateIntroduction(@RequestBody JsonNode body){
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Introduction introduction = new Introduction();
        introduction.setId(id.asInt());
        introduction.setTime(new Date());
        introduction.setPublisher(publisher.asText());
        introduction.setTitle(title.asText());
        introduction.setContent(content.asText());
        labService.updateIntroduction(introduction);
        return success("success");
    }
}
