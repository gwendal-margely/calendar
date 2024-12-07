package com.adopteunrdv.repository;

import com.adopteunrdv.model.Constraints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstraintsRepository extends JpaRepository<Constraints, Long> {
}