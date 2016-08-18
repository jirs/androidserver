package ru.jirs.testprojects.androidserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.jirs.testprojects.androidserver.entity.Remind;
import ru.jirs.testprojects.androidserver.service.ReminderService;

import java.util.List;

/**
 * Created by irs on 13.08.16.
 */
@RestController
@RequestMapping("/rest")
public class ReminderRestController {

    @Autowired
    private ReminderService reminderService;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getAllReminders() {
        return reminderService.getAll();
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminderById(@PathVariable("id") long id) {
        return reminderService.getById(id);
    }

    @RequestMapping(value = "/reminders", method = RequestMethod.POST)
    @ResponseBody
    public Remind saveReminder(@RequestBody Remind remind) {
        return reminderService.save(remind);
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void saveReminder(@PathVariable("id") long id) {
        reminderService.remove(id);
    }
}
