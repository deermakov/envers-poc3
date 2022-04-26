package ru.lanit.research.envers.adapter.jpa;

import org.springframework.data.repository.CrudRepository;
import ru.lanit.research.envers.domain.Deal;
import ru.lanit.research.envers.domain.Individual;

import java.util.UUID;

public interface DealJpaRepository extends CrudRepository<Deal, UUID> {
}
