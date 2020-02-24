package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.CooperationInternational;
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
import java.util.List;

@Controller
@RequestMapping("/api/International")
public class CooperationInternationalController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取一条国际交流记录
     * @return "json"
     */
    @RequestMapping(value = "/getInternational",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getInternational(Integer id) {
        CooperationInternational cooperationInternational = labService.getInternational(id);

        if (cooperationInternational != null)
            return success("success", cooperationInternational);
        else
            return failed(404, "not found");
    }

    /**
     * 获取所有国际交流记录
     * @return "json"
     */
    @RequestMapping(value = "/getAllInternationals",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getAllInternationals(){
        List<CooperationInternational> cooperationInternationals = labService.getAllInternationals();

        if (cooperationInternationals != null)
            return success("success", cooperationInternationals);
        else
            return failed(404, "not found");
    }

    /**
     * 添加一条国际交流记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addInternational",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addInternational(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        CooperationInternational cooperationInternational = new CooperationInternational();
        cooperationInternational.setTime(new Date());
        cooperationInternational.setPublisher(publisher.asText());
        cooperationInternational.setTitle(title.asText());
        cooperationInternational.setContent(content.asText());
        labService.addInternational(cooperationInternational);

        return success("success");
    }

    /**
     * 修改一条国际交流记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateInternational",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateInternational(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        CooperationInternational cooperationInternational = new CooperationInternational();
        cooperationInternational.setId(id.asInt());
        cooperationInternational.setTime(new Date());
        cooperationInternational.setPublisher(publisher.asText());
        cooperationInternational.setTitle(title.asText());
        cooperationInternational.setContent(content.asText());
        labService.updateInternational(cooperationInternational);
        return success("success");
    }

    /**
     * 删除一条国际交流记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteInternational",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteInternational(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteInternational(id.asInt()));
    }

}