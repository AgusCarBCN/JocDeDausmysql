package carnerero.agustin.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String user;
	private String rol;
	private String password;
	private String token;
	public User() {
		
	}
	 public User(String user, String rol,String password, String token) {
	        this.user = user;
	        this.rol=rol;
	        this.password=password;
	        this.token = token;
	    }
}
