package hu.lamsoft.books.service.user.impl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.lamsoft.books.persistence.user.entity.User;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

/**
 * Created by ui2016 on 2016.08.08..
 */
@Component
public class UserToUserVOConverter implements Converter<User, UserVO> {

  @Override
  public UserVO convert(User user) {

    if (user == null) {

      return null;

    } else {

      UserVO userVO = new UserVO();

      userVO.setId(user.getId());
      userVO.setFullName(user.getFullName());
      userVO.setLoginName(user.getLoginName());
      userVO.setPassword(user.getPassword());
      userVO.setRegistrationDate(user.getRegistrationDate());

      return userVO;

    }

  }

}
