package carnerero.agustin.service;

import java.util.ArrayList;
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
		int winGames;
		int lostGames;
		int totalGames;
		game.setPlayer(player);
		game.setDice1((int) (Math.random() * 6 + 1));
		game.setDice2((int) (Math.random() * 6 + 1));
		game.setResult(game.getDice1() + game.getDice2());
		if (game.getDice1() + game.getDice2() == 7) {
			game.setWinner(true);
			winGames = player.getWinGames() + 1;
			player.setWinGames(winGames);
		} else {
			lostGames = player.getLostGames() + 1;
			player.setLostGames(lostGames);
		}
		totalGames = player.getTotalGames() + 1;
		player.setTotalGames(totalGames);
		average = ((double) player.getWinGames() / (double) player.getTotalGames()) * 100;
		player.setAverage(average);
		playerRepo.save(player);
		gameRepo.save(game);
		return game;
	}

	// Modifica nombre de jugador
	@Transactional
	public Player updatePlayerName(Player player) {
		Player updatedPlayer = getPlayer(player.getId());
		updatedPlayer.setName(player.getName());
		playerRepo.save(updatedPlayer);
		return updatedPlayer;
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

	// Retorna el mejor jugador o los mejores jugadores del sistema si hay un empate.Por eso devuelvo una lista.
	public List<Player> theBestPlayer() {
		List<Player> players = getPlayers();
		List<Player> playersb=new ArrayList<>();
		playersb.removeAll(playersb);
		double hightAverage = 0.0;
		for (Player player : players) {
			if (player.getAverage() > hightAverage) {
				hightAverage = player.getAverage();
				}
		}
		for (Player p : players) {
			if (p.getAverage() == hightAverage) {
				playersb.add(p);
			}
		}
	
	return playersb;
		
	}

	// Retorna el peor jugador o los peores jugadores del sistema si hay un empate.Por eso devuelvo una lista.
	public List<Player> theWorstPlayer() {
		List<Player> players = getPlayers();
		List<Player> playersw=new ArrayList<>();
		playersw.removeAll(playersw);
		double LowAverage = 100.0;
		for (Player player : players) {
			if (player.getAverage() < LowAverage) {
				LowAverage = player.getAverage();
				}
		}
		for (Player p : players) {
				if (p.getAverage() == LowAverage) {
					playersw.add(p);
				}
			}
		
		return playersw;
	}

}
