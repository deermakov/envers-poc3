package ru.lanit.research.envers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LEGAL_ENTITY")
@Audited
@Data
@SuperBuilder
@NoArgsConstructor
public class LegalEntity extends Party {
    private String name;
}
