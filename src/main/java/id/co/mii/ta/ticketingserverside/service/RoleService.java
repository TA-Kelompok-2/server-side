/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.Role;
import id.co.mii.ta.ticketingserverside.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Mac
 */
@Service
public class RoleService {

    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getById(Long id) {
        return roleRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not Found")
        );
    }

    public Role create(Role role) {

        // Buat user sekaligus bisa banyak role
        if (roleRepository.findById(role.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role already exist");
        }
        return roleRepository.save(role);
    }

    public Role update(Long id, Role role) {
        role.setId(id);
        return roleRepository.save(role);
    }

    public Role delete(Long id) {
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }

    public Role getRoleName(String name) {
        return roleRepository.getByName(name).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role name not found"));
    }

}
