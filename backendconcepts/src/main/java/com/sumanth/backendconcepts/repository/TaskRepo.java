package com.sumanth.backendconcepts.repository;

import com.sumanth.backendconcepts.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {

    List<Task>  findAllByUsersId(  Long userid);
}
