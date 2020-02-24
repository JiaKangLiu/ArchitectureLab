package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.Contact;
import cn.edu.ncu.architecture.lab.service.LabService;
import cn.edu.ncu.architecture.lab.utils.BaseController;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.Date;

@Controller
@RequestMapping("/api/Contact")
public class ContactController extends BaseController {

    @Autowired
    private LabService labService;

    /**
     * 获取一条联系我们记录
     * @return "json"
     */
    @RequestMapping(value = "/getContact",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getContact(Integer id) {
        Contact contact = labService.getContact(id);

        if (contact != null)
            return success("success", contact);
        else
            return failed(404, "not found");
    }

    /**
     * 添加一条联系我们
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addContact",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addContact(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Contact contact = new Contact();
        contact.setTime(new Date());
        contact.setPublisher(publisher.asText());
        contact.setTitle(title.asText());
        contact.setContent(content.asText());
        labService.addContact(contact);

        return success("success");
    }

    /**
     * 修改一条联系我们
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateContact",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateContact(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode title = body.get("title");
        JsonNode content = body.get("content");

        if (publisher == null || content == null || title == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Contact contact = new Contact();
        contact.setId(id.asInt());
        contact.setTime(new Date());
        contact.setPublisher(publisher.asText());
        contact.setTitle(title.asText());
        contact.setContent(content.asText());
        labService.updateContact(contact);
        return success("success");
    }

    /**
     * 删除一条联系我们
     * @param "id"
     * @return
     */
    @RequestMapping(value = "/deleteContact",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteContact(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteContact(id.asInt()));
    }

}
