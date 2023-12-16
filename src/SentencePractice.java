/***
 * @author Raymond Klarr
 * 12/16/2023
 * Class handles the Sentence type test for the program: prompt a sentence to be typed.
 */

import java.io.Serial;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//to be removed
public class SentencePractice extends JFrame
{
	@Serial
	private static final long serialVersionUID = 1L;
	private final GUI ret;
	private final JLabel sen;
	private final JTextField tF;
	private final JLabel acc;
	private final JLabel stats;
	private int numWords;
	private int numCorrectWords;
	private double accuracy;
	private String template;
	SenTests sT;
	
	/**
	 * Initializes instance variables, sets up SentencePractice GUI
	 * 
	 * @param safety - GUI object to return to upon back being pressed
	 */
	public SentencePractice(GUI safety)
	{
		super("Sentence Practice");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(500,200);
		super.setVisible(false);
		
		sT = new SenTests();
		
		ret = safety;
		
		sen = new JLabel(); acc = new JLabel(); stats = new JLabel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JButton back = new JButton("Back");
		tF = new JTextField();
		
		numWords = 0;
		numCorrectWords = 0;
		accuracy = 0.0;
		
		template = SGen.genSen();
		sen.setText(template);
		acc.setText("Type the above sentence then press enter.");
		stats.setText("Words Correctly Spelled: " + numCorrectWords + " Words Entered: " + numWords);
		
		back.addActionListener(e -> back());
		
		tF.addActionListener(e -> nextWord());
		
		tF.setColumns(40);
		
		
		p1.add(back); p1.add(sen);
		p2.add(tF); p2.add(stats);
		p3.add(acc);
		
		super.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		super.add(p1);
		super.add(p2);
		super.add(p3);
		
	}
	
	/**
	 * scores entry, removes text from field, and gives a new prompt word
	 */
	private void nextWord()
	{
		String[] x = template.split(" ");
		String entry = tF.getText();
		
		System.out.println(template + "   " + entry);
		
		numCorrectWords += sT.equalityCheckSen(entry, template);
		numWords += x.length;
		accuracy = ((double)numCorrectWords/numWords)*100;
		
		
		
		tF.setText("");
		
		acc.setText("Accuracy: " + (int)accuracy + "%");
		stats.setText("Words Correctly Spelled: " + numCorrectWords + " Words Entered: " + numWords);
		template = SGen.genSen();
		sen.setText(template);
		
	}
	
	/**
	 * sets visibility of menu to false and visibility of this to true
	 */
	public void start()
	{
		ret.setVisible(false);
		this.setVisible(true);
	}
	
	/**
	 * sets visibility of this frame to false and visibility of menu to true
	 */
	private void back()
	{
		ret.setVisible(true);
		this.setVisible(false);
	}
}
