package kalkulatori ;
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;

public class Calculator extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	

	private JTextField txtDisplay;
	private JTextField textField;
	
	
	double firstNum;
	double secondNum;
	double result;
	
	String operations;
	String answer;
	
	

	private JTextField display;
	
	
		//launching the application

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creating the application
	public Calculator() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/calculator-icon.png"));
		setFont(new Font("Ubuntu", Font.PLAIN, 12));
		setTitle("Calculator");
		initialize();
	}

	//initializing the application
	private void initialize() {
		
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 380);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Ubuntu Light", Font.ITALIC, 11));
		menuBar.setBackground(new Color(255, 255, 255));
		
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Ubuntu Light", Font.PLAIN, 12));
		mnFile.setForeground(new Color(0, 0, 0));
		mnFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnFile);
		
		JMenuItem mntmStandard = new JMenuItem("Standard");
		mntmStandard.setSelected(true);
		mntmStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setTitle("Standard Calculator");
				setBounds(100, 100, 361, 380);
				txtDisplay.setBounds(5, 30, 350, 70);
			}
		});
		mntmStandard.setFont(new Font("Ubuntu Light", Font.PLAIN, 11));
		mntmStandard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnFile.add(mntmStandard);
		
		JMenuItem mntmScientific = new JMenuItem("Scientific");
		mntmScientific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setTitle("Scientific Calculator");
				setBounds(100, 100, 680, 380);
				txtDisplay.setBounds(5, 30, 350, 70);
			}
		});
		mntmScientific.setFont(new Font("Ubuntu Light", Font.PLAIN, 11));
		mntmScientific.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnFile.add(mntmScientific);
		

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setFont(new Font("Ubuntu Light", Font.PLAIN, 11));
		mntmExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnFile.add(mntmExit);
		
		JLabel lblByGhassenBen = new JLabel("By Bleon and Eljon");
		lblByGhassenBen.setFont(new Font("Ubuntu Light", Font.PLAIN, 10));
		lblByGhassenBen.setForeground(new Color(0, 0, 0));
		menuBar.add(lblByGhassenBen);
	
		
		
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBackground(new Color(236,236,236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setBounds(5, 30, 350, 70);
		contentPane.add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_0.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_0.setBounds(10, 306, 136, 23);
		btn_0.setFont(new Font("Arial", Font.BOLD, 10));
		btn_0.setBackground(new Color(108, 122, 137));
		btn_0.setForeground(Color.WHITE);
		contentPane.add(btn_0);
		
		JButton btn_back = new JButton("\u25C4");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String backspace = null;
				
				if (txtDisplay.getText().length() > 0) {
					StringBuilder strB = new StringBuilder(txtDisplay.getText());
					strB.deleteCharAt(txtDisplay.getText().length() -1);
					backspace = strB.toString();
					txtDisplay.setText(backspace);
				}
			}
		});
		btn_back.setFont(new Font("Arial", Font.BOLD, 10));
		btn_back.setBackground(new Color(108, 122, 137));
		btn_back.setForeground(Color.WHITE);
		btn_back.setBounds(10, 146, 63, 23);
		contentPane.add(btn_back);
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String iNum = txtDisplay.getText() + btn_7.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_7.setBounds(10, 186, 63, 23);
		btn_7.setFont(new Font("Arial", Font.BOLD, 10));
		btn_7.setBackground(new Color(108, 122, 137));
		btn_7.setForeground(Color.WHITE);
		contentPane.add(btn_7);
		
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iNum = txtDisplay.getText() + btn_4.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_4.setBounds(10, 226, 63, 23);
		btn_4.setFont(new Font("Arial", Font.BOLD, 10));
		btn_4.setBackground(new Color(108, 122, 137));
		btn_4.setForeground(Color.WHITE);
		
		contentPane.add(btn_4);
		
		JButton btnCe = new JButton("\u0152");
		btnCe.setBounds(80, 146, 63, 23);
		btnCe.setFont(new Font("Arial", Font.BOLD, 10));
		btnCe.setBackground(new Color(108, 122, 137));
		btnCe.setForeground(Color.WHITE);
		contentPane.add(btnCe);
		
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_8.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_8.setBounds(80, 186, 63, 23);
		btn_8.setFont(new Font("Arial", Font.BOLD, 10));
		btn_8.setBackground(new Color(108, 122, 137));
		btn_8.setForeground(Color.WHITE);
		contentPane.add(btn_8);
		
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_5.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_5.setBounds(80, 226, 63, 23);
		btn_5.setFont(new Font("Arial", Font.BOLD, 10));
		btn_5.setBackground(new Color(108, 122, 137));
		btn_5.setForeground(Color.WHITE);
		contentPane.add(btn_5);
		
		JButton btn_clear = new JButton("C");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDisplay.setText(null);
			}
		});
		btn_clear.setBounds(150, 146, 63, 23);
		btn_clear.setFont(new Font("Arial", Font.BOLD, 10));
		btn_clear.setBackground(new Color(108, 122, 137));
		btn_clear.setForeground(Color.WHITE);
		contentPane.add(btn_clear);
		
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_9.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_9.setBounds(150, 186, 63, 23);
		btn_9.setFont(new Font("Arial", Font.BOLD, 10));
		btn_9.setBackground(new Color(108, 122, 137));
		btn_9.setForeground(Color.WHITE);
		contentPane.add(btn_9);
		
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_6.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_6.setBounds(150, 226, 63, 23);
		btn_6.setFont(new Font("Arial", Font.BOLD, 10));
		btn_6.setBackground(new Color(108, 122, 137));
		btn_6.setForeground(Color.WHITE);
		contentPane.add(btn_6);
		
		JButton button_plusless = new JButton("\u00B1");
		button_plusless.setForeground(new Color(255, 255, 255));
		button_plusless.setBackground(new Color(108, 122, 137));
		button_plusless.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = ops * (-1);
				txtDisplay.setText(String.valueOf(ops));
				
			}
		});
		button_plusless.setBounds(220, 146, 63, 23);
		btn_0.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(button_plusless);
		
		JButton btn_division = new JButton("/");
		btn_division.setForeground(new Color(255, 255, 255));
		btn_division.setBackground(new Color(108, 122, 137));
		btn_division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				display.setText(firstNum + " /");
				operations = "/";
			}
		});
		btn_division.setBounds(220, 186, 63, 23);
		btn_division.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_division);
		
		JButton btn_multiplication = new JButton("*");
		btn_multiplication.setForeground(new Color(255, 255, 255));
		btn_multiplication.setBackground(new Color(108, 122, 137));
		btn_multiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				display.setText(firstNum + " *");
				operations = "*";
			}
		});
		btn_multiplication.setBounds(220, 226, 63, 23);
		btn_multiplication.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_multiplication);
		
		JButton btnV = new JButton("\u221A");
		btnV.setForeground(new Color(255, 255, 255));
		btnV.setBackground(new Color(108, 122, 137));
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.sqrt(ops) ;
				txtDisplay.setText(String.valueOf(ops));
				
			}
		});
		btnV.setBounds(290, 146, 63, 23);
		btnV.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btnV);
		
		JButton button_13 = new JButton("%");
		button_13.setForeground(new Color(255, 255, 255));
		button_13.setBackground(new Color(108, 122, 137));
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "%";
			}
		});
		button_13.setBounds(290, 186, 63, 23);
		button_13.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(button_13);
		
		JButton btnx = new JButton("1/\u0353");
		btnx.setForeground(new Color(255, 255, 255));
		btnx.setBackground(new Color(108, 122, 137));
		btnx.setBounds(290, 226, 63, 23);
		btnx.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btnx);
		
		JButton btn_subtraction = new JButton("-");
		btn_subtraction.setForeground(new Color(255, 255, 255));
		btn_subtraction.setBackground(new Color(108, 122, 137));
		btn_subtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				display.setText(firstNum + " -");
				operations = "-";
			}
		});
		btn_subtraction.setBounds(220, 266, 63, 23);
		btn_0.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_subtraction);
		
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_3.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_3.setBounds(150, 266, 63, 23);
		btn_3.setFont(new Font("Arial", Font.BOLD, 10));
		btn_3.setBackground(new Color(108, 122, 137));
		btn_3.setForeground(Color.WHITE);
		contentPane.add(btn_3);
		
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_2.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_2.setBounds(80, 266, 63, 23);
		btn_2.setFont(new Font("Arial", Font.BOLD, 10));
		btn_2.setBackground(new Color(108, 122, 137));
		btn_2.setForeground(Color.WHITE);
		contentPane.add(btn_2);
		
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_1.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_1.setBounds(10, 266, 63, 23);
		btn_1.setFont(new Font("Arial", Font.BOLD, 10));
		btn_1.setBackground(new Color(108, 122, 137));
		btn_1.setForeground(Color.WHITE);
		contentPane.add(btn_1);
		
		JButton btn_vrg = new JButton(".");
		btn_vrg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String iNum = txtDisplay.getText() + btn_vrg.getText();
				txtDisplay.setText(iNum);
			}
		});
		btn_vrg.setBounds(150, 306, 63, 23);
		btn_vrg.setFont(new Font("Arial", Font.BOLD, 10));
		btn_vrg.setBackground(new Color(108, 122, 137));
		btn_vrg.setForeground(Color.WHITE);
		contentPane.add(btn_vrg);
		
		JButton btn_addition = new JButton("+");
		btn_addition.setBackground(new Color(108, 122, 137));
		btn_addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				display.setText(firstNum + " +");
				operations = "+";
			}
		});
		btn_addition.setBounds(220, 306, 63, 23);
		btn_addition.setFont(new Font("Arial", Font.BOLD, 10));
		btn_addition.setForeground(Color.WHITE);
		contentPane.add(btn_addition);
		
		JButton btn_sum = new JButton("=");
		btn_sum.setForeground(new Color(255, 255, 255));
		btn_sum.setBackground(new Color(34, 49, 63));
		btn_sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String answer;
				secondNum = Double.parseDouble(txtDisplay.getText());
				if (operations == "+")
				{
					result = firstNum + secondNum;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				
				else if (operations == "-")
				{
					
						result = firstNum - secondNum;
						answer = String.format("%.2f", result);
						txtDisplay.setText(answer);
				}
				
				else if (operations == "*")
					{
						
							result = firstNum * secondNum;
							answer = String.format("%.2f", result);
							txtDisplay.setText(answer);
						}
				else if (operations == "/")
				{
					
						result = firstNum / secondNum;
						answer = String.format("%.2f", result);
						txtDisplay.setText(answer);
					
				}
				display.setText(null);
					}
			
				
			
		});
		btn_sum.setBounds(290, 266, 63, 63);
		btn_0.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_sum);
		
		JButton btn_Log = new JButton("log");
		btn_Log.setFont(new Font("Arial", Font.BOLD, 10));
		btn_Log.setBackground(Color.PINK);
		btn_Log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.log(ops) ;
				txtDisplay.setText(String.valueOf(ops));
				
			}
		});
		btn_Log.setBounds(396, 146, 56, 23);
		btn_0.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Log);
		
	
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.setForeground(Color.WHITE);
		btn_Clear.setBackground(Color.GRAY);
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		btn_Clear.setBounds(806, 286, 89, 23);
		btn_Clear.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Clear);
		
		JButton btn_Sin = new JButton("Sin");
		btn_Sin.setBackground(Color.PINK);
		btn_Sin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.sin(ops) ;
				txtDisplay.setText(String.valueOf(ops));
				
			}
		});
		btn_Sin.setBounds(463, 146, 56, 23);
		btn_Sin.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Sin);
		
		JButton btn_Sinh = new JButton("Sinh");
		btn_Sinh.setBackground(Color.PINK);
		btn_Sinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.sinh(ops) ;
				txtDisplay.setText(String.valueOf(ops));
				
			}
		});
		btn_Sinh.setBounds(530, 146, 56, 23);
		btn_Sinh.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Sinh);
		
		JButton btn_Mod = new JButton("Mod");
		btn_Mod.setBackground(Color.PINK);
		btn_Mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "Mod";
			}
		});
		btn_Mod.setBounds(595, 146, 56, 23);
		btn_Mod.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Mod);
		
		JButton btn_pii = new JButton("\u03C0");
		btn_pii.setBackground(Color.PINK);
		btn_pii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops ;
				ops = (3.14159265359)  ;
				txtDisplay.setText(String.valueOf(ops));
				
				
			}
		});
		btn_pii.setBounds(396, 186, 56, 23);
		btn_pii.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_pii);
		
		JButton btn_Cos = new JButton("Cos");
		btn_Cos.setBackground(Color.PINK);
		btn_Cos.setBounds(463, 186, 56, 23);
		btn_Cos.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Cos);
		
		JButton btn_Cosh = new JButton("Cosh");
		btn_Cosh.setBackground(Color.PINK);
		btn_Cosh.setBounds(529, 186, 56, 23);
		btn_Cosh.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Cosh);
		
		JButton btn_Inx = new JButton("Inx");
		btn_Inx.setBackground(Color.PINK);
		btn_Inx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.log10(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btn_Inx.setBounds(595, 186, 56, 23);
		btn_Inx.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Inx);
		
		JButton btn_XY = new JButton("x \u033D y");
		btn_XY.setBackground(Color.PINK);
		btn_XY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.pow(ops, ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btn_XY.setBounds(396, 226, 56, 23);
		btn_XY.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_XY);
		
		JButton btn_Tan = new JButton("Tan");
		btn_Tan.setBackground(Color.PINK);
		btn_Tan.setFont(new Font("Arial", Font.BOLD, 10));
		btn_Tan.setBounds(463, 226, 56, 23);
		contentPane.add(btn_Tan);
		
		JButton btn_Tanh = new JButton("Tanh");
		btn_Tanh.setBackground(Color.PINK);
		btn_Tanh.setBounds(529, 226, 56, 23);
		btn_Tanh.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Tanh);
		
		JButton btn_Exp = new JButton("Exp");
		btn_Exp.setBackground(Color.PINK);
		btn_Exp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "Exp";
			}
		});
		btn_Exp.setBounds(595, 226, 56, 23);
		btn_Exp.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Exp);
		
		JButton btn_X = new JButton("x \u033D 2");
		btn_X.setBackground(Color.PINK);
		btn_X.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = (ops * ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btn_X.setBounds(396, 266, 56, 23);
		btn_X.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_X);
		
		JButton btn_Cbr = new JButton("Cbr");
		btn_Cbr.setBackground(Color.PINK);
		btn_Cbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.cbrt(ops);
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btn_Cbr.setBounds(463, 266, 56, 23);
		btn_Cbr.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Cbr);
		
		JButton btn_Rund = new JButton("Rnd");
		btn_Rund.setBackground(Color.PINK);
		btn_Rund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				ops = Math.round(ops);
				txtDisplay.setText(String.valueOf(ops));
				
			}
		});
		btn_Rund.setBounds(529, 266, 56, 23);
		btn_Rund.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Rund);
		
		JButton btn_X_1 = new JButton("2 \u033D \u03C0");
		btn_X_1.setBackground(Color.PINK);
		btn_X_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops ;
				ops = (3.14159265359) * 2 ;
				txtDisplay.setText(String.valueOf(ops));
			}
		});
		btn_X_1.setBounds(595, 266, 56, 23);
		btn_X_1.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_X_1);
		
		JButton btnX_2 = new JButton("x \u033D 3");
		btnX_2.setBackground(Color.PINK);
		btnX_2.setBounds(396, 306, 56, 23);
		btnX_2.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btnX_2);
		
		JButton btn_Bin = new JButton("Bin");
		btn_Bin.setBackground(Color.PINK);
		btn_Bin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = Integer.parseInt(txtDisplay.getText()); // Binary
				txtDisplay.setText(Integer.toString(a,2));
			}
		});
		btn_Bin.setBounds(463, 306, 56, 23);
		btn_Bin.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Bin);
		
		JButton btn_Hex = new JButton("Hex");
		btn_Hex.setBackground(Color.PINK);
		btn_Hex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = Integer.parseInt(txtDisplay.getText()); // Binary
				txtDisplay.setText(Integer.toString(a,16));
			}
		});
		btn_Hex.setBounds(529, 306, 56, 23);
		btn_Hex.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Hex);
		
		JButton btn_Oct = new JButton("Oct");
		btn_Oct.setBackground(Color.PINK);
		btn_Oct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = Integer.parseInt(txtDisplay.getText()); // Binary
				textField.setText(Integer.toString(a,8));
			}
		});
		btn_Oct.setBounds(595, 306, 56, 23);
		btn_Oct.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.add(btn_Oct);
		
		
		display = new JTextField();
		display.setFont(new Font("Ubuntu Light", Font.PLAIN, 11));
		display.setEditable(false);
		display.setBounds(249, 11, 86, 20);
		contentPane.add(display);
		display.setColumns(10);			
				
	}
}

