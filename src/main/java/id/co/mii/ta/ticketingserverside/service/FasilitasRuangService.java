/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.FasilitasRuang;
import id.co.mii.ta.ticketingserverside.repository.FasilitasRuangRepository;
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
public class FasilitasRuangService {

    private FasilitasRuangRepository fasilitasRuangRepository;

    @Autowired
    public FasilitasRuangService(FasilitasRuangRepository fasilitasRuangRepository) {
        this.fasilitasRuangRepository = fasilitasRuangRepository;
    }

    public List<FasilitasRuang> getAll() {
        return fasilitasRuangRepository.findAll();
    }

    public FasilitasRuang getById(Integer id) {
        return fasilitasRuangRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status Not Found"));
    }

    public FasilitasRuang create(FasilitasRuang fasilitasRuang) {
        return fasilitasRuangRepository.save(fasilitasRuang);
    }

    public FasilitasRuang update(Integer id, FasilitasRuang fasilitasRuang) {
        getById(id);
        fasilitasRuang.setId(id);
        return fasilitasRuangRepository.save(fasilitasRuang);
    }

    public FasilitasRuang delete(Integer id) {
        FasilitasRuang fasilitasRuang = getById(id);
        fasilitasRuangRepository.delete(fasilitasRuang);
        return fasilitasRuang;
    }
}
