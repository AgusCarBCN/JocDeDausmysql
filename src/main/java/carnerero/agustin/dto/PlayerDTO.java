package carnerero.agustin.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlayerDTO {

	private Long id;
	private String name;
	private Double winGames;
	private Double lostGames;
	private Double average;
	private Double totalGames;

}
