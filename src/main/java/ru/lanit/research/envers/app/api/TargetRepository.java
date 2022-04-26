package ru.lanit.research.envers.app.api;

import ru.lanit.research.envers.domain.Party;

import java.util.List;

/**
 * Компонент для работы с хранилищем полученных сообщений
 */
public interface TargetRepository {
    void save(Party targetEntity);

    List<String> listAll();
}
