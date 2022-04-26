package ru.lanit.research.envers.app.api;

import ru.lanit.research.envers.domain.Deal;

/**
 * Компонент, сохраняющий сообщения в хранилище-получателе
 */
public interface ReceiverService {

    void receiveEntity(Deal sourceEntity);
}
