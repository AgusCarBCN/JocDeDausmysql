package carnerero.agustin.service;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class JocDeDausServiceTests {

	@Autowired
	JocDeDausService service;

	@Test
	@Order(1)
	public void createPlayerTest() {
		Player player = new Player("player");
		Player playerCreated = service.createPlayer(player);
		assertNotNull(playerCreated);
	}

	@Test
	@Order(2)
	public void getAllPlayersTest() {
		List<Player> players = service.getPlayers();
		assertThat(players).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void getOnePlayer() {
		Player player = service.getPlayer(1L);
		assertNotNull(player);
	}

	@Test
	@Order(4)
	public void createGame() {
		Game newGame = new Game();
		service.createGame(1L, newGame);
		assertNotNull(newGame);
	}

	@Test
	@Order(5)
	public void upDatePlayerName() {
		Player player = service.getPlayer(1L);
		String nameBefore = player.getName();

		player.setName("nuevoNombre");
		service.updatePlayerName(player);
		assertNotEquals(nameBefore, player.getName());
	}

	@Test
	@Order(6)
	public void getGamesByPlayer() {
		List<Game> games = service.getGamesByPlayer(1L);
		assertThat(games).size().isGreaterThan(0);
	}

	@Test
	@Order(7)
	public void deleteGamesByPlayer() {
		List<Game> games = service.getGamesByPlayer(1L);
		service.deleteGamesByPlayer(1L);
		games=service.getGamesByPlayer(1L);
		assertThat(games).size().isEqualTo(0);
	}

	@Test
	@Order(8)
	public void averagePlayer() {
		double average = service.averageRanking();
		assertThat(average).isGreaterThanOrEqualTo(0);
	}

	@Test
	@Order(9)
	public void getTheBestPlayer() {
		Player player = service.theBestPlayer();
		assertNotNull(player);
	} 

	@Test
	@Order(10)
	public void getTheWorstPlayer() {
		Player player = service.theWorstPlayer();
		assertNotNull(player);
	}
}
