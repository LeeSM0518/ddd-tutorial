package io.wisoft.dddtutorial.order.command.domain;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface OrderRepository {

  Order findById(OrderNo id);

  void save(Order order);

  void remove(Order order);

  List<Order> findAll(Specification<Order> spec, String ... orders);

  Long counts(Specification<Order> spec);

  Long countsAll();

}
