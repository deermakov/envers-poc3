package ru.lanit.research.envers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public abstract class Party extends DomainObject {
    private String inn;

    @ManyToOne
    @JoinColumn(name = "deal_id")
    @ToString.Exclude
    private Deal deal;
}
