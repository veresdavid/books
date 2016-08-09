package hu.lamsoft.books.webapi.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import hu.lamsoft.books.service.user.UserService;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

/**
 * Created by ui2016 on 2016.08.08..
 */

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/users")
  public List<UserVO> getUsers(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

    return userService.getUsers(page, pageSize);

  }

  @RequestMapping("/user")
  public UserVO getUser(@RequestParam(value = "id", required = true) Integer id) {

    return userService.getUser(id);

  }

}
