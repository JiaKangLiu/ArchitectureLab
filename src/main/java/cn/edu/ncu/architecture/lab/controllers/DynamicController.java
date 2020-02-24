package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.Dynamic;
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
@RequestMapping("/api/Dynamic")
public class DynamicController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取对应id的科技动态记录
     * @return "json"
     */
    @RequestMapping(value = "/getDynamic",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getDynamic(Integer id) {
        Dynamic dynamic = labService.getDynamic(id);

        if (dynamic != null)
            return success("success", dynamic);
        else
            return failed(404, "not found");
    }

    /**
     * 获取所有科技动态记录
     * @return "json"
     */
    @RequestMapping(value = "/getAllDynamic",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getAllDynamic(){
        return success("success",labService.getAllDynamic());
    }

    /**
     * 添加一条科技动态记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addDynamic",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addDynamic(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Dynamic dynamic = new Dynamic();
        dynamic.setTime(new Date());
        dynamic.setPublisher(publisher.asText());
        dynamic.setTitle(title.asText());
        dynamic.setContent(content.asText());
        labService.addDynamic(dynamic);

        return success("success");
    }

    /**
     * 修改一条科技动态记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateDynamic",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateDynamic(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Dynamic dynamic = new Dynamic();
        dynamic.setId(id.asInt());
        dynamic.setTime(new Date());
        dynamic.setPublisher(publisher.asText());
        dynamic.setTitle(title.asText());
        dynamic.setContent(content.asText());
        labService.updateDynamic(dynamic);
        return success("success");
    }

    /**
     * 删除一条科技动态记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteDynamic",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteDynamic(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteDynamic(id.asInt()));
    }

}