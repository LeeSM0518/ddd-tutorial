package io.wisoft.dddtutorial.order.command.domain;

import io.wisoft.dddtutorial.catalog.domain.product.ProductId;
import io.wisoft.dddtutorial.model.Money;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@NoArgsConstructor(access = PRIVATE)
@Getter
@ToString
public class OrderLine {

  @Embedded
  private ProductId productId;

  @Column(name = "price")
  private Money price;

  @Column
  private int quantity;

  @Column(name = "amounts")
  private Money amounts;

  public OrderLine(ProductId productId, Money price, int quantity) {
    this.productId = productId;
    this.price = price;
    this.quantity = quantity;
    this.amounts = calculateAmounts();
  }

  private Money calculateAmounts() {
    return price.multiply(quantity);
  }

}
