package hu.lamsoft.books.persistence.user.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ui2016 on 2016.08.05..
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String fullName;
  private String loginName;
  private String password;
  @CreatedDate
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

}
