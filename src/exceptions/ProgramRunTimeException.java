package exceptions;

@SuppressWarnings("serial")
public class ProgramRunTimeException extends Exception {
	
	public ProgramRunTimeException(){
		super("Development error! Sorry about that :(");
	}

}
