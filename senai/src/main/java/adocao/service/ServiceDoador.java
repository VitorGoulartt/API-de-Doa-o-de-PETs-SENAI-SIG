package adocao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import adocao.models.ModelDoador;
import adocao.models.ModelLogin;
import adocao.repository.RepositoryDoador;
import adocao.repository.RepositoryLogin;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ServiceDoador {

    @Autowired
    private RepositoryDoador repositoryDoador;
    @Autowired
    private RepositoryLogin repositoryLogin;

    public ModelDoador buscarDoadorId(int id){
       Optional<ModelDoador> doador = repositoryDoador.findById(id);
        return doador.orElse(null);
    }

    @Transactional
    public ModelDoador registrarDoador(int IdLogin){
         ModelLogin login = repositoryLogin.findById(IdLogin)
        .orElseThrow(() -> new EntityNotFoundException("Login não encontrado: " + IdLogin));

    ModelDoador doador = new ModelDoador();
    doador.setFk_login(login);
    
    return repositoryDoador.save(doador);

    }

}
