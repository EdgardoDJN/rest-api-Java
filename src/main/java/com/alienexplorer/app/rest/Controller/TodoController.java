package com.alienexplorer.app.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alienexplorer.app.rest.Model.Task;
import com.alienexplorer.app.rest.Repository.TodoRepository;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository TodoRepository;

    @GetMapping(value = "/" )
    public String index() {
        return "Hello World";
    }
    @GetMapping(value = "/tasks" )
    public List<Task> getTasks() {
        //se importo el repositorio y lo llamo con Autowired, que me instancie el repositorio
        //dentro de la clase TodoController
        return TodoRepository.findAll();
    }
    @PostMapping(value = "/savetasks" )
    public String saveTasks(@RequestBody Task task) {
        TodoRepository.save(task);
        return "Task saved";
        
    }
    //Como no podemos crear desde el localhost
    //utilizamos postman para manejar las peticiones que le hacen al servidor
    @PutMapping(value = "/update/{id}" )
    public String updateTasks(@PathVariable long id, @RequestBody Task task) {
        Task updateTask = TodoRepository.findById(id).get();
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        TodoRepository.save(updateTask);
        return "update Task";
        
    }
    @DeleteMapping(value = "/delete/{id}" )
    public String deleteTasks(@PathVariable long id) {
        Task deletedTask = TodoRepository.findById(id).get();
        TodoRepository.delete(deletedTask);
        return "delete Task";
        
    }

    
}
