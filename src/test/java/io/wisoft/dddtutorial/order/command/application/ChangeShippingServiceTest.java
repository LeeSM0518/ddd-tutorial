package io.wisoft.dddtutorial.order.command.application;

import io.wisoft.dddtutorial.catalog.domain.product.ProductId;
import io.wisoft.dddtutorial.common.model.Address;
import io.wisoft.dddtutorial.member.domain.MemberId;
import io.wisoft.dddtutorial.model.Money;
import io.wisoft.dddtutorial.order.command.domain.*;
import io.wisoft.dddtutorial.order.infra.repository.JpaOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class ChangeShippingServiceTest {

  @Autowired
  ChangeShippingService changeShippingService;
  @Autowired
  JpaOrderRepository repository;

  private final OrderNo orderNo = new OrderNo("1");

  @BeforeEach
  void save() {
    // given
    MemberId memberId = new MemberId("1");
    Orderer orderer = new Orderer(memberId, "min");
    List<OrderLine> orderLines = getOrderLines();
    ShippingInfo shippingInfo = getShippingInfo();
    OrderState paymentWaiting = OrderState.PAYMENT_WAITING;
    Order order = new Order(orderNo, orderer, orderLines, shippingInfo, paymentWaiting);

    // when
    repository.save(order);

    // then
    Order orderFoundById = repository.findById(orderNo);
    assertEquals(order.getNumber().getNumber(), orderFoundById.getNumber().getNumber());
  }

  @Test
  public void changeShippingTest() throws Exception {
    // given
    String seoul = "서울";
    Address address = new Address("1234", seoul, "유성구");
    Receiver receiver = new Receiver("min", "010-1234-1234");
    ShippingInfo shippingInfo = new ShippingInfo(address, "구매", receiver);
    ChangeShippingRequest request = new ChangeShippingRequest(orderNo.getNumber(), shippingInfo);

    // when
    changeShippingService.changeShipping(request);

    // then
    Order order = repository.findById(orderNo);
    assertEquals(seoul, order.getShippingInfo().getAddress().getAddress1());
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