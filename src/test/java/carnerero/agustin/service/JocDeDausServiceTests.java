package carnerero.agustin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.List;
import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class JocDeDausServiceTests { 

	@Autowired
	JocDeDausService service;

	List<Player> players;
	Long id;

	@BeforeEach
	void initTest() {
		players = service.getPlayers();
		id = players.get(0).getId();
	}

	@Test
	@DisplayName("Create player testing")
	@Order(1)
	void createPlayerTest(TestInfo info) {
		System.out.println("ejecutando: "+info.getDisplayName());
		Player player = new Player("player");
		Player playerCreated = service.createPlayer(player);
		assertNotNull(playerCreated);
	}

	@Test
	@DisplayName("Get all players in system testing")
	@Order(2)
	void getAllPlayersTest() {
		// List<Player> players = service.getPlayers();
		assertThat(players).size().isGreaterThan(0);
	}

	@Test
	@DisplayName("Get one player testing")
	@Order(3)
	void getOnePlayerTest() {
		// List<Player> players = service.getPlayers();
		// long id = players.get(0).getId();
		Player player = service.getPlayer(id);
		assertNotNull(player);
	}

	@Test
	@DisplayName("Create a new game by player testing")
	@Order(4)
	void createGameTest() {
		// List<Player> players = service.getPlayers();
		// long id = players.get(0).getId();
		Game newGame = new Game();
		service.createGame(id, newGame);
		int result = newGame.getDice1() + newGame.getDice2();
		assertAll(() -> {
			assertNotNull(newGame);
		}, () -> {
			assertThat(result).isGreaterThanOrEqualTo(2);
		}, () -> {
			assertThat(result).isLessThanOrEqualTo(12);
		});

	}

	@Test
	@DisplayName("Update player name testing")
	@Order(5)
	void upDatePlayerNameTest() {
		// List<Player> players = service.getPlayers();
		Player player = players.get(0);
		String nameBefore = player.getName();
		player.setName("nuevoNombre");
		service.updatePlayerName(player);
		assertNotEquals(nameBefore, player.getName());
	}

	@Test
	@DisplayName("Get games by player testing")
	@Order(6)
	void getGamesByPlayerTest() {
		// List<Player> players = service.getPlayers();
		// long id = players.get(0).getId();
		List<Game> games = service.getGamesByPlayer(id);
		assertThat(games).size().isGreaterThan(0);
	}

	@Test
	@DisplayName("Delete games by player testing")
	@Order(7)
	void deleteGamesByPlayerTest() {
		// List<Player> players = service.getPlayers();
		// long id = players.get(0).getId();
		List<Game> games = service.getGamesByPlayer(id);
		service.deleteGamesByPlayer(id);
		games = service.getGamesByPlayer(id);
		assertThat(games).size().isEqualTo(0);
	}

	@Test
	@DisplayName("Get average ranking Testing")
	@Order(8)
	void averagePlayersTest() {
		double average = service.averageRanking();
		assertThat(average).isGreaterThanOrEqualTo(0);
	}

	@Test
	@Order(9)
	@DisplayName("Get the best player testing")
	void getTheBestPlayerTest() {
		Player player = service.theBestPlayer();
		assertNotNull(player);
	}

	@Test
	@DisplayName("Get the worst player testing")
	@Order(10)
	void getTheWorstPlayer() {
		Player player = service.theWorstPlayer();
		assertNotNull(player);
	}

}
