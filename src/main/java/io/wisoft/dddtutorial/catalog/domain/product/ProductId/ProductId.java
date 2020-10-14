package io.wisoft.dddtutorial.catalog.domain.product.ProductId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

import static lombok.AccessLevel.PROTECTED;

@Embeddable
@Access(AccessType.FIELD)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Getter
public class ProductId implements Serializable {

  @Column(name = "product_id")
  private String id;

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ProductId productId = (ProductId) obj;
    return Objects.equals(id, productId.id);
  }

}
