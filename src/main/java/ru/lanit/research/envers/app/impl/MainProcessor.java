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

import java.util.Date;
import java.util.UUID;

/**
 * Оркестратор отправки сообщений
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class MainProcessor {
    private final IndividualEntrepreneurJpaRepository individualEntrepreneurJpaRepository;
    private final IndividualJpaRepository individualJpaRepository;

    @Transactional
    public IndividualEntrepreneur createIndividualEntrepreneur() {
        Individual individual = Individual.builder()
            .actualTo(new Date())
            .fio("Иванов Иван Иванович")
            .inn("77200300")
            .build();
        individualJpaRepository.save(individual);

        IndividualEntrepreneur individualEntrepreneur = IndividualEntrepreneur.builder()
            .actualTo(new Date())
            .name("ИП Иванов")
            .inn("23100200")
            .selfEmployed(false)
            .individual(individual)
            .build();
        return individualEntrepreneurJpaRepository.save(individualEntrepreneur);
    }

    @Transactional
    public IndividualEntrepreneur updateIndividualEntrepreneur(UUID ieId) {
        IndividualEntrepreneur individualEntrepreneur = individualEntrepreneurJpaRepository.findById(ieId).orElseThrow();
        individualEntrepreneur.setName("Новое имя");
        return individualEntrepreneur;
    }

    @Transactional
    public IndividualEntrepreneur getIndividualEntrepreneur(UUID ieId) {
        return individualEntrepreneurJpaRepository.findById(ieId).orElseThrow();
    }
}