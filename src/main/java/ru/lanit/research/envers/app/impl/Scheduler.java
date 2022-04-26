package ru.lanit.research.envers.app.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.lanit.research.envers.domain.IndividualEntrepreneur;

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
            processed = true;

            IndividualEntrepreneur ie = mainProcessor.createIndividualEntrepreneur();
            UUID ieId = ie.getId();
            log.info("ie id = {}", ieId);
            log.info("ie name = {}", ie.getName());
            log.info("ie owner id = {}", ie.getIndividual().getId());

            mainProcessor.updateIndividualEntrepreneur(ieId);

            IndividualEntrepreneur updatedIe = mainProcessor.getIndividualEntrepreneur(ieId);
            log.info("updated ie name = {}", updatedIe.getName());

            mainProcessor.getIndividualEntrepreneurRevisions(ieId);
        }
    }
}
