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
import id.co.mii.ta.ticketingserverside.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Fathullah
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }    

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist"));
    }

    public User create(EmployeeRequest employeeRequest) {
        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        User user = modelMapper.map(employeeRequest, User.class);
        user.setPassword(passwordEncoder.encode(employeeRequest.getPassword()));
        
        List<Role> role = new ArrayList<>();// penampung role -> dibuat karena tdak ada di dto
        
        role.add(roleService.getById(employeeRequest.getRoles()));
        user.setRoles(role);
                
        employee.setUser(user);
        user.setEmployee(employee);
        userRepository.save((user));
        
        return user;
    }

    public User update(Long id, EmployeeRequest employeeRequest) {
        User data = getById(id);
        User user = modelMapper.map(employeeRequest, User.class);

        user.setEmployee(data.getEmployee());
        user.setRoles(data.getRoles());
        user.setId(id);

        return userRepository.save(user);
    }

    public User delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }

}
