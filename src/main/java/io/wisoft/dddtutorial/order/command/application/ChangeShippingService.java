package io.wisoft.dddtutorial.order.command.application;

import io.wisoft.dddtutorial.order.NoOrderException;
import io.wisoft.dddtutorial.order.command.domain.Order;
import io.wisoft.dddtutorial.order.command.domain.OrderNo;
import io.wisoft.dddtutorial.order.command.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangeShippingService {

  private final OrderRepository orderRepository;

  @Transactional
  public void changeShipping(ChangeShippingRequest changeReq) {
    Order order = orderRepository.findById(new OrderNo(changeReq.getNumber()));
    checkNoOrder(order);
    order.changeShippingInfo(changeReq.getShippingInfo());
  }

  private void checkNoOrder(Order order) {
    if (order == null)
      throw new NoOrderException();
  }

}
