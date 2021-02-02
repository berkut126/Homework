package ru.randomfqdn.homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The homework object
 */
@ApiModel(description = "The homework object")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")
@Entity
@Table(name = "HOMEWORK")
public class Homework extends RepresentationModel<Homework> implements Serializable {

  @Id
  @JsonProperty("id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "TASK")
  @JsonProperty("task")
  private String task;

  @JsonProperty("due")
  @DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  @Column(name = "DUE")
  private LocalDate due;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "SUBJECT")
  private Lesson lesson;

  public Homework id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Homework task(String task) {
    this.task = task;
    return this;
  }

  /**
   * Get task
   * @return task
  */
  @ApiModelProperty(value = "")
  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public Homework due(LocalDate due) {
    this.due = due;
    return this;
  }

  /**
   * Get due
   * @return due
  */
  @ApiModelProperty(value = "")
  @Valid
  public LocalDate getDue() {
    return due;
  }

  public void setDue(LocalDate due) {
    this.due = due;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Homework homework = (Homework) o;
    return Objects.equals(this.id, homework.id) &&
        Objects.equals(this.task, homework.task) &&
        Objects.equals(this.due, homework.due);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, task, due);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Homework {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    task: ").append(toIndentedString(task)).append("\n");
    sb.append("    due: ").append(toIndentedString(due)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

