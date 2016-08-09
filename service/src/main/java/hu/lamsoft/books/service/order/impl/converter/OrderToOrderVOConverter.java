package hu.lamsoft.books.service.order.impl.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.lamsoft.books.persistence.order.entity.Order;
import hu.lamsoft.books.service.book.impl.converter.BookToBookVOConverter;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;
import hu.lamsoft.books.service.user.impl.converter.UserToUserVOConverter;

/**
 * Created by ui2016 on 2016.08.08..
 */
@Component
public class OrderToOrderVOConverter implements Converter<Order, OrderVO> {

  @Autowired
  private UserToUserVOConverter userConverter;

  @Autowired
  private BookToBookVOConverter bookConverter;

  @Override
  public OrderVO convert(Order order) {

    if (order == null) {

      return null;

    } else {

      OrderVO orderVO = new OrderVO();

      orderVO.setId(order.getId());
      orderVO.setCreatedDate(order.getCreatedDate());
      orderVO.setReturnDate(order.getReturnDate());
      orderVO.setBook(bookConverter.convert(order.getBook()));
      orderVO.setUser(userConverter.convert(order.getUser()));

      return orderVO;

    }

  }

}
