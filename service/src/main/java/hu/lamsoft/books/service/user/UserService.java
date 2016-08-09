package hu.lamsoft.books.service.user;

import java.util.List;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

/**
 * Created by ui2016 on 2016.08.08..
 */
public interface UserService {

  void createUser(UserVO user);

  List<UserVO> getUsers(Integer page, Integer pageSize);

  UserVO getUser(Integer id);

}
