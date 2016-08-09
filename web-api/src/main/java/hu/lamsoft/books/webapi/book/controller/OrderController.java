package hu.lamsoft.books.webapi.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import hu.lamsoft.books.service.order.OrderService;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;

/**
 * Created by ui2016 on 2016.08.09..
 */

@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @RequestMapping("/orders")
  public List<OrderVO> getOrders(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "page", defaultValue = "10") Integer pageSize) {

    return orderService.getOrders(page, pageSize);

  }

}
