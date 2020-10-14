package io.wisoft.dddtutorial.order.command.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class OrderNo implements Serializable {

  @Column(name = "order_number")
  private String number;

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    OrderNo orderNo = (OrderNo) obj;
    return Objects.equals(number, orderNo.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

}
