package ru.lanit.research.envers.app.api;

import ru.lanit.research.envers.domain.Deal;

/**
 * Компонент для работы с хранилищем отправляемых сообщений
 */
public interface SourceRepository {
    Deal fetchNext();
}
