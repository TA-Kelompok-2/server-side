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

    // JPQL by Entity in CLASS
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=2")
    List<Request> findByStatusId();
    // JPQL by Entity in CLASS
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=1")
    List<Request> findByStatusIdadmin();
    
        // JPQL by Entity in CLASS
    @Query(value = "SELECT e FROM Request e WHERE e.status.id=6")
    List<Request> findByStatusIts();

}
