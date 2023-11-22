package com.fazrina.simpleappone.repository.impl;
import com.fazrina.simpleappone.config.DbConnector;
import com.fazrina.simpleappone.entity.Task;
import com.fazrina.simpleappone.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();

        try (Connection conn = DbConnector.connect()) {
            String query = "SELECT * FROM m_task ORDER BY priority";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();

            Integer id = null, priority=null;
            String activity = null, description = null, reward = null, status=null;

            while (resultSet.next()){
                id = resultSet.getInt(1);
                activity = resultSet.getString(2);
                description = resultSet.getString(3);
                priority = resultSet.getInt(4);
                reward = resultSet.getString(5);
                status = resultSet.getString(6);
                tasks.add(new Task(id, activity, description, priority, reward, status));
            }

            pst.execute();
            pst.close();

            System.out.println(tasks);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public List<Task> getAllDone() {
        List<Task> tasks = new ArrayList<>();

        try (Connection conn = DbConnector.connect()) {
            String query = "SELECT * FROM m_task WHERE status='done'";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();

            Integer id = null, priority=null;
            String activity = null, description = null, reward = null, status=null;

            while (resultSet.next()){
                id = resultSet.getInt(1);
                activity = resultSet.getString(2);
                description = resultSet.getString(3);
                priority = resultSet.getInt(4);
                reward = resultSet.getString(5);
                status = resultSet.getString(6);
                tasks.add(new Task(id, activity, description, priority, reward, status));
            }

            pst.execute();
            pst.close();

            System.out.println(tasks);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }


    @Override
    public Task create(Task task) {
        try (Connection conn = DbConnector.connect()) {
            String query = "INSERT INTO m_task (activity, description, priority, reward, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, task.getActivity());
            pst.setString(2, task.getDescription());
            pst.setInt(3, task.getPriority());
            pst.setString(4, task.getReward());
            pst.setString(5, task.getStatus());

            pst.execute();

            System.out.println("Successfully insert a new task...");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return task;
    }

    @Override
    public void update(Task task) {
        try (Connection conn = DbConnector.connect()) {
            String query = "UPDATE m_task SET status = ?  WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(2, task.getId());
            pst.setString(1, task.getStatus());

            pst.execute();
            pst.close();

            System.out.println("Successfully update a task status...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String id) {
        try (Connection conn = DbConnector.connect()) {
            String query = "DELETE FROM m_task WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, Integer.parseInt(id));

            pst.execute();
            pst.close();

            System.out.println("Successfully delete a task...");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
