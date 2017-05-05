package ui;

import javax.swing.JOptionPane;

public class WarningKudeatzailea {
	public WarningKudeatzailea(String title){
		JOptionPane.showMessageDialog(null, title, "Errorea", JOptionPane.WARNING_MESSAGE);
	}
}
