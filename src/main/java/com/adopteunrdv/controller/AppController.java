package com.adopteunrdv.controller;

import com.adopteunrdv.model.AppUser;
import com.adopteunrdv.model.Appointment;
import com.adopteunrdv.model.Constraints;
import com.adopteunrdv.service.AppUserService;
import com.adopteunrdv.service.AppointmentService;
import com.adopteunrdv.service.ConfigService;
import com.adopteunrdv.service.ConstraintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ConstraintsService constraintsService;

    @Autowired
    private ConfigService configService;

    @GetMapping("/")
    public String home(Model model) {
        Map<String, Object> config = configService.getConfig();
        model.addAttribute("cssFile", config.get("cssFile"));
        model.addAttribute("logoFile", config.get("logoFile"));
        model.addAttribute("homeImage", config.get("homeImage"));
        model.addAttribute("homeTextKey", config.get("homeTextKey"));
        model.addAttribute("siteName", config.get("siteName"));
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(AppUser user) {
        appUserService.save(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(AppUser user, Model model) {
        AppUser existingUser = appUserService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", existingUser);
            return "redirect:/calendar";
        } else {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
            return "login";
        }
    }

    @GetMapping("/calendar")
    public String calendar(@RequestParam(required = false) LocalDate date, Model model) {
        if (date == null) {
            date = LocalDate.now();
        }
        List<Appointment> appointments = appointmentService.findByDate(date);
        model.addAttribute("date", date);
        model.addAttribute("appointments", appointments);

        Map<String, Object> config = configService.getConfig();
        model.addAttribute("cssFile", config.get("cssFile"));
        model.addAttribute("logoFile", config.get("logoFile"));
        model.addAttribute("siteName", config.get("siteName"));

        return "calendar";
    }

    @PostMapping("/book")
    public String bookAppointment(Appointment appointment, @RequestParam("date") String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        appointment.setDate(date);
        appointmentService.save(appointment);
        return "redirect:/calendar";
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        List<Appointment> appointments = appointmentService.findAll();
        model.addAttribute("appointments", appointments);

        Map<String, Object> config = configService.getConfig();
        model.addAttribute("cssFile", config.get("cssFile"));
        model.addAttribute("logoFile", config.get("logoFile"));
        model.addAttribute("siteName", config.get("siteName"));

        return "appointments";
    }

    @PostMapping("/appointments/delete")
    public String deleteAppointment(@RequestParam Long id) {
        appointmentService.delete(id);
        return "redirect:/appointments";
    }

    @PostMapping("/constraints")
    public String saveConstraints(Constraints constraints) {
        constraintsService.save(constraints);
        return "redirect:/calendar";
    }
}
