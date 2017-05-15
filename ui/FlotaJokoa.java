package ui;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import sprint1.*;

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
				String zerDa=(Jokoa.getNireJokoa().zerDaKasillaHau(i,j,norena));
				boolean begiratua=(Jokoa.getNireJokoa().begiratua(i,j,norena));
				//System.out.println(zerDa+" x="+i+"y="+j);
				if(begiratua){
					if(zerDa.equals("Osorik")){
						if(norena.equals("pertsona")){
							tableroNi[i][j].setBackground(new Color(210,180,140));
						}
						else if(norena.equals("ordenagailua")){
							tableroAurk[i][j].setBackground(new Color(210,180,140));
						}
					}
					else if(zerDa.equals("EzkutuOsoa")){
						if(norena.equals("pertsona")){
							tableroNi[i][j].setBackground(new Color(160,82,45));
						}
						else if(norena.equals("ordenagailua")){
							tableroAurk[i][j].setBackground(new Color(160,82,45));
						}
					}else if(zerDa.equals("EzkutuBakarra")){
						if(norena.equals("pertsona")){
							tableroNi[i][j].setBackground(new Color(205,133,63));
						}
						else if(norena.equals("ordenagailua")){
							tableroAurk[i][j].setBackground(new Color(205,133,63));
						}
					}
					else if(zerDa.equals("OUrperatua")){
						if(norena.equals("pertsona")){
							tableroNi[i][j].setBackground(new Color(255,0,0));
						}
						else if(norena.equals("ordenagailua")){
							tableroAurk[i][j].setBackground(new Color(255,0,0));
						}
					}
					else if(zerDa.equals("OIkutua")){
						if(norena.equals("pertsona")){
								tableroNi[i][j].setBackground(new Color(240,128,128));
						}
						else if(norena.equals("ordenagailua")){
								tableroAurk[i][j].setBackground(new Color(240,128,128));
						}
					}else if(zerDa.equals("UrIkutua")){
						if(norena.equals("pertsona")){
							tableroNi[i][j].setBackground(new Color(70,130,180));
						}
						else if(norena.equals("ordenagailua")){
							tableroAurk[i][j].setBackground(new Color(70,130,180));
						}
	//				}else if(zerDa.equals("OUrperatua")){
	//					if(norena.equals("pertsona")){
	//						tableroNi[i][j].setBackground(new Color(70,225,180));
	//					}
	//					else if(norena.equals("ordenagailua")){
	//						tableroAurk[i][j].setBackground(new Color(70,225,180));
	//					}
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
				int errorea=Jokoa.getNireJokoa().kokatu(koordenatuak[0], koordenatuak[1], aukeratutakoOntzia, kokapena);
				if(errorea==0){
				 tableroaEguneratu("pertsona");
				 tableroaEguneratu("ordenagailua");
				}
				else if(errorea==1){
					new ErroreKudeatzailea("ez dago mota horretako ontzirik");
				}
				else if(errorea==2){
					new WarningKudeatzailea("ezin da gelaxka horretan kokatu");
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
				int i=Jokoa.getNireJokoa().ezktuaJarri(koordenatuak[0],koordenatuak[1]);
				if(i==0){
					tableroaEguneratu("pertsona");
				}
				else if(i==1){
					//ura da
					new WarningKudeatzailea("ez dago ontzirik gelaxka horretan");
				}
				else if(i==2){
					//badauka ezkutua
					new ErroreKudeatzailea("Ontziak jadanik ezkutua du");
				}
				else if(i==3){
					//ez dauka ezkuturik
					new ErroreKudeatzailea("ezkuturik ez");
				}
				else if(i==4){
					new ErroreKudeatzailea("ontzia urperatuta dago");
				}
				
				
			}
		});
		tiroEgin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jokoa.getNireJokoa().tiroEgin(arma,koordenatuak[0],koordenatuak[1]);
				tableroaEguneratu("ordenagailua");
				//poner para pintar
			}
		});
		
		erosi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=Jokoa.getNireJokoa().armaErosi(arma);
				if(i==0){
					//ondo erosi
					new WarningKudeatzailea("Ondo erosi da");
				}
				else if(i==1){
					//ez duzu dirurik
					new WarningKudeatzailea("Ez duzu dirurik eskatutako arma erosteko");
				}
				else if(i==2){
					//ez dago arma existentziarik
					new WarningKudeatzailea("Ez dago arma alerik");
				}
				else if(i==3){
					//ez dago mota horretako armarik
					new WarningKudeatzailea("Ez dago mota horretako alerik");
				}
				
			}
		});
		
		konpondu.addActionListener(new ActionListener() {
			//mirar si al arreglar pasandole (x,y) se suma uno en la cantidad de trozos enteros que le quedan
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=Jokoa.getNireJokoa().ontziaKonpondu(koordenatuak[0],koordenatuak[1]);
				if(i==0){
				tableroaEguneratu("pertsona");	
				}
				else if(i==1){
					//ez du dirurik
					new WarningKudeatzailea("ez duzu diru nahikorik");
				}
				else if(i==2){
					//ontzia osorik
					new ErroreKudeatzailea("ontzia osorik dago");
				}
			}
		});
		
		radarraKontsultatu.addActionListener(new ActionListener() {
			//mirar si al arreglar pasandole (x,y) se suma uno en la cantidad de trozos enteros que le quedan
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] i=Jokoa.getNireJokoa().radarraKontsultatu();
				if(i[0]==0){
					// zein kasillatan dauka
					new WarningKudeatzailea(i[1]+". errenkadan eta "+i[2]+". zutabean ontzi bat dago.");
				}
				else if(i[0]==1){
					// ez daukazu kontsultarik
					new WarningKudeatzailea("Ez zaizu kontsultarik geratzen,beste radar bat erosi");
				}
				else if(i[0]==2){
					//ez dago ontzirik inguruan
					new WarningKudeatzailea("Radarraren eremuan ez dago ontzirik.");
				}
			
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
					arma = "Bonba";
					
				}
			});


	        JRadioButton radarButton = new JRadioButton("Radar");
	        radarButton.setMnemonic('c');
	        radarButton.setActionCommand("Radar");
	        radarButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "Radar";
					
				}
			});
	        
	        JRadioButton misilaButton = new JRadioButton("Misila");
	        misilaButton.setMnemonic('d');
	        misilaButton.setActionCommand("Misila");
	        misilaButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "Misila";
					
				}
			});
	        

	        JRadioButton misilZuzenduaBertButton = new JRadioButton("MisilZuzenduaBertikal");
	        misilZuzenduaBertButton.setMnemonic('r'); //no se que es esto
	        misilZuzenduaBertButton.setActionCommand("MisilZuzenduaBertikal");
	        misilZuzenduaBertButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "MisilZuzenduaBertikal";
					
				}
			});
	        
	        JRadioButton misilZuzenduaHorButton = new JRadioButton("MisilZuzenduaHorizontal");
	        misilZuzenduaHorButton.setMnemonic('r');
	        misilZuzenduaHorButton.setActionCommand("MisilZuzenduaHorizontal");
	        misilZuzenduaHorButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "MisilZuzenduaHorizontal";
					
				}
			});
	        JRadioButton misilZuzenduaBoomButton = new JRadioButton("MisilZuzenduaBoom");
	        misilZuzenduaBoomButton.setMnemonic('r');
	        misilZuzenduaBoomButton.setActionCommand("MisilZuzenduaBoom");
	        misilZuzenduaBoomButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "MisilZuzenduaBoom";
					
				}
			});
	        
	        JRadioButton ezkutuaButton = new JRadioButton("Ezkutua");
	        ezkutuaButton.setMnemonic('e');
	        ezkutuaButton.setActionCommand("Ezkutua");
	        ezkutuaButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					arma = "Ezkutua";
					
				}
			});
	      


	        // Group the radio buttons.
	        ButtonGroup group = new ButtonGroup();
	        group.add(bonbaButton);
	        group.add(radarButton);
	        group.add(misilaButton);
	        group.add(misilZuzenduaBertButton);
	        group.add(misilZuzenduaHorButton);
	        group.add(misilZuzenduaBoomButton);
	        group.add(ezkutuaButton);

        //botoiak gehitu
	        botoiak.add(bonbaButton);
	        botoiak.add(radarButton);
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
		botoiak.add(nireTablero, BorderLayout.SOUTH);
		botoiak.add(new JPanel(), BorderLayout.CENTER);
		botoiak.add(aurkariTablero, BorderLayout.NORTH);
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
