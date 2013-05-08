package helpers;

import java.util.*;

public class RegisterMapper {
	
	static Hashtable<String, Integer> registers ;
	
	public static void populate(){
		
		registers.put("zero", 0);
		registers.put("at", 1);
		registers.put("v0", 2);
		registers.put("v1", 3);
		registers.put("a0", 4);
		registers.put("a1", 5);
		registers.put("a2", 6);
		registers.put("a3", 7);
		registers.put("t0", 8);
		registers.put("t1", 9);
		registers.put("t2", 10);
		registers.put("t3", 11);
		registers.put("t4", 12);
		registers.put("t5", 13);
		registers.put("t6", 14);
		registers.put("t7", 15);
		registers.put("s0", 16);
		registers.put("s1", 17);
		registers.put("s2", 18);
		registers.put("s3", 19);
		registers.put("s4", 20);
		registers.put("s5", 21);
		registers.put("s6", 22);
		registers.put("s7", 23);
		registers.put("t8", 24);
		registers.put("t9", 25);
		registers.put("k0", 26);
		registers.put("k1", 27);
		registers.put("gp", 28);
		registers.put("sp", 29);
		registers.put("fp", 30);
		registers.put("ra", 31);
		
	}
	
	public static int map_to_index(String register){ // takes register name, returns its index e.g: a0 --> 1
		
		return registers.get(register);
	}
	
	public static String map_to_name(int index){ //takes register index, returns its name e.g: 1 --> a0
		
		return "";
	}

}

