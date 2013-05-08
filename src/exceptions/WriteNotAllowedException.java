package exceptions;

@SuppressWarnings("serial")
public class WriteNotAllowedException extends Exception {
	
	public WriteNotAllowedException(){
		super("You are not allowed to write to this register");
	}
	
	public WriteNotAllowedException(int register_index){
		super("You are not allowed to write to register # " + register_index);
	}
	

}
