package org.workwork.h_jdbc.work_1.work_1.src.main.java.dao;


import org.workwork.h_jdbc.work_1.work_1.src.main.java.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;

public class TaskDao {
    private final DataSource dataSource;

    public TaskDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Task save(Task task) {

        String sql = "INSERT INTO task (title, finished, created_date) VALUES (?, ?, ?)";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, task.getTitle());
            statement.setBoolean(2, task.getFinished());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(task.getCreatedDate()));
            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {

                if (resultSet.next()) {
                    task.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        return task;
    }

    public List<Task> findAll() {

        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT task_id, title, finished, created_date FROM task ORDER BY task_id";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                final Task task = new Task(
                        resultSet.getString(2),
                        resultSet.getBoolean(3),
                        resultSet.getTimestamp(4).toLocalDateTime());

                task.setId(resultSet.getInt(1));
                tasks.add(task);

            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        return tasks;

    }

    public int deleteAll() throws SQLException {

        int deletedRows = findAll().size();

        String sql = "DELETE FROM task";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }

        return deletedRows;

    }

    public Task getById(Integer id) {
        Task task = null;
        String sql = "SELECT task_id, title, finished, created_date FROM task WHERE task_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    task = new Task(
                            resultSet.getString(2),
                            resultSet.getBoolean(3),
                            resultSet.getTimestamp(4).toLocalDateTime());
                    task.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        return task;
    }


    public List<Task> findAllNotFinished() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT task_id, title, finished, created_date FROM task WHERE finished = false ORDER BY task_id";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Task task = new Task(
                        resultSet.getString(2),
                        resultSet.getBoolean(3),
                        resultSet.getTimestamp(4).toLocalDateTime());
                task.setId(resultSet.getInt(1));
                tasks.add(task);
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        return tasks;
    }


    public List<Task> findNewestTasks(Integer numberOfNewestTasks) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT task_id, title, finished, created_date FROM task ORDER BY created_date DESC LIMIT ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, numberOfNewestTasks);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Task task = new Task(
                            resultSet.getString(2),
                            resultSet.getBoolean(3),
                            resultSet.getTimestamp(4).toLocalDateTime());
                    task.setId(resultSet.getInt(1));
                    tasks.add(task);
                }
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        return tasks;
    }


    public Task finishTask(Task task) {
        String sql = "UPDATE task SET finished = true WHERE task_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, task.getId());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                task.setFinished(true);
            } else {
                throw new RuntimeException("No task found with id: " + task.getId());
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        return task;
    }


    public void deleteById(Integer id) {
        String sql = "DELETE FROM task WHERE task_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

}
