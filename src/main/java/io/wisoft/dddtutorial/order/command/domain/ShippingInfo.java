package io.wisoft.dddtutorial.order.command.domain;

import io.wisoft.dddtutorial.common.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShippingInfo {

  @Embedded
  /**
   * @AttributeOverrides : // 임베디드 타입에 정의한 매핑정보를 재정의
   */
  @AttributeOverrides({
      @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zip_code")),
      @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
      @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2"))
  })
  private Address address;

  @Column(name = "shipping_message")
  private String message;

  @Embedded
  private Receiver receiver;

}
