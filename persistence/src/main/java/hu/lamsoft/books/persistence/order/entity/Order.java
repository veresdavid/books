package hu.lamsoft.books.persistence.order.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import hu.lamsoft.books.persistence.book.entity.Book;
import hu.lamsoft.books.persistence.user.entity.User;

/**
 * Created by ui2016 on 2016.08.05..
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ORDERS")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @CreatedDate
  private LocalDate createdDate;
  private LocalDate returnDate;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")
  private Book book;

  public Integer getId() {
    return id;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public User getUser() {
    return user;
  }

  public Book getBook() {
    return book;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setBook(Book book) {
    this.book = book;
  }

}
