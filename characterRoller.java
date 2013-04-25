/*uriah sypolt
 * 1/19/2011
 * hayhurst 1100 class
 * Revision of Bryan lemon's lab2 
 * 
 * additions:
 *   added another button
 *   added another label
 *   made button to get 5 random numbers from 6 to 20 to be stored as 
 *        statistics for a Character sheet
 *   made button2 to reset the rolls and keep a count of how many times 
 *        you reset the rolls 
 *   made label to show the random number form 6 to 20
 *   made label2 to show the build of the statistics   
 * 
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JOptionPane;

public class characterRoller extends JFrame {

	private JButton button, button2;
	private JLabel label, label2;
	private boolean toggle, toggle2;

	public static void main(String[] args) {
		characterRoller lab = new characterRoller();
	}

	public characterRoller() {
		button = new JButton("roll for Strenth");
		label = new JLabel("0");
		toggle = true;
		button2 = new JButton("discard rolls");
		label2 = new JLabel("loading...");
		toggle = true;

		Container content = getContentPane();
		content.setBackground(Color.lightGray);
		content.setLayout(new GridLayout(2, 2));
		content.add(button);
		content.add(button2);
		content.add(label);
		content.add(label2);
		setVisible(true);
		setSize(400, 200);
		String newTitle = JOptionPane
				.showInputDialog("Enter the name of your character");
		JOptionPane.showMessageDialog(null, "your character's name is: "
				+ newTitle, "Character sheet", JOptionPane.DEFAULT_OPTION);
		setTitle(newTitle + " Character Sheet");
		addWindowListener(new ExitListener());

		button.addActionListener(new ActionListener() {
			int a = 0, r, r1, r2, r3, r4, r5;

			public void actionPerformed(ActionEvent e) {
				if (toggle2) {
					a = 0;
					toggle2 = !toggle2;
				}

				if (toggle || !toggle) {
					a = a + 1;
					r = ((int) ((Math.random() * 15) + 6));
					if (a < 5) {
						label.setText("you rolled a " + r);
					}
					switch (a) {
					case 1:
						r1 = r;
						button.setText(" roll for Dexterity");
						label2.setText("Str:" + r1);
						break;
					case 2:
						r2 = r;
						button.setText(" roll for Constitution");
						label2.setText("Str:" + r1 + " Dex:" + r2);
						break;
					case 3:
						r3 = r;
						button.setText(" roll for Intelligence");
						label2.setText("Str:" + r1 + " Dex:" + r2 + " Con:"
								+ r3);
						break;
					case 4:
						r4 = r;
						button.setText(" roll for wisdom");
						label2.setText("Str:" + r1 + " Dex:" + r2 + " Con:"
								+ r3 + " Int:" + r4);
						break;
					case 5:
						r5 = r;
						label2.setText("Str:" + r1 + " Dex:" + r2 + " Con:"
								+ r3 + " Int:" + r4 + " Wis:" + r5);
					case 999:
						button.setText("no more rolls");
					}
					toggle = !toggle;
				}
			}
		});
		button2.addActionListener(new ActionListener() {
			int b = 0;
			public void actionPerformed(ActionEvent e) {
				if (toggle2 || !toggle2) {
					b = b + 1;
					button2.setText("you have reset " + b + " times");
					button.setText("Roll for strenth");
				}
				toggle2 = !toggle2;
			}
		});
	}
	private class ExitListener extends WindowAdapter {
		public void windowClosing(WindowEvent event) {
			System.exit(0);
		}
	}
}
