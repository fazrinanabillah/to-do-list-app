package com.fazrina.simpleappone.repository;

import com.fazrina.simpleappone.entity.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> getAll();
    List<Task> getAllDone();
    Task create(Task task);
    void update(Task task);
    void delete(String id);
}
