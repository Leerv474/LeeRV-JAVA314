package com.top.sampleRest.mvc;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class HomeController {
    @RequestMapping(value ="/infostand", method = RequestMethod.GET)
    public String infoStand(Map<String, Object> model) {
        model.put("date", Instant.now());
        model.put("text", "Model attribute.");

        return "home/infostand";
    }

}
