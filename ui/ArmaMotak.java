package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArmaMotak extends JPanel {
    static JFrame frame;

    static String bonbaString = "Bonba";
    static String radarString = "radar";
    static String misilaString = "misila";
    static String misilZuzenduaString = "misilZuzendua";
    static String ezkutuaString = "ezktuaZuzendua";

    JLabel picture;

    public ArmaMotak() {
    	
    	
        JRadioButton bonbaButton = new JRadioButton(bonbaString);
        bonbaButton.setMnemonic('b');
        bonbaButton.setActionCommand(bonbaString);
        bonbaButton.setSelected(true);

        JRadioButton radarButton = new JRadioButton(radarString);
        radarButton.setMnemonic('c');
        radarButton.setActionCommand(radarString);

        JRadioButton misilaButton = new JRadioButton(misilaString);
        misilaButton.setMnemonic('d');
        misilaButton.setActionCommand(misilaString);

        JRadioButton misilZuzenduaButton = new JRadioButton(misilZuzenduaString);
        misilZuzenduaButton.setMnemonic('r');
        misilZuzenduaButton.setActionCommand(misilZuzenduaString);
        
        JRadioButton ezkutuaButton = new JRadioButton(ezkutuaString);
        misilZuzenduaButton.setMnemonic('e');
        misilZuzenduaButton.setActionCommand(ezkutuaString);
      


        // Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(bonbaButton);
        group.add(radarButton);
        group.add(misilaButton);
        group.add(misilZuzenduaButton);
        group.add(ezkutuaButton);

        // Register a listener for the radio buttons.
        RadioListener myListener = new RadioListener();
        bonbaButton.addActionListener(myListener);
        radarButton.addActionListener(myListener);
        misilaButton.addActionListener(myListener);
        misilZuzenduaButton.addActionListener(myListener);
        ezkutuaButton.addActionListener(myListener);
      


        // Set up the picture label
        picture = new JLabel(new ImageIcon("images/" 
                                           + bonbaString 
					   + ".gif"));

        // The preferred size is hard-coded to be the width of the
        // widest image and the height of the tallest image.
        // A real program would compute this.
        picture.setPreferredSize(new Dimension(177, 122));


        // Put the radio buttons in a column in a panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(0, 1));
        radioPanel.add(bonbaButton);
        radioPanel.add(radarButton);
        radioPanel.add(misilaButton);
        radioPanel.add(misilZuzenduaButton);
        radioPanel.add(ezkutuaButton);

        setLayout(new BorderLayout());
        add(radioPanel, "West");
        add(picture, "Center");
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        
        
    }


    /** Listens to the radio buttons. */
    class RadioListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            picture.setIcon(new ImageIcon("images/" 
                                          + e.getActionCommand() 
                                          + ".gif"));
        }
    }

    public static void main(String s[]) {
         WindowListener l = new WindowAdapter() {
             public void windowClosing(WindowEvent e) {System.exit(0);}
         };
 
         frame = new JFrame("Erabili ahal ditudan armak");
         frame.addWindowListener(l);
         frame.getContentPane().add("Center", new ArmaMotak());
         frame.pack();
         frame.setVisible(true);
    }
}
