package com.onlineJobPortal.controller;


import com.onlineJobPortal.dto.AuthenticationRequest;
import com.onlineJobPortal.dto.UserDto;
import com.onlineJobPortal.entity.User;
import com.onlineJobPortal.repo.UserRepo;
import com.onlineJobPortal.responce.GeneralResponse;
import com.onlineJobPortal.services.jwt.UserDetailsServiceImpl;
import com.onlineJobPortal.services.user.UserService;
import com.onlineJobPortal.utill.JwtUtil;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    @PostMapping({"/authenticate"})
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException, JSONException, ServletException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password", e);
        }
        catch (DisabledException disabledException){
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "User Is Not Activated");
            return;
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        User user = userRepo.findFirstByEmail(authenticationRequest.getUsername());


        final String jwt = jwtUtil.generateToken(userDetails);

        response.getWriter().write(new JSONObject()
                .put("userId", user.getId())
                .toString()
        );
        
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Access-Control-Allow-Headers", "Authorization, X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, X-Custom-header");
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
    }

    @PostMapping("/update")
    public GeneralResponse updateProfile(@ModelAttribute UserDto userDto) {
        GeneralResponse response = new GeneralResponse();
        try {
            return userService.updateUser(userDto);
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;
        }
    }

    @GetMapping("user/{userId}")
    public GeneralResponse updateProfile(@PathVariable Long userId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setStatus(HttpStatus.OK);
             response.setData(userService.getUser(userId));
            return response;
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;
        }
    }

}