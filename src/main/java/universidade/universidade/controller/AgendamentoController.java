package universidade.universidade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidade.universidade.entity.Agendamento;
import universidade.universidade.service.AgendamentoService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable UUID id){
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> bucarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos()); //2
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable UUID id, @RequestBody Agendamento obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.atualizar(obj));
    }
}
