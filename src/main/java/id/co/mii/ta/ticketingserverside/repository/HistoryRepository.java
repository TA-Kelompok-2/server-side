/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.repository;

import id.co.mii.ta.ticketingserverside.model.History;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fathullah
 */
@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

    // JPQL by Entity in CLASS
    @Query(value = "SELECT e FROM History e WHERE e.request.id=?1")
    List<History> findByRequestId(Integer id);
}
