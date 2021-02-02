package ru.randomfqdn.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.Valid;
import java.util.Objects;

/**
 * InlineResponse200
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")

public class InlineResponse200 extends RepresentationModel<InlineResponse200>   {

  @JsonProperty("homework")
  @Valid
  private java.util.List<Homework> homework = null;

  public InlineResponse200 homework(java.util.List<Homework> homework) {
    this.homework = homework;
    return this;
  }

  public InlineResponse200 addHomeworkItem(Homework homeworkItem) {
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
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.homework, inlineResponse200.homework);
  }

  @Override
  public int hashCode() {
    return Objects.hash(homework);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
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

