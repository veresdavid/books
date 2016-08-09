package hu.lamsoft.books.persistence.user.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import hu.lamsoft.books.persistence.user.entity.User;

/**
 * Created by ui2016 on 2016.08.05..
 */
public interface UserDao extends JpaRepository<User, Integer> {

  Page<User> findAll(Pageable page);

}
