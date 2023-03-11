package com.alienexplorer.app.rest.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alienexplorer.app.rest.Model.Task;

public interface TodoRepository extends JpaRepository<Task, Long>    {
    
}
