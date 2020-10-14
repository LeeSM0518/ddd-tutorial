package io.wisoft.dddtutorial.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@Getter
public class MemberId implements Serializable {

  @Column(name = "member_id")
  private String id;

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    MemberId memberId = (MemberId) obj;
    return Objects.equals(id, memberId.id);
  }

}
