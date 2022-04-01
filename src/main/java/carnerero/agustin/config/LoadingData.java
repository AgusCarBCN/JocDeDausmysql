package carnerero.agustin.config;


import java.util.Date;

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
			
			service.createPlayer(new Player("Agustin", new Date()));
			service.createPlayer(new Player("Salva", new Date()));
			service.createPlayer(new Player("Adela", new Date()));
			service.createPlayer(new Player("Jose", new Date()));
			service.createPlayer(new Player("Manolo", new Date()));
			
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			service.createGame(1L,new Game());
			
			
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			service.createGame(2L,new Game());
			
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			service.createGame(3L,new Game());
			
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			service.createGame(4L,new Game());
			
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
			service.createGame(5L,new Game());
		};
	}
}
