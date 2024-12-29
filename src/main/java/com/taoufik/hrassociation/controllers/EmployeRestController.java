package com.taoufik.hrassociation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taoufik.hrassociation.models.Employe;
import com.taoufik.hrassociation.services.EmployeService;

@RestController
@RequestMapping("/api/employes")
public class EmployeRestController {
    @Autowired
    private EmployeService employeService;

    @PostMapping("/create")
    public Employe create(@RequestBody Employe employe){
        return employeService.createEmploye(employe);
    }

    @GetMapping("/all")
    public List<Employe> getEmploye(){
        return employeService.getAllEmployes();
    }

    @PutMapping("/update/{id}")
    public Employe updateEmploye(@PathVariable Long id, @RequestBody Employe employe){
        return employeService.updateEmploye(id, employe);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable Long id){
        return employeService.deleteEmploye(id);
    }
}
