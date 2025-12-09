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

    public ModelAdocao atualizarAdocao(ModelAdocao adocao, int id){
        ModelAdocao adocaoN = ProcurarAdocaoId(id);
        if(adocaoN != null){
            adocao.setStatusAdocao(adocaoN.getStatusAdocao());
            adocao.setMotivo_adotante(adocaoN.getMotivo_adotante());
            adocao.setOBSERVACOES(adocaoN.getOBSERVACOES());
            return repositoryAdocao.save(adocao);
        }
        return null;
    }

    public ModelAdocao deletarAdocao(int id){
        ModelAdocao adocao = ProcurarAdocaoId(id);
         repositoryAdocao.deleteById(id);
           return adocao;
        
    }

    public List<ModelAdocao> listarAdocoesPorAdotante(int idAdotante){
        List<ModelAdocao> adocoes = repositoryAdocao.findAllByAdotanteId(idAdotante);
        return adocoes;
        
    }
    public List<ModelAdocao> listarAdocoesPorDoador(int idDoador){
        List<ModelAdocao> adocoes = repositoryAdocao.findAllByDoadorId(idDoador);
        return adocoes;
        
    }

    public List<ModelAdocao> listarAdocoesPorPet(int idPet){
        List<ModelAdocao> adotante = repositoryAdocao.findByPetId(idPet);
        return adotante;
        
    }

}
