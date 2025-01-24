package com.adopteunrdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class LanguageController {

    @Autowired
    private HttpSession session;

    @GetMapping("/changeLanguage")
    public String changeLanguage(@RequestParam("lang") String lang) {
        Locale locale = new Locale(lang);
        session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", locale);
        LocaleContextHolder.setLocale(locale);
        return "redirect:/";
    }
}
