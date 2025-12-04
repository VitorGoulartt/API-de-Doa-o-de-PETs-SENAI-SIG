package adocao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import adocao.models.ModelAdocao;
import adocao.service.ServiceAdocao;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController("/api/adocoes")
@RequestMapping
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
    

    @GetMapping
    public ResponseEntity<List<ModelAdocao>> listarAdocoes(){
        List<ModelAdocao> adocao = serviceAdocao.listarAdocoes();
        return ResponseEntity.ok(adocao);
    }

    @GetMapping("/{id}")
    public Response


}
