package carnerero.agustin.converter;

import carnerero.agustin.dto.PlayerDTO;
import carnerero.agustin.entity.Player;

public class ProductConverter extends AbstractConverter<Player,PlayerDTO>{

	@Override
	public PlayerDTO fromEntity(Player entity) {
		return PlayerDTO.builder().
				id(entity.getId()).
				name(entity.getName()).
				rol(entity.getRol()).
				winGames(entity.getWinGames()).
				lostGames(entity.getLostGames()).
				average(entity.getAverage()).
				totalGames(entity.getTotalGames()).build();
	}

	@Override
	public Player fromDTO(Player dto) {
		return Player.builder().
				id(dto.getId()).
				name(dto.getName()).
				rol(dto.getRol()).
				winGames(dto.getWinGames()).
				lostGames(dto.getLostGames()).
				average(dto.getAverage()).
				totalGames(dto.getTotalGames()).build();
		
	}

}
