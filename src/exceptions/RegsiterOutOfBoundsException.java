package exceptions;

public class RegsiterOutOfBoundsException extends ArrayIndexOutOfBoundsException {
	
	public RegsiterOutOfBoundsException(){
		super("This register is out of bounds.");
	}
	
	public RegsiterOutOfBoundsException(int register_index){
		super("Register # " + register_index + " is out of bounds.");
	}
	
}
