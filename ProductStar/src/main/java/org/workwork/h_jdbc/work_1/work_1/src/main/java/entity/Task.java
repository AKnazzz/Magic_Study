package org.workwork.h_jdbc.work_1.work_1.src.main.java.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Task {
  private Integer id;
  private String title;
  private Boolean finished;
  private LocalDateTime createdDate;

  public Task(String title, Boolean finished, LocalDateTime createdDate) {
    this.title = title;
    this.finished = finished;
    this.createdDate = createdDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getFinished() {
    return finished;
  }

  public void setFinished(Boolean finished) {
    this.finished = finished;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public String toString() {
    return "Task{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", finished=" + finished +
            ", createdDate=" + createdDate +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Task task = (Task) o;
    return Objects.equals(id, task.id) &&
            Objects.equals(title, task.title) &&
            Objects.equals(finished, task.finished) &&
            Objects.equals(createdDate.truncatedTo(ChronoUnit.MILLIS),
                    task.createdDate.truncatedTo(ChronoUnit.MILLIS));
  }

}