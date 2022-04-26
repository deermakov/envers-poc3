package ru.lanit.research.envers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PARTY")
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class Party extends DomainObject {
    private String inn;

    @ManyToOne
    @JoinColumn(name = "deal_id")
    private Deal deal;
}
