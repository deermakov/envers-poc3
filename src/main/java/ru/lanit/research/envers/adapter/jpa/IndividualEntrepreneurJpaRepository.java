package ru.lanit.research.envers.adapter.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import ru.lanit.research.envers.domain.IndividualEntrepreneur;

import java.util.UUID;

public interface IndividualEntrepreneurJpaRepository extends CrudRepository<IndividualEntrepreneur, UUID>,
    RevisionRepository<IndividualEntrepreneur, UUID, Long> {
}
