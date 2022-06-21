/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.Ruang;
import id.co.mii.ta.ticketingserverside.repository.RuangRepository;
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
public class RuangService {
    
    RuangRepository ruangRepository;

    @Autowired
    public RuangService(RuangRepository ruangRepository) {
        this.ruangRepository = ruangRepository;
    }
    
    public List<Ruang> getAll() {
        return ruangRepository.findAll();
    }

    public Ruang getById(Long id) {
        return ruangRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruang not Found")
        );
    }

    public Ruang create(Ruang ruang) {

        if (ruangRepository.findById(ruang.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ruang already exist");
        }
        return ruangRepository.save(ruang);
    }

    public Ruang update(Long id, Ruang ruang) {
        ruang.setId(id);
        return ruangRepository.save(ruang);
    }

    public Ruang delete(Long id) {
        Ruang ruang = getById(id);
        ruangRepository.delete(ruang);
        return ruang;
    }

    public Ruang findRoleName(String name) throws Throwable {
        return ruangRepository.findByName(name).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruang name not found"));
    }

    
}
