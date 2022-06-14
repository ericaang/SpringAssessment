package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> all();

    Task save(Task task);

    void delete(int taskId);

    Task findByid(int task);
}
