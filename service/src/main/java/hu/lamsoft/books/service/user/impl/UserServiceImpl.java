package hu.lamsoft.books.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import hu.lamsoft.books.persistence.user.dao.UserDao;
import hu.lamsoft.books.persistence.user.entity.User;
import hu.lamsoft.books.service.user.UserService;
import hu.lamsoft.books.service.user.impl.converter.UserToUserVOConverter;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

/**
 * Created by ui2016 on 2016.08.08..
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private UserToUserVOConverter converter;

  @Override
  public void createUser(UserVO user) {

    User userEntity = new User();

    // userEntity.setId(user.getId());
    userEntity.setPassword(user.getPassword());
    userEntity.setLoginName(user.getLoginName());
    userEntity.setFullName(user.getFullName());

    userDao.save(userEntity);

  }

  @Override
  public List<UserVO> getUsers(Integer page, Integer pageSize) {

    Page<User> userPage = userDao.findAll(new PageRequest(page, pageSize));
    List<UserVO> users = new ArrayList<>(userPage.getSize());

    for (User user : userPage) {
      users.add(converter.convert(user));
    }

    return users;
  }

  @Override
  public UserVO getUser(Integer id) {

    return converter.convert(userDao.findOne(id));

  }

}
