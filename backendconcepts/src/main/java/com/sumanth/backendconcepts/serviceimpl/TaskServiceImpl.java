package com.sumanth.backendconcepts.serviceimpl;

import com.sumanth.backendconcepts.entity.Task;
import com.sumanth.backendconcepts.entity.Users;
import com.sumanth.backendconcepts.exception.ApiException;
import com.sumanth.backendconcepts.exception.TaskNotFoundException;
import com.sumanth.backendconcepts.exception.UserNotFoundException;
import com.sumanth.backendconcepts.payload.TaskDto;
import com.sumanth.backendconcepts.repository.TaskRepo;
import com.sumanth.backendconcepts.repository.UserRepo;
import com.sumanth.backendconcepts.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private ModelMapper modelMapper;
   @Autowired
    private UserRepo urepo;
   @Autowired
   private TaskRepo trepo;
///////////////////// post method

    @Override
    public TaskDto savetask(Long userid, TaskDto taskDto) {

   Users user=urepo.findById(userid)
           .orElseThrow(( )-> new UserNotFoundException(String.format("USer id %d notfound",userid)));
    Task task =modelMapper.map  (taskDto,Task.class);
    task.setUsers( user);
   Task savedtask= trepo.save(task);
        return modelMapper.map(savedtask, TaskDto.class);
    }

    @Override
    public List<TaskDto> getall(Long userid) {
        Users user=urepo.findById(userid)
                .orElseThrow(( )-> new UserNotFoundException(String.format("USer id %d notfound",userid)));
       List<Task>   task=   trepo.findAllByUsersId(userid);

          return task.stream().map(t->modelMapper.map(t,TaskDto.class)).collect(Collectors.toList());
    }

    @Override
    public TaskDto gettask(Long userid, Long taskid) {
        Users user=urepo.findById(userid)
                .orElseThrow(( )-> new UserNotFoundException(String.format("USer id %d notfound",userid)));
        Task task=trepo.findById(taskid)
                .orElseThrow(()-> new TaskNotFoundException(String.format("Tasks with %d not found",taskid)));
    if(user.getId() !=task.getUsers().getId())
    {
     throw  new ApiException(String.format("task id %d not belongs to user %d",taskid,userid));
    }
        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public void deltask(Long userid, Long taskid) {
        Users user=urepo.findById(userid)
                .orElseThrow(( )-> new UserNotFoundException(String.format("USer id %d notfound",userid)));
        Task task=trepo.findById(taskid)
                .orElseThrow(()-> new TaskNotFoundException(String.format("Tasks with %d not found",taskid)));
        if(user.getId() !=task.getUsers().getId())
        {
            throw  new ApiException(String.format("task id %d not belongs to user %d",taskid,userid));
        }
        trepo.deleteById(taskid);
    }
}
