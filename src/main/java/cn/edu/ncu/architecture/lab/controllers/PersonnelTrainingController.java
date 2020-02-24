package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.PersonnelTraining;
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
@RequestMapping("/api/PersonnelTraining")
public class PersonnelTrainingController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取一条人才培养记录
     * @return "json"
     */
    @RequestMapping(value = "/getPersonnelTraining",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getPersonnelTraining(Integer id) {
        PersonnelTraining personnelTraining = labService.getPersonnel(id);

        if (personnelTraining != null)
            return success("success", personnelTraining);
        else
            return failed(404, "not found");
    }

    /**
     * 添加一条人才培养记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addPersonnelTraining",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addPersonnelTraining(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        PersonnelTraining personnelTraining = new PersonnelTraining();
        personnelTraining.setTime(new Date());
        personnelTraining.setPublisher(publisher.asText());
        personnelTraining.setTitle(title.asText());
        personnelTraining.setContent(content.asText());
        labService.addPersonnel(personnelTraining);

        return success("success");
    }

    /**
     * 修改一条人才培养记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updatePersonnelTraining",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updatePersonnelTraining(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        PersonnelTraining personnelTraining = new PersonnelTraining();
        personnelTraining.setId(id.asInt());
        personnelTraining.setTime(new Date());
        personnelTraining.setPublisher(publisher.asText());
        personnelTraining.setTitle(title.asText());
        personnelTraining.setContent(content.asText());
        labService.updatePersonnel(personnelTraining);
        return success("success");
    }

    /**
     * 删除一条人才培养记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deletePersonnelTraining",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deletePersonnelTraining(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deletePersonnel(id.asInt()));
    }

}