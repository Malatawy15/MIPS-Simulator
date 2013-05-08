package components;

import java.util.Arrays;

public class MemoryUnit {
	
	byte[] memory;
	
	public MemoryUnit(){
		memory = new byte[1<<20];
	}
	
	public static byte[] break_integer(int value){
		//To implement
		return new byte[4];
	}
	
	public static int connect_integer(byte[] array){
		//To implement
		return 0;
	}
	
	public void store_word(int index, int value){
		
		byte[] array = break_integer(value);
		
		for(int i=index; i<index+4; i++){
			memory[i] = array[i-index];
		}
		
	}
	
	public int load_word(int index){
		byte[] array = Arrays.copyOfRange(memory, index, index+4);
		return connect_integer(array);
	}

}
