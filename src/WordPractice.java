import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//To be removed
public class WordPractice extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton back;
	private JPanel p;
	private JPanel p1;
	private JPanel p2;
	private JTextField tF;
	private JLabel label;
	private String template;
	private int wordsDone;
	private int correctWords;
	private GUI menu;
	private double accuracy;
	private JLabel accLabel;
	private JLabel stats;
	
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
		
		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		
		template = SGen.retRanWord();
		
		tF = new JTextField();
		tF.setColumns(30);
		tF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextWord();
			}
		});
		
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
		
		
		
		super.setLayout(new BoxLayout(this.getContentPane(), 1));
		
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
			wordsDone++;
		}
		else
		{
			wordsDone++;
		}
		
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
