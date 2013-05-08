package instructions;

import helpers.RegisterMapper;

import java.util.Hashtable;
import java.util.StringTokenizer;

public class Instruction {

	InstructionType type;
	int format;

	int rs;
	int rt;

	int immediate_value; 
	
	int target_address;

	int rd;
	int shamt;
	int funct;
	
	boolean immediate;

	public Instruction() {

	}

	public Instruction(String raw_instruction, Hashtable<String, Integer> label_map) {
		decode_instruction(raw_instruction, label_map);
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

	public void decode_instruction(String raw_instruction, Hashtable<String, Integer> label_map) {
		StringTokenizer st = new StringTokenizer(raw_instruction, ",");
		StringTokenizer st1 = new StringTokenizer(st.nextToken());
		String ins_type = st1.nextToken().trim(), target = st1.nextToken()
				.trim();
		get_class(ins_type);

		switch(format){
		case 0:
			rd = RegisterMapper.map_to_index(target.trim());
			rs = RegisterMapper.map_to_index(st.nextToken().trim());
			if (immediate){
				immediate_value = Integer.parseInt(st.nextToken().trim());
			}
			else{
				rt = RegisterMapper.map_to_index(st.nextToken().trim());
			}
			break;
		case 1:
			rt = RegisterMapper.map_to_index(target.trim());
			if (immediate){
				immediate_value = Integer.parseInt(st.nextToken().trim());
			}
			else{
				StringTokenizer st2 = new StringTokenizer(st.nextToken(),"(");
				immediate_value = Integer.parseInt(st2.nextToken().trim());
				rs = RegisterMapper.map_to_index(st2.nextToken().trim());
			}
			break;
		case 2:
			rt = RegisterMapper.map_to_index(target.trim());
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),"(");
			immediate_value = Integer.parseInt(st2.nextToken().trim());
			rs = RegisterMapper.map_to_index(st2.nextToken().trim());
			break;
		case 3:
			rs = Integer.parseInt(target.trim());
			rt = Integer.parseInt(st.nextToken().trim());
			immediate_value = label_map.get(st.nextToken().trim()); 
			break;
		case 4:
			immediate_value = label_map.get(target.trim());
			break;
		case 5:
			rs = Integer.parseInt(target.trim());
			break;
		}
	}

	@SuppressWarnings("incomplete-switch")
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
