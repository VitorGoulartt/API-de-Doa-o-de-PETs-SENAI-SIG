package adocao.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adocao.dtos.AdotanteDTO;
import adocao.mapper.mapperAdotante;
import adocao.models.ModelAdotante;
import adocao.repository.RepositoryAdotante;

@Service
public class ServiceAdotante {
    @Autowired
    private RepositoryAdotante repositoryAdotante;
    @Autowired
    private mapperAdotante mapper;

    public ModelAdotante registrarAdotante(ModelAdotante adotante){
        if(adotante != null){
            return repositoryAdotante.save(adotante);
        }
        return null;
    }

    public List<AdotanteDTO> listarAdotantes(){
        List<ModelAdotante> adotante = repositoryAdotante.findAll();

        return adotante.stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
    }

    public AdotanteDTO listarAdotantesId(int id){
        
        Optional<ModelAdotante> adotante = repositoryAdotante.findById(id);

        Optional<AdotanteDTO> adotanteDto = adotante.map(mapper::toDto);

        return adotanteDto.orElse(null);

    }
}
