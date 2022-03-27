package carnerero.agustin.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
@Table(name = "players")
public class Player {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false, unique = true)
	private String name = "ANONIM";
	@Column(name = "date", nullable = false)	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Past
	private Date date;
	private Double winGames = 0.0;
	private Double lostGames = 0.0;	
	private Double average = 0.0;
	private Double totalGames=0.0;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
	private List<Game> games;

	public Player(String name, Date date) {
		this.name = name;
		this.date = date;
	}
	
	public void setWinGames() {
		this.winGames+=1;
	}
	public void setLostGames() {
		this.lostGames+=1;
	}
	public void setTotalGames() {
		this.totalGames+=1;
		
	}
	public void setAverage(double average) {
		this.average=average;
		
	}
	public Game plays() {
		return new Game();
	}
	public void setName(String name) {
		this.name=name;
	}

	
}
