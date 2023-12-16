/***
 * @author Raymond Klarr
 * 12/16/2023
 * Class prompts user to type a given word and records accuracy.
 */

import java.io.Serial;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//To be removed
public class WordPractice extends JFrame
{
	@Serial
	private static final long serialVersionUID = 1L;
	private final JTextField tF;
	private final JLabel label;
	private String template;
	private int wordsDone;
	private int correctWords;
	private final GUI menu;
	private double accuracy;
	private final JLabel accLabel;
	private final JLabel stats;
	
	/**
	 * Initializes instance variables, sets up WordPractice GUI
	 * 
	 * @param safety - GUI object to return to upon back being pressed
	 */
	public WordPractice(GUI safety)
	{
		super("Word Practice");
		
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(500, 200);
		super.setVisible(false);
		super.setResizable(false);
		
		menu = safety;
		
		wordsDone = 0;
		correctWords = 0;
		accuracy = 0.00;

		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		JButton back = new JButton("Back");
		back.addActionListener(e -> back());
		
		template = SGen.retRanWord();
		
		tF = new JTextField();
		tF.setColumns(30);
		tF.addActionListener(e -> nextWord());
		
		label = new JLabel();
		label.setText(template);
		stats = new JLabel();
		accLabel = new JLabel();
		accLabel.setText("Type the word above, then press enter");
		stats.setText("Words Correctly Spelled: " + correctWords + " Words Entered: " + wordsDone);
		
		p.add(back);
		p.add(label);
		p1.add(tF);
		p1.add(stats);
		p2.add(accLabel);
		
		
		
		super.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		super.add(p);
		super.add(p1);
		super.add(p2);
	}
	
	/**
	 * sets the JFrame of this class to visible
	 */
	public void start()
	{
		super.setVisible(true);
	}
	
	/**
	 * checks if the entered word matches the requested word, and prompts the user with a new one, as well as displays their accuracy
	 */
	private void nextWord()
	{
		if(tF.getText().equals(template))
		{
			correctWords++;
        }
        wordsDone++;

        accuracy = ((double)correctWords/wordsDone)*100;
		
		tF.setText("");
		accLabel.setText("Accuracy: " + (int)accuracy + "%");

		stats.setText("Words Correctly Spelled: " + correctWords + " Words Entered: " + wordsDone);
		template = SGen.retRanWord();
		label.setText(template);
	}
	
	/**
	 * returns to the Menu
	 */
	public void back()
	{
		super.setVisible(false);
		menu.setVisible(true);
		
	}
}
