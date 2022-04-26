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
public class Scheduler {
    private final MainProcessor mainProcessor;
    private boolean processed;

    @Scheduled(fixedDelay = 5000)
    public void save() {
        if (!processed) {
            IndividualEntrepreneur ie = mainProcessor.createIndividualEntrepreneur();
            log.info("ie id = {}", ie.getId());
            log.info("ie name = {}", ie.getName());
            log.info("ie owner id = {}", ie.getIndividual().getId());

            mainProcessor.updateIndividualEntrepreneur(ie.getId());

            IndividualEntrepreneur updatedIe = mainProcessor.getIndividualEntrepreneur(ie.getId());
            log.info("updated ie name = {}", updatedIe.getName());

            processed = true;
        }
    }

}
