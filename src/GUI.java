import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//to be redesigned
public class GUI extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JPanel p1;
	private JPanel p2;
	private JButton wP, sP;
	private WordPractice wordsPr;
	private SentencePractice senPr;
	
	
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
		senPr = new SentencePractice(this);
		
		wP = new JButton("Word Practice");
		sP = new JButton("Sentence Practice");
		
		wP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startWordP();
			}
		});
		
		sP.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				startSenP();
			}
		});
		
		label = new JLabel();
		label.setText("Touch Typing Practice");
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		p1.add(label);
		
		p2.add(wP);
		p2.add(sP);
		
		super.add(p1);
		super.add(p2);
		
		BoxLayout x = new BoxLayout(this.getContentPane(), 1);
		
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
