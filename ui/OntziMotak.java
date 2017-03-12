package ui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OntziMotak extends JPanel {
    static JFrame frame;

    static String hegazkinOntziString = "Hegazkin-Ontzi";
    static String itsaspekoString = "Itsaspeko";
    static String suntsitzaileString = "Suntsitzaile";
    static String fragataString = "Fragata";
    static String sartuString = "Onartu";
    static String irtenString = "Ezeztatu";

    JLabel picture;

    public OntziMotak() {
    	
    	
        JRadioButton hegazkinOntziButton = new JRadioButton(hegazkinOntziString);
        hegazkinOntziButton.setMnemonic('b');
        hegazkinOntziButton.setActionCommand(hegazkinOntziString);
        hegazkinOntziButton.setSelected(true);

        JRadioButton itsaspekoButton = new JRadioButton(itsaspekoString);
        itsaspekoButton.setMnemonic('c');
        itsaspekoButton.setActionCommand(itsaspekoString);

        JRadioButton suntsitzaileButton = new JRadioButton(suntsitzaileString);
        suntsitzaileButton.setMnemonic('d');
        suntsitzaileButton.setActionCommand(suntsitzaileString);

        JRadioButton fragataButton = new JRadioButton(fragataString);
        fragataButton.setMnemonic('r');
        fragataButton.setActionCommand(fragataString);
        
        JButton sartu = new JButton(sartuString);
        fragataButton.setMnemonic('s');
        fragataButton.setActionCommand(sartuString);

        
        JButton irten = new JButton(irtenString);
        fragataButton.setMnemonic('i');
        fragataButton.setActionCommand(irtenString);


        // Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(hegazkinOntziButton);
        group.add(itsaspekoButton);
        group.add(suntsitzaileButton);
        group.add(fragataButton);
        group.add(sartu);
        group.add(irten);

        // Register a listener for the radio buttons.
        RadioListener myListener = new RadioListener();
        hegazkinOntziButton.addActionListener(myListener);
        itsaspekoButton.addActionListener(myListener);
        suntsitzaileButton.addActionListener(myListener);
        fragataButton.addActionListener(myListener);
       
        sartu.addActionListener(myListener);
        irten.addActionListener(myListener);


        // Set up the picture label
        picture = new JLabel(new ImageIcon("images/" 
                                           + hegazkinOntziString 
					   + ".gif"));

        // The preferred size is hard-coded to be the width of the
        // widest image and the height of the tallest image.
        // A real program would compute this.
        picture.setPreferredSize(new Dimension(177, 122));


        // Put the radio buttons in a column in a panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(0, 1));
        radioPanel.add(hegazkinOntziButton);
        radioPanel.add(itsaspekoButton);
        radioPanel.add(suntsitzaileButton);
        radioPanel.add(fragataButton);
        radioPanel.add(sartu);
        radioPanel.add(irten);

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
 
         frame = new JFrame("Ontzi motak");
         frame.addWindowListener(l);
         frame.getContentPane().add("Center", new OntziMotak());
         frame.pack();
         frame.setVisible(true);
    }
}
