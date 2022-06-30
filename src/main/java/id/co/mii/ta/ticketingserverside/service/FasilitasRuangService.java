/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.FasilitasRuang;
import id.co.mii.ta.ticketingserverside.model.dto.request.FasilitasDTO;
import id.co.mii.ta.ticketingserverside.repository.FasilitasRuangRepository;
import java.util.List;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class FasilitasRuangService {

    private FasilitasRuangRepository fasilitasRuangRepository;
    private ModelMapper modelMapper;
    private FasilitasService fasilitasService;
    private RuangService ruangService;

    public List<FasilitasRuang> getAll() {
        return fasilitasRuangRepository.findAll();
    }

    public FasilitasRuang getById(Integer id) {
        return fasilitasRuangRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status Not Found"));
    }

    public List<FasilitasRuang> getByRuang(Integer id) {
        return fasilitasRuangRepository.findByRuang(id);
    }

    public FasilitasRuang create(FasilitasDTO fasilitasDTO) {
        FasilitasRuang fasilitasRuang = modelMapper.map(fasilitasDTO, FasilitasRuang.class);
        fasilitasRuang.setRuang(ruangService.getById(fasilitasDTO.getRuang()));
        fasilitasRuang.setFasilitas(fasilitasService.getById(fasilitasDTO.getFasilitas()));
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
