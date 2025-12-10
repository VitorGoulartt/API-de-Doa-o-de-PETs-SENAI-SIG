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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import adocao.models.ModelEspecie;
import adocao.service.ServiceEspecie;

@RestController
@RequestMapping("/api/especies")
@CrossOrigin
public class ControllerEspecies {
    @Autowired 
    private ServiceEspecie serviceEspecie;

    @GetMapping
    public ResponseEntity<List<ModelEspecie>> listarEspecies(){
        List<ModelEspecie> especie = serviceEspecie.listarEspecies();

        return ResponseEntity.ok(especie);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelEspecie> buscarEspecieId(@PathVariable int id){
        ModelEspecie especie = serviceEspecie.buscarEspecieId(id);
        if(especie != null){
            return ResponseEntity.ok(especie);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<ModelEspecie> cadastrarEspecie(@RequestParam ModelEspecie especie){
        ModelEspecie especieCadastrada = serviceEspecie.cadastrarEspecie(especie);
        if(especieCadastrada != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(especieCadastrada);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelEspecie> atualizarEspecie (@RequestParam ModelEspecie especie, @PathVariable int id){
        ModelEspecie especieAtualizada = serviceEspecie.atualizarEspecie(especie, id);
        if(especieAtualizada != null){
            return ResponseEntity.ok(especieAtualizada);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEspecie(@PathVariable int id){
        ModelEspecie especie = serviceEspecie.buscarEspecieId(id);
        if(especie != null){
            serviceEspecie.deletarEspecie(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    
}
