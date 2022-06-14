package org.generation.SpringAssessment.controller;

import org.generation.SpringAssessment.controller.dto.TaskDto;
import org.generation.SpringAssessment.repository.entity.Task;
import org.generation.SpringAssessment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/task")
public class taskController {
    final TaskService taskService;

    public taskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Task> getItems(){
        return taskService.all();
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Task findItemById(@PathVariable Integer id){
        return taskService.findByid(id);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        taskService.delete(id);
    }
    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="date", required = true) String date
                       ){

        TaskDto itemDto = new TaskDto(title, description, date);
        taskService.save(new Task(itemDto));
    }

}
