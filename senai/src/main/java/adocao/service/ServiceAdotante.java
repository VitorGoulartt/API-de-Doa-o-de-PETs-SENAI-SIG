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

    public ModelAdotante atualizarAdotante(ModelAdotante adotante, int id){
        Optional<ModelAdotante> adotanteId = repositoryAdotante.findById(id);
        if(adotanteId.isPresent()){
            ModelAdotante adotanteNovo = adotanteId.get();
            if(adotante.getNome() != null){
                adotanteNovo.setNome(adotante.getNome());
            }
            if(adotante.getEmail() != null){
                adotanteNovo.setNome(adotante.getEmail());
            }
            if(adotante.getTelefone() != null){
                adotanteNovo.setTelefone(adotante.getTelefone());
            }
            return repositoryAdotante.save(adotanteNovo);
        }
        return null;

    }

    public void deletarAdotante(int id){
        repositoryAdotante.deleteById(id);
        
    }

    public AdotanteDTO listarAdotantesId(int id){
        
        Optional<ModelAdotante> adotante = repositoryAdotante.findById(id);

        Optional<AdotanteDTO> adotanteDto = adotante.map(mapper::toDto);

        return adotanteDto.orElse(null);

    }
}
