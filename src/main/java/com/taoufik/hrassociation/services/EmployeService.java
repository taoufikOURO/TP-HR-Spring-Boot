package com.taoufik.hrassociation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taoufik.hrassociation.models.Employe;
import com.taoufik.hrassociation.repositories.EmployeRepository;

@Service
public class EmployeService implements IEmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).get();
    }

    @Override
    public Employe updateEmploye(Long id, Employe employe) {
        return employeRepository.findById(id)
        .map(employeData -> {
            employeData.setNom(employe.getNom());
            employeData.setPrenom(employe.getPrenom());
            employeData.setDnaissance(employe.getDnaissance());
            employeData.setSexe(employe.getSexe());
            return employeRepository.save(employeData);
        }).orElseThrow(()->new RuntimeException("Employe non trouvé"));
    }

    @Override
    public String deleteEmploye(Long id) {
        employeRepository.deleteById(id);
        return "Employe supprimé";
    }

}
