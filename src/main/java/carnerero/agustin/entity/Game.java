package carnerero.agustin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "games")

public class Game {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "winner")
	private Boolean winner = false;
	private int dado1;
	private int dado2;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "idplayer",nullable=false)
	private Player player;

	public Game() {
		
	}
	
	
}
