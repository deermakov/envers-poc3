package ru.lanit.research.envers.app.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.research.envers.adapter.jpa.IndividualEntrepreneurJpaRepository;
import ru.lanit.research.envers.adapter.jpa.IndividualJpaRepository;
import ru.lanit.research.envers.domain.Individual;
import ru.lanit.research.envers.domain.IndividualEntrepreneur;

/**
 * Оркестратор отправки сообщений
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class MainProcessor {
    private final IndividualEntrepreneurJpaRepository individualEntrepreneurJpaRepository;
    private final IndividualJpaRepository individualJpaRepository;

    @Scheduled(fixedDelay = 5000)
    @Transactional
    public void save() {
        createIndividualEntrepreneur();
    }

    private void createIndividualEntrepreneur() {
        Individual individual = Individual.builder()
            .fio("Иванов Иван Иванович")
            .build();
        individualJpaRepository.save(individual);

        IndividualEntrepreneur individualEntrepreneur = IndividualEntrepreneur.builder()
            .fullName("ИП Иванов")
            .individual(individual)
            .build();
        individualEntrepreneurJpaRepository.save(individualEntrepreneur);
    }
}
