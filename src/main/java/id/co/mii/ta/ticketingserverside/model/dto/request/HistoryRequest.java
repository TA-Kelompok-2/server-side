/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.model.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author Mac
 */
@Data
public class HistoryRequest {

    String keterangan;
    String gambar;
    String date;
    Long employee;
    Long Status;
    Long fasilitasruang;
}
