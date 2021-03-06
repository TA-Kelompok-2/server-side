/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.User;
import id.co.mii.ta.ticketingserverside.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fathullah
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @GetMapping("/{username}")
    public ResponseEntity<User> getIdByUsername(@PathVariable String username) {
        return new ResponseEntity(userService.getIdByUsername(username), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }

}
