package ru.lanit.research.envers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INDIVIDUAL_ENTREPRENEUR")
@Data
@SuperBuilder
@NoArgsConstructor
public class IndividualEntrepreneur extends LegalEntity {
    @OneToOne
    @JoinColumn(name = "individual_id")
    private Individual individual;

    private Boolean selfEmployed;
}
