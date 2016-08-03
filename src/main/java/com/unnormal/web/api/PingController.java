package com.unnormal.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vazgen on 08/02/2016.
 */
@RestController
public class PingController {

    @RequestMapping("/ping")
    public String index() {
        return "pong";
    }

}