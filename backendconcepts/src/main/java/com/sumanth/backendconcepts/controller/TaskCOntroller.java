package com.sumanth.backendconcepts.controller;

import com.sumanth.backendconcepts.payload.TaskDto;
import com.sumanth.backendconcepts.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskCOntroller {
    @Autowired
    private TaskService  taskService;

    //save all tasks
    @PostMapping("/{userid}/tasks")
    public ResponseEntity<TaskDto>  savetask(@PathVariable ("userid") Long userid, @RequestBody TaskDto taskDto)
    {
        return new ResponseEntity<>(taskService.savetask(userid,taskDto), HttpStatus.CREATED);
    }

    //get all tasks


   @PreAuthorize(value ="USER_ADMIN")
    @GetMapping("/{userid}/tasks")
    public ResponseEntity<List<TaskDto>> getAll(@PathVariable(name="userid") Long userid)
    {
       return new ResponseEntity<>(taskService.getall(userid),HttpStatus.OK);
    }


    //get ind tasks

  @GetMapping("/{userid}/tasks/{taskid}")
    public ResponseEntity<TaskDto> getTAsk(@PathVariable(name="userid") Long userid
                                , @PathVariable(name="taskid") Long taskid)
    {
        return new ResponseEntity<>(taskService.gettask(userid,taskid),HttpStatus.OK);
    }

    //delete ind tasks
    @PreAuthorize(value ="USER_ADMIN")
    @DeleteMapping("/{userid}/tasks/{taskid}")
    public ResponseEntity<String> deltask(@PathVariable(name="userid") Long userid
            , @PathVariable(name="taskid") Long taskid)
    {
        taskService.deltask(userid,taskid);
     return  new ResponseEntity<>("userdeleted successfully",HttpStatus.OK);
    }



}
