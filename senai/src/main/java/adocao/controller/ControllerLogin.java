package adocao.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import adocao.dtos.AuthRequestDTO;
import adocao.service.ServiceLogin;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RequestMapping("/api/auth")
@RestController
@CrossOrigin
public class ControllerLogin {

    @Autowired
    private ServiceLogin serviceLogin;

    @PostMapping("/login")
    public ResponseEntity<?>  authenticateUser(@RequestBody AuthRequestDTO request){
        try{
            String jwtToken = serviceLogin.login(request.getEmail(),  request.getSenha());
            return ResponseEntity.ok(jwtToken);
        } catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
