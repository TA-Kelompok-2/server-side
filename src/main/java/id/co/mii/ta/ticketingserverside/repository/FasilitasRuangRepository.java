/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.repository;

import id.co.mii.ta.ticketingserverside.model.FasilitasRuang;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fathullah
 */
@Repository
public interface FasilitasRuangRepository extends JpaRepository<FasilitasRuang, Integer> {
    
        // JPQL by Entity in CLASS
    @Query(value = "SELECT e FROM FasilitasRuang e WHERE e.ruang.id=?1")
    List<FasilitasRuang> findByRuang(Integer id);
    
}
