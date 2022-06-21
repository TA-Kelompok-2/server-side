/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.Ruang;
import id.co.mii.ta.ticketingserverside.service.RuangService;
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
 * @author Fathullah
 */
@RestController
@RequestMapping("/ruang")
public class RuangController {
    
    private RuangService ruangService;

    @Autowired
    public RuangController(RuangService ruangService) {
        this.ruangService = ruangService;
    }
    
    @GetMapping
    public ResponseEntity<List<Ruang>> getAll() {
        return new ResponseEntity(ruangService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruang> getById(@PathVariable Long id) {
        return new ResponseEntity(ruangService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ruang> create(@RequestBody Ruang ruang) {
        return new ResponseEntity(ruangService.create(ruang), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ruang> update(@PathVariable("id") Long id, @RequestBody Ruang ruang) {
        return new ResponseEntity(ruangService.update(id, ruang), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ruang> delete(@PathVariable Long id) {
        return new ResponseEntity(ruangService.delete(id), HttpStatus.OK);
    }

}