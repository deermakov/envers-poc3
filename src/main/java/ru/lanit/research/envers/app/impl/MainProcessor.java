package ru.lanit.research.envers.app.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.research.envers.adapter.jpa.DealJpaRepository;
import ru.lanit.research.envers.adapter.jpa.IndividualEntrepreneurJpaRepository;
import ru.lanit.research.envers.adapter.jpa.IndividualJpaRepository;
import ru.lanit.research.envers.domain.Deal;
import ru.lanit.research.envers.domain.Individual;
import ru.lanit.research.envers.domain.IndividualEntrepreneur;
import ru.lanit.research.envers.domain.Party;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
    private final DealJpaRepository dealJpaRepository;

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
            .name("ИП Иванов И.И.")
            .inn("23100200")
            .selfEmployed(false)
            .individual(individual)
            .build();
        return individualEntrepreneurJpaRepository.save(individualEntrepreneur);
    }

    @Transactional
    public IndividualEntrepreneur updateIndividualEntrepreneur(UUID ieId) {
        IndividualEntrepreneur individualEntrepreneur = individualEntrepreneurJpaRepository.findById(ieId).orElseThrow();
        individualEntrepreneur.setName("ИП Новое ФИО");
        individualEntrepreneur.setInn("33100300");
        individualEntrepreneur.getIndividual().setFio("Новое ФИО");
        individualEntrepreneur.setSelfEmployed(true);
        return individualEntrepreneur;
    }

    @Transactional
    public IndividualEntrepreneur getIndividualEntrepreneur(UUID ieId) {
        return individualEntrepreneurJpaRepository.findById(ieId).orElseThrow();
    }

    public void getIndividualEntrepreneurRevisions(UUID ieId) {
        Revisions<Long, IndividualEntrepreneur> revisions = individualEntrepreneurJpaRepository.findRevisions(ieId);
        revisions.stream().forEach(individualEntrepreneurRevision -> log.info("IE revision = {}", individualEntrepreneurRevision));
    }

    @Transactional
    public Deal createDeal(UUID ieId) {
        IndividualEntrepreneur ie = individualEntrepreneurJpaRepository.findById(ieId).orElseThrow();

        List<Party> participants = List.of(ie, ie.getIndividual());

        Deal deal = Deal.builder()
            .num("№ 1")
            .sum(BigDecimal.TEN)
            .creator(ie.getIndividual()) // Полиморфная ссылка Deal > Party
            //.participants(participants) // это не нужно, т.к. связь хранится не в Deal, а в Party - см. далее
            .build();

        // Полиморфная ссылка Party > Deal
        // т.к. ссылка на Deal лежит в Party, надо ее заполнить
        participants.stream().forEach(party -> party.setDeal(deal));

        dealJpaRepository.save(deal); // новая сущность, надо сохранить
        // individualEntrepreneurJpaRepository.save(ie); измененная сущность, JPA сам её сохраняет

        return deal;
    }

    @Transactional
    public Deal getDeal(UUID dealId) {
        return dealJpaRepository.findById(dealId).orElseThrow();
    }
}