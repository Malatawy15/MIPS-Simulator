package instructions;

import heplers.RegisterMapper;

import java.util.StringTokenizer;

import components.RegisterFile;

public class Instruction {

	InstructionType type;
	int format;

	int rs;
	int rt;

	int address;

	int rd;
	int shamt;
	int funct;
	
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
		switch(format){
		case 0:
			if (type == InstructionType.jr){
			
			}
			else {
				rd = RegisterMapper.map_to_index(target.trim());
				rs = RegisterMapper.map_to_index(st.nextToken().trim());
				rt = RegisterMapper.map_to_index(st.nextToken().trim());
			}
			break;
		case 1:
			break;
		case 2:
			break;
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
		
		if (str.equals("add")) {
			type = InstructionType.add;
			format = 0;
		} else if (str.equals("addi")) {
			type = InstructionType.addi;
			format = 0;
			immediate = true;
		} else if (str.equals("sub")) {
			type = InstructionType.sub;
			format = 0;
		} else if (str.equals("lw")) {
			type = InstructionType.lw;
			format = 1;
		} else if (str.equals("lh")) {
			type = InstructionType.lh;
			format = 1;
		} else if (str.equals("lhu")) {
			type = InstructionType.lhu;
			format = 1;
		} else if (str.equals("lb")) {
			type = InstructionType.lb;
			format = 1;
		} else if (str.equals("lbu")) {
			type = InstructionType.lbu;
			format = 1;
		} else if (str.equals("sw")) {
			type = InstructionType.sw;
			format = 1;
		} else if (str.equals("sh")) {
			type = InstructionType.sh;
			format = 1;
		} else if (str.equals("sb")) {
			type = InstructionType.sb;
			format = 1;
		} else if (str.equals("lui")) {
			type = InstructionType.lui;
			format = 1;
			immediate = true;
		} else if (str.equals("sll")) {
			type = InstructionType.sll;
			format = 0;
		} else if (str.equals("srl")) {
			type = InstructionType.srl;
			format = 0;
		} else if (str.equals("and")) {
			type = InstructionType.and;
			format = 0;
		} else if (str.equals("andi")) {
			type = InstructionType.andi;
			format = 0;
			immediate = true;
		} else if (str.equals("or")) {
			type = InstructionType.or;
			format = 0;
		} else if (str.equals("ori")) {
			type = InstructionType.ori;
			format = 0;
			immediate = true;
		} else if (str.equals("nor")) {
			type = InstructionType.nor;
			format = 0;
		} else if (str.equals("beq")) {
			type = InstructionType.beq;
			format = 1;
		} else if (str.equals("bne")) {
			type = InstructionType.bne;
			format = 1;
		} else if (str.equals("j")) {
			type = InstructionType.j;
			format = 2;
		} else if (str.equals("jal")) {
			type = InstructionType.jal;
			format = 2;
		} else if (str.equals("jr")) {
			type = InstructionType.jr;
			format = 0;
		} else if (str.equals("slt")) {
			type = InstructionType.slt;
			format = 0;
		}
	}

}
