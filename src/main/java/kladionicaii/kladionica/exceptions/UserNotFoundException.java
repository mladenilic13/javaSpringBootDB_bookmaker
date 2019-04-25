package kladionicaii.kladionica.exceptions;

public class UserNotFoundException extends RuntimeException{

	// for serialization ?? not relevant for exceptions ??
	/**
	 * 
	 */
	private static final long serialVersionUID = -100630816716347475L;
	
	public UserNotFoundException(Integer id) {
		// insert custom message in default message of runtime exception if needed 
		super("user with id " + id + " is not found");
	}
	
}
