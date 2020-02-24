package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.ResearchResults;
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
@RequestMapping("/api/ResearchResults")
public class ResearchResultsController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取一条研究成果记录
     * @return "json"
     */
    @RequestMapping(value = "/getResearchResults",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getResearchResults(Integer id) {
        ResearchResults researchResults = labService.getResearchResults(id);

        if (researchResults != null)
            return success("success", researchResults);
        else
            return failed(404, "not found");
    }

    /**
     * 添加一条研究成果记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addResearchResults",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addResearchResults(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        ResearchResults researchResults = new ResearchResults();
        researchResults.setTime(new Date());
        researchResults.setPublisher(publisher.asText());
        researchResults.setTitle(title.asText());
        researchResults.setContent(content.asText());
        labService.addResearchResults(researchResults);

        return success("success");
    }

    /**
     * 修改一条研究成果记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateResearchResults",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateResearchResults(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        ResearchResults researchResults = new ResearchResults();
        researchResults.setId(id.asInt());
        researchResults.setTime(new Date());
        researchResults.setPublisher(publisher.asText());
        researchResults.setTitle(title.asText());
        researchResults.setContent(content.asText());
        labService.updateResearchResults(researchResults);
        return success("success");
    }

    /**
     * 删除一条研究成果记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteResearchResults",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteResearchResults(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteResearchResults(id.asInt()));
    }

}