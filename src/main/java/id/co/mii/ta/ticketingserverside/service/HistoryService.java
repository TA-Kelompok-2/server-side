/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.History;
import id.co.mii.ta.ticketingserverside.model.dto.request.HistoryRequest;
import id.co.mii.ta.ticketingserverside.repository.HistoryRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Mac
 */
@Service
public class HistoryService {

    private HistoryRepository historyRepository;
    private ModelMapper modelMapper;
    private EmployeeService employeeService;
    private StatusService statusService;

    @Autowired
    public HistoryService(HistoryRepository historyRepository, ModelMapper modelMapper, EmployeeService employeeService, StatusService statusService) {
        this.historyRepository = historyRepository;
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.statusService = statusService;
    }

    public List<History> getAll() {
        return historyRepository.findAll();
    }

    public List<History> getByRequest(Integer id) {
        return historyRepository.findByRequestId(id);
    }

    public History getById(Integer id) {
        return historyRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "History Not Found"));
    }

    public History create(History history) {
        return historyRepository.save(history);
    }

    public History update(Integer id, HistoryRequest historyRequest) {
        History data = getById(id);

        History history = modelMapper.map(historyRequest, History.class);
        history.setEmployee(employeeService.getById(historyRequest.getEmployee()));
        history.setStatus(statusService.getById(historyRequest.getStatus()));
        history.setRequest(data.getRequest());
        //      history.setId(id);

        return historyRepository.save(history);
    }

    public History delete(Integer id) {
        History history = getById(id);
        historyRepository.delete(history);
        return history;
    }
}
