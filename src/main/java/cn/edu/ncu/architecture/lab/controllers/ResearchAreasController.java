package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.ResearchAreas;
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
@RequestMapping("/api/ResearchAreas")
public class ResearchAreasController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取最新一条研究领域记录
     * @return "json"
     */
    @RequestMapping(value = "/getResearchAreas",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getResearchAreas(Integer id) {
        ResearchAreas researchAreas = labService.getResearchAreas(id);

        if (researchAreas != null)
            return success("success", researchAreas);
        else
            return failed(404, "not found");
    }

    /**
     * 添加一条研究领域记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addResearchAreas",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addResearchAreas(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        ResearchAreas researchAreas = new ResearchAreas();
        researchAreas.setTime(new Date());
        researchAreas.setPublisher(publisher.asText());
        researchAreas.setTitle(title.asText());
        researchAreas.setContent(content.asText());
        labService.addResearchAreas(researchAreas);

        return success("success");
    }

    /**
     * 修改一条研究领域记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateResearchAreas",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateResearchAreas(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        ResearchAreas researchAreas = new ResearchAreas();
        researchAreas.setId(id.asInt());
        researchAreas.setTime(new Date());
        researchAreas.setPublisher(publisher.asText());
        researchAreas.setTitle(title.asText());
        researchAreas.setContent(content.asText());
        labService.updateResearchAreas(researchAreas);
        return success("success");
    }

    /**
     * 删除一条研究领域记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteResearchAreas",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteResearchAreas(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteResearchAreas(id.asInt()));
    }

}