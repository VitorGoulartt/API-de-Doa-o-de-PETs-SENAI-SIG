package adocao.controller;

import java.security.Provider.Service;
import java.util.List;

import javax.security.auth.kerberos.ServicePermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import adocao.models.ModelPet;
import adocao.service.ServicePet;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
    public ResponseEntity<List<ModelPet>> ListarPets(){
        List<ModelPet> pets = servicePet.ListarPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/filtroPets")
    public ResponseEntity<List<ModelPet>> ListarPetFiltro(@RequestParam(required = false) String especie,
                                                          @RequestParam(required = false) Integer idade,
                                                          @RequestParam(required = false ) String porte,
                                                          @RequestParam(required = false) String condicao){

    List<ModelPet> pets = servicePet.ListarPetFiltro(especie, idade, porte, condicao);
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
    public ResponseEntity<Void> DeletarPet(@PathVariable int id){
        boolean deletado = servicePet.DeletarPet(id);
        if(deletado == true){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<ModelPet>> ListarPetsDisponiveis(){
        List<ModelPet> pets = servicePet.ListarPetsDisponiveis();
        return ResponseEntity.ok(pets);
    }

}
