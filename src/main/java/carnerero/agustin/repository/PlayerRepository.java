package carnerero.agustin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carnerero.agustin.entity.Player;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	
}
