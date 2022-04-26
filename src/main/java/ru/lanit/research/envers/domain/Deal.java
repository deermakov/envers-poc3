package ru.lanit.research.envers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "DEAL")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Deal extends DomainObject {
    private String num;
    private BigDecimal sum;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Party> participants;
}
