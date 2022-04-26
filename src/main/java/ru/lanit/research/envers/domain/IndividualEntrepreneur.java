package ru.lanit.research.envers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INDIVIDUAL_ENTREPRENEUR")
@Audited
@Data
@SuperBuilder
@NoArgsConstructor
public class IndividualEntrepreneur extends LegalEntity {
    @OneToOne
    @JoinColumn(name = "individual_id")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Individual individual;

    private Boolean selfEmployed;
}
