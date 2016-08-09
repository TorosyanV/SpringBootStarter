package com.unnormal.web.api;

import com.unnormal.helper.DozerExtension;
import com.unnormal.service.PingService;
import com.unnormal.service.dto.PingDto;
import com.unnormal.web.viewmodel.PingCreateModel;
import com.unnormal.web.viewmodel.PingModel;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vazgen on 08/02/2016.
 */
@RestController
@RequestMapping(value = "/ping")
public class PingController {
    @Autowired
    private PingService userService;
    @Autowired
    private Mapper mapper;

    @RequestMapping("/")
    public String index() {
        return "pong";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public long insert(@RequestBody PingCreateModel requestModel) {
        PingDto pingDto = mapper.map(requestModel, PingDto.class);
        long pingId = userService.add(pingDto);
        return pingId;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PingModel get(@PathVariable("id") long id) {
        PingDto pingDto = userService.getById(id);
        PingModel responseModel=mapper.map(pingDto,PingModel.class);
        return responseModel;
    }


    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    public List<PingModel> get(@PathVariable("name") String name) {
        List<PingDto> pingDtos = userService.findByName(name);
        List<PingModel> responseModel= DozerExtension.map(mapper, pingDtos, PingModel.class);
        return responseModel;
    }

}
