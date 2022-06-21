/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.Request;
import id.co.mii.ta.ticketingserverside.repository.EmployeeRepository;
import id.co.mii.ta.ticketingserverside.repository.FasilitasRuangRepository;
import id.co.mii.ta.ticketingserverside.repository.HistoryRepository;
import id.co.mii.ta.ticketingserverside.repository.RequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Fathullah
 */
@Service
public class RequestService {
        
    private RequestRepository requestRepository;
//    private HistoryRepository historyRepository;
//    private EmployeeRepository employeeRepository;
//    private FasilitasRuangRepository fasilitasRuangRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAll() {
        return requestRepository.findAll();
    }
    
    public Request getById(Long id) {
        return requestRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Request Not Found"));
    }
    
    public Request create(Request request) {
         return requestRepository.save(request);
    }
    
     public Request update(Long id, Request role) {
        getById(id);
        role.setId(id);
        return requestRepository.save(role);
    }
     
     public Request delete(Long id) {
        Request role = getById(id);
        requestRepository.delete(role);
        return role;
    }
     
}
