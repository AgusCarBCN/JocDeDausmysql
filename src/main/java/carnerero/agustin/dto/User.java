package carnerero.agustin.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String user;
	private String pwd;
	private String token;
	public  User(String user,String pwd){
		this.user=user;
		this.pwd=pwd;
	}
}
