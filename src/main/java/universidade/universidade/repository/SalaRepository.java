package universidade.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import universidade.universidade.entity.Sala;

import java.util.UUID;

public interface SalaRepository extends JpaRepository<Sala, UUID> {
}
