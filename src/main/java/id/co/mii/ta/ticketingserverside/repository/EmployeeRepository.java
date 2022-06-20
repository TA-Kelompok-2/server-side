/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.repository;

import id.co.mii.ta.ticketingserverside.model.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mac
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    Optional<Employee> findByFullname(String name);
//
//    List<Employee> findByFullnameContaining(String name);

}
