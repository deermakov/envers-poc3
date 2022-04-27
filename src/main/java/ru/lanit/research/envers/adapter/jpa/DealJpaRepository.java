package ru.lanit.research.envers.adapter.jpa;

import org.springframework.data.repository.CrudRepository;
import ru.lanit.research.envers.domain.Deal;

import java.util.UUID;

public interface DealJpaRepository extends CrudRepository<Deal, UUID> {
}
