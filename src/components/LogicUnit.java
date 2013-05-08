package components;

import exceptions.*;
import instructions.*;
import simulator.*;

public class LogicUnit {
	
	
	Simulator simulator;
	RegisterFile register_file;
	
	Instruction inst;
	
	int result;
	
	public void set_sim(Simulator sim){
		this.simulator = sim;
	}
	
	public int execute(Instruction inst){
		
		this.inst = inst;
		
		InstructionType type = inst.get_type();
		int format = inst.get_format();
		
		/*String string = "";
		
		switch(string){
		
		}*/
		
		switch(format){
			case 0:{
				if (r_format()){
					return result;
				}
				break;
			}
		}
		
		
/*		switch(type){
			case add:{
				add();
				break;
			}
		}*/
		
		return 0;
	}
	
	public boolean r_format(){
		
		int rs, rt, rd;
		
		try{
			rs = register_file.get_register(inst.get_rs());
			rt = register_file.get_register(inst.get_rt());
			register_file.validate_index(inst.get_rd());
		} catch (RegisterOutOfBoundsException e) {
			e.printStackTrace();
			return false;
		}
				
		switch(inst.get_type()){
			case add:{
				result = rs + rt;
				break;
			}
			case sub:{
				result = rs - rt;
				break;
			}
			case or:{
				result = rs | rt;
				break;
			}
			default:{
				//throw illegal arguments exception
				break;
			}
		}
		
		return true;
		
	}
	
/*	public void add(){
		
	}*/

}
