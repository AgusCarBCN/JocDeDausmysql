package carnerero.agustin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import carnerero.agustin.converter.ProductConverter;
import carnerero.agustin.dto.PlayerDTO;
import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;
import carnerero.agustin.service.JocDeDausService;

@RestController
public class JocDeDausController {
	@Autowired
	private JocDeDausService service;

	private ProductConverter converter=new ProductConverter();

	// Lista un jugador del sistema
	
	@GetMapping("/players/{id}")
	public ResponseEntity<PlayerDTO> getPlayer(@PathVariable(value = "id") Long idPlayer) {
		Player player = service.getPlayer(idPlayer);
		PlayerDTO playerDTO = converter.fromEntity(player);
		return new ResponseEntity<PlayerDTO>(playerDTO, HttpStatus.OK);

	}

	// Crear jugador
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/players")
	public ResponseEntity<PlayerDTO> createPayer(@RequestBody Player player) {
		Player newPlayer = service.createPlayer(player);
		PlayerDTO playerDTO =converter.fromEntity(newPlayer);
		return new ResponseEntity<PlayerDTO>(playerDTO, HttpStatus.CREATED);

	}

	// Modifica el nombre del jugador
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/players")
	public ResponseEntity<PlayerDTO> modifyPlayerName(@RequestBody Player player) {
		Player updatedPlayer = service.updatePlayerName(player);
		PlayerDTO updatedPlayerDTO = converter.fromEntity(updatedPlayer);
		return new ResponseEntity<PlayerDTO>(updatedPlayerDTO, HttpStatus.CREATED);

	}

	// Un jugador realiza una tirada de dados
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/players/{id}/games")
	public ResponseEntity<Game> newGame(@PathVariable(value = "id") Long idPlayer) {
		try {
			Player player = service.getPlayer(idPlayer);
			Game newGame = player.plays();
			return new ResponseEntity<>(service.createGame(idPlayer, newGame), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Elimina las jugadas del jugador
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<List<Game>> deleteGamesByPlayer(@PathVariable Long id) {
		return new ResponseEntity<List<Game>>(service.deleteGamesByPlayer(id), HttpStatus.OK);
	}
	// Retorna el listado de todos los jugadores

	@GetMapping("/players")
	public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
		List<Player> players = service.getPlayers();
		List<PlayerDTO> playersdto = converter.fromEntity(players);
		return new ResponseEntity<List<PlayerDTO>>(playersdto, HttpStatus.OK);
	}
	// Listado de jugadas de un jugador

	@GetMapping("/players/{id}/games")
	public ResponseEntity<List<Game>> getGamesByPlayer(@PathVariable Long id) {
		return new ResponseEntity<List<Game>>(service.getGamesByPlayer(id), HttpStatus.OK);
	}

	// Retorna el ranking medio de todos los jugadores del sistema

	@GetMapping("/players/ranking")
	public ResponseEntity<Double> getRankingPlayers() {
		System.out.println("El valor es " + service.averageRanking());
		return new ResponseEntity<Double>(service.averageRanking(), HttpStatus.OK);
	}

	// Retorna el jugador con mejor ranking

	@GetMapping("/players/ranking/winner")
	public ResponseEntity<PlayerDTO> getTheBestPlayer() {
		Player player = service.theBestPlayer();
		PlayerDTO theBestPlayerDTO = converter.fromEntity(player);
		return new ResponseEntity<PlayerDTO>(theBestPlayerDTO, HttpStatus.OK);
	}
	// Retorna el jugador con peor ranking

	@GetMapping("/players/ranking/loser")
	public ResponseEntity<PlayerDTO> getTheWorstPlayer() {
		Player player = service.theWorstPlayer();
		PlayerDTO theWorstPlayerDTO = converter.fromEntity(player);
		return new ResponseEntity<PlayerDTO>(theWorstPlayerDTO, HttpStatus.OK);
	}

}
