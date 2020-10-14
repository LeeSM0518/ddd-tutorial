package io.wisoft.dddtutorial.order.infra.repository;

import io.wisoft.dddtutorial.order.command.domain.Order;
import io.wisoft.dddtutorial.order.command.domain.OrderNo;
import io.wisoft.dddtutorial.order.command.domain.OrderRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaOrderRepository implements OrderRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Order findById(OrderNo id) {
    return em.find(Order.class, id);
  }

  @Override
  public void save(Order order) {
    em.persist(order);
  }

  @Override
  public void remove(Order order) {
    em.remove(order);
  }

  @Override
  public List<Order> findAll(Specification<Order> spec, String... orders) {
    return null;
  }

  @Override
  public Long counts(Specification<Order> spec) {
    return null;
  }

  @Override
  public Long countsAll() {
    TypedQuery<Long> query = em.createQuery("select count(o) from Order o", Long.class);
    return query.getSingleResult();
  }

  public List<Order> findAll() {
    return em.createQuery("select o from Order o", Order.class).getResultList();
  }

}
