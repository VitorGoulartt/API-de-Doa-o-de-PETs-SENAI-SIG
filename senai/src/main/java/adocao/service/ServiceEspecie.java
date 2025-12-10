package adocao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adocao.models.ModelEspecie;
import adocao.repository.RepositoryEspecie;

@Service
public class ServiceEspecie {
    @Autowired
    private RepositoryEspecie repositoryEspecie;

    public List<ModelEspecie> listarEspecies(){
        List<ModelEspecie> especie = repositoryEspecie.findAll();

        return especie;
    }
    public ModelEspecie buscarEspecieId(int id){
        Optional<ModelEspecie> especie = repositoryEspecie.findById(id);
        return especie.orElse(null);
    }

    public ModelEspecie cadastrarEspecie(ModelEspecie especie){
        ModelEspecie especieN = repositoryEspecie.save(especie);
        if(especie != null){
            return especieN;

        }
        return null;
        
    }

    public ModelEspecie atualizarEspecie(ModelEspecie especie, int id){
        Optional<ModelEspecie> especieN = repositoryEspecie.findById(id);
        if( especieN.isPresent()){
            ModelEspecie especieNo =especieN.get();
            especieNo.setNome_especie(especie.getNome_especie());
            return repositoryEspecie.save(especieNo);
        
        }
        return null;
    }

    public void deletarEspecie(int id){
        repositoryEspecie.deleteById(id);
    }


}
