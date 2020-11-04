package io.wisoft.dddtutorial.order.command.application;

import io.wisoft.dddtutorial.order.command.domain.ShippingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangeShippingRequest {

  private String number;
  private ShippingInfo shippingInfo;

}
