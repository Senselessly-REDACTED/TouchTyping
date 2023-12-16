/***
 * @author Raymond Klarr
 * 12/16/2023
 * Class handles gui elements and IO. Class may be more accurately named to 'Menu'
 */

import java.io.Serial;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//to be redesigned
public class GUI extends JFrame 
{
	@Serial
	private static final long serialVersionUID = 1L;
	private final WordPractice wordsPr;
	private final SentencePractice senPr = new SentencePractice(this);
	
	
	/**
	 * Initializes instance variables, runs the menu GUI
	 */
	public GUI()
	{
		super("Touch Typing");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(400,300);
		super.setResizable(false);
		
		wordsPr = new WordPractice(this);

        JButton wP = new JButton("Word Practice");
		JButton sP = new JButton("Sentence Practice");
		
		wP.addActionListener(e -> startWordP());
		
		sP.addActionListener(e -> startSenP());

		JLabel label = new JLabel();
		label.setText("Touch Typing Practice");

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.add(label);
		
		p2.add(wP);
		p2.add(sP);
		
		super.add(p1);
		super.add(p2);
		
		BoxLayout x = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		
		super.setLayout(x);
		
		super.setVisible(true);
	}
	
	/**
	 * sets visibility of the menu to false and calls the wordPractice's start method
	 */
	public void startWordP()
	{
		super.setVisible(false);
		wordsPr.start();
	}
	
	/**
	 * sets visibility of the menu to false and calls the SentencePractice's start method
	 */
	public void startSenP()
	{
		senPr.start();
	}
}
