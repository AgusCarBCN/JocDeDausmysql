package carnerero.agustin.converter;

import org.springframework.stereotype.Component;

import carnerero.agustin.dto.PlayerDTO;
import carnerero.agustin.entity.Player;
@Component
public class PlayerConverter extends AbstractConverter<Player,PlayerDTO>{

	@Override
	public PlayerDTO fromEntity(Player entity) {
		return PlayerDTO.builder().
				id(entity.getId()).
				name(entity.getName()).	
				dateReg(entity.getDateReg()).
				winGames(entity.getWinGames()).
				lostGames(entity.getLostGames()).
				average(entity.getAverage()).
				totalGames(entity.getTotalGames()).build();
	}

	

	@Override
	public Player fromDTO(PlayerDTO dto) {
		return Player.builder().
				id(dto.getId()).
				name(dto.getName()).	
				dateReg(dto.getDateReg()).
				winGames(dto.getWinGames()).
				lostGames(dto.getLostGames()).
				average(dto.getAverage()).
				totalGames(dto.getTotalGames()).build();
	}

}
