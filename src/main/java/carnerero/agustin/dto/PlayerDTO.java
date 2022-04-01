package carnerero.agustin.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDTO {

	private Long id;
	private String name;
	private Double winGames;
	private Double lostGames;
	private Double average;
	private Double totalGames;

}
