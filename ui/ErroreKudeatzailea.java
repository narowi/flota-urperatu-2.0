package ui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ErroreKudeatzailea extends JDialog {
//	private JLabel jLabel1 = new JLabel();
//	private JButton jButton1 = new JButton();
	
	public ErroreKudeatzailea(String title){
		JOptionPane.showMessageDialog(null, title, "Errorea", JOptionPane.ERROR_MESSAGE);
	}
}
