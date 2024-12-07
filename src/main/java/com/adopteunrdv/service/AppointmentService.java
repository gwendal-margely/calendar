package com.adopteunrdv.service;

import com.adopteunrdv.model.Appointment;
import com.adopteunrdv.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> findByDate(LocalDate date) {
        return appointmentRepository.findByDate(date);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
}