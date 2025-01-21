package com.adopteunrdv.controller;

import com.adopteunrdv.model.Appointment;
import com.adopteunrdv.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class AppointmentRestController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/todayslist/{date}")
    public List<Appointment> getTodaysList(@PathVariable String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return appointmentService.findByDate(localDate);
    }

    @GetMapping("/myappointments/{name}")
    public List<Appointment> getMyAppointments(@PathVariable String name) {
        // Implement the logic to get appointments by user name
        return appointmentService.findAll(); // Placeholder
    }
}