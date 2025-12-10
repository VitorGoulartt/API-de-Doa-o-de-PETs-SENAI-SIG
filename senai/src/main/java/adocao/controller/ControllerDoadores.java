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

import adocao.models.ModelDoador;

import adocao.models.ModelPet;
import adocao.service.ServiceDoador;




@RestController
@RequestMapping("/api/doadores")
@CrossOrigin
public class ControllerDoadores {
    @Autowired
    private ServiceDoador serviceDoador;

    @GetMapping
    public ResponseEntity<List<ModelDoador>> listarDoadores(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDoador> buscaDoadorId(@PathVariable int id){
        ModelDoador doador = serviceDoador.buscarDoadorId(id);
        if(doador != null){
            return ResponseEntity.ok(doador);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping("/{IdLogin}")
    public ResponseEntity<ModelDoador> registrarDoador (@PathVariable int IdLogin){
        ModelDoador doador = serviceDoador.registrarDoador(IdLogin);
        if(doador != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(doador);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDoador> atualizarDoador(@RequestParam ModelDoador doador,  @PathVariable int id){
        ModelDoador doadores = serviceDoador.atualizarDoador(doador, id);
        if(doadores != null){
            return ResponseEntity.status(HttpStatus.OK).body(doadores);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDoador(@PathVariable int id){
        ModelDoador doador = serviceDoador.buscarDoadorId(id);
        if(doador != null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<List<ModelPet>> listarPetsDoados(@PathVariable int id){
        List<ModelPet> pets = serviceDoador.listarPetsDoados(id);
        
        if(pets != null ){
            return ResponseEntity.ok(pets);   
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
    }



}
