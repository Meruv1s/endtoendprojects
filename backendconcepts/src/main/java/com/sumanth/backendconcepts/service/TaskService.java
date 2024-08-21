package com.sumanth.backendconcepts.service;

import com.sumanth.backendconcepts.payload.TaskDto;

import java.util.List;

public interface TaskService {

   TaskDto savetask( Long userid,TaskDto taskDto);

   List<TaskDto> getall(Long userid);

    TaskDto gettask(Long userid,Long todoid);

   void deltask(Long userid, Long todoid);

}
