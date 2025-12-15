package adocao.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adocao.dtos.EspecieDTO;
import adocao.mapper.mapperEspecie;
import adocao.models.ModelEspecie;
import adocao.repository.RepositoryEspecie;

@Service
public class ServiceEspecie {
    @Autowired
    private RepositoryEspecie repositoryEspecie;

    @Autowired
    private mapperEspecie mapper;

    public List<EspecieDTO> listarEspecies(){
        List<ModelEspecie> especie = repositoryEspecie.findAll();

        return especie.stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
    }
    public EspecieDTO buscarEspecieId(int id){
        Optional<ModelEspecie> especie = repositoryEspecie.findById(id);

        Optional<EspecieDTO> especieDto = especie.map(mapper::toDto);
        return especieDto.orElse(null);
    }

    public ModelEspecie cadastrarEspecie(ModelEspecie especie){
         
        if(especie != null){
            return repositoryEspecie.save(especie);

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
