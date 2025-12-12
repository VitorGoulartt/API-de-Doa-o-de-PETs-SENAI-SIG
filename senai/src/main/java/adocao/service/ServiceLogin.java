package adocao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import adocao.models.ModelLogin;
import adocao.repository.RepositoryLogin;
import adocao.security.jwt.JwtUtil;

@Service
public class ServiceLogin {
    @Autowired
    private RepositoryLogin repositoryLogin;
    @Autowired
    private PasswordEncoder passowrdEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public String login(String email, String senha){
        ModelLogin login = repositoryLogin.findByEmail(email);

        if(login != null && passowrdEncoder.matches(senha, login.getSenha())){
            return jwtUtil.generateToken(email);

        } else{
            return null;
        }




        

    }

}
