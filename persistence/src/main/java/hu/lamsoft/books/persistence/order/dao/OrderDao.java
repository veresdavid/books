package hu.lamsoft.books.persistence.order.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.books.persistence.order.entity.Order;

/**
 * Created by ui2016 on 2016.08.05..
 */

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

  Page<Order> findAll(Pageable page);

}
