package ru.lanit.research.envers.adapter.jpa;

import org.springframework.data.repository.CrudRepository;
import ru.lanit.research.envers.domain.LegalEntity;

import java.util.List;
import java.util.UUID;

public interface LegalEntityJpaRepository extends CrudRepository<LegalEntity, UUID> {
    List<LegalEntity> findAllByOrderByInn();
}
