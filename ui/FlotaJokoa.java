package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import sprint1.Tablero;
import sprint1.Jokoa;

public class FlotaJokoa {

	private JFrame frame;
	private JPanel content;
	private JPanel goikoBotoiak;
	private JPanel barkuak;
	private JPanel norantzak;
	private JPanel erdikoBotoiak;
	private JPanel nireTablero;
	private JButton[][] tableroNi;
	private JButton[][] tableroAurk;
	private JPanel aurkariTablero;
	private JPanel behekoBotoiak;
	private JPanel armak;
	private JPanel onarpenBotoiak;
	private JButton ontziaKokatu;
	private JButton ezkutuaJarri;
	private JButton radarraKontsultatu;
	private JButton tiroEgin;
	private JButton erosi;
	private JButton konpondu;
	private String aukeratutakoOntzia="HegazkinOntzi";
	private char kokapena='g';
	private String arma="Bonba";//nose si mayus o minus;
	static Integer[] koordenatuak = new Integer[2];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlotaJokoa window = new FlotaJokoa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FlotaJokoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = new JPanel();
		content.setLayout(new BorderLayout());
		goikoBotoiak = goikoBotoiakJarri();
		erdikoBotoiak = erdikoBotoiakJarri();
		behekoBotoiak = behekoBotoiakJarri();
		content.add(goikoBotoiak, BorderLayout.NORTH);
		content.add(erdikoBotoiak, BorderLayout.CENTER);
		content.add(behekoBotoiak, BorderLayout.SOUTH);
		frame.setContentPane(content);
		frame.pack();
		frame.setResizable(false);
	}
	private void tableroaEguneratu(String norena){
		int i=0;
		while(i<tableroNi.length){
			//System.out.println("tableroa eguneratzen hasi da....");
			int j=0;
			while(j<tableroNi.length){
				System.out.println("ontzia da UIn? "+(Jokoa.getNireJokoa().zerDaKasillaHau(i,j, norena)).equals("ontzia"));
				if((Jokoa.getNireJokoa().zerDaKasillaHau(i,j,norena)).equals("ontzia")){
					if(norena.equals("pertsona")){
						tableroNi[i][j].setBackground(new Color(210,180,140));
					}
					else if(norena.equals("ordenagailu")){
						tableroAurk[i][j].setBackground(new Color(210,180,140));
					}
				}
				else if(Jokoa.getNireJokoa().zerDaKasillaHau(i, j, norena).equals("EzkutuOsoa")){
					if(norena.equals("pertsona")){
						tableroNi[i][j].setBackground(new Color(160,82,45));
					}
				}else if(Jokoa.getNireJokoa().zerDaKasillaHau(i, j, norena).equals("EzkutuBakarra")){
					if(norena.equals("pertsona")){
						tableroNi[i][j].setBackground(new Color(205,133,63));
					}
				}
				j++;
			}
			i++;
		}
	}

	private JPanel behekoBotoiakJarri() {
		JPanel botoiak = new JPanel();
		botoiak.setLayout(new BorderLayout());
		armak = armakJarri();
		onarpenBotoiak = onarpenBotoiakJarri();
		botoiak.add(armak, BorderLayout.NORTH);
		botoiak.add(onarpenBotoiak, BorderLayout.SOUTH);
		return botoiak;
	}

	private JPanel onarpenBotoiakJarri() {
		JPanel botoiak = new JPanel();
		botoiak.setLayout(new FlowLayout());
		ontziaKokatu = new JButton("OntziaKokatu");
		ezkutuaJarri = new JButton("EzkutuaJarri");
		radarraKontsultatu = new JButton("RadarraKontsultatu");
		tiroEgin = new JButton("TiroEgin");
		erosi = new JButton("Erosi");
		konpondu = new JButton("Konpondu");
		
		ontziaKokatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean listo=false;
				if(Jokoa.getNireJokoa().kokatu(koordenatuak[0], koordenatuak[1], aukeratutakoOntzia, kokapena)){
				 tableroaEguneratu("pertsona");
				 tableroaEguneratu("ordenagailua");
				}
				if(!Jokoa.getNireJokoa().hegazkinOntziKokatzenJarraituAhal() && !Jokoa.getNireJokoa().fragataKokatzenJarraituAhal() && !Jokoa.getNireJokoa().itsaspekoKokatzenJarraituAhal() && !Jokoa.getNireJokoa().suntsitzaileKokatzenJarraituAhal()){
					goikoBotoiak.setVisible(false);
					ontziaKokatu.setVisible(false);
				}
			}
		
		});
	
		ezkutuaJarri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Jokoa.getNireJokoa().ezktuaJarri(koordenatuak[0],koordenatuak[1])){
					tableroaEguneratu("pertsona");
				}
				
				
			}
		});
		tiroEgin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jokoa.getNireJokoa().tiroEgin(arma,koordenatuak[0],koordenatuak[1]);
				//poner para pintar
			}
		});
		
		erosi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jokoa.getNireJokoa().armaErosi(arma);				
				
			}
		});
		
		konpondu.addActionListener(new ActionListener() {
			//mirar si al arreglar pasandole (x,y) se suma uno en la cantidad de trozos enteros que le quedan
			@Override
			public void actionPerformed(ActionEvent e) {
				Jokoa.getNireJokoa().ontziaKonpondu(koordenatuak[0],koordenatuak[1]);
				tableroaEguneratu("pertsona");	
			
			}
		});
		
		radarraKontsultatu.addActionListener(new ActionListener() {
			//mirar si al arreglar pasandole (x,y) se suma uno en la cantidad de trozos enteros que le quedan
			@Override
			public void actionPerformed(ActionEvent e) {
				Jokoa.getNireJokoa().radarraKontsultatu();
				
			
			}
		});

		botoiak.add(ontziaKokatu, FlowLayout.LEFT);
		botoiak.add(ezkutuaJarri, FlowLayout.LEFT);
		botoiak.add(radarraKontsultatu,FlowLayout.LEFT);
		botoiak.add(tiroEgin, FlowLayout.CENTER);
		botoiak.add(konpondu, FlowLayout.RIGHT);
		botoiak.add(erosi, FlowLayout.RIGHT);
		return botoiak;
	}

	private JPanel armakJarri() {
		JPanel botoiak = new JPanel();
		botoiak.setLayout(new GridLayout());
		 JRadioButton bonbaButton = new JRadioButton("Bonba");
	        bonbaButton.setMnemonic('b');
	        bonbaButton.setActionCommand("Bonba");
	        bonbaButton.setSelected(true);
	        bonbaButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "bonba";
					
				}
			});


//	        JRadioButton radarButton = new JRadioButton("Radarra");
//	        radarButton.setMnemonic('c');
//	        radarButton.setActionCommand("Radarra");
//	        radarButton.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					arma = "radarra";
//					
//				}
//			});
	        
	        JRadioButton misilaButton = new JRadioButton("Misila");
	        misilaButton.setMnemonic('d');
	        misilaButton.setActionCommand("Misila");
	        misilaButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "misila";
					
				}
			});
	        

	        JRadioButton misilZuzenduaBertButton = new JRadioButton("Misil zuzendua bertikal");
	        misilZuzenduaBertButton.setMnemonic('r'); //no se que es esto
	        misilZuzenduaBertButton.setActionCommand("Misil zuzendua bertikal");
	        misilZuzenduaBertButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "misil zuzendua bertikal";
					
				}
			});
	        
	        JRadioButton misilZuzenduaHorButton = new JRadioButton("Misil zuzendua bertikal");
	        misilZuzenduaHorButton.setMnemonic('r');
	        misilZuzenduaHorButton.setActionCommand("Misil zuzendua bertikal");
	        misilZuzenduaHorButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "misil zuzendua bertikal";
					
				}
			});
	        JRadioButton misilZuzenduaBoomButton = new JRadioButton("Misil zuzendua boom");
	        misilZuzenduaHorButton.setMnemonic('r');
	        misilZuzenduaHorButton.setActionCommand("Misil zuzendua boom");
	        misilZuzenduaHorButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "misil zuzendua boom";
					
				}
			});
	        
	        JRadioButton ezkutuaButton = new JRadioButton("Ezkutua");
	        ezkutuaButton.setMnemonic('e');
	        ezkutuaButton.setActionCommand("Ezkutua");
	        ezkutuaButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "ezkutua";
					
				}
			});
	      


	        // Group the radio buttons.
	        ButtonGroup group = new ButtonGroup();
	        group.add(bonbaButton);
	        //group.add(radarButton);
	        group.add(misilaButton);
	        group.add(misilZuzenduaBertButton);
	        group.add(misilZuzenduaHorButton);
	        group.add(misilZuzenduaBoomButton);
	        group.add(ezkutuaButton);

        //botoiak gehitu
	        botoiak.add(bonbaButton);
	       // botoiak.add(radarButton);
	        botoiak.add(misilaButton);
	        botoiak.add(misilZuzenduaBertButton);
	        botoiak.add(misilZuzenduaHorButton);
	        botoiak.add(misilZuzenduaBoomButton);
	        botoiak.add(ezkutuaButton);
        
        return botoiak;
	}

	private JPanel erdikoBotoiakJarri() {
		JPanel botoiak = new JPanel();
		botoiak.setLayout(new BorderLayout());
		nireTablero = tableroaBete(1);
		aurkariTablero = tableroaBete(2);
		botoiak.add(nireTablero, BorderLayout.NORTH);
		botoiak.add(new JPanel(), BorderLayout.CENTER);
		botoiak.add(aurkariTablero, BorderLayout.SOUTH);
		return botoiak;
	}

	private JPanel tableroaBete(int a) {
		JPanel tablero = new JPanel();
		tablero.setBorder(new EmptyBorder(20, 20, 20, 20));
		//tablero.setSize(150, 150);
		tablero.setLayout(new GridLayout(10, 10));
		JButton[][] botoiak = new JButton[10][10];
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				botoiak[i][j] = new JButton();
				botoiak[i][j].setText(i + "/" + j);
				//botoiak[i][j].setText("("+ i + "," + j + ")");
				//botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/argaziak/ura.jpg")));
				botoiak[i][j].setBackground(new Color(135,206,250));
				
		//AQUI LE METO AL BOTON QUE BUSQUE SUS KOORDENADAS Y RONPO EL WHILE CON LISTO
				
				botoiak[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						for(int i=0;i<10;i++){
							for(int j=0;j<10;j++){
								if (e.getSource().equals(botoiak[i][j])){
									koordenatuak[0]= i;
									koordenatuak[1]= j;
								}
							}
						}
					}
				});
				tablero.add(botoiak[i][j], BorderLayout.CENTER);
				if(a==1){
					this.tableroNi=botoiak;
				}
				else{
					this.tableroAurk=botoiak;
				}
			}
		}
		return tablero;
		
	}

	private JPanel goikoBotoiakJarri() {
		JPanel botoiak = new JPanel();
		botoiak.setLayout(new BorderLayout());
		barkuak = barkuakJarri();
		norantzak = norantzakJarri();
		botoiak.add(barkuak, BorderLayout.NORTH);
		botoiak.add(norantzak, BorderLayout.SOUTH);
		return botoiak;
	}

	private JPanel norantzakJarri() {
		JPanel botoiak = new JPanel();
		botoiak.setLayout(new GridLayout());
		 JRadioButton goraButton = new JRadioButton("gora");
	        goraButton.setMnemonic('b');
	        goraButton.setActionCommand("gora");
	        goraButton.setSelected(true);
	        goraButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					kokapena = 'g';
					
				}
			});

	        JRadioButton beheraButton = new JRadioButton("behera");
	        beheraButton.setMnemonic('c');
	        beheraButton.setActionCommand("behera");
	        beheraButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					kokapena = 'b';
					
				}
			});

	        JRadioButton ezkerraButton = new JRadioButton("ezkerrera");
	        ezkerraButton.setMnemonic('d');
	        ezkerraButton.setActionCommand("ezkerrera");
	        ezkerraButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					kokapena = 'z';
				}
			});

	        JRadioButton eskumaButton = new JRadioButton("eskumara");
	        eskumaButton.setMnemonic('r');
	        eskumaButton.setActionCommand("eskumara");
	        eskumaButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					kokapena = 's';
				}
			});
	      


	        // Group the radio buttons.
	        ButtonGroup group = new ButtonGroup();
	        group.add(goraButton);
	        group.add(beheraButton);
	        group.add(ezkerraButton);
	        group.add(eskumaButton);
	        
	        botoiak.add(goraButton);
	        botoiak.add(beheraButton);
	        botoiak.add(ezkerraButton);
	        botoiak.add(eskumaButton);
	        
	        return botoiak;
	}

	private JPanel barkuakJarri() {
		JPanel botoiak = new JPanel();
		botoiak.setLayout(new GridLayout());
		JRadioButton hegazkinOntziButton = new JRadioButton("HegazkinOntzi");
        hegazkinOntziButton.setMnemonic('b');
        hegazkinOntziButton.setActionCommand("HegazkinOntzi");
        hegazkinOntziButton.setSelected(true);
        hegazkinOntziButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aukeratutakoOntzia = "HegazkinOntzi";
			}
		});

        JRadioButton itsaspekoButton = new JRadioButton("Itsaspeko");
        itsaspekoButton.setMnemonic('c');
        itsaspekoButton.setActionCommand("Itsaspeko");
        itsaspekoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aukeratutakoOntzia = "Itsaspeko";	
			}
		});

        JRadioButton suntsitzaileButton = new JRadioButton("Suntsitzaile");
        suntsitzaileButton.setMnemonic('d');
        suntsitzaileButton.setActionCommand("Suntsitzaile");
        suntsitzaileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aukeratutakoOntzia = "Suntsitzaile";
			}
		});

        JRadioButton fragataButton = new JRadioButton("Fragata");
        fragataButton.setMnemonic('r');
        fragataButton.setActionCommand("Fragata");
        fragataButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aukeratutakoOntzia = "Fragata";
			}
		});
        //botoi taldea sortu
        ButtonGroup group = new ButtonGroup();
        group.add(hegazkinOntziButton);
        group.add(itsaspekoButton);
        group.add(suntsitzaileButton);
        group.add(fragataButton);
        
        //botoiak gehitu
        botoiak.add(hegazkinOntziButton);
        botoiak.add(itsaspekoButton);
        botoiak.add(suntsitzaileButton);
        botoiak.add(fragataButton);
        
        return botoiak;
	}
	
}
