package hu.lamsoft.books.webadmin.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ui2016 on 2016.08.09..
 */

@Controller
@RequestMapping("/list")
public class ListAdminController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String list(Model model) {
    return "list";
  }

}
