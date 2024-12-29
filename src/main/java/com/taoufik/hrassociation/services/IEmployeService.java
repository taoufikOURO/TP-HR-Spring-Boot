package com.taoufik.hrassociation.services;

import java.util.List;

import com.taoufik.hrassociation.models.Employe;

public interface IEmployeService {
    public Employe createEmploye(Employe employe);
    public List<Employe> getAllEmployes();
    public Employe getEmployeById(Long id);
    public Employe updateEmploye (Long id, Employe employe);
    public String deleteEmploye(Long id);
}
