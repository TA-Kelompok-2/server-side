/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.model.dto.request;

import lombok.Data;
/**
 *
 * @author Fathullah
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
