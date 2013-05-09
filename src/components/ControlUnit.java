package components;

import instructions.Instruction;
import instructions.InstructionType;

public class ControlUnit {

	boolean reg_dest; //rem.
	boolean jump;
	boolean branch;
	boolean mem_read;
	boolean mem_to_reg;
	boolean alu_op; //rem.
	boolean mem_write;
	boolean alu_src; //rem.
	boolean reg_write;
	
	public ControlUnit(){
		
	}
	
	public void clear_signals(){
		set_reg_dest(false);
		set_jump(false);
		set_branch(false);
		set_mem_read(false);
		set_mem_to_reg(false);
		set_alu_op(false);
		set_mem_write(false);
		set_alu_src(false);
		set_reg_write(false);
	}
	
	public void generate_signals(Instruction current_instruction){
		clear_signals();
		switch(current_instruction.get_format()){
		case 0:
			set_reg_write(true);
			break;
		case 1:
			set_reg_write(true);
			set_mem_read(true);
			set_mem_to_reg(true);
			break;
		case 2:
			set_mem_write(true);
			break;
		case 3:
			set_branch(true);
			break;
		case 4:
			set_jump(true);
			if (current_instruction.get_type() == InstructionType.jal){
				set_reg_write(true);
			}
			break;
		case 5:
			set_reg_write(true);
			set_jump(true);
			break;
		}
	}
	
	/**
	 * @return the reg_dest
	 */
	public boolean get_reg_dest() {
		return reg_dest;
	}
	/**
	 * @param reg_dest the reg_dest to set
	 */
	public void set_reg_dest(boolean reg_dest) {
		this.reg_dest = reg_dest;
	}
	
	
	/**
	 * @return the jump
	 */
	public boolean get_jump() {
		return jump;
	}
	/**
	 * @param jump the jump to set
	 */
	public void set_jump(boolean jump) {
		this.jump = jump;
	}
	
	
	/**
	 * @return the branch
	 */
	public boolean get_branch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void set_branch(boolean branch) {
		this.branch = branch;
	}
	
	
	/**
	 * @return the mem_read
	 */
	public boolean get_mem_read() {
		return mem_read;
	}
	/**
	 * @param mem_read the mem_read to set
	 */
	public void set_mem_read(boolean mem_read) {
		this.mem_read = mem_read;
	}
	
	
	/**
	 * @return the mem_to_reg
	 */
	public boolean get_mem_to_reg() {
		return mem_to_reg;
	}
	/**
	 * @param mem_to_reg the mem_to_reg to set
	 */
	public void set_mem_to_reg(boolean mem_to_reg) {
		this.mem_to_reg = mem_to_reg;
	}
	
	
	/**
	 * @return the alu_op
	 */
	public boolean get_alu_op() {
		return alu_op;
	}
	/**
	 * @param alu_op the alu_op to set
	 */
	public void set_alu_op(boolean alu_op) {
		this.alu_op = alu_op;
	}
	
	
	/**
	 * @return the mem_write
	 */
	public boolean get_mem_write() {
		return mem_write;
	}
	/**
	 * @param mem_write the mem_write to set
	 */
	public void set_mem_write(boolean mem_write) {
		this.mem_write = mem_write;
	}
	
	
	/**
	 * @return the alu_src
	 */
	public boolean get_alu_src() {
		return alu_src;
	}
	/**
	 * @param alu_src the alu_src to set
	 */
	public void set_alu_src(boolean alu_src) {
		this.alu_src = alu_src;
	}
	
	
	/**
	 * @return the reg_write
	 */
	public boolean get_reg_write() {
		return reg_write;
	}
	/**
	 * @param reg_write the reg_write to set
	 */
	public void set_reg_write(boolean reg_write) {
		this.reg_write = reg_write;
	}
	
}
