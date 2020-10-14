package io.wisoft.dddtutorial.order.infra.repository;

import io.wisoft.dddtutorial.catalog.domain.product.ProductId.ProductId;
import io.wisoft.dddtutorial.common.model.Address;
import io.wisoft.dddtutorial.member.domain.MemberId;
import io.wisoft.dddtutorial.model.Money;
import io.wisoft.dddtutorial.order.command.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class JpaOrderRepositoryTest {

  @Autowired
  JpaOrderRepository jpaOrderRepository;

  @Test
  void save() {
    // given
    MemberId memberId = new MemberId("1");
    Orderer orderer = new Orderer(memberId, "min");
    OrderNo orderNo = new OrderNo("1");
    List<OrderLine> orderLines = getOrderLines();
    ShippingInfo shippingInfo = getShippingInfo();
    OrderState paymentWaiting = OrderState.PAYMENT_WAITING;
    Order order = new Order(orderNo, orderer, orderLines, shippingInfo, paymentWaiting);

    // when
    jpaOrderRepository.save(order);

    // then
    List<Order> all = jpaOrderRepository.findAll();
    assertEquals(all.size(), 1);
    assertEquals(orderNo.getNumber(), all.get(0).getNumber().getNumber());
  }

  private ShippingInfo getShippingInfo() {
    Address address = new Address("1234", "대전", "유성구");
    Receiver receiver = new Receiver("min", "010-1234-1234");
    return new ShippingInfo(address, "구매", receiver);
  }

  private List<OrderLine> getOrderLines() {
    ProductId productId1 = new ProductId("1");
    Money money1 = new Money(1000);
    ProductId productId2 = new ProductId("2");
    Money money2 = new Money(2000);
    ProductId productId3 = new ProductId("3");
    Money money3 = new Money(3000);
    return Arrays.asList(new OrderLine(productId1, money1, 1),
        new OrderLine(productId2, money2, 1),
        new OrderLine(productId3, money3, 1));
  }
}