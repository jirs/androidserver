package ru.jirs.testprojects.androidserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.jirs.testprojects.androidserver.entity.Remind;
import ru.jirs.testprojects.androidserver.service.ReminderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by irs on 13.08.16.
 */
@Controller
//@RequestMapping("/reminder")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    public String getAllReminders(ModelMap model) {
        List<Remind> reminds = reminderService.getAll();
        model.addAttribute("reminders", reminds);
        //System.out.println(reminds);
        return "reminders";
    }

    @RequestMapping(value = "/reminder/{id}", method = RequestMethod.GET)
    public String getReminderById(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("reminder", reminderService.getById(id));
        return "reminder";
    }


    @RequestMapping(value = "/reminder/edit/{id}", method = RequestMethod.GET)
    public String getEditReminderById(@PathVariable("id") long id, ModelMap model) {

        Remind remind = reminderService.getById(id);
        if (remind == null) {
            return "redirect:/reminders";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        model.addAttribute("date", dateFormat.format( remind.getRemindDate()));

        model.addAttribute("reminder", remind);
        return "reminder_edit";
    }

    @RequestMapping(value = "/reminder/add", method = RequestMethod.GET)
    public String addReminder(ModelMap model) {

        Remind remind = new Remind();
        remind.setRemindDate(new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        model.addAttribute("date", dateFormat.format( remind.getRemindDate()));

        model.addAttribute("reminder", remind);
        return "reminder_edit";
    }


    @RequestMapping(value = "/reminder/edit", method = RequestMethod.POST)
    public ModelAndView saveReminder(@ModelAttribute("remind") Remind remind, BindingResult result, ModelMap model) {
        System.out.println(remind);
        Remind savedRemind = reminderService.save(remind);

//        model.addAttribute("reminder", savedRemind);
        String redirectUrl = "/reminder/edit/" + savedRemind.getId();
        return new ModelAndView("redirect:" + redirectUrl);
    }


    @RequestMapping(value = "/reminder/delete", method = RequestMethod.POST)
    public ModelAndView removeReminder(@ModelAttribute("remind") Remind remind, BindingResult result, ModelMap model) {
        reminderService.remove(remind.getId());
        String redirectUrl = "/reminders";
        return new ModelAndView("redirect:" + redirectUrl);
    }

}
