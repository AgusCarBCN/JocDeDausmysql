package carnerero.agustin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	public List<Game> findByPlayer(Player player);
	public int countByPlayer(Player player);
	
}
