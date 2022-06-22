/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.model.dto.request;

import java.time.LocalDateTime;
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
public class HistoryRequest {

    private String keterangan;
    private String gambar;
    private LocalDateTime date = LocalDateTime.now();
    private Long employee;
    private Long status;
    private Long fasilitasRuang;
}
