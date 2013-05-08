package simulator;

import components.*;
import instructions.*;
import exceptions.*;
import helpers.*;

import java.io.*;
import java.util.*;


public class Simulator {
	
	ArrayList<String> raw_instructions;
	
	RegisterFile register_file;
	MemoryUnit memory_unit;
	
	LogicUnit logic_unit;
	
	int pc;
	
	String current_raw_instruction;
	Instruction current_instruction;
	
	int alu_result;
	int memory_result;
	int write_back_value;
	
	public static void main (String[]args){
		
	}
	
	public void run(){
		
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
			
			execute_stage();
			
			//Memory stage
			
			memory_stage();
			
			//Write back stage
			
			write_back_stage();
			
		}
	}
	
	private static void welcome_message() {
		System.out.println("Hello World! --Git Style ;)");
	}

	private void initialize_values() {
		pc = 0;
		current_raw_instruction = "";
		current_instruction = new Instruction();
		
		logic_unit = new LogicUnit();
		logic_unit.set_sim(this);
		
		memory_unit = new MemoryUnit();
		populate_memory();
		
		RegisterMapper.populate();
	}
	
	private void populate_memory(){
		Random r = new Random();
		for(int i = 0; i<4096; i+=4){
			memory_unit.store_word(i, r.nextInt());
		}
	}
	
	private void load_data(){

	}
	
	private void fetch_stage(){
		current_raw_instruction = raw_instructions.get(pc/4);
		pc+=4;
	}
	
	private void decode_stage() {
		current_instruction = new Instruction(current_raw_instruction);
	}
	
	private void execute_stage(){
		alu_result = logic_unit.execute(current_instruction);
	}
	
	private void memory_stage(){
		int address = calculate_memory_address();
		InstructionType type = current_instruction.get_type();
		
		switch(type){
			case lw:{
				memory_result = memory_unit.load_word(alu_result);
			}
			case sw:{
				
			}
			default:{
				
			}
		}
		
	}
	
	private void write_back_stage() {

		int format = current_instruction.get_format();
		switch (format) {
		case 0:
			write_back_value = alu_result;
		case 1:
			write_back_value = memory_result;
			write_register();
			break;
		case 4:
			if (current_instruction.get_type() == InstructionType.jal) {
				write_register();
			}
			break;
		}
	}
	
	private void write_register(){
		try {
			register_file.write_register(current_instruction.get_rd(),
					write_back_value);
		} catch (WriteNotAllowedException e) {
			// See how to handle exception
		}
	}
	
	private int calculate_memory_address(){ //To Do! // Is it actually handled in ALU?
		return 0;
	}
	
}