package simulator;

import components.*;
import instructions.*;
import exceptions.*;

import java.io.*;
import java.util.*;


public class Simulator {
	
	static ArrayList<String> raw_instructions;
	static RegisterFile register_file;
	
	static int pc;
	
	static String current_raw_instruction;
	static Instruction current_instruction;
	
	static int alu_result;
	
	public static void main (String[]args){
		
		welcome_message();
		
		load_data(); //Reads all instructions
		
		initialize_values(); //Initializes all values
		
		
		//Loop over all instructions executing one by one
		while(true){
			
			//Fetch stage
			
			/*load instruction from instruction memory
			 * increment the PC
			 */
			
			fetch_stage();
			
			//Decode stage
			
			/*determine type of fetched instruction
			 *break the instruction accordingly
			 *pass values to their correct path in the execution phase 
			 */
			
			decode_stage();
			
			//Execute stage
			
			//Memory stage
			
			//Write back stage
			
		}
	}
	


	private static void welcome_message() {
		System.out.println("Hello World! --Git Style ;)");
		
	}

	private static void initialize_values() {
		pc = 0;
		current_raw_instruction = "";
		current_instruction = new Instruction();
	}

	private static void load_data(){

	}
	
	private static void fetch_stage(){
		current_raw_instruction = raw_instructions.get(pc/4);
		pc+=4;
	}
	
	private static void decode_stage() {
		current_instruction = new Instruction(current_raw_instruction);
		//dRegisterFile.load(current_instruction);
	}
	
	private static void execute_stage(){
		alu_result = LogicUnit.execute(current_instruction);
	}
	
	

}
