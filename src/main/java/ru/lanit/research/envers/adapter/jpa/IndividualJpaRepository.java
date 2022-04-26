package ru.lanit.research.envers.adapter.jpa;

import org.springframework.data.repository.CrudRepository;
import ru.lanit.research.envers.domain.Individual;
import ru.lanit.research.envers.domain.IndividualEntrepreneur;

import java.util.UUID;

public interface IndividualJpaRepository extends CrudRepository<Individual, UUID> {
}
