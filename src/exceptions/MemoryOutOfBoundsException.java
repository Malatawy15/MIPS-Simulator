package exceptions;

@SuppressWarnings("serial")
public class MemoryOutOfBoundsException extends ArrayIndexOutOfBoundsException {
	
	public MemoryOutOfBoundsException(){
		super("Sorry, the memory address you tried to access is out of bounds!");
	}

}
