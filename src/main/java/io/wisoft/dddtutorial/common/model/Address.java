package io.wisoft.dddtutorial.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Address {

  @Column
  private String zipCode;

  @Column
  private String address1;

  @Column
  private String address2;

}
