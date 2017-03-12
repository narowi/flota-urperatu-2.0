package ui;



	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	public class KokapenAukerak extends JPanel {
	    static JFrame frame;

	    static String goraString = "Gora";
	    static String beheraString = "Behera";
	    static String ezkerreraString = "Ezkerra";
	    static String eskumaraString = "Eskuma";


	    JLabel picture;

	    public KokapenAukerak() {
	    	
	    	
	        JRadioButton goraButton = new JRadioButton(goraString);
	        goraButton.setMnemonic('b');
	        goraButton.setActionCommand(goraString);
	        goraButton.setSelected(true);

	        JRadioButton beheraButton = new JRadioButton(beheraString);
	        beheraButton.setMnemonic('c');
	        beheraButton.setActionCommand(beheraString);

	        JRadioButton ezkerraButton = new JRadioButton(ezkerreraString);
	        ezkerraButton.setMnemonic('d');
	        ezkerraButton.setActionCommand(ezkerreraString);

	        JRadioButton eskumaButton = new JRadioButton(eskumaraString);
	        eskumaButton.setMnemonic('r');
	        eskumaButton.setActionCommand(eskumaraString);
	        
	      


	        // Group the radio buttons.
	        ButtonGroup group = new ButtonGroup();
	        group.add(goraButton);
	        group.add(beheraButton);
	        group.add(ezkerraButton);
	        group.add(eskumaButton);
	     

	        // Register a listener for the radio buttons.
	        RadioListener myListener = new RadioListener();
	        goraButton.addActionListener(myListener);
	        beheraButton.addActionListener(myListener);
	        ezkerraButton.addActionListener(myListener);
	        eskumaButton.addActionListener(myListener);
	       
	      


	        // Set up the picture label
	        picture = new JLabel(new ImageIcon("images/" 
	                                           + goraString 
						   + ".gif"));

	        // The preferred size is hard-coded to be the width of the
	        // widest image and the height of the tallest image.
	        // A real program would compute this.
	        picture.setPreferredSize(new Dimension(177, 122));


	        // Put the radio buttons in a column in a panel
	        JPanel radioPanel = new JPanel();
	        radioPanel.setLayout(new GridLayout(0, 1));
	        radioPanel.add(goraButton);
	        radioPanel.add(beheraButton);
	        radioPanel.add(ezkerraButton);
	        radioPanel.add(eskumaButton);
	      

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
	         frame.getContentPane().add("Center", new KokapenAukerak());
	         frame.pack();
	         frame.setVisible(true);
	    }
	}

