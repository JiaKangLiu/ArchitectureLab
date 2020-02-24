package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.Work;
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
import java.util.List;

@Controller
@RequestMapping("/api/Work")
public class WorkController extends BaseController {

    @Autowired
    LabService labService;

    /**
     * 获取相应id的工作条例
     * @return "json"
     */
    @RequestMapping(value = "/getWorkById",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getWorkById(Integer id){
        Work work = labService.getWorkById(id);

        if (work!= null)
            return success("success", work);
        else
            return failed(404, "not found");
    }

    /**
     * 获取所有的工作条例
     * @return "json"
     */
    @RequestMapping(value = "/getAllWorks",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getAllWorks(){
        List<Work> works = labService.getAllWorks();

        if (works!= null)
            return success("success", works);
        else
            return failed(404, "not found");
    }

    /**
     * 增加一条工作条例
     */
    @RequestMapping(value = "/addWork",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addWork(@RequestBody JsonNode body){
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Work work = new Work();
        work.setTime(new Date());
        work.setPublisher(publisher.asText());
        work.setTitle(title.asText());
        work.setContent(content.asText());
        labService.addWork(work);

        return success("success");
    }

    /**
     * 修改一条工作条例
     * @param "json"
     */
    @RequestMapping(value = "/updateWork",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateWork(@RequestBody JsonNode body){
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Work work = new Work();
        work.setId(id.asInt());
        work.setTime(new Date());
        work.setPublisher(publisher.asText());
        work.setTitle(title.asText());
        work.setContent(content.asText());
        labService.updateWork(work);
        return success("success");
    }

    /**
     * 删除一条工作条例
     * @param 'json'
     */
    @RequestMapping(value = "/deleteWork",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteWork(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteWork(id.asInt()));
    }
}
