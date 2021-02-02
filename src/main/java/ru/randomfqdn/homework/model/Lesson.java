package ru.randomfqdn.homework.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.randomfqdn.homework.model.Homework;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * The lesson object
 */
@ApiModel(description = "The lesson object")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")

public class Lesson extends RepresentationModel<Lesson>   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("day")
  @Valid
  private java.util.List<String> day = null;

  @JsonProperty("time")
  @Valid
  private java.util.List<String> time = null;

  @JsonProperty("homework")
  @Valid
  private java.util.List<Homework> homework = null;

  public Lesson id(Integer id) {
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

  public Lesson name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Lesson day(java.util.List<String> day) {
    this.day = day;
    return this;
  }

  public Lesson addDayItem(String dayItem) {
    if (this.day == null) {
      this.day = new java.util.ArrayList<>();
    }
    this.day.add(dayItem);
    return this;
  }

  /**
   * Get day
   * @return day
  */
  @ApiModelProperty(value = "")


  public java.util.List<String> getDay() {
    return day;
  }

  public void setDay(java.util.List<String> day) {
    this.day = day;
  }

  public Lesson time(java.util.List<String> time) {
    this.time = time;
    return this;
  }

  public Lesson addTimeItem(String timeItem) {
    if (this.time == null) {
      this.time = new java.util.ArrayList<>();
    }
    this.time.add(timeItem);
    return this;
  }

  /**
   * Get time
   * @return time
  */
  @ApiModelProperty(value = "")


  public java.util.List<String> getTime() {
    return time;
  }

  public void setTime(java.util.List<String> time) {
    this.time = time;
  }

  public Lesson homework(java.util.List<Homework> homework) {
    this.homework = homework;
    return this;
  }

  public Lesson addHomeworkItem(Homework homeworkItem) {
    if (this.homework == null) {
      this.homework = new java.util.ArrayList<>();
    }
    this.homework.add(homeworkItem);
    return this;
  }

  /**
   * Get homework
   * @return homework
  */
  @ApiModelProperty(value = "")

  @Valid

  public java.util.List<Homework> getHomework() {
    return homework;
  }

  public void setHomework(java.util.List<Homework> homework) {
    this.homework = homework;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lesson lesson = (Lesson) o;
    return Objects.equals(this.id, lesson.id) &&
        Objects.equals(this.name, lesson.name) &&
        Objects.equals(this.day, lesson.day) &&
        Objects.equals(this.time, lesson.time) &&
        Objects.equals(this.homework, lesson.homework);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, day, time, homework);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lesson {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    homework: ").append(toIndentedString(homework)).append("\n");
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

