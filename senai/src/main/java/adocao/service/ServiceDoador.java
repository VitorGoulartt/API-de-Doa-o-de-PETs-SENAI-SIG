package adocao.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import adocao.dtos.DoadorDTO;
import adocao.mapper.mapperDoador;
import adocao.models.ModelDoador;
import adocao.models.ModelLogin;
import adocao.repository.RepositoryDoador;
import adocao.repository.RepositoryLogin;
import jakarta.transaction.Transactional;

@Service
public class ServiceDoador {
 

    @Autowired
    private RepositoryDoador repositoryDoador;
    @Autowired
    private RepositoryLogin repositoryLogin;

    @Autowired
    private mapperDoador mapper;

  
    

    public DoadorDTO buscarDoadorId(int id){
       Optional<ModelDoador> doador = repositoryDoador.findById(id);

       Optional<DoadorDTO> doadorDto = doador.map(mapper::toDto);
        return doadorDto.orElse(null);
    }

    @Transactional
    public ModelDoador registrarDoador(int IdLogin){
    ModelLogin login = repositoryLogin.findById(IdLogin).orElse(null);
        
    ModelDoador doador = new ModelDoador();
    doador.setFk_login(login);
    
    return repositoryDoador.save(doador);

    }
    public ModelDoador atualizarDoador(ModelDoador doador, int id){
        DoadorDTO doadorN = buscarDoadorId(id);
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

    public List<DoadorDTO> listarPetsDoados(int id){
        List<ModelDoador> pet = repositoryDoador.findPetsByDoador_Id(id);
        return pet.stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
    }

}
