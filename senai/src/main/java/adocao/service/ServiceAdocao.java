package adocao.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adocao.dtos.AdocaoDTO;
import adocao.mapper.mapperAdocao;
import adocao.models.ModelAdocao;

import adocao.repository.RepositoryAdocao;



@Service
public class ServiceAdocao {

    @Autowired
    private RepositoryAdocao repositoryAdocao;

    @Autowired
    private mapperAdocao mapper;

    

    

    public ModelAdocao adotarPet(ModelAdocao pet){
        if( pet != null){
            return repositoryAdocao.save(pet);
        }

        return null;

    }

    public List<AdocaoDTO> listarAdocoes(){
        List<ModelAdocao> adocao = repositoryAdocao.findAll();
        return adocao.stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
    }

    public AdocaoDTO ProcurarAdocaoId(int id){
        Optional<ModelAdocao> adocao = repositoryAdocao.findById(id);

        Optional<AdocaoDTO> adocaoDto = adocao.map(mapper::toDto);

        return adocaoDto.orElse(null);

    }

    public ModelAdocao atualizarAdocao(ModelAdocao adocao, int id){
        Optional<ModelAdocao> adocaoN = repositoryAdocao.findById(id);
        if(adocaoN.isPresent()){
            ModelAdocao adocaoD = adocaoN.get();
            adocao.setStatusAdocao(adocaoD.getStatusAdocao());
            adocao.setMotivo_adotante(adocaoD.getMotivo_adotante());
            adocao.setOBSERVACOES(adocaoD.getOBSERVACOES());
            return repositoryAdocao.save(adocao);
        }
        return null;
    }

    public ModelAdocao deletarAdocao(int id){
        Optional<ModelAdocao> adocao = repositoryAdocao.findById(id);
         repositoryAdocao.deleteById(id);
           return adocao.orElse(null);
        
    }

    public List<AdocaoDTO> listarAdocoesPorAdotante(int idAdotante){
        List<ModelAdocao> adocoes = repositoryAdocao.findAllByAdotante_Id(idAdotante);
        return adocoes.stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
        
    }
    public List<AdocaoDTO> listarAdocoesPorDoador(int idDoador){
        List<ModelAdocao> adocoes = repositoryAdocao.findAllByDoadorId(idDoador);
        return adocoes.stream()
        .map(mapper::toDto)
        .collect(Collectors.toList()); 
        
    }

    public List<AdocaoDTO> listarAdocoesPorPet(int idPet){
        List<ModelAdocao> adotante = repositoryAdocao.findAllByPet_Id(idPet);
        return adotante.stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
        
    }
    

}
