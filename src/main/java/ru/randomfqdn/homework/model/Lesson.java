package ru.randomfqdn.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.RepresentationModel;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The lesson object
 */
@ApiModel(description = "The lesson object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")
@Entity
@Table(name = "LESSON")
public class Lesson extends RepresentationModel<Lesson> implements Serializable {

  @Id
  @JsonProperty("id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @JsonProperty("name")
  @Column(name = "NAME")
  private String name;

  @Column(name = "WHEN")
  @OneToMany(
          mappedBy = "TIMETABLE"
  )
  private List<Time> when = new ArrayList<>();

  @JsonProperty("day")
  @Valid
  @Transient
  private List<String> day = when.stream().map(it -> it.getDay()).collect(Collectors.toList());

  @JsonProperty("time")
  @Valid
  @Transient
  private List<String> time = when.stream().map(it -> {
    var formatter = new SimpleDateFormat("hh:MM");
    return formatter.format(it.getTime());
  }).collect(Collectors.toList());

  @JsonProperty("homework")
  @Valid
  @ManyToMany
  @JoinTable(
          name = "TASKS",
          joinColumns = @JoinColumn(name = "SUBJECT"),
          inverseJoinColumns = @JoinColumn(name = "TASK")
  )
  private List<Homework> homework = new ArrayList<>();

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

  public Lesson() {
    // Required by the JPA
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

  public Lesson day(List<String> day) {
    this.day = day;
    return this;
  }

  public Lesson addDayItem(String dayItem) {
    if (this.day == null) {
      this.day = new ArrayList<>();
    }
    this.day.add(dayItem);
    return this;
  }

  /**
   * Get day
   * @return day
  */
  @ApiModelProperty(value = "")
  public List<String> getDay() {
    return day;
  }

  public void setDay(List<String> day) {
    this.day = day;
  }

  public Lesson time(List<String> time) {
    this.time = time;
    return this;
  }

  public Lesson addTimeItem(String timeItem) {
    if (this.time == null) {
      this.time = new ArrayList<>();
    }
    this.time.add(timeItem);
    return this;
  }

  /**
   * Get time
   * @return time
  */
  @ApiModelProperty(value = "")
  public List<String> getTime() {
    return time;
  }

  public void setTime(List<String> time) {
    this.time = time;
  }

  public Lesson homework(List<Homework> homework) {
    this.homework = homework;
    return this;
  }

  public Lesson addHomeworkItem(Homework homeworkItem) {
    if (this.homework == null) {
      this.homework = new ArrayList<>();
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

  public List<Homework> getHomework() {
    return homework;
  }

  public void setHomework(List<Homework> homework) {
    this.homework = homework;
  }


  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

