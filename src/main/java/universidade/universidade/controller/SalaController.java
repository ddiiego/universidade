package universidade.universidade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidade.universidade.entity.Sala;
import universidade.universidade.service.SalaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/sala")
public class SalaController {
    @Autowired
    private SalaService service;

    @PostMapping
    public ResponseEntity<Sala> criar(@RequestBody Sala obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable UUID id){
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Sala>> bucarTodos(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Sala> atualizar(@PathVariable UUID id, @RequestBody Sala obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.atualizar(obj));
    }
}
