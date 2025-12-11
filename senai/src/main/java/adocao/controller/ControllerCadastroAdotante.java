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
import org.springframework.web.bind.annotation.RestController;

import adocao.models.ModelAdotante;
import adocao.service.ServiceAdotante;


@CrossOrigin
@RequestMapping("/api/adotantes")
@RestController
public class ControllerCadastroAdotante {

    @Autowired
    private ServiceAdotante serviceAdotante;

    @PostMapping
    public ResponseEntity<ModelAdotante> RegistrarAdotante(@RequestBody ModelAdotante adotante){
        ModelAdotante adotantes = serviceAdotante.registrarAdotante(adotante);
        if(adotantes != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(adotantes);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        
    }


    @GetMapping
    public ResponseEntity<List<ModelAdotante>> listarAdotantes(){
        List<ModelAdotante> adotantes = serviceAdotante.listarAdotantes();
        return ResponseEntity.ok(adotantes);


    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelAdotante> listarAdotantesId(@PathVariable int id){
        ModelAdotante adotantes = serviceAdotante.listarAdotantesId(id);
        return ResponseEntity.ok(adotantes);
    }

    @PutMapping
    public ResponseEntity<ModelAdotante> atualizarAdotante(@RequestBody ModelAdotante adotante){
        ModelAdotante adotantes = serviceAdotante.registrarAdotante(adotante);
        if(adotantes != null){
            return ResponseEntity.status(HttpStatus.OK).body(adotantes);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        
    }               

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdotante(@PathVariable int id){
        ModelAdotante adotante = serviceAdotante.listarAdotantesId(id);
        if(adotante != null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
