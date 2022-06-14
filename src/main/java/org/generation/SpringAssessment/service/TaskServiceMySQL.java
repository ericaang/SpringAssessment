package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.TaskRepository;
import org.generation.SpringAssessment.repository.entity.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceMySQL implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceMySQL(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> all(){
        List<Task> result = new ArrayList<>();
        taskRepository.findAll().forEach(result :: add);
        return result;
    }
    @Override
    public Task save(Task task){
        return taskRepository.save(task);
    }
    @Override
    public void delete(int taskId){
        taskRepository.deleteById(taskId);
    }
    @Override
    public Task findByid(int taskId){
        Optional<Task> task = taskRepository.findById(taskId);
        Task taskResponse = task.get();
        return taskResponse;

    }
}
