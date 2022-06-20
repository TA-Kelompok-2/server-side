/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Mac
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_fasilitas_ruang")
public class FasilitasRuang {
    
    @Id
    Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_fasilitas")
    Fasilitas fasilitas;

    @ManyToOne
    @JoinColumn(name = "id_ruang")
    Ruang ruang;
}
