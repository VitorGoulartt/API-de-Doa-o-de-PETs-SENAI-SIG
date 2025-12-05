package adocao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adocao.models.ModelPet;
import adocao.repository.RepositoryPet;

@Service
public class ServicePet {
    @Autowired
    private RepositoryPet repositoryPet;

    public ModelPet RegistrarPet(ModelPet pet){
        if(pet != null){
            return repositoryPet.save(pet);
        }
        return null;
    }
    public List<ModelPet> ListarPets(){
        List<ModelPet> pet = repositoryPet.findAll();
        return pet;
    }
    public List<ModelPet> ListarPetFiltro(String especie, Integer idade, String porte, String condicao){
        List<ModelPet> pet = repositoryPet.findByfiltro(especie, idade, porte, condicao);
        if(pet != null){
            return pet;
        }
        return null;
    }
    public ModelPet AtualizarPet(int id, ModelPet pet){
        Optional<ModelPet> pets = repositoryPet.findById(id);
        if(pets.isPresent()){
            ModelPet petNovo = pets.get();
            pets.setNome(petNovo.getNome);
            pets.setEspecie(petNovo.getEspecie);
            pets.setRaca(petNovo.getRaca);
            pets.setIdade(petNovo.getIdade);
            pets.setPorte(petNovo.getPorte);
            pets.setDescricao(petNovo.getDescricao);
            pets.setVacinas(petNovo.getVacinas);
            pets.setDisponivel(petNovo.getDisponivel);
           
           
            return repositoryPet.save(petNovo);
        }

        return null;
    }
    public ModelPet AdotarPet(int id){
        Optional<ModelPet> pet = repositoryPet.findById(id);
        if(pet.isPresent()){
            ModelPet petAdotado = pet.get();
            petAdotado.setDisponivel(false);

            return repositoryPet.save(petAdotado);
        }

        return null;

    }
    public void DeletarPet(int id){
        ModelPet pet = repositoryPet.findById(id);
        if(pet != null){
            
        }
        
        
    }

}
