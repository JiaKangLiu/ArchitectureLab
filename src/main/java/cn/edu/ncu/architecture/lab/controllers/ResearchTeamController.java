package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.ResearchTeam;
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
@RequestMapping("/api/ResearchTeam")
public class ResearchTeamController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取一条研究团队记录
     * @return "json"
     */
    @RequestMapping(value = "/getResearchTeam",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getResearchTeam(Integer id) {
        ResearchTeam researchTeam = labService.getResearchTeam(id);

        if (researchTeam != null)
            return success("success", researchTeam);
        else
            return failed(404, "not found");
    }

    /**
     * 添加一条研究团队记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addResearchTeam",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addResearchTeam(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        ResearchTeam researchTeam = new ResearchTeam();
        researchTeam.setTime(new Date());
        researchTeam.setPublisher(publisher.asText());
        researchTeam.setTitle(title.asText());
        researchTeam.setContent(content.asText());
        labService.addResearchTeam(researchTeam);

        return success("success");
    }

    /**
     * 修改一条研究团队记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateResearchTeam",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateResearchTeam(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        ResearchTeam researchTeam = new ResearchTeam();
        researchTeam.setId(id.asInt());
        researchTeam.setTime(new Date());
        researchTeam.setPublisher(publisher.asText());
        researchTeam.setTitle(title.asText());
        researchTeam.setContent(content.asText());
        labService.updateResearchTeam(researchTeam);
        return success("success");
    }

    /**
     * 删除一条研究团队记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteResearchTeam",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteResearchTeam(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteResearchTeam(id.asInt()));
    }

}
