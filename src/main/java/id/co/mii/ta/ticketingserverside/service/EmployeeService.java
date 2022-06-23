/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.Employee;
import id.co.mii.ta.ticketingserverside.model.Role;
import id.co.mii.ta.ticketingserverside.model.User;
import id.co.mii.ta.ticketingserverside.model.dto.request.EmployeeRequest;
import id.co.mii.ta.ticketingserverside.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Mac
 */
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private RoleService roleService;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper, RoleService roleService, UserService userService, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee does not exist"));
    }

    public Employee create(EmployeeRequest employeeRequest) {
        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        User user = modelMapper.map(employeeRequest, User.class);
        user.setPassword(passwordEncoder.encode(employeeRequest.getPassword()));

        List<Role> role = new ArrayList<>();
        role.add(roleService.getById(1L));
//        role.add(roleService.getById(employeeRequest.getRoles()));

        user.setEmployee(employee);
        user.setRoles(role);
        employee.setUser(user);

        return employeeRepository.save(employee);
    }

    public Employee update(Long id, EmployeeRequest employeeRequest) {
        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        User user = modelMapper.map(employeeRequest, User.class);
        employee.setId(id);
        user.setId(id);

        user.setEmployee(employee);
        employee.setUser(user);
        return employeeRepository.save(employee);
    }

    public Employee delete(Long id) {

        Employee employee = getById(id);
        employeeRepository.delete(employee);
        userService.delete(id);
        return employee;
    }

}
