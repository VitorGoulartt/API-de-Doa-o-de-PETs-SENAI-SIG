package adocao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adocao.models.ModelAdocao;
import adocao.repository.RepositoryAdocao;

@Service
public class ServiceAdocao {

    @Autowired
    private RepositoryAdocao repositoryAdocao;

    public ModelAdocao adotarPet(ModelAdocao pet){
        if( pet != null){
            return repositoryAdocao.save(pet);
        }

        return null;

    }

    public List<ModelAdocao> listarAdocoes(){
        List<ModelAdocao> adocao = repositoryAdocao.findAll();
        return adocao;
    }

    public ModelAdocao ProcurarAdocaoId(int id){
        Optional<ModelAdocao> adocao = repositoryAdocao.findById(id);

        return adocao.orElse(null);

    }

}
