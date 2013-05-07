package components;

import exceptions.*;

import java.util.ArrayList;

public class RegisterFile {
	
	int[] register_file;
	static int file_size;
	
	ArrayList<Integer> write_not_allowed;
	
	public RegisterFile(){
		file_size = 32;
		register_file = new int[file_size];
	
		write_not_allowed = new ArrayList<Integer>();
		write_not_allowed.add(0);
	}
	
	public int get_regsiter(int index){
		if(index < 0 || index > file_size){
			throw new RegsiterOutOfBoundsException(index);
		}
		return register_file[index];
	}
	
	public int write_register(int index) throws WriteNotAllowedException{
		
		if(write_not_allowed.contains(index)){
			throw new WriteNotAllowedException(index);
		}
		return 0;
	}
	
}
