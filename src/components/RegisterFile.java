package components;

import exceptions.*;

import heplers.RegisterMapper;

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
	
	public void validate_index(int index){
		if(index < 0 || index > file_size){
			throw new RegisterOutOfBoundsException(index);
		}
	}
	
	public int get_register(int index){
		validate_index(index);
		return register_file[index];
	}
	
	public int get_register(String name){
		return get_register(RegisterMapper.map_to_index(name));
	}
	
	public void write_register(int index, int value) throws WriteNotAllowedException{
		
		validate_index(index);
		 
		if(write_not_allowed.contains(index)){
			throw new WriteNotAllowedException(index);
		}
		register_file[index] = value;
	}
	
}
