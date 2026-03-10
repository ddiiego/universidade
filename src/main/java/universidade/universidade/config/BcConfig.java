package universidade.universidade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import universidade.universidade.entity.Agendamento;
import universidade.universidade.entity.Sala;
import universidade.universidade.entity.StatusSala;
import universidade.universidade.repository.AgendamentoRepository;
import universidade.universidade.repository.SalaRepository;

import java.util.Arrays;

@Configuration
@Profile("teste")
public class BcConfig implements CommandLineRunner {
    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private  AgendamentoRepository agendamentoRepository;

    @Override
    public void run(String... args) throws Exception {
        Sala a1 = new Sala(null, "901", "9ª andar", 35, StatusSala.ATIVA);
        Sala a2 = new Sala(null, "902", "9ª andar", 35, StatusSala.ATIVA);
        Sala a3 = new Sala(null, "903", "9ª andar", 35, StatusSala.INATIVA);
        Sala a4 = new Sala(null, "904", "9ª andar", 35, StatusSala.ATIVA);
        Sala a5 = new Sala(null, "905", "9ª andar", 35, StatusSala.ATIVA);
        Sala a6 = new Sala(null, "906", "9ª andar", 35, StatusSala.MANUTENCAO);
        Sala a7 = new Sala(null, "907", "9ª andar", 35, StatusSala.ATIVA);
        Sala a8 = new Sala(null, "908", "9ª andar", 35, StatusSala.ATIVA);
        Sala a9 = new Sala(null, "909", "9ª andar", 35, StatusSala.ATIVA);
        Sala a10 = new Sala(null, "910", "9ª andar", 35, StatusSala.ATIVA);
        Sala a11 = new Sala(null, "911", "9ª andar", 35, StatusSala.ATIVA);
        Sala a12 = new Sala(null, "912", "9ª andar", 35, StatusSala.ATIVA);

        salaRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11,a12));

       //Agendamento l1 = new Agendamento(null, "Aula de Medicina", a1);
       //Agendamento l2 = new Agendamento(null, "Aula da Pós", a2);

       //agendamentoRepository.saveAll(Arrays.asList(l1, l2));
    }
}
