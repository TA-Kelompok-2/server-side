/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.Request;
import id.co.mii.ta.ticketingserverside.model.Role;
import id.co.mii.ta.ticketingserverside.service.RequestService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author Fathullah
 */

@RestController
@RequestMapping("/request")
public class RequestController {
    
    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }
    
    @GetMapping
    public ResponseEntity<List<Request>> getAll() {
        return new ResponseEntity(requestService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById(@PathVariable Long id) {
        return new ResponseEntity(requestService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Request> create(@RequestBody Request request) {
        return new ResponseEntity(requestService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable("id") Long id, @RequestBody Request request) {
        return new ResponseEntity(requestService.update(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Request> delete(@PathVariable Long id) {
        return new ResponseEntity(requestService.delete(id), HttpStatus.OK);
    }

}
