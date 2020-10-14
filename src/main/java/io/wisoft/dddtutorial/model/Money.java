package io.wisoft.dddtutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
@Getter
@Setter
@Embeddable
public class Money implements Serializable {

  @Column(name = "money")
  private int value;

  public Money multiply(int multiplier) {
    return new Money(value * multiplier);
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }

}
