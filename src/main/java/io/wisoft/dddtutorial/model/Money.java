package io.wisoft.dddtutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Money implements Serializable {

  private int value;

  public Money multiply(int multiplier) {
    return new Money(value * multiplier);
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }

}
