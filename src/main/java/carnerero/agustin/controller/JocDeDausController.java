package carnerero.agustin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import carnerero.agustin.entity.Player;
import carnerero.agustin.repository.PlayerRepository;

@RestController
public class JocDeDausController {
	@Autowired
	private PlayerRepository  playerRepo;

	// Crear jugador
	@PostMapping("/POST/player/")
	public ResponseEntity<Player> createPayer(@RequestBody Player player) {
		try {
			return new ResponseEntity<>(playerRepo.save(player), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Listar tiendas: Lista tiendas con su nombre y capacidad

	@GetMapping("/GET/players/")
	public ResponseEntity<List<Player>> getPlayers() {
		try {
			List<Player> players = playerRepo.findAll();
			if (players.isEmpty() || players.size() == 0) {
				return new ResponseEntity<List<Player>>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
