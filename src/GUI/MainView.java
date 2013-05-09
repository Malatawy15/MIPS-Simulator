package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JScrollPane instructionMemory;
	private JPanel panel;
	private JScrollPane dataMemory;
	private JPanel panel2;
	private JScrollPane registers;
	private JPanel panel3;
	private ArrayList<String> instructions;
	private ArrayList<JLabel> instructionLabels;
	private int[] registerValues;
	private byte[] memory;
	private JPanel panel_1;
	private JPanel panel_2;
	private JFrame datapathFrame;
	private DataPath datapath;
	private JButton next;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<String> a = new ArrayList<String>();
					for(int i = 0; i < 50; i++)
						a.add("A");
					int[] a2 = new int[32];
					byte[] a3 = new byte[30];
					MainView frame = new MainView(a,a2, a3);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1040, 10, 550, 400);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		datapath = new DataPath();
		
		datapathFrame = new JFrame();
		datapathFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		datapathFrame.setBounds(10, 150, 1250, 700);
		datapathFrame.add(datapath);
		datapathFrame.setVisible(true);
		
		instructionMemory = new JScrollPane();
		instructionMemory.setBounds(10, 50, 190, 300);
		contentPane.add(instructionMemory);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		instructionMemory.setViewportView(panel);
		
		
		dataMemory = new JScrollPane();
		dataMemory.setBounds(220, 50, 110, 300);
		contentPane.add(dataMemory);
		
		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		dataMemory.setViewportView(panel2);
		
		
		registers = new JScrollPane();
		registers.setBounds(350, 50, 190, 300);
		contentPane.add(registers);
		
		panel3 = new JPanel();
		panel3.setBorder(new LineBorder(new Color(0, 0, 0)));
		registers.setViewportView(panel3);
		
		panel_1 = new JPanel();
		panel3.add(panel_1);
		
		panel_2 = new JPanel();
		panel3.add(panel_2);
		
		next = new JButton("next step");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		next.setBounds(10, 10, 120, 20);
		contentPane.add(next);
		
	}
	
	public MainView(ArrayList<String> instructions,int[] registerValues,byte[] memory){
		this();
		this.instructions = instructions;
		this.registerValues = registerValues;
		this.memory = memory;
		instructionLabels = new ArrayList<JLabel>();
		panel.setLayout(new GridLayout(instructions.size(), 1, 0, 0));
		panel2.setLayout(new GridLayout(memory.length, 1, 0, 0));
		panel3.setLayout(new GridLayout(1, 2, 0, 0));
		panel_1.setLayout(new GridLayout(32, 1, 0, 0));
		panel_1.add(new JLabel("$zero"));
		panel_1.add(new JLabel("$at"));
		panel_1.add(new JLabel("$v0"));
		panel_1.add(new JLabel("$v1"));
		panel_1.add(new JLabel("$a0"));
		panel_1.add(new JLabel("$a1"));
		panel_1.add(new JLabel("$a2"));
		panel_1.add(new JLabel("$a3"));
		panel_1.add(new JLabel("$t0"));
		panel_1.add(new JLabel("$t1"));
		panel_1.add(new JLabel("$t2"));
		panel_1.add(new JLabel("$t3"));
		panel_1.add(new JLabel("$t4"));
		panel_1.add(new JLabel("$t5"));
		panel_1.add(new JLabel("$t6"));
		panel_1.add(new JLabel("$t7"));
		panel_1.add(new JLabel("$s0"));
		panel_1.add(new JLabel("$s1"));
		panel_1.add(new JLabel("$s2"));
		panel_1.add(new JLabel("$s3"));
		panel_1.add(new JLabel("$s4"));
		panel_1.add(new JLabel("$s5"));
		panel_1.add(new JLabel("$s6"));
		panel_1.add(new JLabel("$s7"));
		panel_1.add(new JLabel("$t8"));
		panel_1.add(new JLabel("$t9"));
		panel_1.add(new JLabel("$k0"));
		panel_1.add(new JLabel("$k1"));
		panel_1.add(new JLabel("$gp"));
		panel_1.add(new JLabel("$sp"));
		panel_1.add(new JLabel("$fp"));
		panel_1.add(new JLabel("$ra"));
		panel_2.setLayout(new GridLayout(32, 1, 0, 0));
		for(int i=0 ; i<instructions.size();i++){
			JLabel l = new JLabel(instructions.get(i));
			panel.add(l);
			instructionLabels.add(l);
		}
		for(int i=0 ; i<memory.length;i++){
			JLabel l = new JLabel(memory[i] + "");
			l.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2.add(l);
			
		}
		for(int i=0 ; i<registerValues.length;i++){
			JLabel l = new JLabel(registerValues[i] + "");
			l.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_2.add(l);
		}
		selectInstruction(0);
	}
	
	public void selectInstruction(int pc){
		instructionLabels.get(pc).setForeground(Color.red);
	}
}
