package ru.jirs.testprojects.androidserver.controller;

import freemarker.ext.beans.MapModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by irs on 18.08.16.
 */
@Controller
public class Login {

    @RequestMapping("/login")
    public String Login() {
        return "login";
    }
}
