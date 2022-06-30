/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.controller;

import id.co.mii.ta.ticketingserverside.model.FasilitasRuang;
import id.co.mii.ta.ticketingserverside.model.dto.request.FasilitasDTO;
import id.co.mii.ta.ticketingserverside.service.FasilitasRuangService;
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
 * @author Mac
 */
@RestController
@RequestMapping("/fasilitasruang")
public class FasilitasRuangController {

    private FasilitasRuangService fasilitasRuangService;

    @Autowired
    public FasilitasRuangController(FasilitasRuangService fasilitasRuangService) {
        this.fasilitasRuangService = fasilitasRuangService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @GetMapping
    public ResponseEntity<List<FasilitasRuang>> getAll() {
        return new ResponseEntity(fasilitasRuangService.getAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @GetMapping("/{id}")
    public ResponseEntity<FasilitasRuang> getById(@PathVariable Integer id) {
        return new ResponseEntity(fasilitasRuangService.getById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @GetMapping("/ruang/{id}")
    public ResponseEntity<List<FasilitasRuang>> getByRuang(@PathVariable Integer id) {
        return new ResponseEntity(fasilitasRuangService.getByRuang(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @PostMapping
    public ResponseEntity<FasilitasRuang> create(@RequestBody FasilitasDTO fasilitasRuang) {
        return new ResponseEntity(fasilitasRuangService.create(fasilitasRuang), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @PutMapping("/{id}")
    public ResponseEntity<FasilitasRuang> update(@PathVariable Integer id, @RequestBody FasilitasRuang fasilitasRuang) {
        return new ResponseEntity(fasilitasRuangService.update(id, fasilitasRuang), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','ITSUPPORT')")
    @DeleteMapping("/{id}")
    public ResponseEntity<FasilitasRuang> delete(@PathVariable Integer id) {
        return new ResponseEntity(fasilitasRuangService.delete(id), HttpStatus.OK);

    }
}
