/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.Fasilitas;
import id.co.mii.ta.ticketingserverside.service.FasilitasService;
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
@RequestMapping("/fasilitas")
public class FasilitasController {
    
    private FasilitasService fasilitasService;

    @Autowired
    public FasilitasController(FasilitasService fasilitasService) {
        this.fasilitasService = fasilitasService;
    }
    
    @GetMapping
    public ResponseEntity<List<Fasilitas>> getAll() {
        return new ResponseEntity(fasilitasService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fasilitas> getById(@PathVariable Long id) {
        return new ResponseEntity(fasilitasService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Fasilitas> create(@RequestBody Fasilitas fasilitas) {
        return new ResponseEntity(fasilitasService.create(fasilitas), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fasilitas> update(@PathVariable("id") Long id, @RequestBody Fasilitas fasilitas) {
        return new ResponseEntity(fasilitasService.update(id, fasilitas), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fasilitas> delete(@PathVariable Long id) {
        return new ResponseEntity(fasilitasService.delete(id), HttpStatus.OK);
    }

}