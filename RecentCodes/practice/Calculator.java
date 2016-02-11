package practice;

import javax.swing.*;

public class Calculator {
	public static void main(String[] args){
		JFrame frame = new JFrame("Calculator Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		JPanel panel = new JPanel();
		JTextPane pane = new JTextPane();
		pane.setText("HelloWorld");
		
		panel.add(pane);
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
	 
}
