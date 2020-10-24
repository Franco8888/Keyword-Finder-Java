import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class searchGUI implements ActionListener {
	
	private String keyword = "";	//contain the keyword
	private String text = "";		//contain the text 
	
	JTextField field = new JTextField();
	JTextArea textA = new JTextArea();
	JFrame frame = new JFrame();	//the window
	JPanel panel = new JPanel();	//the layout in the window
	JButton but1 = new JButton("Find Word");
	JLabel label1 = new JLabel("Enter keyword:");
	JLabel label2 = new JLabel("Copy your text:");
	
	public searchGUI() {	//constructor
		
		but1.addActionListener(this); 
		
		
		//fixing textArea		
		textA.setLineWrap(true); 			//wraps the text of jTextArea
		textA.setWrapStyleWord(true); 		//wraps the text according to words
		
				
		panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));	//set border
		panel.setLayout(new GridLayout(3,2));	//GridLayout takes rows and columns as arguments
		//add the widgets in the following order:
		panel.add(label1);	//1st order
		panel.add(field);	//2nd order
		panel.add(label2);
		panel.add(textA);
		panel.add(but1);
						
		frame.add(panel, BorderLayout.CENTER);	//add panel to frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Word finder");
		frame.setPreferredSize(new Dimension(800,500));		//set initial size of window

		frame.pack();		//set window to match a certain size 
		frame.setVisible(true);	//set window to visible and in focus
		
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		keyword = field.getText();
		text = textA.getText();
		Search s = new Search(keyword, text);
		int kLenght = keyword.length();	//word lenght
		
		ArrayList<Integer> positions = s.find();	//find position of words
		
		//highlight the words using position
		Highlighter hl = textA.getHighlighter();
		try {
			for(int i: positions) {
				hl.addHighlight(i, i+kLenght, new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
			}
			
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new searchGUI();		
		
	}



}
