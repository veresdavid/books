package hu.lamsoft.books.service.user.impl.vo;

import java.time.LocalDate;

/**
 * Created by ui2016 on 2016.08.08..
 */
public class UserVO {

  private Integer id;
  private String fullName;
  private String loginName;
  private String password;
  private LocalDate registrationDate;

  public Integer getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getLoginName() {
    return loginName;
  }

  public String getPassword() {
    return password;
  }

  public LocalDate getRegistrationDate() {
    return registrationDate;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRegistrationDate(LocalDate registrationDate) {
    this.registrationDate = registrationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserVO userVO = (UserVO) o;

    if (!id.equals(userVO.id)) {
      return false;
    }
    if (!fullName.equals(userVO.fullName)) {
      return false;
    }
    if (!loginName.equals(userVO.loginName)) {
      return false;
    }
    if (!password.equals(userVO.password)) {
      return false;
    }
    return registrationDate.equals(userVO.registrationDate);

  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + fullName.hashCode();
    result = 31 * result + loginName.hashCode();
    result = 31 * result + password.hashCode();
    result = 31 * result + registrationDate.hashCode();
    return result;
  }

}
