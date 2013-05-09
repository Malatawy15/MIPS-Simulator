package components;

import exceptions.*;
import instructions.*;
import simulator.*;

public class LogicUnit {

	Simulator simulator;
	RegisterFile register_file;

	Instruction inst;

	int result;

	public void set_sim(Simulator sim) {
		this.simulator = sim;
		this.register_file = sim.get_register_file();
	}

	public int execute(Instruction inst) {

		this.inst = inst;

		InstructionType type = inst.get_type();
		int format = inst.get_format();

		switch (format) {
		case 0:
			if (r_format())
				return result;
			break;
		case 1:
			if (memory_format())
				return result;
			break;
		case 2:
			if (memory_format())
				return result;
			break;
		// branch case
		// if the branch condition is true then : PC <- PC + 4 + (sign-extended
		// immediate field)<<2.
		// two types : bne , beq
		case 3:
			branch_format();
			return 0;
		case 4:
			// j and jal , there is no ALU as they only update the PC ==> 'PC <-
			// target address'
		case 5:
			// jr => Sets only the value of PC to the value of the 'rs' register
		}

		return 0;
	}

	public boolean r_format() {

		int rs, rt, rd;

		try {
			rs = register_file.get_register(inst.get_rs());
			rt = register_file.get_register(inst.get_rt());
			register_file.validate_index(inst.get_rd());
		} catch (RegisterOutOfBoundsException e) {
			e.printStackTrace();
			return false;
		}

		switch (inst.get_type()) {
		case add:
			result = rs + rt;
			break;
		case sub:
			result = rs - rt;
			break;
		case or:
			result = rs | rt;
			break;
		case sll:
			result = rs << inst.get_shamt();
			break;
		case srl:
			result = rs >> inst.get_shamt();
			break;
		case addi:
			result = rs + inst.get_immediate_value();
			break;
		case and:
			result = rt & rs;
			break;
		case ori:
			result = rs | inst.get_immediate_value();
			break;
		case andi:
			result = rs & inst.get_immediate_value();
			break;
		case nor:
			result = ~(rs | rt);
			break;
		case slt:
			result = rs < rt ? 1 : 0;
			break;
		default: // throw illegal arguments exception
			break;
		}

		return true;

	}
	
	public boolean memory_format() {

		int rs;
		int immediate_value = inst.get_immediate_value(); // Automatically sign
															// extended?

		try {
			rs = register_file.get_register(inst.get_rs());
		} catch (RegisterOutOfBoundsException e) {
			e.printStackTrace();
			return false;
		}
		result = rs + immediate_value;

		return true;
	}
	
	private boolean branch_format() {
		
		int rs, rt;
		
		try {
			rs = register_file.get_register(inst.get_rs());
			rt = register_file.get_register(inst.get_rt());
			register_file.validate_index(inst.get_rd());
		} catch (RegisterOutOfBoundsException e) {
			e.printStackTrace();
			return false;
		}
		
		switch (inst.get_type()){
		case beq :
			if(rs == rt)
				simulator.set_alu_zero();
			break;
		case bne: 
			if(rs != rt)
				simulator.set_alu_zero();
			break;
		}
	
		return true;

	}

}
