package ru.jirs.testprojects.androidserver.service;

import ru.jirs.testprojects.androidserver.entity.Remind;

import java.util.List;

/**
 * Created by irs on 13.08.16.
 */
public interface ReminderService {

    List<Remind> getAll();
    Remind getById(long id);
    Remind save(Remind remind);
    void remove(long id);
}
