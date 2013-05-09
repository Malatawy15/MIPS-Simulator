package components;

import java.nio.ByteBuffer;
import java.util.Arrays;
import exceptions.MemoryOutOfBoundsException;

public class MemoryUnit {

	byte[] memory;

	public MemoryUnit() {
		memory = new byte[1 << 10];
	}

	public MemoryUnit(int size) {
		memory = new byte[size];
	}
	
	public int size(){
		return memory.length;
	}
	
	public void print(){
		System.out.println(Arrays.toString(memory));
	}
	
	public byte[] read(int start, int end) {
		if (start < 0 || end > memory.length) {
			throw new MemoryOutOfBoundsException();
		}
		return Arrays.copyOfRange(memory, start, end);
	}
	
	public void write(int index, byte[]array){
		
		if(index < 0 || index+array.length > memory.length)
			throw new MemoryOutOfBoundsException();
				
		for(int i=index; i-index < array.length; i++){
			memory[i] = array[i-index];
		}
		
	}

	public static byte[] break_word(int value) {
		return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16),
				(byte) (value >>> 8), (byte) value };
	}
	
	public static byte[] break_half_word (int value){
		return new byte[] { (byte) (value >>> 8), (byte) value};
	}
	
	public int load_word(int index) {
		byte[] array = read(index, index + 4);
		return ByteBuffer.wrap(array).getInt();
	}

	public int load_half_word(int index) {
		byte[] array = read(index, index + 2);
		return (short)(
	            (0xff & array[0]) << 8   |
	            (0xff & array[1]) << 0
	            );
	}
	
	public int load_half_word_unsigned(int index) {
		byte[] array = read(index, index+2);
		return (char)(
	            (0xff & array[0]) << 8   |
	            (0xff & array[1]) << 0
	            );	}

	public int load_byte(int index) {
		byte[] array = read(index, index+1);
		return (byte) array[0];
	}
	
	public int load_byte_unsigned(int index){
		byte[] array = read(index, index+1);
		return (short) array[0] & 0xff;
	}

	public void store_word(int index, int value) {
		byte[] array = break_word(value);
		write(index,array);
	}
	
	public void store_half_word(int index, int value){
		byte[] array = break_half_word(value);
		write(index,array);
	}

	public void store_byte(int index, int value) {
		write(index, new byte[] {((byte) (value & 0x000000FF))});
	}

}
