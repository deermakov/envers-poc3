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
    private List<Party> participants; // Полиморфная ссылка

    @OneToOne
    @JoinColumn(name = "creator_id")
    private Party creator; // Полиморфная ссылка
}
