package universidade.universidade.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universidade.universidade.entity.Agendamento;
import universidade.universidade.repository.AgendamentoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository repository;

    @Transactional
    public Agendamento criar(Agendamento obj){
        return repository.save(obj);
    }

    public void excluir(UUID id){
        repository.deleteById(id);
    }

    public Agendamento buscarPorId(UUID id){
        Optional<Agendamento> obj = repository.findById(id);
        return obj.get();
    }

    public List<Agendamento> buscarTodos(){
        return repository.findAll();
    }

    public Agendamento atualizar(Agendamento obj){
        Optional<Agendamento> newObj = repository.findById(obj.getId());
        atualizarAgendamento(newObj, obj);
        return repository.save(newObj.get());
    }
    private void atualizarAgendamento(Optional<Agendamento> newObj, Agendamento obj){
        newObj.get().setDescricao(obj.getDescricao());
        newObj.get().setSala(obj.getSala());
    }
}
