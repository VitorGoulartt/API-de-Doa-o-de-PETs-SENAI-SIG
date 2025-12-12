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

import adocao.dtos.AdocaoDTO;
import adocao.models.ModelAdocao;
import adocao.service.ServiceAdocao;


@CrossOrigin
@RestController
@RequestMapping("/api/adocoes")
public class ControllerAdocaoPet {

    @Autowired
    private ServiceAdocao serviceAdocao;

    @PostMapping
    public ResponseEntity<ModelAdocao> fazerAdocao(@RequestBody ModelAdocao adocao){
        ModelAdocao adocaoPet = serviceAdocao.adotarPet(adocao);

        if(adocaoPet != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(adocao);
        }

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }
    

    @GetMapping("/listar")
    public ResponseEntity<List<AdocaoDTO>> listarAdocoes(){
        List<AdocaoDTO> adocao = serviceAdocao.listarAdocoes();
        return ResponseEntity.ok(adocao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdocaoDTO>  listarAdocaoId(@PathVariable int id){
        AdocaoDTO adocao = serviceAdocao.ProcurarAdocaoId(id);
        if(adocao != null){
            return ResponseEntity.ok(adocao);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelAdocao> atualizarAdocao(@RequestBody ModelAdocao adocao, @PathVariable int id){
        ModelAdocao adocaoAtualizada = serviceAdocao.atualizarAdocao(adocao, id);
        if(adocaoAtualizada != null){
            return ResponseEntity.ok(adocaoAtualizada); 
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarAdocao(@PathVariable int id){
        
        
            serviceAdocao.deletarAdocao(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        
    }

    @GetMapping("/doador/{idDoador}")
    public ResponseEntity<List<AdocaoDTO>> listarAdocoesPorDoador(@PathVariable int idDoador){
        // Agora chama corretamente: Service de Doador com ID de Doador
        List<AdocaoDTO> adocoes = serviceAdocao.listarAdocoesPorAdotante(idDoador);
        return ResponseEntity.ok(adocoes);
    }
    
    @GetMapping("/pet/{idPet}")
    public ResponseEntity<List<AdocaoDTO>> listarAdocoesPorPet(@PathVariable int idPet){
        List<AdocaoDTO> adocoes = serviceAdocao.listarAdocoesPorDoador(idPet);
        return ResponseEntity.ok(adocoes);
    }

    @GetMapping("/adotante/{idAdotante}")
    public ResponseEntity<List<AdocaoDTO>> listarAdocoesPorAdotante(@PathVariable int idAdotante){
        List<AdocaoDTO> adocoes = serviceAdocao.listarAdocoesPorPet(idAdotante);
        return ResponseEntity.ok(adocoes);  
    }




}
