/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.Fasilitas;
import id.co.mii.ta.ticketingserverside.repository.FasilitasRepository;
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
public class FasilitasService {

    FasilitasRepository fasilitasRepository;

    @Autowired
    public FasilitasService(FasilitasRepository fasilitasRepository) {
        this.fasilitasRepository = fasilitasRepository;
    }

    public List<Fasilitas> getAll() {
        return fasilitasRepository.findAll();
    }

    public Fasilitas getById(Integer id) {
        return fasilitasRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fasilitas not Found")
        );
    }

    public Fasilitas create(Fasilitas fasilitas) {
        return fasilitasRepository.save(fasilitas);
    }

    public Fasilitas update(Integer id, Fasilitas fasilitas) {
        fasilitas.setId(id);
        return fasilitasRepository.save(fasilitas);
    }

    public Fasilitas delete(Integer id) {
        Fasilitas fasilitas = getById(id);
        fasilitasRepository.delete(fasilitas);
        return fasilitas;
    }

    public Fasilitas findRoleName(String name) throws Throwable {
        return fasilitasRepository.findByName(name).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fasilitas name not found"));
    }

}
