package carnerero.agustin.exceptions;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code=HttpStatus.NO_CONTENT)
public class PlayerNotFoundException extends RuntimeException {

	public PlayerNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	} 

	public PlayerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(Throwable cause) {
		super(cause); 
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(Long id){
		super(MessageFormat.format("No se ha podido encontrar el jugador con id; {0}", id));
	}
}