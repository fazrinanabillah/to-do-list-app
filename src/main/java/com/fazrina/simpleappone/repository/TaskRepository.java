package com.fazrina.simpleappone.repository;

import com.fazrina.simpleappone.entity.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> find(String search);
    void create(Task task);
    void update(String id);
    void delete(String id);
}
