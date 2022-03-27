package carnerero.agustin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;
import carnerero.agustin.service.JocDeDausService;

@RestController
public class JocDeDausController {
	@Autowired
	private JocDeDausService service;

	// Crear jugador
	@PostMapping("/players")
	public ResponseEntity<Player> createPayer(@RequestBody Player newPlayer) {
		try {
			return new ResponseEntity<>(service.createPlayer(newPlayer), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Modifica el nombre del jugador
	@PutMapping("/players")
	public ResponseEntity<Player> modifyPlayerName(@RequestBody Player player) {
		try {
			Player updatedPlayer = service.updatePlayerName(player);
			return new ResponseEntity<>(updatedPlayer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Un jugador realiza una tirada de dados
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
	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<List<Game>> deleteGamesByPlayer(@PathVariable Long id) {
		return new ResponseEntity<List<Game>>(service.deleteGamesByPlayer(id), HttpStatus.OK);
	}
	//Retorna el listado de todos los jugadores
	
	@GetMapping("/players")
	public ResponseEntity<List<Player>> getAllPlayers() {
		return new ResponseEntity<List<Player>>(service.getPlayers(), HttpStatus.OK);
	}
	//Listado de jugadas de un jugador
	
	@GetMapping("/players/{id}/games")
	public ResponseEntity<List<Game>>getGamesByPlayer(@PathVariable Long id){
		return new ResponseEntity<List<Game>>(service.getGamesByPlayer(id),HttpStatus.OK);
	}
	
	//Retorna el ranking medio de todos los jugadores del sistema
	
	@GetMapping("/players/ranking")
	public ResponseEntity<Double>getRankingPlayers(){
		System.out.println("El valor es "+service.averageRanking());
		return new ResponseEntity<Double>(service.averageRanking(),HttpStatus.OK);
	}
	
	//Retorna el jugador con mejor ranking
	
	@GetMapping("/players/ranking/winner")
	public ResponseEntity<Player>getTheBestPlayer(){
		return new ResponseEntity<Player>(service.theBestPlayer(),HttpStatus.OK);
	}
	//Retorna el jugador con peor ranking
	
		@GetMapping("/players/ranking/loser")
		public ResponseEntity<Player>getTheWorstPlayer(){
			return new ResponseEntity<Player>(service.theWorstPlayer(),HttpStatus.OK);
		}
	
}	
	
	
	
	
	
	


