/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.dto.request.LoginRequest;
import id.co.mii.ta.ticketingserverside.model.dto.response.LoginResponse;
import id.co.mii.ta.ticketingserverside.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Fathullah
 */
@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

//    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity(loginService.login(loginRequest), HttpStatus.OK);
    }

}
