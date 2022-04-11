package carnerero.agustin.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import carnerero.agustin.entity.Game;
import carnerero.agustin.entity.Player;
import carnerero.agustin.service.JocDeDausService;

@Configuration
public class LoadingData {
	@Bean
	public CommandLineRunner loadData(JocDeDausService service) {
		return (args) -> {
			if (service.countAllPlayers() == 0) {
				Player player1 = new Player("Agustin");
				Player player2 = new Player("Salva");
				Player player3 = new Player("Adela");
				Player player4 = new Player("Jose");
		 		Player player5 = new Player("Manolo");

				service.createPlayer(player1);
				service.createPlayer(player2);
				service.createPlayer(player3);
				service.createPlayer(player4);
				service.createPlayer(player5);

				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());

				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());

				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());

				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());

				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());

			}
		};
	}
}
