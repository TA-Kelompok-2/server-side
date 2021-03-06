/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.Status;
import id.co.mii.ta.ticketingserverside.service.StatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.status;
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
@RequestMapping("/status")
public class StatusController {

    private StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @GetMapping
    public ResponseEntity<List<Status>> getAll() {
        return new ResponseEntity(statusService.getAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @GetMapping("/{id}")
    public ResponseEntity<Status> getById(@PathVariable Integer id) {
        return new ResponseEntity(statusService.getById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @PostMapping
    public ResponseEntity<Status> create(@RequestBody Status status) {
        return new ResponseEntity(statusService.create(status), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @PutMapping("/{id}")
    public ResponseEntity<Status> update(@PathVariable Integer id, @RequestBody Status status) {
        return new ResponseEntity(statusService.update(id, status), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Status> delete(@PathVariable Integer id) {
        return new ResponseEntity(statusService.delete(id), HttpStatus.OK);
    }

}
