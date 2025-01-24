package com.adopteunrdv.controller;

import com.adopteunrdv.model.AppUser;
import com.adopteunrdv.service.AppUserService;
import com.adopteunrdv.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class AccountController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ConfigService configService;

    @GetMapping("/account")
    public String account(Model model) {
        // Remplacez "currentUser" par le nom d'utilisateur actuel
        AppUser user = appUserService.findByUsername("currentUser");
        model.addAttribute("user", user);

        Map<String, Object> config = configService.getConfig();
        model.addAttribute("cssFile", config.get("cssFile"));
        model.addAttribute("logoFile", config.get("logoFile"));
        model.addAttribute("siteName", config.get("siteName"));

        return "account";
    }
}
