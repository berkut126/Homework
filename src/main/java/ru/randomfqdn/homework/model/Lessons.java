package ru.randomfqdn.homework.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.randomfqdn.homework.model.Lesson;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Array of lessons
 */
@ApiModel(description = "Array of lessons")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")

public class Lessons extends RepresentationModel<Lessons>   {
  @JsonProperty("lessons")
  @Valid
  private java.util.List<Lesson> lessons = null;

  @JsonProperty("version")
  private Integer version;

  public Lessons lessons(java.util.List<Lesson> lessons) {
    this.lessons = lessons;
    return this;
  }

  public Lessons addLessonsItem(Lesson lessonsItem) {
    if (this.lessons == null) {
      this.lessons = new java.util.ArrayList<>();
    }
    this.lessons.add(lessonsItem);
    return this;
  }

  /**
   * Get lessons
   * @return lessons
  */
  @ApiModelProperty(value = "")

  @Valid

  public java.util.List<Lesson> getLessons() {
    return lessons;
  }

  public void setLessons(java.util.List<Lesson> lessons) {
    this.lessons = lessons;
  }

  public Lessons version(Integer version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
  */
  @ApiModelProperty(value = "")


  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lessons lessons = (Lessons) o;
    return Objects.equals(this.lessons, lessons.lessons) &&
        Objects.equals(this.version, lessons.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lessons, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lessons {\n");
    
    sb.append("    lessons: ").append(toIndentedString(lessons)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

