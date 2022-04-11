package carnerero.agustin.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

	@Test
	void namePlayerTest() {
		Player player = new Player("name");
		String expected = "name";
		String real = player.getName();
		assertEquals(expected, real, "Nombre de jugador no es el esperado");
	}

	@Test
	void nameAnonymousPlayerTest() {
		Player player = new Player();
		String expected = "ANONYMOUS";
		String real = player.getName();
		assertEquals(expected, real, "Nombre del jugador no es anonymous");
	}

	@Test
	void idPlayerTest() { 
		Player player1 = new Player();
		Player player2 = new Player();
		assertNotEquals(player1.getId(), player2.getId());
	}

	@Test
	void playGamePlayerTest() {
		Player player = new Player();
		Game newGame = player.plays();
		assertNotNull(newGame);
	}
	

}
