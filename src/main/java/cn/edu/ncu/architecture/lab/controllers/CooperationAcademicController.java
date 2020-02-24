package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.utils.BaseController;
import cn.edu.ncu.architecture.lab.model.CooperationAcademic;
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
@RequestMapping("/api/Academic")
public class CooperationAcademicController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取相应id的学术交流记录
     * @return "json"
     */
    @RequestMapping(value = "/getAcademic",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getAcademic(Integer id) {
        CooperationAcademic cooperationAcademic = labService.getAcademic(id);

        if (cooperationAcademic != null)
            return success("success", cooperationAcademic);
        else
            return failed(404, "not found");
    }

    /**
     * 获取所有学术交流记录
     * @return "json"
     */
    @RequestMapping(value = "/getAllAcademic",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getAllAcademic(){
        return success("success",labService.getAllCooperationAcademic());
    }

    /**
     * 添加一条学术交流记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addAcademic",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addAcademic(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        CooperationAcademic cooperationAcademic = new CooperationAcademic();
        cooperationAcademic.setTime(new Date());
        cooperationAcademic.setPublisher(publisher.asText());
        cooperationAcademic.setTitle(title.asText());
        cooperationAcademic.setContent(content.asText());
        labService.addAcademic(cooperationAcademic);

        return success("success");
    }

    /**
     * 修改一条学术交流记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateAcademic",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateAcademic(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        CooperationAcademic cooperationAcademic = new CooperationAcademic();
        cooperationAcademic.setId(id.asInt());
        cooperationAcademic.setTime(new Date());
        cooperationAcademic.setPublisher(publisher.asText());
        cooperationAcademic.setTitle(title.asText());
        cooperationAcademic.setContent(content.asText());
        labService.updateAcademic(cooperationAcademic);
        return success("success");
    }

    /**
     * 删除一条学术交流记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteAcademic",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteAcademic(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteAcademic(id.asInt()));
    }

}