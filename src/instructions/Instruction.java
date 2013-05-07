package instructions;

import java.util.StringTokenizer;

public class Instruction {
	
	InstructionType type;
	
	int rs;
	int rt;
	
	int address;
	
	int rd;
	int shamt;
	int funct;
	
	public Instruction(){
		
	}
	
	public Instruction (String raw_instruction){
		decode_instruction(raw_instruction);
	}
	
	public void decode_instruction(String raw_instruction){
		//StringTokenizer st = new StringTokenizer(raw_instruction,",");
		
		//For now:
		type = InstructionType.add;
	}

}
