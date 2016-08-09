package hu.lamsoft.books.webadmin.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import hu.lamsoft.books.service.order.OrderService;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;

/**
 * Created by ui2016 on 2016.08.09..
 */

@Controller
@RequestMapping("/order")
public class OrderAdminController {

  @Autowired
  private OrderService orderService;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createOrder(@Valid OrderVO order, BindingResult result, Model model) {

    if (result.hasErrors()) {
      model.addAttribute("order", order);
      model.addAttribute("message", "Failed operation.");
    } else {
      orderService.createOrder(order);
      model.addAttribute("order", new OrderVO());
      model.addAttribute("message", "Success operation.");
    }
    return "order";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String orderForm(Model model) {
    model.addAttribute("order", new OrderVO());
    return "order";
  }

}
