package io.wisoft.dddtutorial.order.command.domain;

import io.wisoft.dddtutorial.member.domain.MemberId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

// Orderer 클래스가 다른 엔티티에 통합될 것임을 알림
@Embeddable
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@Getter
public class Orderer {

  @AttributeOverrides(
      @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
  )
  private MemberId memberId;

  @Column(name = "orderer_name")
  private String name;

  @Override
  public int hashCode() {
    return Objects.hash(memberId, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Orderer orderer = (Orderer) obj;
    return Objects.equals(memberId, orderer.memberId) &&
        Objects.equals(name, orderer.name);
  }

}
