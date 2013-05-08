package exceptions;

@SuppressWarnings("serial")
public class RegisterOutOfBoundsException extends ArrayIndexOutOfBoundsException {
	
	public RegisterOutOfBoundsException(){
		super("This register is out of bounds.");
	}
	
	public RegisterOutOfBoundsException(int register_index){
		super("Register # " + register_index + " is out of bounds.");
	}
	
}
