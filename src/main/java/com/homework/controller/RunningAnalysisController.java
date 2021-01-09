package com.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RunningAnalysisController {

//    @RequestMapping(value = "/1", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/run")
    @ResponseBody
    public String helloWorld(){
        return "hello";
    }
}
