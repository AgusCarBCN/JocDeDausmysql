package carnerero.agustin.JocDeDaus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;
import carnerero.agustin.repository.PlayerRepository;
import carnerero.agustin.service.JocDeDausService;

@SpringBootTest
class JocDeDausServiceTests {

	@Autowired 
	JocDeDausService service;
	
	@Test
	public void createPlayerTest() {
		
		Player player=new Player("Pep");
		Player playerCreated=service.createPlayer(player);
		Long id=playerCreated.getId();
		assertNotNull(service.getPlayer(id));
		
}
	@Test
	public void getAllPlayersTest() {
		
		List<Player>players=service.getPlayers();
		assertThat(players).size().isGreaterThan(0);
	}

	@Test
	public void getOnePlayer() {
		Player player=service.getPlayer(1L);
		assertNotNull(player);
	}
	@Test
	public void createGame() {
		Game newGame=new Game();		
		service.createGame(1L, newGame);	   
		assertNotNull(newGame);
	}
	@Test
	public void upDatePlayerName() {
		Player player=service.getPlayer(1L);	
		String nameBefore=player.getName();
		player.setName("Manolo");
		service.updatePlayerName(player);		
		assertNotEquals(nameBefore,player.getName());
	}
	@Test
	public void getGamesByPlayer() {
		List<Game>games=service.getGamesByPlayer(1L);
		assertThat(games).size().isGreaterThan(0);
	}
	@Test
	public void deleteGamesByPlayer() {
		List<Game>games=service.getGamesByPlayer(1L);
		service.deleteGamesByPlayer(1L);
		assertThat(games).size().isEqualTo(0);
	}
	
}
