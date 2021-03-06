package simulator;

import GUI.MainView;
import components.*;
import instructions.*;
import exceptions.*;
import helpers.*;

import java.awt.Color;
import java.io.*;
import java.net.URL;
import java.util.*;

public class Simulator {

	ArrayList<String> raw_instructions;

	RegisterFile register_file;
	MemoryUnit memory_unit;

	LogicUnit logic_unit;

	int pc;
	int counter;
	int current_step;

	Hashtable<String, Integer> label_map;

	String current_raw_instruction;
	Instruction current_instruction;

	int alu_result;
	int memory_result;
	int write_back_value;

	boolean signal_alu_zero;
	
	MainView gui;

	public static void main(String[] args) throws Exception {
		Simulator sim = new Simulator();
		sim.run();
	}

	public RegisterFile get_register_file() {
		return register_file;
	}

	public void run() throws Exception {

		welcome_message();

		initialize_values(); // Initializes all values

		load_instructions(); // Reads all instructions
		
		load_data(); // Reads all data
		
//		run_all_instructions();
	}
	
	public void run_step() throws Exception{
		switch(current_step){
		case 0:
			if (pc >> 2 < raw_instructions.size()){
				// Fetch stage

				/*
				 * load instruction from instruction memory increment the PC
				 */

				fetch_stage();
				
				gui.selectInstruction(pc >> 2);
				gui.set_fetch_red();
				
				System.out.println(current_raw_instruction);

				current_step++;
			}
			else {
				//disable all buttons
			}
			break;
		case 1:
			// Decode stage

			/*
			 * determine type of fetched instructionbreak the instruction
			 * accordinglypass values to their correct path in the execution
			 * phase
			 */

			decode_stage();
			gui.set_decode_red();

			System.out.println(current_instruction);

			current_step++;
			break;
		case 2:
			// Execute stage

			execute_stage();
			gui.set_exec_red();

			System.out.println("ALU result = " + alu_result);

			current_step++;
			break;
		case 3:
			// Memory stage

			memory_stage();
			gui.set_memory_red();

			System.out.println("Memory result = " + memory_result);
			System.out.println("word at address 24 is = "
					+ memory_unit.load_word(24));

			current_step++;
			break;
		case 4:
			// Write back stage

			write_back_stage();
			gui.set_write_back_red();

			System.out.println("Register s2 is now equal " + register_file.get_register(18));
			System.out.println("Register s3 is now equal " + register_file.get_register(RegisterMapper.map_to_index("s3")));
			
			System.out.println("========");

			current_step = 0;
			break;
		}
	}
	
	public void run_instruction() throws Exception{
		if (pc >> 2 < raw_instructions.size()){
			while(current_step<4)
				run_step();
			run_step();
		}
	}
	
	public void run_all_instructions() throws Exception{
		// Loop over all instructions executing one by one
		while (pc >> 2 < raw_instructions.size()) {
			run_instruction();
		}
	}

	private static void welcome_message() {
		System.out.println("Hello World! --Git Style ;)");
	}

	private void initialize_values() {
		
		gui = new MainView(this);
		
		pc = 0; // change this, can allow different start values
		current_step = 0;
		current_raw_instruction = "";
		current_instruction = new Instruction();

		raw_instructions = new ArrayList<String>();
		register_file = new RegisterFile();
		register_file.test_data();
		gui.fillRegisters(register_file.get_register_file());

		label_map = new Hashtable<String, Integer>();

		logic_unit = new LogicUnit();
		logic_unit.set_sim(this);

		memory_unit = new MemoryUnit();

		RegisterMapper.populate();

	}

	private void load_data() throws IOException {
/*		Random r = new Random();
		for (int i = 0; i < memory_unit.size(); i += 4) {
			memory_unit.store_word(i, i);
		}*/
		InputStream input = getClass().getResourceAsStream("Data 1.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line = "";
		while (((line = br.readLine())) != null) {
			StringTokenizer st = new StringTokenizer(line,",");
			memory_unit.store_word(Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()));
		}
		
		gui.fillMemory(memory_unit.get_memory());

	}

	private void load_instructions() throws IOException {

		/*
		 * String instruction = "add s2, s0, s1";
		 * raw_instructions.add(instruction);
		 * 
		 * instruction = "lw s2, 4(s2)"; raw_instructions.add(instruction);
		 * 
		 * instruction = "sub s2, s2, s0"; raw_instructions.add(instruction);
		 * 
		 * instruction = "addi s2, s2, 1"; raw_instructions.add(instruction);
		 */
		InputStream input = getClass().getResourceAsStream("Program 1.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String line = "";
		while (((line = br.readLine())) != null) {
			raw_instructions.add(line);
		}
		map_labels();
		gui.addInstructions(raw_instructions);
	}
	
	private void map_labels(){
		int i =0;
		ArrayList<String> rep = new ArrayList<String>();
		for(String str : raw_instructions){
			if(str.contains(":")){
				StringTokenizer st = new StringTokenizer(str, ":");
				label_map.put(st.nextToken(), i);
//				if (st.countTokens()>0){
//					rep.add(st.nextToken());
//				}
			}
			else {
				rep.add(str);
				i+=4;
			}
		}
		raw_instructions = rep;
	}

	private void fetch_stage() {
		current_raw_instruction = raw_instructions.get(counter);
		pc += 4;
		counter = pc >> 2;
	}

	private void decode_stage() {
		current_instruction = new Instruction(current_raw_instruction,
				label_map);
	}
	
	private void execute_stage(){
		switch(current_instruction.get_format()){
		case 4:
			write_back_value = pc;
			write_to_pc(current_instruction.get_immediate_value());
			break;
		case 5:
			write_to_pc(current_instruction.get_rs());
			break;
		case 3:
			alu_result = logic_unit.execute(current_instruction);
			System.out.println("ALU Signal is "+signal_alu_zero);
			if (signal_alu_zero){
				write_to_pc(current_instruction.get_immediate_value());
			}
			break;
		default:
			alu_result = logic_unit.execute(current_instruction);
			break;
		}
	}
	
	private void write_to_pc(int value){
		pc = value;
		counter = pc >> 2;
	}

	private void memory_stage() {
		InstructionType type = current_instruction.get_type();
		int rt;
		
		switch (type) {
		case lw:
			memory_result = memory_unit.load_word(alu_result);
			break;
		case lh:
			memory_result = memory_unit.load_half_word(alu_result);
			break;
		case lhu:
			memory_result = memory_unit.load_half_word_unsigned(alu_result);
			break;
		case lb:
			memory_result = memory_unit.load_byte(alu_result);
			break;
		case lbu:
			memory_result = memory_unit.load_byte_unsigned(alu_result);
			break;
		case sw:
			rt = register_file.get_register(current_instruction.get_rt());
			memory_unit.store_word(alu_result, rt);
			break;
		case sh:
			rt = register_file.get_register(current_instruction.get_rt());
			memory_unit.store_half_word(alu_result, rt);
			break;
		case sb:
			rt= register_file.get_register(current_instruction.get_rt());
			memory_unit.store_byte(alu_result, rt);
			break;
		default:

		}
		memory_unit.print();
	}

	private void write_back_stage() throws Exception {

		int format = current_instruction.get_format();
		switch (format) {
		case 0:
			write_back_value = alu_result;
			write_register();
			break;
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
		gui.fillRegisters(register_file.get_register_file());
	}

	private void write_register() throws Exception {
		try {
			register_file.write_register(
					current_instruction.get_write_register(), write_back_value);
		} catch (WriteNotAllowedException e) {
			// See how to handle exception
		}
	}


	public void set_alu_zero() {
		signal_alu_zero = true;
	}

	public void reset_alu_zero() {
		signal_alu_zero = false;
	}

	public void clear_signals() {

	}

	public int get_current_instruction_format() {
		// TODO Auto-generated method stub
		return current_instruction.get_format();
	}

}
