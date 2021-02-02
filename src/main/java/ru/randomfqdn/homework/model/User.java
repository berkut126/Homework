package ru.randomfqdn.homework.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * User object
 */
@ApiModel(description = "User object")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")

public class User extends RepresentationModel<User>   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("login")
  private String login;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("password")
  private String password;

  @JsonProperty("group")
  private String group;

  public User id(Integer id) {
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

  public User login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
  */
  @ApiModelProperty(value = "")


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User group(String group) {
    this.group = group;
    return this;
  }

  /**
   * Get group
   * @return group
  */
  @ApiModelProperty(value = "")


  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.login, user.login) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.group, user.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, firstName, lastName, password, group);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
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

