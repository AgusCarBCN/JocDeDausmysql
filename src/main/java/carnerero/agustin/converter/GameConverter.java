package carnerero.agustin.converter;

import carnerero.agustin.dto.GameDTO;
import carnerero.agustin.entity.Game;

public class GameConverter extends AbstractConverter<Game, GameDTO> {

	@Override
	public GameDTO fromEntity(Game entity) {
		return GameDTO.builder().id(entity.getId()).winner(entity.getWinner()).dice1(entity.getDice1())
				.dice2(entity.getDice2()).result(entity.getResult()).build();
	}

	@Override
	public Game fromDTO(Game dto) {
		return Game.builder().id(dto.getId()).winner(dto.getWinner()).dice1(dto.getDice1()).dice2(dto.getDice2())
				.result(dto.getResult()).build();
	}

}
