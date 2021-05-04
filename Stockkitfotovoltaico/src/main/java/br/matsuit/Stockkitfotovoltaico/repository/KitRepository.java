package br.matsuit.Stockkitfotovoltaico.repository;

import br.matsuit.Stockkitfotovoltaico.entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KitRepository extends JpaRepository<Modulo, Long> {

    Optional<Modulo> findByName(String name);
}
