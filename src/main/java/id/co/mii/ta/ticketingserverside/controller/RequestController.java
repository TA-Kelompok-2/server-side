/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.Request;
import id.co.mii.ta.ticketingserverside.model.dto.request.HistoryRequest;
import id.co.mii.ta.ticketingserverside.model.dto.request.RequestDTO;
import id.co.mii.ta.ticketingserverside.service.RequestService;
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
 * @author Fathullah
 */
@RestController
@RequestMapping("/request")
//@PreAuthorize("hasAnyRole('ADMIN','ITSUPPORT')")
public class RequestController {

    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ResponseEntity<List<Request>> getAll() {
        return new ResponseEntity(requestService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById(@PathVariable Integer id) {
        return new ResponseEntity(requestService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Request> create(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity(requestService.create(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable("id") Integer id, @RequestBody RequestDTO requestDTO) {
        return new ResponseEntity(requestService.update(id, requestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Request> delete(@PathVariable Integer id) {
        return new ResponseEntity(requestService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/approved")
    public ResponseEntity<List<Request>> getByApproval() {
        return new ResponseEntity(requestService.getByApproved(), HttpStatus.OK);
    }

    @GetMapping("/approvedadmin")
    public ResponseEntity<List<Request>> getByApprovaladmin() {
        return new ResponseEntity(requestService.getByApprovedadmin(), HttpStatus.OK);
    }

    @GetMapping("/approvedits")
    public ResponseEntity<List<Request>> getByApprovalIts() {
        return new ResponseEntity(requestService.getByApprovedIts(), HttpStatus.OK);
    }

    @GetMapping("/approvedDTOA")
    public ResponseEntity<List<Request>> getByDTOA() {
        return new ResponseEntity(requestService.getByDTOA(), HttpStatus.OK);
    }

    @GetMapping("/approvedDTOITS")
    public ResponseEntity<List<Request>> getByDTOITS() {
        return new ResponseEntity(requestService.getByDTOITS(), HttpStatus.OK);
    }

    @GetMapping("/approvedS")
    public ResponseEntity<List<Request>> getByS() {
        return new ResponseEntity(requestService.getByS(), HttpStatus.OK);
    }

    @GetMapping("/approvedPYT")
    public ResponseEntity<List<Request>> getByPYT() {
        return new ResponseEntity(requestService.getByPYT(), HttpStatus.OK);
    }

    @GetMapping("/approvedKPT")
    public ResponseEntity<List<Request>> getByKPT() {
        return new ResponseEntity(requestService.getByKPT(), HttpStatus.OK);
    }

    @GetMapping("/approvedAC")
    public ResponseEntity<List<Request>> getByAC() {
        return new ResponseEntity(requestService.getByAC(), HttpStatus.OK);
    }
}
