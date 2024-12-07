package com.adopteunrdv.service;

import com.adopteunrdv.model.Constraints;
import com.adopteunrdv.repository.ConstraintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstraintsService {

    @Autowired
    private ConstraintsRepository constraintsRepository;

    public Constraints save(Constraints constraints) {
        return constraintsRepository.save(constraints);
    }
}
