package ru.lanit.research.envers.adapter.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import ru.lanit.research.envers.domain.LegalEntity;

import java.util.UUID;

public interface LegalEntityJpaRepository extends CrudRepository<LegalEntity, UUID>,
    RevisionRepository<LegalEntity, UUID, Long> {
}
