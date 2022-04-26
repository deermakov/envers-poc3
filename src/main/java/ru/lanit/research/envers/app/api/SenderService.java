package ru.lanit.research.envers.app.api;

/**
 * Компонент, отправляющий сообщения из хранилища-источника в Kafka
 */
public interface SenderService {
    void sendNextEntity();
}
