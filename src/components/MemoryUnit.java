package components;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class MemoryUnit {
	
	byte[] memory;
	
	public MemoryUnit(){
		memory = new byte[1<<20];
	}
	
	public MemoryUnit(int size){
		memory = new byte[size];
	}
	
	public static byte[] break_integer(int value){
	    return new byte[] {
	            (byte)(value >>> 24),
	            (byte)(value >>> 16),
	            (byte)(value >>> 8),
	            (byte)value};
	}
	
	
	public static int connect_integer(byte[] array){
		return ByteBuffer.wrap(array).getInt();
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
