package adocao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import adocao.models.ModelDoador;
import adocao.models.ModelLogin;
import adocao.models.ModelPet;
import adocao.repository.RepositoryDoador;
import adocao.repository.RepositoryLogin;
import adocao.repository.RepositoryPet;
import jakarta.transaction.Transactional;

@Service
public class ServiceDoador {
    @Autowired
    private RepositoryPet repositoryPet;

    @Autowired
    private RepositoryDoador repositoryDoador;
    @Autowired
    private RepositoryLogin repositoryLogin;

    ServiceDoador(RepositoryPet repositoryPet) {
        this.repositoryPet = repositoryPet;
    }

    public ModelDoador buscarDoadorId(int id){
       Optional<ModelDoador> doador = repositoryDoador.findById(id);
        return doador.orElse(null);
    }

    @Transactional
    public ModelDoador registrarDoador(int IdLogin){
    ModelLogin login = repositoryLogin.findById(IdLogin).orElse(null);
        
    ModelDoador doador = new ModelDoador();
    doador.setFk_login(login);
    
    return repositoryDoador.save(doador);

    }
    public ModelDoador atualizarDoador(ModelDoador doador, int id){
        ModelDoador doadorN = buscarDoadorId(id);
        if(doadorN != null){
            doador.setNome(doadorN.getNome());
            doador.setCpf(doadorN.getCpf());
            doador.setTelefone(doadorN.getTelefone());
            doador.setEmail(doadorN.getEmail());
            doador.setDt_update(doadorN.getDt_update());
            return repositoryDoador.save(doador);
        }
        return null;
    }

    public List<ModelPet> listarPetsDoados(int id){
        List<ModelPet> pet = repositoryPet.findPetsByDoador_Id(id);
        return pet;
    }

}
