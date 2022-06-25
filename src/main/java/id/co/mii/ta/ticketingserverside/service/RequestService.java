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
import id.co.mii.ta.ticketingserverside.model.dto.request.RequestDTO;
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

    public Request getById(Integer id) {
        return requestRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Request Not Found"));
    }

    public Request create(RequestDTO requestDTO) {
        // Set Request
        Request request = modelMapper.map(requestDTO, Request.class);
        request.setEmployee(employeeService.getById(requestDTO.getEmployee()));
        request.setStatus(statusService.getById(requestDTO.getStatus()));
        request.setFasilitasRuang(fasilitasRuangService.getById(requestDTO.getFasilitasruang()));
        Request req = requestRepository.save(request);
        
        //Set History
        History history = new History();
        history.setDate(requestDTO.getDate());
        history.setEmployee(employeeService.getById(requestDTO.getEmployee()));
        history.setKeterangan(requestDTO.getKeterangan());
        history.setStatus(statusService.getById(requestDTO.getStatus()));
        history.setRequest(req);
        historyService.create(history);

        return req;
    }

    public Request delete(Integer id) {
        Request role = getById(id);
        requestRepository.delete(role);
        return role;
    }

}
