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
	private int winGames;
	private int lostGames;
	private double average;
	private int totalGames;

}
