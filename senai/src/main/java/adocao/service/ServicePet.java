package adocao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adocao.enums.Disponibilidade;
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
        List<ModelPet> pet = repositoryPet.filtrarPets(especie, idade, porte, condicao);
        if(pet != null){
            return pet;
        }
        return null;
    }
    public ModelPet AtualizarPet(int id, ModelPet pet){
        Optional<ModelPet> pets = repositoryPet.findById(id);
        if(pets.isPresent()){
            ModelPet petNovo = pets.get();
            petNovo.setNome(pet.getNome());
           //petNovo.setEspecie(pet.getEspecie());
            petNovo.setRaca(pet.getRaca());
            petNovo.setIdade(pet.getIdade());
            petNovo.setPorte(pet.getPorte());
            petNovo.setDescricao(pet.getDescricao());
            petNovo.setVacinas(pet.getVacinas());
            petNovo.setDisponibilidade(pet.getDisponibilidade());
           
           
            return repositoryPet.save(petNovo);
        }

        return null;
    }
    public ModelPet AdotarPet(int id){
        Optional<ModelPet> pet = repositoryPet.findById(id);
        if(pet.isPresent()){
            ModelPet petAdotado = pet.get();
            petAdotado.setDisponibilidade(Disponibilidade.Adotado);

            return repositoryPet.save(petAdotado);
        }

        return null;

    }
    public ModelPet DeletarPet(int id) {
        Optional<ModelPet> pet = repositoryPet.findById(id);
        if(pet.isPresent()){
            
            repositoryPet.deleteById(id);
            return pet.get();
        }
        return null;
    
    }
    public List<ModelPet> ListarPetsDisponiveis(){
        List<ModelPet> pet = repositoryPet.findAllByDisponibilidade(Disponibilidade.Disponível);
        return pet;
        
    }
    public List<ModelPet> ListarPetsEsp(List<Integer> id){
        List<ModelPet> especie = repositoryPet.findAllById(id);
        return especie;
    }
        
        
        
    

}
