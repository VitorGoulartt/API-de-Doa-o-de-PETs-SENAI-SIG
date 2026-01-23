package adocao.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import adocao.dtos.PetDTO;
import adocao.enums.Porte;
import adocao.enums.Sexo;
import adocao.models.ModelPet;
import adocao.service.ServicePet;


@CrossOrigin
@RestController
@RequestMapping("/api/pets")
public class ControllerCadastroPe {

    @Autowired
    private ServicePet servicePet;

    

    @PostMapping
    public ResponseEntity<ModelPet> RegistrarPet(@RequestBody ModelPet pet){
        ModelPet pets = servicePet.RegistrarPet(pet);
        if(pets != null){
            

            return ResponseEntity.status(HttpStatus.CREATED).body(pets);

        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();

        

    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> ListarPets(){
        List<PetDTO> pets = servicePet.ListarPets();
        return ResponseEntity.ok(pets); 
    }

    @GetMapping("/filtro")  
    public ResponseEntity<List<PetDTO>> ListarPetFiltro(@RequestParam(required = false) String cor,
                                                          @RequestParam(required = false) Sexo sexo,
                                                          @RequestParam(required = false ) Porte porte,
                                                          @RequestParam(required = false) String vacinado){
    
                                      

    List<PetDTO> pets = servicePet.ListarPetFiltro(cor, sexo, porte, vacinado);
    return ResponseEntity.ok(pets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelPet> AtualizarPet(@PathVariable int id,@RequestBody ModelPet pet){
        ModelPet pets = servicePet.AtualizarPet(id, pet);
        if(pets != null){
            return ResponseEntity.ok(pets);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @PutMapping("/{id}/adotar")
    public ResponseEntity<ModelPet> AdotarPet(@PathVariable int id){
        ModelPet pets = servicePet.AdotarPet(id);
        if(pets != null){
            return ResponseEntity.ok(pets);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelPet> DeletarPet(@PathVariable int id){
        ModelPet deletado = servicePet.DeletarPet(id);
        if(deletado != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<PetDTO>> ListarPetsDisponiveis(){
        List<PetDTO> pets = servicePet.ListarPetsDisponiveis();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/especie/{IdEspecie}")
    public ResponseEntity<List<PetDTO>> ListaPetsEsp(@PathVariable List<Integer> IdEspecie ){
        List<PetDTO> Especie = servicePet.ListarPetsEsp(IdEspecie);
        return ResponseEntity.ok(Especie);
    }
    

}
