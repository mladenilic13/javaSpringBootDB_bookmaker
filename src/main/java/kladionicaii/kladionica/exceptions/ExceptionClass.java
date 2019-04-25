package kladionicaii.kladionica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionClass {
	
	// methods for handling specific exceptions (separate for every exception)
	
	// response body returns message (in postman or..)
	@ResponseBody
	// specify exception
	@ExceptionHandler(value=UserNotFoundException.class)
	// specify response status for controller method
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String userNotFoundException(UserNotFoundException exception){
		return exception.getMessage();
	}

}
