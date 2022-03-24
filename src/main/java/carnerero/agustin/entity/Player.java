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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="players")
public class Player {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	@Column(name="NAME",nullable=false,unique=true)
	private String name;
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="REGISTRATIONDATE",nullable=false)
	private Date registrationDate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<Game> games;
}
