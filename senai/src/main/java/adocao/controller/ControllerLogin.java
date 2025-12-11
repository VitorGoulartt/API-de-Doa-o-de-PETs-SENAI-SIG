package adocao.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import adocao.dtos.AuthRequestDTO;
import adocao.service.ServiceLogin;


@RequestMapping("/api/auth")
@RestController
@CrossOrigin
public class ControllerLogin {

    @Autowired
    private ServiceLogin serviceLogin;

    @PostMapping("/login")
    public ResponseEntity<?>  authenticateUser(@RequestBody AuthRequestDTO request){
        String token = serviceLogin.login(request.getEmail(),  request.getSenha());
        if(token != null){
            return ResponseEntity.ok(token);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        

    }

}
