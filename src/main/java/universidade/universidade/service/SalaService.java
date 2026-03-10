package universidade.universidade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universidade.universidade.entity.Sala;
import universidade.universidade.repository.SalaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SalaService {
   @Autowired
    private SalaRepository repository;
    /*
    public Sala criar(Sala obj){
        return repository.save(obj);
    }

    public void excluir(UUID id){
        repository.deleteById(id);
    }
    */
    public Sala buscarPorId(UUID id){
        Optional<Sala> obj = repository.findById(id);
        return obj.get();
    }

    public List<Sala> buscarTodos(){
        return repository.findAll();
    }
    /*
    public Sala atualizar(Sala obj){
        Optional<Sala> newObj = repository.findById(obj.getId());
        atualizarSala(newObj, obj);
        return repository.save(newObj.get());
    }
    private void atualizarSala(Optional<Sala> newObj, Sala obj){
        newObj.get().setDescricao(obj.getDescricao());
    }

  */
}
