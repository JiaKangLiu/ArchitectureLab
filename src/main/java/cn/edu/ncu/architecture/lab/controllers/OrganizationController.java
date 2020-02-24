package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.Organization;
import cn.edu.ncu.architecture.lab.service.LabService;
import cn.edu.ncu.architecture.lab.utils.BaseController;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.Date;

@Controller
@RequestMapping("/api/Organization")
public class OrganizationController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取一条组织机构记录
     * @return "json"
     */
    @RequestMapping(value = "/getOrganization",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getOrganization(Integer id) {
        Organization organization = labService.getOrganization(id);

        if (organization != null)
            return success("success", organization);
        else
            return failed(404, "not found");
    }

    /**
     * 添加一条组织机构
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addOrganization",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addOrganization(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Organization organization = new Organization();
        organization.setTime(new Date());
        organization.setPublisher(publisher.asText());
        organization.setTitle(title.asText());
        organization.setContent(content.asText());
        labService.addOrganization(organization);

        return success("success");
    }

    /**
     * 修改一条组织机构
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateOrganization",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateOrganization(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Organization organization = new Organization();
        organization.setId(id.asInt());
        organization.setTime(new Date());
        organization.setPublisher(publisher.asText());
        organization.setTitle(title.asText());
        organization.setContent(content.asText());
        labService.updateOrganization(organization);
        return success("success");
    }

    /**
     * 删除一条组织机构
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteOrganization",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteOrganization(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteOrganization(id.asInt()));
    }

}
