package com.andrewdev.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//<Task, Long> indicates that this repository manages Task entities with primary keys of type Long
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
