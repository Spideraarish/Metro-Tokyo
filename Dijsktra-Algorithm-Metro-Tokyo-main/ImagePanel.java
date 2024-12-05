import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JFrame {
	
	Panel mainPanel = new Panel();
	BufferedImage img;
	
	public ImagePanel() {
		try {
			img=ImageIO.read(getClass().getClassLoader().getResource("metro.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		this.setTitle("Metro Tokyo");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.prepareImage(img, mainPanel);
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);

		this.setSize(new Dimension(960, 768));
		this.setLocationRelativeTo(null);	//	If the value null is passed, it is positioned in the center of the screen 
		// Possible solution to get origin and destination

		this.add(mainPanel);
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + "," + e.getY());
			}
		});

	}

	class Panel extends JPanel {

		private ArrayList<Station> allStations;
		private ArrayList<String> minimumPath;

		public void setMinimumPath(ArrayList<String> minimumPath) {
			this.minimumPath = minimumPath;
			allStations = new ArrayList<Station>();
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			int circleSize = 18;
		
			// GREEN Line (g1)

			Graphics2D g1 = (Graphics2D) g; 
			g1.setColor(Color.DARK_GRAY);

			Station ikebukuro = new Station("Ikebukuro", 226-10, 186-10, circleSize, circleSize);
			allStations.add(ikebukuro);
			Station ikebukuroG = new Station("IkebukuroG", 226-10, 186-10, circleSize, circleSize);
			allStations.add(ikebukuroG);
			Station higashiShinjuku = new Station("Higashi-Shinjuku", 227-10, 281-10, circleSize, circleSize);
			allStations.add(higashiShinjuku);
			Station higashiShinjukuG = new Station("Higashi-ShinjukuG", 227-10, 281-10, circleSize, circleSize);
			allStations.add(higashiShinjukuG);
			Station shinjukuSanchome = new Station("Shinjuku-Sanchome", 228-10, 376-10, circleSize, circleSize);
			allStations.add(shinjukuSanchome);
			Station shinjukuSanchomeG = new Station("Shinjuku-SanchomeG", 228-10, 376-10, circleSize, circleSize);
			allStations.add(shinjukuSanchomeG);
			Station meijiJingumae = new Station("Meiji-Jingumae", 228-10, 527-10, circleSize, circleSize);
			allStations.add(meijiJingumae);
			Station shibuya = new Station("Shibuya", 228-10, 592-10, circleSize, circleSize);
			allStations.add(shibuya);
			Station shibuyaG = new Station("ShibuyaG", 228-10, 592-10, circleSize, circleSize);
			allStations.add(shibuyaG);
			

			g1.draw(ikebukuro.getEllipseStation());
			g1.draw(ikebukuroG.getEllipseStation());
			g1.draw(higashiShinjuku.getEllipseStation());
			g1.draw(higashiShinjukuG.getEllipseStation());
			g1.draw(shinjukuSanchome.getEllipseStation());
			g1.draw(shinjukuSanchomeG.getEllipseStation());
			g1.draw(meijiJingumae.getEllipseStation());
			g1.draw(shibuya.getEllipseStation());
			g1.draw(shibuyaG.getEllipseStation());

			g1.fill(ikebukuro.getEllipseStation());
			g1.fill(ikebukuroG.getEllipseStation());
			g1.fill(higashiShinjuku.getEllipseStation());
			g1.fill(higashiShinjukuG.getEllipseStation());
			g1.fill(shinjukuSanchome.getEllipseStation());
			g1.fill(shinjukuSanchomeG.getEllipseStation());
			g1.fill(meijiJingumae.getEllipseStation());
			g1.fill(shibuya.getEllipseStation());
			g1.fill(shibuyaG.getEllipseStation());


			// YELLOW Line (g2)

			Graphics2D g2 = (Graphics2D) g; 
			g2.setColor(Color.DARK_GRAY);

			Station higashishinjuku = new Station("Higashi-shinjuku", 227-10, 281-10, circleSize, circleSize); 
			allStations.add(higashishinjuku);
			Station higashishinjukuY = new Station("Higashi-shinjukuY", 227-10, 281-10, circleSize, circleSize);
			allStations.add(higashishinjukuY);
			Station tochomae = new Station("Tochomae", 54-10, 398-10, circleSize, circleSize);
			allStations.add(tochomae);
			Station shinjukunishiguchi = new Station("Shinjuku-nishiguchi", 148-10, 396-10, circleSize, circleSize);
			allStations.add(shinjukunishiguchi);
			Station aoyamaItchome = new Station("Aoyama-itchome", 362-10, 472-10, circleSize, circleSize);
			allStations.add(aoyamaItchome);
			Station aoyamaItchomeY = new Station("Aoyama-itchomeY", 362-10, 472-10, circleSize, circleSize);
			allStations.add(aoyamaItchomeY);
			Station roppongi = new Station("Roppongi", 438-10, 547-10, circleSize, circleSize);
			allStations.add(roppongi);
			Station daimon = new Station("Daimon", 595-10, 580-10, circleSize, circleSize);
			allStations.add(daimon);
			Station akabanebashi = new Station("Akabanebashi", 522-10, 580-10, circleSize, circleSize);
			allStations.add(akabanebashi);
			Station kasuga = new Station("Kasuga", 491-10, 172-10, circleSize, circleSize);
			allStations.add(kasuga);
			Station hongosanchome = new Station("Hongosanchome", 592-10, 203-10, circleSize, circleSize);
			allStations.add(hongosanchome);
			Station hongosanchomeY = new Station("HongosanchomeY", 592-10, 203-10, circleSize, circleSize);
			allStations.add(hongosanchomeY);
			Station uenoOkachimachi = new Station("Ueno-okachimachi", 748-10, 203-10, circleSize, circleSize);
			allStations.add(uenoOkachimachi);
			Station uenoOkachimachiY = new Station("Ueno-okachimachiY", 748-10, 203-10, circleSize, circleSize);
			allStations.add(uenoOkachimachiY);
			Station ryogoku = new Station("Ryogoku", 840-10, 249-10, circleSize, circleSize);
			allStations.add(ryogoku);
			Station kiyosumiShirakawa = new Station("Kiyosumi-shirakawa", 840-10, 320-10, circleSize, circleSize);
			allStations.add(kiyosumiShirakawa);
			Station tsukishima = new Station("Tsukishima", 842-10, 393-10, circleSize, circleSize);
			allStations.add(tsukishima);
			Station tsukijishijo = new Station("Tsukijishijo", 791-10, 461-10, circleSize, circleSize);
			allStations.add(tsukijishijo);
			Station shidome = new Station("Shidome", 711-10, 537-10, circleSize, circleSize);
			allStations.add(shidome);


			g2.draw(higashishinjuku.getEllipseStation());
			g2.draw(higashishinjukuY.getEllipseStation());
			g2.draw(tochomae.getEllipseStation());
			g2.draw(shinjukunishiguchi.getEllipseStation());
			g2.draw(aoyamaItchome.getEllipseStation());
			g2.draw(aoyamaItchomeY.getEllipseStation());
			g2.draw(roppongi.getEllipseStation());
			g2.draw(daimon.getEllipseStation());
			g2.draw(akabanebashi.getEllipseStation());
			g2.draw(kasuga.getEllipseStation());
			g2.draw(hongosanchome.getEllipseStation());
			g2.draw(hongosanchomeY.getEllipseStation());
			g2.draw(uenoOkachimachi.getEllipseStation());
			g2.draw(uenoOkachimachiY.getEllipseStation());
			g2.draw(ryogoku.getEllipseStation());
			g2.draw(kiyosumiShirakawa.getEllipseStation());
			g2.draw(tsukishima.getEllipseStation());
			g2.draw(tsukijishijo.getEllipseStation());
			g2.draw(shidome.getEllipseStation());

			g2.fill(higashishinjuku.getEllipseStation());
			g2.fill(tochomae.getEllipseStation());
			g2.fill(shinjukunishiguchi.getEllipseStation());
			g2.fill(aoyamaItchome.getEllipseStation());
			g2.fill(roppongi.getEllipseStation());
			g2.fill(daimon.getEllipseStation());
			g2.fill(akabanebashi.getEllipseStation());
			g2.fill(kasuga.getEllipseStation());
			g2.fill(hongosanchome.getEllipseStation());
			g2.fill(uenoOkachimachi.getEllipseStation());
			g2.fill(ryogoku.getEllipseStation());
			g2.fill(kiyosumiShirakawa.getEllipseStation());
			g2.fill(tsukishima.getEllipseStation());
			g2.fill(tsukijishijo.getEllipseStation());
			g2.fill(shidome.getEllipseStation());
			g2.fill(higashishinjukuY.getEllipseStation());
			g2.fill(aoyamaItchomeY.getEllipseStation());
			g2.fill(hongosanchomeY.getEllipseStation());
			g2.fill(uenoOkachimachiY.getEllipseStation());

			// RED Line (g3)

			Graphics2D g3 = (Graphics2D) g; 
			g3.setColor(Color.DARK_GRAY);

			Station nishiShinjuku = new Station("Nishi-Shinjuku", 54-10, 376-10, circleSize, circleSize);
			allStations.add(nishiShinjuku);
			Station shinjuku = new Station("Shinjuku", 159-10, 377-10, circleSize, circleSize);
			allStations.add(shinjuku);
			Station shinjukuSanchomeR = new Station("Shinjuku-SanchomeR", 228-10, 376-10, circleSize, circleSize);
			allStations.add(shinjukuSanchomeR);
			Station akasakaMitsuke = new Station("Akasaka-Mitsuke", 438-10, 415-10, circleSize, circleSize);
			allStations.add(akasakaMitsuke);
			Station akasakaMitsukeR = new Station("Akasaka-MitsukeR", 438-10, 415-10, circleSize, circleSize);
			allStations.add(akasakaMitsukeR);
			Station kasumigaseki = new Station("Kasumigaseki", 570-10, 434-10, circleSize, circleSize);
			allStations.add(kasumigaseki);
			Station ginza = new Station("Ginza", 685-10, 417-10, circleSize, circleSize);
			allStations.add(ginza);
			Station ginzaR = new Station("GinzaR", 685-10, 417-10, circleSize, circleSize);
			allStations.add(ginzaR);
			Station tokyo = new Station("Tokyo", 652-10, 345-10, circleSize, circleSize);
			allStations.add(tokyo);
			Station tokyoR = new Station("TokyoR", 652-10, 345-10, circleSize, circleSize);
			allStations.add(tokyoR);
			Station otemachi = new Station("Otemachi", 652-10, 317-10, circleSize, circleSize);
			allStations.add(otemachi);
			Station hongoSanchomeR = new Station("Hongo-SanchomeR", 592-10, 203-10, circleSize, circleSize);
			allStations.add(hongoSanchomeR);
			Station korakuen = new Station("Korakuen", 492-10, 202-10, circleSize, circleSize);
			allStations.add(korakuen);
			Station ikebukuroR = new Station("IkebukuroR", 226-10, 186-10, circleSize, circleSize);
			allStations.add(ikebukuroR);

			g3.draw(nishiShinjuku.getEllipseStation());   
			g3.draw(shinjuku.getEllipseStation());
			g3.draw(shinjukuSanchomeR.getEllipseStation());
			g3.draw(akasakaMitsuke.getEllipseStation());
			g3.draw(akasakaMitsukeR.getEllipseStation());
			g3.draw(kasumigaseki.getEllipseStation());
			g3.draw(ginza.getEllipseStation());
			g3.draw(ginzaR.getEllipseStation());
			g3.draw(tokyo.getEllipseStation());
			g3.draw(tokyoR.getEllipseStation());
			g3.draw(otemachi.getEllipseStation());
			g3.draw(hongoSanchomeR.getEllipseStation());
			g3.draw(korakuen.getEllipseStation());
			g3.draw(ikebukuroR.getEllipseStation());

			g3.fill(nishiShinjuku.getEllipseStation());
			g3.fill(shinjuku.getEllipseStation());
			g3.fill(shinjukuSanchomeR.getEllipseStation());
			g3.fill(akasakaMitsuke.getEllipseStation());
			g3.fill(akasakaMitsukeR.getEllipseStation());
			g3.fill(kasumigaseki.getEllipseStation());
			g3.fill(ginza.getEllipseStation());
			g3.fill(ginzaR.getEllipseStation());
			g3.fill(tokyo.getEllipseStation());
			g3.fill(tokyoR.getEllipseStation());
			g3.fill(otemachi.getEllipseStation());
			g3.fill(hongoSanchomeR.getEllipseStation());
			g3.fill(korakuen.getEllipseStation());
			g3.fill(ikebukuroR.getEllipseStation());

			// BLUE Line (g4)

			Graphics2D g4 = (Graphics2D) g; 
			g4.setColor(Color.DARK_GRAY);

			Station shibuyaB = new Station("ShibuyaB", 228-10, 592-10, circleSize, circleSize);
			allStations.add(shibuyaB);
			Station omoteSando = new Station("Omote-Sando", 301-10, 528-10, circleSize, circleSize);
			allStations.add(omoteSando);
			Station aoyamaItchomeB = new Station("Aoyama-itchomeB", 362-10, 472-10, circleSize, circleSize);
			allStations.add(aoyamaItchomeB);
			Station akasakaMitsukeB = new Station("Akasaka-mitsukeB", 438-10, 415-10, circleSize, circleSize);
			allStations.add(akasakaMitsukeB);
			Station shimbashi = new Station("Shimbashi", 620-10, 514-10, circleSize, circleSize);
			allStations.add(shimbashi);
			Station shimbashiB = new Station("ShimbashiB", 620-10, 514-10, circleSize, circleSize);
			allStations.add(shimbashiB);
			Station ginzaB = new Station("GinzaB", 685-10, 417-10, circleSize, circleSize);
			allStations.add(ginzaB);
			Station mitsukoshimae = new Station("Mitsukoshimae", 717-10, 325-10, circleSize, circleSize);
			allStations.add(mitsukoshimae);
			Station kanda = new Station("Kanda", 716-10, 290-10, circleSize, circleSize);
			allStations.add(kanda);
			Station suehirocho = new Station("Suehirocho", 717-10, 255-10, circleSize, circleSize);
			allStations.add(suehirocho);
			Station uenoHirokoji = new Station("Ueno-hirokoji", 716-10, 181-10, circleSize, circleSize);
			allStations.add(uenoHirokoji);
			Station ueno = new Station("Ueno", 748-10, 157-10, circleSize, circleSize);
			allStations.add(ueno);
			Station uenoB = new Station("UenoB", 748-10, 157-10, circleSize, circleSize);
			allStations.add(uenoB);
			Station asakusa = new Station("Asakusa", 845-10, 157-10, circleSize, circleSize);
			allStations.add(asakusa);

			g4.draw(shibuyaB.getEllipseStation());
			g4.draw(omoteSando.getEllipseStation());
			g4.draw(aoyamaItchomeB.getEllipseStation());
			g4.draw(akasakaMitsukeB.getEllipseStation());
			g4.draw(shimbashi.getEllipseStation());
			g4.draw(shimbashiB.getEllipseStation());
			g4.draw(ginzaB.getEllipseStation());
			g4.draw(mitsukoshimae.getEllipseStation());
			g4.draw(kanda.getEllipseStation());
			g4.draw(suehirocho.getEllipseStation());
			g4.draw(uenoHirokoji.getEllipseStation());
			g4.draw(ueno.getEllipseStation());
			g4.draw(uenoB.getEllipseStation());
			g4.draw(asakusa.getEllipseStation());

			g4.fill(shibuyaB.getEllipseStation());
			g4.fill(omoteSando.getEllipseStation());
			g4.fill(aoyamaItchomeB.getEllipseStation());
			g4.fill(akasakaMitsukeB.getEllipseStation());
			g4.fill(shimbashi.getEllipseStation());
			g4.fill(shimbashiB.getEllipseStation());
			g4.fill(ginzaB.getEllipseStation());
			g4.fill(mitsukoshimae.getEllipseStation());
			g4.fill(kanda.getEllipseStation());
			g4.fill(suehirocho.getEllipseStation());
			g4.fill(uenoHirokoji.getEllipseStation());
			g4.fill(ueno.getEllipseStation());
			g4.fill(uenoB.getEllipseStation());
			g4.fill(asakusa.getEllipseStation());

			// PURPLE Line (g5)

			Graphics2D g5 = (Graphics2D) g; 
			g5.setColor(Color.DARK_GRAY);

			Station shibuyaP = new Station("ShibuyaP", 228-10, 592-10, circleSize, circleSize);
			allStations.add(shibuyaP);
			Station ikebukuroP = new Station("IkebukuroP", 226-10, 186-10, circleSize, circleSize);
			allStations.add(ikebukuroP);
			Station nippori = new Station("Nippori", 656-10, 112-10, circleSize, circleSize);
			allStations.add(nippori);
			Station ebisu = new Station("Ebisu", 301-10, 620-10, circleSize, circleSize);
			allStations.add(ebisu);
			Station uenoP = new Station("Ueno", 748-10, 157-10, circleSize, circleSize);
			allStations.add(uenoP);
			Station akihabara = new Station("Akihabara", 750-10, 254-10, circleSize, circleSize);
			allStations.add(akihabara);
			Station tokyoP = new Station("TokyoP", 652-10, 345-10, circleSize, circleSize);
			allStations.add(tokyoP);
			Station uenoOkachimachiP = new Station("Ueno-okachimachiP", 748-10, 203-10, circleSize, circleSize);
			allStations.add(uenoOkachimachiP);
			Station shimbashiP = new Station("ShimbashiP", 620-10, 514-10, circleSize, circleSize);
			allStations.add(shimbashiP);

			g5.draw(shibuyaP.getEllipseStation());
			g5.draw(ikebukuroP.getEllipseStation());
			g5.draw(nippori.getEllipseStation());
			g5.draw(ebisu.getEllipseStation());
			g5.draw(uenoP.getEllipseStation());
			g5.draw(akihabara.getEllipseStation());
			g5.draw(tokyoP.getEllipseStation());
			g5.draw(uenoOkachimachiP.getEllipseStation());
			g5.draw(shimbashiP.getEllipseStation());

			g5.fill(shibuyaP.getEllipseStation());
			g5.fill(ikebukuroP.getEllipseStation());
			g5.fill(nippori.getEllipseStation());
			g5.fill(ebisu.getEllipseStation());
			g5.fill(uenoP.getEllipseStation());
			g5.fill(akihabara.getEllipseStation());
			g5.fill(tokyoP.getEllipseStation());
			g5.fill(uenoOkachimachiP.getEllipseStation());
			g5.fill(shimbashiP.getEllipseStation());


			// Finding Shortest path and highlight Station nodes in BLUE (Along with marking two or more connections on one station)
			Graphics2D g6 = (Graphics2D) g;
			g6.setColor(Color.BLUE);

			ArrayList<Ellipse2D.Double> minimumPathEllipse = new ArrayList<Ellipse2D.Double>();

			for(int i=0; i<minimumPath.size(); i++) {
				for(int j=0; j<allStations.size(); j++) {
					if(minimumPath.get(i).equals(allStations.get(j).getName())) {
						minimumPathEllipse.add(allStations.get(j).getEllipseStation());

						if(allStations.get(j).getName().equals("Ikebukuro") || allStations.get(j).getName().equals("IkebukuroR") || allStations.get(j).getName().equals("IkebukuroG") || allStations.get(j).getName().equals("IkebukuroP")) {
							g6.draw(ikebukuroG.getEllipseStation());
							g6.fill(ikebukuroG.getEllipseStation());
						} // done the first one for your reference. follow along for the rest of the connections.
	
						else if(allStations.get(j).getName().equals("Shibuya") || allStations.get(j).getName().equals("ShibuyaG") || allStations.get(j).getName().equals("ShibuyaB")) {
							g6.draw(shibuyaG.getEllipseStation());
							g6.fill(shibuyaG.getEllipseStation());
							
						}
						else if(allStations.get(j).getName().equals("Shinjuku-Sanchome") || allStations.get(j).getName().equals("Shinjuku-SanchomeG") || allStations.get(j).getName().equals("Shinjuku-SanchomeR")) {
							g6.draw(shinjukuSanchomeR.getEllipseStation());
							g6.fill(shinjukuSanchomeR.getEllipseStation());
						}
						else if(allStations.get(j).getName().equals("Aoyama-itchome") || allStations.get(j).getName().equals("Aoyama-itchomeY") || allStations.get(j).getName().equals("Aoyama-itchomeB")) {
							g6.draw(aoyamaItchomeB.getEllipseStation());
							g6.fill(aoyamaItchomeB.getEllipseStation());
						}
						else if(allStations.get(j).getName().equals("Akasaka-Mitsuke") || allStations.get(j).getName().equals("Akasaka-MitsukeB") || allStations.get(j).getName().equals("Akasaka-MitsukeR")) {
							g6.draw(akasakaMitsukeB.getEllipseStation());
							g6.fill(akasakaMitsukeB.getEllipseStation());
						}
						else if(allStations.get(j).getName().equals("Ginza") || allStations.get(j).getName().equals("GinzaR") || allStations.get(j).getName().equals("GinzaB")) {
							g6.draw(ginzaB.getEllipseStation());
							g6.fill(ginzaB.getEllipseStation());
						}
						else if(allStations.get(j).getName().equals("Ueno") || allStations.get(j).getName().equals("UenoB") || allStations.get(j).getName().equals("UenoB") || allStations.get(j).getName().equals("UenoB") || allStations.get(j).getName().equals("UenoB") || allStations.get(j).getName().equals("UenoB")) {
							g6.draw(uenoB.getEllipseStation());
							g6.fill(uenoB.getEllipseStation());
						}
						else if(allStations.get(j).getName().equals("Tokyo") || allStations.get(j).getName().equals("TokyoR") || allStations.get(j).getName().equals("TokyoR")) {
							g6.draw(tokyoR.getEllipseStation());
							g6.fill(tokyoR.getEllipseStation());
						}
						else if(allStations.get(j).getName().equals("Shimbashi") || allStations.get(j).getName().equals("ShimbashiB") || allStations.get(j).getName().equals("ShimbashiB")) {
							g6.draw(shimbashiB.getEllipseStation());
							g6.fill(shimbashiB.getEllipseStation());
						}
						else if(allStations.get(j).getName().equals("Higashi-Shinjuku") || allStations.get(j).getName().equals("Higashi-ShinjukuG") || allStations.get(j).getName().equals("Higashi-ShinjukuY")) {
							g6.draw(higashishinjukuY.getEllipseStation());
							g6.fill(higashishinjukuY.getEllipseStation());
						}
						
						else if(allStations.get(j).getName().equals("Hongo-Sanchome") || allStations.get(j).getName().equals("Hongo-SanchomeR") || allStations.get(j).getName().equals("Hongo-SanchomeY")) {
							g6.draw(hongoSanchomeR.getEllipseStation());
							g6.fill(hongoSanchomeR.getEllipseStation());
						}
						else if(allStations.get(j).getName().equals("Ueno-okachimachi") || allStations.get(j).getName().equals("Ueno-okachimachiP") || allStations.get(j).getName().equals("Ueno-okachimachiP")) {
							g6.draw(uenoOkachimachiP.getEllipseStation());
							g6.fill(uenoOkachimachiP.getEllipseStation());
						}
						else {
							g6.draw(allStations.get(j).getEllipseStation());
							g6.fill(allStations.get(j).getEllipseStation());
						}
					}
				}
			}
		}
	}

	// INITIAL PAGE


	public static void main(String[] args) throws InterruptedException {
		String origin = JOptionPane.showInputDialog("Enter source (first letter capitalized):");
		String destination = JOptionPane.showInputDialog("Enter destination (first letter capitalized):");
		MapRepresentation map=new MapRepresentation();
		Graph graph = MapRepresentation.getStations();
		Node original=graph.getNode(origin);
		Node destinations=graph.getNode(destination);
		map.shortestPath(original, destinations);

		ImagePanel ip = new ImagePanel();
		
		//ArrayList<String> minimumPath = map.getMinimumPathCondensed();
		//ip.mainPanel.setMinimumPath(minimumPath);
		//System.out.println(minimumPath);

		ArrayList<String> minimumShortestPath = map.getMinimumPathCondensed();
		ip.mainPanel.setMinimumPath(minimumShortestPath);
		System.out.println(minimumShortestPath);
	}

}
