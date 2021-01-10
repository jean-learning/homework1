package com.homework.controller;

import com.homework.domain.RunningInformation;
import com.homework.service.RunningAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningAnalysisController {

    @Autowired
    RunningAnalysisService runningAnalysisService;

    //@PostMapping(value = "/add")

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody List<RunningInformation> runningInformations){
        runningAnalysisService.saveRunningInformation(runningInformations);
    }

    @GetMapping(value = "/findbyusername/{username}")
    public Page<RunningInformation> searchByUserName(@PathVariable("username") String userName, @RequestParam(name="page") int page, @RequestParam(name="size") int size){
        return runningAnalysisService.findByUserName(userName, new PageRequest(page, size));
    }

    @GetMapping(value = "/findbyid/{runningId}")
    public Page<RunningInformation> searchByRunningId(@PathVariable("runningId") String runningId, @RequestParam(name="page") int page, @RequestParam(name="size") int size){
        return runningAnalysisService.findByRunningId(runningId, new PageRequest(page, size));
    }

    @GetMapping(value = "/findall")
    public Page<RunningInformation> findAllOrderByHealthWarningLevelDesc(@RequestParam(name="page") int page, @RequestParam(name="size") int size){
        return runningAnalysisService.findAllOrderByHealthWarningLevelDesc(new PageRequest(page, size));
    }

    @DeleteMapping(value = "/deletebyid")
    public void deleteByRunningId(@PathVariable("runningId") String runningId){
        runningAnalysisService.deleteByRunningId(runningId);
    }
}
