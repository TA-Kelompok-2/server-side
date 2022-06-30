/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.repository;

import id.co.mii.ta.ticketingserverside.model.Request;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fathullah
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    // Diajukan
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=1")
    List<Request> findByStatusIdadmin();
    
    // Disetujui 
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=2")
    List<Request> findByStatusId();
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=6")
    List<Request> findByStatusIts();
    
    //Ditolak
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=3")
    List<Request> findByDTOA();
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=7")
    List<Request> findByDTOITS();
    
    // Selesai
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=5")
    List<Request> findByS();
    
    // fasilitas id 1
    @Query(value = "SELECT e FROM Request e WHERE e.fasilitasRuang.fasilitas.id=1")
    List<Request> findByPYT();
    @Query(value = "SELECT e FROM Request e WHERE e.fasilitasRuang.fasilitas.id=2")
    List<Request> findByKPT();
    @Query(value = "SELECT e FROM Request e WHERE e.fasilitasRuang.fasilitas.id=3")
    List<Request> findByAC();
    
}
