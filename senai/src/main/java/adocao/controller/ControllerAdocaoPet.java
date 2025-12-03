package adocao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import adocao.models.ModelPet;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/api/pets")
public class ControllerAdocaoPet {

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
        List<ModelPet> pets = servicePet.ListarPetsDisponiveis();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelPet> ListarPetFiltro(@RequestParam())

}
