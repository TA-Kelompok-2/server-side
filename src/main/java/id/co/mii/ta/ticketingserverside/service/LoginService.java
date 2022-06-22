/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.ta.ticketingserverside.service;

import id.co.mii.ta.ticketingserverside.model.User;
import id.co.mii.ta.ticketingserverside.model.dto.request.LoginRequest;
import id.co.mii.ta.ticketingserverside.model.dto.response.LoginResponse;
import id.co.mii.ta.ticketingserverside.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fathullah
 */
@Service
@AllArgsConstructor
public class LoginService {
    private AuthenticationManager authenticationManager;
    private AppUserDetailService appUserDetailService;
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(auth);

        User user = userRepository.findByUsername(loginRequest.getUsername()).get();
        UserDetails userDetails = appUserDetailService.loadUserByUsername(loginRequest.getUsername());

        List<String> authorities = userDetails.getAuthorities()
                .stream().map(authority -> authority.getAuthority())
                .collect(Collectors.toList());

        return new LoginResponse(user.getEmployee().getName(),
                user.getUsername(),
                user.getEmployee().getEmail(),
                authorities);
    }
}
