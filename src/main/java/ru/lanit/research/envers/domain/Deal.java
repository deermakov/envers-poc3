package ru.lanit.research.envers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "DEAL")
@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Deal extends DomainObject {
    private String num;
    private BigDecimal sum;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "deal")
    private List<Individual> participantsIndividual; // Неполиморфная ссылка

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "deal")
    private List<IndividualEntrepreneur> participantsIndividualEntrepreneur; // Неполиморфная ссылка

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "deal")
    private List<LegalEntity> participantsLegalEntity; // Неполиморфная ссылка

    @OneToOne
    @JoinColumn(name = "creator_individual_id")
    private Individual creatorIndividual; // Неполиморфная ссылка

    @OneToOne
    @JoinColumn(name = "creator_individual_entrepreneur_id")
    private IndividualEntrepreneur creatorIndividualEntrepreneur; // Неполиморфная ссылка

    @OneToOne
    @JoinColumn(name = "creator_legal_entity_id")
    private LegalEntity creatorLegalEntity; // Неполиморфная ссылка
}
