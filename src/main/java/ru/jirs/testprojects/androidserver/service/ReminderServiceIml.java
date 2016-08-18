package ru.jirs.testprojects.androidserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.jirs.testprojects.androidserver.entity.Remind;
import ru.jirs.testprojects.androidserver.repository.RemindRepository;

import java.util.List;

/**
 * Created by irs on 13.08.16.
 */
@Service
public class ReminderServiceIml implements ReminderService {

    @Autowired
    private RemindRepository remindRepository;

    public List<Remind> getAll() {
        return remindRepository.findAll(sortByIdAsc());
    }

    public Remind getById(long id) {
        return remindRepository.findOne(id);
    }

    public Remind save(Remind remind) {
        return remindRepository.saveAndFlush(remind);
    }

    public void remove(long id) {
        remindRepository.delete(id);
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
}
