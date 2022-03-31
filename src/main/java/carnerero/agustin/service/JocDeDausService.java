package carnerero.agustin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;
import carnerero.agustin.exceptions.PlayerNotFoundException;
import carnerero.agustin.repository.GameRepository;
import carnerero.agustin.repository.PlayerRepository;

@Service
public class JocDeDausService {
	@Autowired
	private PlayerRepository playerRepo;
	@Autowired
	private GameRepository gameRepo;

	// Crea un jugador
	public Player createPlayer(Player player) {
		Player newPlayer = playerRepo.save(player);
		return newPlayer;
	}

	// Lista todos los jugadores
	public List<Player> getPlayers() {
		List<Player> players = playerRepo.findAll();
		return players;
	}

	// Obtiene un jugador del sistema
	public Player getPlayer(Long id) {
		Player player = playerRepo.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
		return player;
	}

	// Cuenta todos los jugadores del sistema
	public int countAllPlayers() {
		List<Player> players = playerRepo.findAll();
		int result = players.size();
		return result;
	}

	// Obtiene todas las tiradas de un jugador
	public List<Game> getGamesByPlayer(Long id) {
		Player player = getPlayer(id);
		List<Game> games = gameRepo.findAllByPlayer(player);
		return games;
	}
	// Elimina todas las tiradas de un jugador

	public List<Game> deleteGamesByPlayer(Long id) {
		List<Game> games = getGamesByPlayer(id);
		gameRepo.deleteAll(games);
		return games;
	}

	// Crea una jugada
	@Transactional
	public Game createGame(Long id, Game game) {
		Player player = getPlayer(id);
		double average = 0.0;
		game.setPlayer(player);
		game.setDice1((int) (Math.random() * 6 + 1));
		game.setDice2((int) (Math.random() * 6 + 1));
		if (game.getDice1() + game.getDice2() == 7) {
			game.setWinner(true);
			player.setWinGames();
		} else {
			player.setLostGames();
		}
		player.setTotalGames();
		average = (player.getWinGames() / player.getTotalGames()) * 100;
		player.setAverage(average);
		gameRepo.save(game);
		return game;
	}

	// Modifica nombre de jugador
	@Transactional
	public Player updatePlayerName(Player playerUpdated) {
		Player player = getPlayer(playerUpdated.getId());
		player.setName(playerUpdated.getName());
		return playerUpdated;
	}

	// Porcentaje medio de jugadores
	public double averageRanking() {
		List<Player> players = getPlayers();
		int playersNum = players.size();
		double averageSum = 0.0;
		for (Player player : players) {
			averageSum += player.getAverage();
		}

		return averageSum / playersNum;
	}

	// Retorna el mejor jugador
	public Player theBestPlayer() {
		List<Player> players = getPlayers();
		Player theBest = null;
		double hightAverage = 0.0;
		for (Player player : players) {
			if (player.getAverage() > hightAverage) {
				hightAverage = player.getAverage();
				theBest = player;
			}
		}
		return theBest;
	}

	// Retorna el peor jugador
	public Player theWorstPlayer() {
		List<Player> players = getPlayers();
		Player theWorst = null;
		double LowAverage = 100.0;
		for (Player player : players) {
			if (player.getAverage() < LowAverage) {
				LowAverage = player.getAverage();
				theWorst = player;
			}
		}
		return theWorst;
	}

}
