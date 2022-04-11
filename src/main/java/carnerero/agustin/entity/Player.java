package carnerero.agustin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Table(name = "players")
public class Player {
	@Id
	@Column(name = "idplayer")
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "date", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Past
	private Date date;

	@Column(name = "wingames")
	private int winGames;
	@Column(name = "lostgames")
	private int lostGames;
	@Column(name = "average")
	private double average;
	@Column(name = "totalgames")
	private int totalGames;
	{
		Random rnd = new Random();
		id = rnd.nextLong(100000);
		name = "ANONYMOUS";
		date = new Date();
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
	private List<Game> games;

	public Player(String name) {
		
		games = new ArrayList<>();
		this.name = name;

	}

	public void addGame(Game game) {
		games.add(game);
	}

	public void setAverage(double average) {
		this.average = average;

	}

	public Game plays() {
		return new Game();
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}
