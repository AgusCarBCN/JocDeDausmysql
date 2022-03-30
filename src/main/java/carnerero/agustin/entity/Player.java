package carnerero.agustin.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder

@Table(name = "players")
public class Player {
	@Id
	@Column(name = "idplayer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@Column(name="password",nullable=false)
	private String password;	
	@Column(name = "date", nullable = false)	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Past
	private Date date;
	@Column(name="rol",nullable=false)
	@Enumerated(EnumType.STRING)
	private Rol rol;
	@Column(name="wingames")
	private Double winGames ;
	@Column(name="lostgames")
	private Double lostGames;	
	@Column(name="average")
	private Double average;
	@Column(name="totalgames")
	private Double totalGames;
	{
		winGames=0.0;
		lostGames=0.0;
		average=0.0;
		totalGames=0.0;
		name="ANONIM";
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
	private List<Game> games;

	public Player(String name,Rol rol,String password, Date date) {
		this.name = name;
		this.rol=rol;
		this.password=password;
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
