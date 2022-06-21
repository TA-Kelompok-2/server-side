/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.Status;
import id.co.mii.ta.ticketingserverside.repository.StatusRepository;
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
public class StatusService {

    private StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    public Status getById(Long id) {
        return statusRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status Not Found"));
    }

    public Status create(Status status) {
        return statusRepository.save(status);
    }

    public Status update(Long id, Status status) {
        getById(id);
        status.setId(id);
        return statusRepository.save(status);
    }

    public Status delete(Long id) {
        Status status = getById(id);
        statusRepository.delete(status);
        return status;
    }

}
