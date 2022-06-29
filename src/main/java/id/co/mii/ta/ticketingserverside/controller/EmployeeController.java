/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.Employee;
import id.co.mii.ta.ticketingserverside.model.dto.request.EmployeeRequest;
import id.co.mii.ta.ticketingserverside.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mac
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN','ITSUPPORT','USER')")
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity(employeeService.getAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','ITSUPPORT','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Integer id) {
        return new ResponseEntity(employeeService.getById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','ITSUPPORT','USER')")
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeRequest employee) {
        return new ResponseEntity(employeeService.create(employee), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','ITSUPPORT','USER')")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody EmployeeRequest employee) {
        return new ResponseEntity(employeeService.update(id, employee), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','ITSUPPORT','USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Integer id) {
        return new ResponseEntity(employeeService.delete(id), HttpStatus.OK);
    }

}
