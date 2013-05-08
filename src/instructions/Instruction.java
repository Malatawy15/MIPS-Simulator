package instructions;

import heplers.RegisterMapper;

import java.util.StringTokenizer;

import components.RegisterFile;

public class Instruction {

	public InstructionType type;
	int format;

	public int rs;
	public int rt;

	public short immediate_value;

	public int labelJump = 0;
	int rd;
	public int shamt;
	int funct;
	public int value;

	boolean immediate;

	public Instruction() {

	}

	public Instruction(String raw_instruction) {
		decode_instruction(raw_instruction);
	}
	
	public InstructionType get_type(){
		return type;
	}
	
	public int get_rd(){
		return rd;
	}
	
	public int get_rs(){
		return rs;
	}
	
	public int get_rt(){
		return rt;
	}
	
	public int get_format(){
		return format;
	}

	public void decode_instruction(String raw_instruction) {
		StringTokenizer st = new StringTokenizer(raw_instruction, ",");
		StringTokenizer st1 = new StringTokenizer(st.nextToken());
		String ins_type = st1.nextToken().trim(), target = st1.nextToken()
				.trim();
		get_class(ins_type);
		if (format==0){
			rd = RegisterMapper.map_to_index(st.nextToken().trim());
			rs = RegisterMapper.map_to_index(st.nextToken().trim());
			rt = RegisterMapper.map_to_index(st.nextToken().trim());
		}
		else if (format==1){
			
		}else if (format==2){
			
		}
//		if (st.countTokens() > 0) {
//			rs = RegisterFile.get_register(st.nextToken().trim());
//			if (st.countTokens() > 0) {
//				rt = RegisterFile.get_register(st.nextToken().trim());
//				if (st.countTokens() > 0) {
//					rd = RegisterFile.get_register(st.nextToken().trim());
//				}
//			}
//		}

	}

	private void get_class(String str) {
		
		str = str.toLowerCase();
		type = InstructionType.valueOf(str);
		
		switch(type){
			case add: 
			case and: 
			case sub:
			case sll:
			case srl:
			case or:
			case nor:
			case slt:
				format = 0;
				break;
			case addi:
			case andi:
			case ori:
				format = 0;
				immediate = true;
				break;
			case lw:
			case lh:
			case lhu:
			case lb:
			case lbu:
				format = 1;
				break;
			case lui:
				format = 1;
				immediate = true;
				break;
			case sw:
			case sh:
				format = 2;
				break;
			case beq:
			case bne:
				format = 3;
				break;
			case j:
			case jal:
				format = 4;
				break;
			case jr:
				format = 5; // Should change that they all have same value?
				break;

		}
			
	}

}
