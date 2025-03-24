import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AreYouAnIdiot extends JFrame implements ActionListener {
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 150;
	final Random rg = new Random();
	final JLabel question = new JLabel("Are you an idiot?");
	final JButton yes = new JButton("Yes");
	final JButton no = new JButton("No");
	final JLabel iknewit = new JLabel("I knew it :)");
	
	public AreYouAnIdiot() {
		super("Are you an idiot?");
		setBounds(rg.nextInt(1442), rg.nextInt(1000), FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		yes.addActionListener(this);
		no.addActionListener(this);
		setLayout(new FlowLayout());
		add(question);
		add(yes);
		add(no);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == yes) {
			remove(question);
			remove(yes);
			remove(no);
			add(iknewit);
			invalidate();
			validate();
			repaint();
		} else if (source == no) {
			setBounds(rg.nextInt(1442), rg.nextInt(1000), FRAME_WIDTH, FRAME_HEIGHT);
		}
	}
}
