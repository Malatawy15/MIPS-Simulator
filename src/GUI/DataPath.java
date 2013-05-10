package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DataPath extends JPanel {
	
	InstructionMemory instructionMemory;
	Registers registers;
	DataMemory dataMemory;
	PC pc;
	ShiftLeft shiftLeft;
	ALU alu;
	Adder adder1;
	Adder adder2;
	SignExtend signExtend;
	Mux mux1;
	Mux mux2;
	Mux mux3;
	Wire[] pcToAdder1;
	Wire[] adder2ToPc;
	Wire pcToInstructionMemory;
	Wire adder2ToMux;
	Wire adder1ToAdder2;
	Wire[] adder1ToMux;
	Wire shifterToAdder2;
	Wire[] signExtendToShifter;
	Wire aluToDataMemory;
	Wire dataMemoryToMux;
	Wire muxToAlu;
	Wire registerToAlu;
	Wire[] aluToMux;
	Wire[] muxToRegisters;
	Wire siginExtendToMux;
	Wire[] registersToDataMemory;
	Wire registersToMux;
	Wire instructionMemoryOut;
	Wire[] registerIn;
	Wire[] signExtendIn;
	Wire adder1In;
	JLabel four;
	Mux mux4;
	Mux mux5;
	ShiftLeft shiftLeft2;
	Wire muxToMux;
	Wire[] instructionMemToShifter;
	Wire[] shifter2ToMux;
	Wire adder1ToShifter1;
	Control control;
	Wire[] regDst;
	Wire[] jump;
	Wire[] branch;
	Wire[] memRead;
	Wire[] memToReg;
	Wire[] aluOp;
	Wire[] memWrite;
	Wire[] aluSrc;
	Wire[] regWrite;

	/**
	 * Create the panel.
	 */
	public DataPath() {
		setLayout(null);
		instructionMemory = new InstructionMemory();
		instructionMemory.setBounds(180, 220, 140, 180);
		add(instructionMemory);
		registers = new Registers();
		registers.setBounds(400, 215, 190, 230);
		add(registers);
		dataMemory = new DataMemory();
		dataMemory.setBounds(900, 265, 160, 210);
		add(dataMemory);
		pc = new PC();
		pc.setBounds(100, 190, 50, 150);
		add(pc);
		shiftLeft = new ShiftLeft();
		shiftLeft.setBounds(650, 80, 90, 170);
		add(shiftLeft);
		alu = new ALU();
		alu.setBounds(700, 195, 190, 230);
		add(alu);
		adder1 = new Adder();
		adder1.setBounds(200, 50, 110, 170);
		add(adder1);
		adder2 = new Adder();
		adder2.setBounds(800, 80, 110, 170);
		add(adder2);
		signExtend = new SignExtend();
		signExtend.setBounds(470, 450, 110, 170);
		add(signExtend);
		mux1 = new Mux();
		mux1.setBounds(630, 280, 110, 170);
		add(mux1);
		mux2 = new Mux();
		mux2.setBounds(1070, 280, 110, 170);
		add(mux2);
		mux3 = new Mux();
		mux3.setBounds(880, 20, 110, 170);
		add(mux3);
		pcToAdder1 = new Wire[2];
		pcToAdder1[0] = new VerticalWire();
		pcToAdder1[0].setBounds(155, 80, 10, 175);
		add(pcToAdder1[0]);
		pcToAdder1[1] = new HorizontalWire();
		pcToAdder1[1].setBounds(159, 75, 47, 10);
		add(pcToAdder1[1]);
		pcToInstructionMemory = new HorizontalWire();
		pcToInstructionMemory.setBounds(145, 250, 40, 10);
		add(pcToInstructionMemory);
		adder2ToPc = new Wire[5];
		adder2ToPc[0] = new HorizontalWire();
		adder2ToPc[0].setBounds(70, 250, 35, 10);
		add(adder2ToPc[0]);
		adder2ToPc[1] = new VerticalWire();
		adder2ToPc[1].setBounds(65, 10, 10, 245);
		add(adder2ToPc[1]);
		adder2ToPc[2] = new HorizontalWire();
		adder2ToPc[2].setBounds(70, 5, 990, 10);
		add(adder2ToPc[2]);
		adder2ToPc[3] = new VerticalWire();
		adder2ToPc[3].setBounds(1055, 10, 10, 100);
		add(adder2ToPc[3]);
		adder2ToPc[4] = new HorizontalWire();
		adder2ToPc[4].setBounds(1025, 105, 35, 10);
		add(adder2ToPc[4]);
		adder2ToMux = new HorizontalWire();
		adder2ToMux.setBounds(865, 130, 55, 10);
		add(adder2ToMux);
		adder1ToAdder2 = new HorizontalWire();
		adder1ToAdder2.setBounds(265, 100, 540, 10);
		add(adder1ToAdder2);
		adder1ToMux = new Wire[2];
		adder1ToMux[0] = new VerticalWire();
		adder1ToMux[0].setBounds(700, 65, 10, 40);
		add(adder1ToMux[0]);
		adder1ToMux[1] = new HorizontalWire();
		adder1ToMux[1].setBounds(705, 60, 215, 10);
		add(adder1ToMux[1]);
		shifterToAdder2 = new HorizontalWire();
		shifterToAdder2.setBounds(725, 160, 80, 10);
		add(shifterToAdder2);
		signExtendToShifter = new Wire[3];
		signExtendToShifter[0] = new VerticalWire();
		signExtendToShifter[0].setBounds(615, 165, 10, 370);
		add(signExtendToShifter[0]);
		signExtendToShifter[1] = new HorizontalWire();
		signExtendToShifter[1].setBounds(620, 160, 45, 10);
		add(signExtendToShifter[1]);
		signExtendToShifter[2] = new HorizontalWire();
		signExtendToShifter[2].setBounds(565, 530, 55, 10);
		add(signExtendToShifter[2]);
		aluToDataMemory = new HorizontalWire();
		aluToDataMemory.setBounds(845, 330, 60, 10);
		add(aluToDataMemory);
		dataMemoryToMux = new HorizontalWire();
		dataMemoryToMux.setBounds(1055, 330,55, 10);
		add(dataMemoryToMux);
		muxToAlu = new HorizontalWire();
		muxToAlu.setBounds(700, 350, 45, 10);
		add(muxToAlu);
		registerToAlu = new HorizontalWire();
		registerToAlu.setBounds(585, 255, 160, 10);
		add(registerToAlu);
		aluToMux = new Wire[4];
		aluToMux[0] = new VerticalWire();
		aluToMux[0].setBounds(885, 335, 10, 170);
		add(aluToMux[0]);
		aluToMux[1] = new HorizontalWire();
		aluToMux[1].setBounds(890, 500, 190, 10);
		add(aluToMux[1]);
		aluToMux[2] = new VerticalWire();
		aluToMux[2].setBounds(1075, 395, 10, 110);
		add(aluToMux[2]);
		aluToMux[3] = new HorizontalWire();
		aluToMux[3].setBounds(1080, 390, 30, 10);
		add(aluToMux[3]);
		muxToRegisters = new Wire[4];
		muxToRegisters[0] = new VerticalWire();
		muxToRegisters[0].setBounds(425, 420, 10, 215);
		add(muxToRegisters[0]);
		muxToRegisters[1] = new HorizontalWire();
		muxToRegisters[1].setBounds(1140, 355, 40, 10);
		add(muxToRegisters[1]);
		muxToRegisters[2] = new VerticalWire();
		muxToRegisters[2].setBounds(1175, 360, 10, 275);
		add(muxToRegisters[2]);
		muxToRegisters[3] = new HorizontalWire();
		muxToRegisters[3].setBounds(430, 630, 750, 10);
		add(muxToRegisters[3]);
		siginExtendToMux = new HorizontalWire();
		siginExtendToMux.setBounds(620, 390, 50, 10);
		add(siginExtendToMux);
		registersToDataMemory = new Wire[2];
		registersToDataMemory[0] = new VerticalWire();
		registersToDataMemory[0].setBounds(590, 345, 10, 110);
		add(registersToDataMemory[0]);
		registersToDataMemory[1] = new HorizontalWire();
		registersToDataMemory[1].setBounds(595, 450, 310, 10);
		add(registersToDataMemory[1]);
		registersToMux = new HorizontalWire();
		registersToMux.setBounds(585, 340, 85, 10);
		add(registersToMux);
		instructionMemoryOut = new HorizontalWire();
		instructionMemoryOut.setBounds(315, 300, 30, 10);
		add(instructionMemoryOut);
		registerIn = new Wire[7];
		registerIn[0] = new VerticalWire();
		registerIn[0].setBounds(340, 250, 10, 110);
		add(registerIn[0]);
		registerIn[1] = new HorizontalWire();
		registerIn[1].setBounds(345, 245, 60, 10);
		add(registerIn[1]);
		registerIn[2] = new HorizontalWire();
		registerIn[2].setBounds(345, 300, 60, 10);
		add(registerIn[2]);
		registerIn[3] = new HorizontalWire();
		registerIn[3].setBounds(395, 355, 10, 10);
		add(registerIn[3]);
		registerIn[4] = new HorizontalWire();
		registerIn[4].setBounds(345, 380, 20, 10);
		add(registerIn[4]);
		registerIn[5] = new HorizontalWire();
		registerIn[5].setBounds(355, 330, 10, 10);
		add(registerIn[5]);
		registerIn[6] = new VerticalWire();
		registerIn[6].setBounds(350, 305, 10, 30);
		add(registerIn[6]);
		signExtendIn = new Wire[2];
		signExtendIn[0] = new VerticalWire();
		signExtendIn[0].setBounds(340, 360, 10, 175);
		add(signExtendIn[0]);
		signExtendIn[1] = new HorizontalWire();
		signExtendIn[1].setBounds(345, 530, 140, 10);
		add(signExtendIn[1]);
		adder1In = new HorizontalWire();
		adder1In.setBounds(150, 135, 55, 10);
		add(adder1In);
		
		four = new JLabel("4");
		four.setBounds(135, 132, 40, 15);
		add(four);
		
		mux4 = new Mux();
		mux4.setBounds(990, 55, 40, 100);
		add(mux4);
		mux5 = new Mux();
		mux5.setBounds(360, 310, 40, 100);
		add(mux5);
		shiftLeft2 = new ShiftLeft();
	    shiftLeft2.setBounds(350, 20, 80, 80);
		add(shiftLeft2);
		
		muxToMux = new HorizontalWire();
		muxToMux.setBounds(950, 120, 45, 10);
		add(muxToMux);
		
		instructionMemToShifter = new Wire[2];
		instructionMemToShifter[0] = new VerticalWire();
		instructionMemToShifter[0].setBounds(320, 65, 10, 240);
		add(instructionMemToShifter[0]);
		instructionMemToShifter[1] = new HorizontalWire();
		instructionMemToShifter[1].setBounds(325, 60, 35, 10);
		add(instructionMemToShifter[1]);
		
		shifter2ToMux = new Wire[3];
		shifter2ToMux[0] = new HorizontalWire();
		shifter2ToMux[0].setBounds(412, 30, 555, 10);
		add(shifter2ToMux[0]);
		shifter2ToMux[1] = new VerticalWire();
		shifter2ToMux[1].setBounds(962, 34, 10, 40);
		add(shifter2ToMux[1]);
		shifter2ToMux[2] = new HorizontalWire();
		shifter2ToMux[2].setBounds(966, 70, 30, 10);
		add(shifter2ToMux[2]);
		
		adder1ToShifter1 = new VerticalWire();
		adder1ToShifter1.setBounds(500, 35, 10, 70);
		add(adder1ToShifter1);
		
		control = new Control();
		control.setBounds(400, 75, 100, 200);
		add(control);
		
		regDst = new Wire[1];
		regDst[0] = new HorizontalWire();
		regDst[0].setText("RegDst");
		regDst[0].setBounds(480, 120, 50, 10);
		add(regDst[0]);
		jump = new Wire[1];
		jump[0] = new HorizontalWire();
		jump[0].setText("jump");
		jump[0].setBounds(485, 132, 50, 10);
		add(jump[0]);
		branch = new Wire[1];
		branch[0] = new HorizontalWire();
		branch[0].setText("branch");
		branch[0].setBounds(490, 144, 50, 10);
		add(branch[0]);
		memRead = new Wire[1];
		memRead[0] = new HorizontalWire();
		memRead[0].setText("MemRead ");
		memRead[0].setBounds(490, 156, 50, 10);
		add(memRead[0]);
		memToReg = new Wire[1];
		memToReg[0] = new HorizontalWire();
		memToReg[0].setText("MemtoReg");
		memToReg[0].setBounds(490, 168, 50, 10);
		add(memToReg[0]);
		aluOp = new Wire[1];
		aluOp[0] = new HorizontalWire();
		aluOp[0].setText("ALUOp");
		aluOp[0].setBounds(490, 180, 50, 10);
		add(aluOp[0]);
		memWrite = new Wire[1];
		memWrite[0] = new HorizontalWire();
		memWrite[0].setText("MemWrite");
		memWrite[0].setBounds(485, 192, 50, 10);
		add(memWrite[0]);
		aluSrc = new Wire[1];
		aluSrc[0] = new HorizontalWire();
		aluSrc[0].setText("ALUSrc");
		aluSrc[0].setBounds(480, 204, 70, 10);
		add(aluSrc[0]);
		regWrite = new Wire[1];
		regWrite[0] = new HorizontalWire();
		regWrite[0].setText("RegWrite");
		regWrite[0].setBounds(470, 216, 70, 10);
		add(regWrite[0]);
		
	}
	

	public static void main(String[] args) {
		DataPath p = new DataPath();
		JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.getContentPane().add(p);
		app.setSize(1500, 800);
		app.setVisible(true);
	}
	
	public InstructionMemory getInstructionMemory() {
		return instructionMemory;
	}


	/**
	 * @return the mux4
	 */
	public Mux getMux4() {
		return mux4;
	}


	/**
	 * @param mux4 the mux4 to set
	 */
	public void setMux4(Mux mux4) {
		this.mux4 = mux4;
	}


	/**
	 * @return the mux5
	 */
	public Mux getMux5() {
		return mux5;
	}


	/**
	 * @param mux5 the mux5 to set
	 */
	public void setMux5(Mux mux5) {
		this.mux5 = mux5;
	}


	/**
	 * @return the shiftLeft2
	 */
	public ShiftLeft getShiftLeft2() {
		return shiftLeft2;
	}


	/**
	 * @param shiftLeft2 the shiftLeft2 to set
	 */
	public void setShiftLeft2(ShiftLeft shiftLeft2) {
		this.shiftLeft2 = shiftLeft2;
	}


	/**
	 * @return the muxToMux
	 */
	public Wire getMuxToMux() {
		return muxToMux;
	}


	/**
	 * @param muxToMux the muxToMux to set
	 */
	public void setMuxToMux(Wire muxToMux) {
		this.muxToMux = muxToMux;
	}


	/**
	 * @return the instructionMemToShifter
	 */
	public Wire[] getInstructionMemToShifter() {
		return instructionMemToShifter;
	}


	/**
	 * @param instructionMemToShifter the instructionMemToShifter to set
	 */
	public void setInstructionMemToShifter(Wire[] instructionMemToShifter) {
		this.instructionMemToShifter = instructionMemToShifter;
	}


	/**
	 * @return the shifter2ToMux
	 */
	public Wire[] getShifter2ToMux() {
		return shifter2ToMux;
	}


	/**
	 * @param shifter2ToMux the shifter2ToMux to set
	 */
	public void setShifter2ToMux(Wire[] shifter2ToMux) {
		this.shifter2ToMux = shifter2ToMux;
	}


	/**
	 * @return the adder1ToShifter1
	 */
	public Wire getAdder1ToShifter1() {
		return adder1ToShifter1;
	}


	/**
	 * @param adder1ToShifter1 the adder1ToShifter1 to set
	 */
	public void setAdder1ToShifter1(Wire adder1ToShifter1) {
		this.adder1ToShifter1 = adder1ToShifter1;
	}


	/**
	 * @return the control
	 */
	public Control getControl() {
		return control;
	}


	/**
	 * @param control the control to set
	 */
	public void setControl(Control control) {
		this.control = control;
	}


	/**
	 * @return the regDst
	 */
	public Wire[] getRegDst() {
		return regDst;
	}


	/**
	 * @param regDst the regDst to set
	 */
	public void setRegDst(Wire[] regDst) {
		this.regDst = regDst;
	}


	/**
	 * @return the jump
	 */
	public Wire[] getJump() {
		return jump;
	}


	/**
	 * @param jump the jump to set
	 */
	public void setJump(Wire[] jump) {
		this.jump = jump;
	}


	/**
	 * @return the branch
	 */
	public Wire[] getBranch() {
		return branch;
	}


	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Wire[] branch) {
		this.branch = branch;
	}


	/**
	 * @return the memRead
	 */
	public Wire[] getMemRead() {
		return memRead;
	}


	/**
	 * @param memRead the memRead to set
	 */
	public void setMemRead(Wire[] memRead) {
		this.memRead = memRead;
	}


	/**
	 * @return the memToReg
	 */
	public Wire[] getMemToReg() {
		return memToReg;
	}


	/**
	 * @param memToReg the memToReg to set
	 */
	public void setMemToReg(Wire[] memToReg) {
		this.memToReg = memToReg;
	}


	/**
	 * @return the aluOp
	 */
	public Wire[] getAluOp() {
		return aluOp;
	}


	/**
	 * @param aluOp the aluOp to set
	 */
	public void setAluOp(Wire[] aluOp) {
		this.aluOp = aluOp;
	}


	/**
	 * @return the memWrite
	 */
	public Wire[] getMemWrite() {
		return memWrite;
	}


	/**
	 * @param memWrite the memWrite to set
	 */
	public void setMemWrite(Wire[] memWrite) {
		this.memWrite = memWrite;
	}


	/**
	 * @return the aluSrc
	 */
	public Wire[] getAluSrc() {
		return aluSrc;
	}


	/**
	 * @param aluSrc the aluSrc to set
	 */
	public void setAluSrc(Wire[] aluSrc) {
		this.aluSrc = aluSrc;
	}


	/**
	 * @return the regWrite
	 */
	public Wire[] getRegWrite() {
		return regWrite;
	}


	/**
	 * @param regWrite the regWrite to set
	 */
	public void setRegWrite(Wire[] regWrite) {
		this.regWrite = regWrite;
	}


	public void setInstructionMemory(InstructionMemory instructionMemory) {
		this.instructionMemory = instructionMemory;
	}


	public Registers getRegisters() {
		return registers;
	}


	public void setRegisters(Registers registers) {
		this.registers = registers;
	}


	public DataMemory getDataMemory() {
		return dataMemory;
	}


	public void setDataMemory(DataMemory dataMemory) {
		this.dataMemory = dataMemory;
	}


	public PC getPc() {
		return pc;
	}


	public void setPc(PC pc) {
		this.pc = pc;
	}


	public ShiftLeft getShiftLeft() {
		return shiftLeft;
	}


	public void setShiftLeft(ShiftLeft shiftLeft) {
		this.shiftLeft = shiftLeft;
	}


	public ALU getAlu() {
		return alu;
	}


	public void setAlu(ALU alu) {
		this.alu = alu;
	}


	public Adder getAdder1() {
		return adder1;
	}


	public void setAdder1(Adder adder1) {
		this.adder1 = adder1;
	}


	public Adder getAdder2() {
		return adder2;
	}


	public void setAdder2(Adder adder2) {
		this.adder2 = adder2;
	}


	public SignExtend getSignExtend() {
		return signExtend;
	}


	public void setSignExtend(SignExtend signExtend) {
		this.signExtend = signExtend;
	}


	public Mux getMux1() {
		return mux1;
	}


	public void setMux1(Mux mux1) {
		this.mux1 = mux1;
	}


	public Mux getMux2() {
		return mux2;
	}


	public void setMux2(Mux mux2) {
		this.mux2 = mux2;
	}


	public Mux getMux3() {
		return mux3;
	}


	public void setMux3(Mux mux3) {
		this.mux3 = mux3;
	}


	public Wire[] getPcToAdder1() {
		return pcToAdder1;
	}


	public void setPcToAdder1(Wire[] pcToAdder1) {
		this.pcToAdder1 = pcToAdder1;
	}


	public Wire[] getAdder2ToPc() {
		return adder2ToPc;
	}


	public void setAdder2ToPc(Wire[] adder2ToPc) {
		this.adder2ToPc = adder2ToPc;
	}


	public Wire getPcToInstructionMemory() {
		return pcToInstructionMemory;
	}


	public void setPcToInstructionMemory(Wire pcToInstructionMemory) {
		this.pcToInstructionMemory = pcToInstructionMemory;
	}


	public Wire getAdder2ToMux() {
		return adder2ToMux;
	}


	public void setAdder2ToMux(Wire adder2ToMux) {
		this.adder2ToMux = adder2ToMux;
	}


	public Wire getAdder1ToAdder2() {
		return adder1ToAdder2;
	}


	public void setAdder1ToAdder2(Wire adder1ToAdder2) {
		this.adder1ToAdder2 = adder1ToAdder2;
	}


	public Wire[] getAdder1ToMux() {
		return adder1ToMux;
	}


	public void setAdder1ToMux(Wire[] adder1ToMux) {
		this.adder1ToMux = adder1ToMux;
	}


	public Wire getShifterToAdder2() {
		return shifterToAdder2;
	}


	public void setShifterToAdder2(Wire shifterToAdder2) {
		this.shifterToAdder2 = shifterToAdder2;
	}


	public Wire[] getSignExtendToShifter() {
		return signExtendToShifter;
	}


	public void setSignExtendToShifter(Wire[] signExtendToShifter) {
		this.signExtendToShifter = signExtendToShifter;
	}


	public Wire getAluToDataMemory() {
		return aluToDataMemory;
	}


	public void setAluToDataMemory(Wire aluToDataMemory) {
		this.aluToDataMemory = aluToDataMemory;
	}


	public Wire getDataMemoryToMux() {
		return dataMemoryToMux;
	}


	public void setDataMemoryToMux(Wire dataMemoryToMux) {
		this.dataMemoryToMux = dataMemoryToMux;
	}


	public Wire getMuxToAlu() {
		return muxToAlu;
	}


	public void setMuxToAlu(Wire muxToAlu) {
		this.muxToAlu = muxToAlu;
	}


	public Wire getRegisterToAlu() {
		return registerToAlu;
	}


	public void setRegisterToAlu(Wire registerToAlu) {
		this.registerToAlu = registerToAlu;
	}


	public Wire[] getAluToMux() {
		return aluToMux;
	}


	public void setAluToMux(Wire[] aluToMux) {
		this.aluToMux = aluToMux;
	}


	public Wire[] getMuxToRegisters() {
		return muxToRegisters;
	}


	public void setMuxToRegisters(Wire[] muxToRegisters) {
		this.muxToRegisters = muxToRegisters;
	}


	public Wire getSiginExtendToMux() {
		return siginExtendToMux;
	}


	public void setSiginExtendToMux(Wire siginExtendToMux) {
		this.siginExtendToMux = siginExtendToMux;
	}


	public Wire[] getRegistersToDataMemory() {
		return registersToDataMemory;
	}


	public void setRegistersToDataMemory(Wire[] registersToDataMemory) {
		this.registersToDataMemory = registersToDataMemory;
	}


	public Wire getRegistersToMux() {
		return registersToMux;
	}


	public void setRegistersToMux(Wire registersToMux) {
		this.registersToMux = registersToMux;
	}


	public Wire getInstructionMemoryOut() {
		return instructionMemoryOut;
	}


	public void setInstructionMemoryOut(Wire instructionMemoryOut) {
		this.instructionMemoryOut = instructionMemoryOut;
	}


	public Wire[] getRegisterIn() {
		return registerIn;
	}


	public void setRegisterIn(Wire[] registerIn) {
		this.registerIn = registerIn;
	}


	public Wire[] getSignExtendIn() {
		return signExtendIn;
	}


	public void setSignExtendIn(Wire[] signExtendIn) {
		this.signExtendIn = signExtendIn;
	}


	public Wire getAdder1In() {
		return adder1In;
	}


	public void setAdder1In(Wire adder1In) {
		this.adder1In = adder1In;
	}


	public JLabel getFour() {
		return four;
	}


	public void setFour(JLabel four) {
		this.four = four;
	}
}
