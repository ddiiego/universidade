package universidade.universidade.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_sala")
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private String andar;
    private Integer capacidade;
    //@ManyToOne
    //@JoinColumn(name = "status_id")
    private StatusSala status;

    @JsonIgnore
    @OneToMany(mappedBy = "sala")
    //@JoinTable
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Sala(UUID id, String descricao, String andar, Integer capacidade, StatusSala status) {
        this.id = id;
        this.descricao = descricao;
        this.andar = andar;
        this.capacidade = capacidade;
        this.status = status;
    }
}
