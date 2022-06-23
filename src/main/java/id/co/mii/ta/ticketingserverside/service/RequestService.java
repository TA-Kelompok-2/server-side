/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.Employee;
import id.co.mii.ta.ticketingserverside.model.FasilitasRuang;
import id.co.mii.ta.ticketingserverside.model.History;
import id.co.mii.ta.ticketingserverside.model.Request;
import id.co.mii.ta.ticketingserverside.model.Status;
import id.co.mii.ta.ticketingserverside.model.dto.request.HistoryRequest;
import id.co.mii.ta.ticketingserverside.repository.EmployeeRepository;
import id.co.mii.ta.ticketingserverside.repository.FasilitasRuangRepository;
import id.co.mii.ta.ticketingserverside.repository.HistoryRepository;
import id.co.mii.ta.ticketingserverside.repository.RequestRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;
    private EmployeeService employeeService;
    private StatusService statusService;
    private HistoryService historyService;
    private FasilitasRuangService fasilitasRuangService;
//    private HistoryRepository historyRepository;
//    private EmployeeRepository employeeRepository;
//    private FasilitasRuangRepository fasilitasRuangRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository, ModelMapper modelMapper, EmployeeService employeeService, StatusService statusService, HistoryService historyService, FasilitasRuangService fasilitasRuangService) {
        this.requestRepository = requestRepository;
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.statusService = statusService;
        this.historyService = historyService;
        this.fasilitasRuangService = fasilitasRuangService;
    }

    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    public Request getById(Long id) {
        return requestRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Request Not Found"));
    }

    public Request create(HistoryRequest historyRequest) {
        // Set Request
        Request request = modelMapper.map(historyRequest, Request.class);
        request.setEmployee(employeeService.getById(historyRequest.getEmployee()));
        request.setStatus(statusService.getById(historyRequest.getStatus()));
        request.setFasilitasRuang(fasilitasRuangService.getById(historyRequest.getFasilitasRuang()));
        Request req = requestRepository.save(request);
        
        //Set History
        History history = new History();
        history.setDate(historyRequest.getDate());
        history.setEmployee(employeeService.getById(historyRequest.getEmployee()));
        history.setKeterangan(historyRequest.getKeterangan());
        history.setStatus(statusService.getById(historyRequest.getStatus()));
        history.setRequest(req);
        historyService.create(history);

        return req;
    }

    public Request delete(Long id) {
        Request role = getById(id);
        requestRepository.delete(role);
        return role;
    }

}
