/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.History;
import id.co.mii.ta.ticketingserverside.repository.HistoryRepository;
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
public class HistoryService {

   private HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> getAll() {
        return historyRepository.findAll();
    }

    public History getById(Long id) {
        return historyRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "History Not Found"));
    }

    public History create(History history) {
        return historyRepository.save(history);
    }

    public History update(Long id, History history) {
        getById(id);
        history.setId(id);
        return historyRepository.save(history);
    }

    public History delete(Long id) {
        History history = getById(id);
        historyRepository.delete(history);
        return history;
    }
}
