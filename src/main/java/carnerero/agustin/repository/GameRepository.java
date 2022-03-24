package carnerero.agustin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carnerero.agustin.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
