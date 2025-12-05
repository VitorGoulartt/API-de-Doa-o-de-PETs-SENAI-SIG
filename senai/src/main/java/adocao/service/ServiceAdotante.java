package adocao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adocao.models.ModelAdotante;
import adocao.repository.RepositoryAdotante;

@Service
public class ServiceAdotante {
    @Autowired
    private RepositoryAdotante repositoryAdotante;

    public ModelAdotante registrarAdotante(ModelAdotante adotante){
        if(adotante != null){
            return repositoryAdotante.save(adotante);
        }
        return null;
    }

    public List<ModelAdotante> listarAdotantes(){
        List<ModelAdotante> adotante = repositoryAdotante.findAll();

        return adotante;
    }

    public ModelAdotante listarAdotantesId(int id){
        
        Optional<ModelAdotante> adotante = repositoryAdotante.findById(id);

        return adotante.orElse(null);

    }
}
