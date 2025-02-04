package com.taoufik.hrassociation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taoufik.hrassociation.models.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    
}
