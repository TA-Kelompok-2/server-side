/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.History;
import id.co.mii.ta.ticketingserverside.model.dto.request.HistoryRequest;
import id.co.mii.ta.ticketingserverside.service.HistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Mac
 */
@RestController
@RequestMapping("/history")
public class HistoryController {

    private HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public ResponseEntity<List<History>> getAll() {
        return new ResponseEntity(historyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> getById(@PathVariable Long id) {
        return new ResponseEntity(historyService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<History> create(@RequestBody History history) {
        return new ResponseEntity(historyService.create(history), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<History> update(@PathVariable Long id, @RequestBody HistoryRequest history) {
        return new ResponseEntity(historyService.update(id, history), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<History> delete(@PathVariable Long id) {
        return new ResponseEntity(historyService.delete(id), HttpStatus.OK);

    }

}
