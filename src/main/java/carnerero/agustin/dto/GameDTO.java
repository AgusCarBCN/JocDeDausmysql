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
public class GameDTO {
	private Long id;		
	private Boolean winner ;	
	private int dice1;
	private int dice2;	
	private int result;
	
}
