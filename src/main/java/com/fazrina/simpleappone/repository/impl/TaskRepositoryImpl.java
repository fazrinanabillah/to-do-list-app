package com.fazrina.simpleappone.repository.impl;
import com.fazrina.simpleappone.config.DbConnector;
import com.fazrina.simpleappone.entity.Task;
import com.fazrina.simpleappone.repository.TaskRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public List<Task> find(String search) {
        return null;
    }

    @Override
    public void create(Task task) {
        try (Connection conn = DbConnector.connect()) {
            String query = "INSERT INTO m_task (id, name, address, phone_number, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, task.getId());
            pst.setString(2, task.getActivity());
            pst.setString(3, task.getDescription());
            pst.setString(4, task.getPriority());
            pst.setString(5, task.getReward());
            pst.setString(6, task.getStatus());

            pst.execute();
            pst.close();

            System.out.println("Successfully insert a new task...");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }
}
