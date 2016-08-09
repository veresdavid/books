package hu.lamsoft.books.service.order.impl.vo;

import java.time.LocalDate;
import hu.lamsoft.books.service.book.impl.vo.BookVO;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

/**
 * Created by ui2016 on 2016.08.08..
 */
public class OrderVO {

  private Integer id;
  private LocalDate createdDate;
  private LocalDate returnDate;
  private UserVO user;
  private BookVO book;

  public Integer getId() {
    return id;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public UserVO getUser() {
    return user;
  }

  public BookVO getBook() {
    return book;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OrderVO orderVO = (OrderVO) o;

    if (!id.equals(orderVO.id)) {
      return false;
    }
    if (!createdDate.equals(orderVO.createdDate)) {
      return false;
    }
    if (returnDate != null ? !returnDate.equals(orderVO.returnDate) : orderVO.returnDate != null) {
      return false;
    }
    if (!user.equals(orderVO.user)) {
      return false;
    }
    return book.equals(orderVO.book);

  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + createdDate.hashCode();
    result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
    result = 31 * result + user.hashCode();
    result = 31 * result + book.hashCode();
    return result;
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

  public void setUser(UserVO user) {
    this.user = user;
  }

  public void setBook(BookVO book) {
    this.book = book;
  }

}
