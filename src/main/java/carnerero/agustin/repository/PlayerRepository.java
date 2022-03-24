package carnerero.agustin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carnerero.agustin.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
