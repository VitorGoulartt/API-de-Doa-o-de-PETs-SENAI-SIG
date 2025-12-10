package adocao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import adocao.config.JwtUtil;
import adocao.repository.RepositoryLogin;

@Service
public class ServiceLogin {
    @Autowired
    private RepositoryLogin repositoryLogin;
    @Autowired
    private PasswordEncoder passowrdEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public String login(String email, String senha){
        User user = repositoryLogin.findByEmail(email);
        

    }

}
