package cn.edu.ncu.architecture.lab.controllers;

import cn.edu.ncu.architecture.lab.model.Instrument;
import cn.edu.ncu.architecture.lab.utils.BaseController;
import cn.edu.ncu.architecture.lab.service.LabService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/Instrument")
public class InstrumentController extends BaseController{

    @Autowired
    private LabService labService;

    /**
     * 获取所有仪器信息
     * @return "json"
     */
    @RequestMapping(value = "/getAllInstrument",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object getAllInstrument() {
        List<Instrument> instruments = labService.getAllInstrument();

        if (instruments != null)
            return success("success", instruments);
        else
            return failed(404, "not found");
    }

    /**
     * 获取相应id的仪器信息
     * @return "json"
     */
    @RequestMapping(value = "/getInstrumentById",
    method = RequestMethod.GET,
    produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getInstrumentById(Integer id){
        Instrument instrument = labService.getInstrumentById(id);

        if (instrument != null)
            return success("success",instrument);
        else
            return failed(404,"not found");
    }

    /**
     * 添加一个仪器
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/addInstrument",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object addInstrument(@RequestBody JsonNode body) {
        JsonNode publisher = body.get("publisher");
        JsonNode name = body.get("name");
        JsonNode img = body.get("img");
        JsonNode manager = body.get("manager");
        JsonNode tel = body.get("tel");
        JsonNode introduction = body.get("introduction");

        if (publisher == null || name == null || img == null || manager == null || tel == null || introduction == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Instrument instrument = new Instrument();
        instrument.setTime(new Date());
        instrument.setPublisher(publisher.asText());
        instrument.setName(name.asText());
        instrument.setImg(img.asText());
        instrument.setManager(manager.asText());
        instrument.setTel(tel.asText());
        instrument.setIntroduction(introduction.asText());
        labService.addInstrument(instrument);

        return success("success");
    }

    /**
     * 修改一条仪器记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/updateInstrument",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object updateInstrument(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        JsonNode publisher = body.get("publisher");
        JsonNode name = body.get("name");
        JsonNode img = body.get("img");
        JsonNode manager = body.get("manager");
        JsonNode tel = body.get("tel");
        JsonNode introduction = body.get("introduction");

        if (id == null || publisher == null || name == null || img == null || manager == null || tel == null || introduction == null) {
            return failed(0, "bad request", HttpStatus.BAD_REQUEST);
        }

        Instrument instrument = new Instrument();
        instrument.setId(id.asInt());
        instrument.setTime(new Date());
        instrument.setPublisher(publisher.asText());
        instrument.setName(name.asText());
        instrument.setImg(img.asText());
        instrument.setManager(manager.asText());
        instrument.setTel(tel.asText());
        instrument.setIntroduction(introduction.asText());
        labService.updateInstrument(instrument);

        return success("success");
    }

    /**
     * 删除一条仪器记录
     * @param "json"
     * @return
     */
    @RequestMapping(value = "/deleteInstrument",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public Object deleteInstrument(@RequestBody JsonNode body) {
        JsonNode id = body.get("id");
        return success("success", labService.deleteInstrument(id.asInt()));
    }

}