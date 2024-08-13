package org.workwork.h_jdbc.work_1.work_1.src.test.java.dao;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.workwork.h_jdbc.work_1.work_1.src.main.java.dao.TaskDao;
import org.workwork.h_jdbc.work_1.work_1.src.main.java.entity.Task;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import javax.sql.DataSource;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskDaoTest {
  private TaskDao taskDao;

  @BeforeAll
  public void setUp() throws IOException {
    DataSource dataSource = EmbeddedPostgres
      .builder()
      .start()
      .getPostgresDatabase();

    initializeDb(dataSource);
    taskDao = new TaskDao(dataSource);
  }

  @BeforeEach
  public void beforeEach() throws SQLException {
    int deletedRows = taskDao.deleteAll();
  }

  private void initializeDb(DataSource dataSource) {
    try(InputStream inputStream = this.getClass().getResource("/initial.sql").openStream()) {
      String sql = new String(inputStream.readAllBytes());
      try(
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()
      ) {
        statement.executeUpdate(sql);
      }

    } catch (IOException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testSaveSetsId() {
    Task task = new Task("test task", false, LocalDateTime.now());
    taskDao.save(task);

      Assertions.assertNotNull(task.getId());
  }

  @Test
  public void testFindAllReturnsAllTasks() {
    Task firstTask = new Task("first task", false, LocalDateTime.now());
    taskDao.save(firstTask);

    Task secondTask = new Task("second task", false, LocalDateTime.now());
    taskDao.save(secondTask);

    List<Task> tasks = taskDao.findAll();
    Assertions.assertEquals(2, tasks.size());
    Assertions.assertTrue(tasks.contains(firstTask));
    Assertions.assertTrue(tasks.contains(secondTask));
  }

  @Test
  public void testDeleteAllDeletesAllRowsInTasks() throws SQLException {
    Task firstTask = new Task("any task", false, LocalDateTime.now());
    taskDao.save(firstTask);

    int rowsDeleted = taskDao.deleteAll();
    Assertions.assertEquals(1, rowsDeleted);

    Assertions.assertTrue(taskDao.findAll().isEmpty());
  }

  @Test
  public void testGetByIdReturnsCorrectTask() {
    Task task = new Task("test task", false, LocalDateTime.now());
    taskDao.save(task);

    Assertions.assertNotNull(taskDao.getById(task.getId()));
    Assertions.assertEquals(task, taskDao.getById(task.getId()));
  }

  @Test
  public void testFindNotFinishedReturnsCorrectTasks()  {
    Task unfinishedTask = new Task("test task", false, LocalDateTime.now());
    taskDao.save(unfinishedTask);

    Task finishedTask = new Task("test task", false, LocalDateTime.now());
    taskDao.save(finishedTask);

    Assertions.assertTrue(taskDao.findAllNotFinished().contains(unfinishedTask));
  }

  @Test
  public void testFindNewestTasksReturnsCorrectTasks() {
    Task firstTask = new Task("first task", false, LocalDateTime.now());
    taskDao.save(firstTask);

    Task secondTask = new Task("second task", false, LocalDateTime.now());
    taskDao.save(secondTask);

    Task thirdTask = new Task("third task", false, LocalDateTime.now());
    taskDao.save(thirdTask);

    Assertions.assertEquals(2, taskDao.findNewestTasks(2).size());
    Assertions.assertTrue(taskDao.findNewestTasks(2).contains(secondTask));
    Assertions.assertTrue(taskDao.findNewestTasks(2).contains(thirdTask));
  }

  @Test
  public void testFinishSetsCorrectFlagInDb() {
    Task task = new Task("test task", false, LocalDateTime.now());
    taskDao.save(task);

    Assertions.assertEquals(true, taskDao.finishTask(task).getFinished());
    Assertions.assertEquals(true, taskDao.getById(task.getId()).getFinished());
  }

  @Test
  public void deleteByIdDeletesOnlyNecessaryData() {
    Task taskToDelete = new Task("first task", false, LocalDateTime.now());
    taskDao.save(taskToDelete);

    Task taskToPreserve = new Task("second task", false, LocalDateTime.now());
    taskDao.save(taskToPreserve);

    taskDao.deleteById(taskToDelete.getId());
    Assertions.assertNull(taskDao.getById(taskToDelete.getId()));
    Assertions.assertNotNull(taskDao.getById(taskToPreserve.getId()));
  }
}
