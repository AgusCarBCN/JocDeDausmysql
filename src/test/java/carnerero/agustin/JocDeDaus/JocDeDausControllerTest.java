package carnerero.agustin.JocDeDaus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import carnerero.agustin.controller.JocDeDausController;
import carnerero.agustin.service.JocDeDausService;
import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;

@WebMvcTest(JocDeDausController.class)
public class JocDeDausControllerTest {

	@Autowired
	private MockMvc mockMvc;	
	
	@MockBean
	private JocDeDausService service;
	
		
	//Test espera un error 403 acceso denegado 
	@Test	
	public void listPlayersTest() throws Exception {
		List<Player>players=service.getPlayers();	
		Player player1=new Player("player1");
		Player player2=new Player("player2");
		players.add(player1);
		players.add(player2);
		Mockito.when(service.getPlayers()).thenReturn(players);
		String url="/players";
		mockMvc.perform(get(url)).andExpect(status().is(403));
	}
	@Test
	public void createPlayerTest() throws Exception {
		Player player=new Player("player3");		
		Mockito.when(service.createPlayer(player)).thenReturn(player);
		String url="/players";
		mockMvc.perform(get(url)).andExpect(status().is(403));
	}
	
	@Test
	public void createGameTest() throws Exception {
		Game newGame=new Game();		
		Mockito.when(service.createGame(1L, newGame)).thenReturn(newGame);
		String url="/players/id/games";
		mockMvc.perform(get(url)).andExpect(status().is(403));
	}
	@Test
	public void listGamesByPlayer() throws Exception {
		List<Game>games=service.getGamesByPlayer(1L);	
		Game game1=new Game();
		Game game2=new Game();
		games.add(game1);
		games.add(game2);
		Mockito.when(service.getGamesByPlayer(1L)).thenReturn(games);
		String url="/players/id/games";
		mockMvc.perform(get(url)).andExpect(status().is(403));
	}
	@Test 
	public void deleteGamesByPlayer() throws Exception {		
		List<Game>games=service.getGamesByPlayer(1L);				
		Mockito.when(service.deleteGamesByPlayer(1L)).thenReturn(games);
		String url="/players/id/games";
		mockMvc.perform(get(url)).andExpect(status().is(403));
		
	}
	@Test
	public void modifyPlayerName() throws Exception {		
		Player player=new Player();
		player.setName("nuevoNombre");
		Mockito.when(service.updatePlayerName(player)).thenReturn(player);
		String url="/players";
		mockMvc.perform(get(url)).andExpect(status().is(403));		
	}
	
}
