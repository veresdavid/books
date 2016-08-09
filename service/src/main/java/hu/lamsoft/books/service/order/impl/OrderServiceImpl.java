package hu.lamsoft.books.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import hu.lamsoft.books.persistence.book.dao.BookDao;
import hu.lamsoft.books.persistence.order.dao.OrderDao;
import hu.lamsoft.books.persistence.order.entity.Order;
import hu.lamsoft.books.persistence.user.dao.UserDao;
import hu.lamsoft.books.service.order.OrderService;
import hu.lamsoft.books.service.order.impl.converter.OrderToOrderVOConverter;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;

/**
 * Created by ui2016 on 2016.08.08..
 */
@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao orderDao;

  @Autowired
  private UserDao userDao;

  @Autowired
  private BookDao bookDao;

  @Autowired
  private OrderToOrderVOConverter converter;

  @Override
  public void createOrder(OrderVO orderVO) {

    Order orderEntity = new Order();
    orderEntity.setBook(bookDao.findOne(orderVO.getBook().getId()));
    orderEntity.setUser(userDao.findOne(orderVO.getUser().getId()));

    orderDao.save(orderEntity);

  }

  @Override
  public void returnOrder(Integer id) {

    Order order = orderDao.findOne(id);
    order.setReturnDate(LocalDate.now());
    orderDao.save(order);

  }

  @Override
  public List<OrderVO> getOrders(Integer page, Integer pageSize) {

    Page<Order> orderPage = orderDao.findAll(new PageRequest(page, pageSize));
    List<OrderVO> orders = new ArrayList<>(orderPage.getSize());

    for (Order order : orderPage) {
      orders.add(converter.convert(order));
    }

    return orders;
  }

  @Override
  public OrderVO getOrder(Integer id) {

    return converter.convert(orderDao.findOne(id));

  }

}
