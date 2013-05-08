package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DataPath extends JPanel {

	InstructionMemory instructionMemory;
	public InstructionMemory getInstructionMemory() {
		return instructionMemory;
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

	/**
	 * Create the panel.
	 */
	public DataPath() {
		setLayout(null);
		instructionMemory = new InstructionMemory();
		instructionMemory.setBounds(180, 220, 140, 180);
		add(instructionMemory);
		registers = new Registers();
		registers.setBounds(400, 195, 190, 230);
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
		adder2ToPc[1].setBounds(65, 30, 10, 225);
		add(adder2ToPc[1]);
		adder2ToPc[2] = new HorizontalWire();
		adder2ToPc[2].setBounds(70, 25, 950, 10);
		add(adder2ToPc[2]);
		adder2ToPc[3] = new VerticalWire();
		adder2ToPc[3].setBounds(1014, 30, 10, 80);
		add(adder2ToPc[3]);
		adder2ToPc[4] = new HorizontalWire();
		adder2ToPc[4].setBounds(950, 105, 70, 10);
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
		muxToRegisters = new Wire[5];
		muxToRegisters[0] = new VerticalWire();
		muxToRegisters[0].setBounds(375, 380, 10, 255);
		add(muxToRegisters[0]);
		muxToRegisters[1] = new HorizontalWire();
		muxToRegisters[1].setBounds(1140, 355, 40, 10);
		add(muxToRegisters[1]);
		muxToRegisters[2] = new VerticalWire();
		muxToRegisters[2].setBounds(1175, 360, 10, 275);
		add(muxToRegisters[2]);
		muxToRegisters[3] = new HorizontalWire();
		muxToRegisters[3].setBounds(380, 375, 25, 10);
		add(muxToRegisters[3]);
		muxToRegisters[4] = new HorizontalWire();
		muxToRegisters[4].setBounds(380, 630, 800, 10);
		add(muxToRegisters[4]);
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
		registerIn = new Wire[4];
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
		registerIn[3].setBounds(345, 355, 60, 10);
		add(registerIn[3]);
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
		
	}
	

	public static void main(String[] args) {
		DataPath p = new DataPath();
		JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.getContentPane().add(p);
		app.setSize(1500, 800);
		app.setVisible(true);
	}
}
