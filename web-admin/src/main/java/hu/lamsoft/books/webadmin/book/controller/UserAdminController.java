package hu.lamsoft.books.webadmin.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import hu.lamsoft.books.service.user.UserService;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

/**
 * Created by ui2016 on 2016.08.08..
 */

@Controller
@RequestMapping("/user")
public class UserAdminController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createUser(@Valid UserVO userVO, BindingResult result, Model model) {

    if (result.hasErrors()) {
      model.addAttribute("user", userVO);
      model.addAttribute("message", "Failed operation.");
    } else {
      userService.createUser(userVO);
      model.addAttribute("user", new UserVO());
      model.addAttribute("message", "Success operation.");
    }

    return "user";

  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String userForm(Model model) {
    model.addAttribute("user", new UserVO());
    return "user";
  }

}
