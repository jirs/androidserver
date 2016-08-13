package ru.jirs.testprojects.androidserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by irs on 13.08.16.
 */
@Controller
@RequestMapping("/reminder")
public class ReminderController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getReminder(ModelMap model) {
        return "Any text here.";
    }
}
