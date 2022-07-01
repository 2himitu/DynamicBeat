package dynamic_beat_13;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exiButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/close botton01.png"));
	private ImageIcon exiButtonBasicImage = new ImageIcon(Main.class.getResource("../images/close botton02.png"));	
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButton01.png"));	
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButton02.png"));	
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButton02.png"));	
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButton01.png"));	
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));	
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));	
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));	
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));	
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/back_normal.png"));	
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/back_hover.png"));	
	
	private ImageIcon nextHoverImage = new ImageIcon(Main.class.getResource("../images/next_hover.png"));	
	private ImageIcon nextPressImage = new ImageIcon(Main.class.getResource("../images/next_press.png"));	
	private ImageIcon prevHoverImage = new ImageIcon(Main.class.getResource("../images/prev_hover.png"));	
	private ImageIcon prevPressImage = new ImageIcon(Main.class.getResource("../images/prev_press.png"));	
	
	
	

	private Image Background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton (exiButtonBasicImage);
	private JButton startButton = new JButton (startButtonBasicImage);
	private JButton quitButton = new JButton (quitButtonBasicImage);
	private JButton nextButton = new JButton (nextHoverImage);
	private JButton prevButton = new JButton (prevHoverImage);
	private JButton easyButton = new JButton (easyButtonBasicImage);
	private JButton hardButton = new JButton (hardButtonBasicImage);
	private JButton backButton = new JButton (backButtonBasicImage);

	private int mouseX,mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	
	ArrayList<Track>trackList =new ArrayList<Track>();
	
	private Music introMusic = new Music("NieR Automata OST-The Weight of the World ENG.mp3", true);
	private Image titleImage ;
	private Image selectedImage;
	private Music selectedMusic ;
	private int nowSelected = 0;
	
	public static  Game game;
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		introMusic.start();
		
		trackList.add(new Track("HIKARUNARA_Title_MEIN.png","HIKARUNARA_MEIN.png","HIKARUNARA.jpg","hikarunara_start.mp3","hikarunara.mp3","HIKARUNARA"));
		trackList.add(new Track("ERROR_Title_MEIN.png","error_MEIN.png","error.png","error_start.mp3","error.mp3","error"));
		trackList.add(new Track("HIMERINNGO_Title_MEIN.png","himerinngo_MEIN.png","himerinngo.jpg","_start.mp3","_.mp3","himerinngo"));
		

		menuBar.setBounds(0, 0, 1200, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX =e.getX();
				mouseY =e.getY();
				
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar);

		exitButton.setBounds(1245,0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exiButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic =new Music ("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exiButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPreseedMusic =new Music ("buttonPreseedMusic.mp3",false);
				buttonPreseedMusic.start();
				try {
					Thread.sleep(1000);
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(exitButton);
		
		startButton.setBounds(40,200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic =new Music ("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPreseedMusic =new Music ("buttonPreseedMusic.mp3",false);
				buttonPreseedMusic.start();
				enterMain();
				
			}
		});
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(startButton);
		
		quitButton.setBounds(40,330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic =new Music ("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPreseedMusic =new Music ("buttonPreseedMusic.mp3",false);
				buttonPreseedMusic.start();
				try {
					Thread.sleep(1000);
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(quitButton);
		
		nextButton.setVisible(false);
		nextButton.setBounds(1080,310, 28, 28);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nextButton.setIcon(nextHoverImage);
				nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic =new Music ("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nextButton.setIcon(nextPressImage);
				nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPreseedMusic =new Music ("buttonPreseedMusic.mp3",false);
				buttonPreseedMusic.start();
				selectedPrev();
			}
		});
		nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(nextButton);
		
		prevButton.setVisible(false);
		prevButton.setBounds(140,310, 28, 28);
		prevButton.setBorderPainted(false);
		prevButton.setContentAreaFilled(false);
		prevButton.setFocusPainted(false);
		prevButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				prevButton.setIcon(prevHoverImage);
				prevButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic =new Music ("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				prevButton.setIcon(prevPressImage);
				prevButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPreseedMusic =new Music ("buttonPreseedMusic.mp3",false);
				buttonPreseedMusic.start();
				selectedNext();
			}
		});
		prevButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(prevButton);

	
	easyButton.setVisible(false);
	easyButton.setBounds(375,580,250, 67);
	easyButton.setBorderPainted(false);
	easyButton.setContentAreaFilled(false);
	easyButton.setFocusPainted(false);
	easyButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			easyButton.setIcon(easyButtonBasicImage);
			easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Music buttonEnteredMusic =new Music ("buttonEnteredMusic.mp3",false);
			buttonEnteredMusic.start();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			easyButton.setIcon(easyButtonEnteredImage);
			easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPreseedMusic =new Music ("buttonPreseedMusic.mp3",false);
			buttonPreseedMusic.start();
			gameStart(nowSelected,"Easy");
		}
	});
	add(easyButton);

	hardButton.setVisible(false);
	hardButton.setBounds(655,580,250, 67);
	hardButton.setBorderPainted(false);
	hardButton.setContentAreaFilled(false);
	hardButton.setFocusPainted(false);
	hardButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			hardButton.setIcon(hardButtonBasicImage);
			hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Music buttonEnteredMusic =new Music ("buttonEnteredMusic.mp3",false);
			buttonEnteredMusic.start();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			hardButton.setIcon(hardButtonEnteredImage);
			hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPreseedMusic =new Music ("buttonPreseedMusic.mp3",false);
			buttonPreseedMusic.start();
			gameStart(nowSelected,"Hard");
		}
	});
	add(hardButton);
	
	backButton.setVisible(false);
	backButton.setBounds(20,50,26,26);
	backButton.setBorderPainted(false);
	backButton.setContentAreaFilled(false);
	backButton.setFocusPainted(false);
	backButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			backButton.setIcon(backButtonBasicImage);
			backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Music buttonEnteredMusic =new Music ("buttonEnteredMusic.mp3",false);
			buttonEnteredMusic.start();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			backButton.setIcon(backButtonEnteredImage);
			backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPreseedMusic =new Music ("buttonPreseedMusic.mp3",false);
			buttonPreseedMusic.start();
			backMain();
		}
	});
	add(backButton);
	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(Background, 0, 0, null);
		if (isMainScreen) {
			g.drawImage(selectedImage,340,100,null);
			g.drawImage(titleImage,340,70,null);
		}
		if (isGameScreen) 
		{
			game.screenDraw(g);
		}
		paintComponents(g);
		this.repaint();
	}
	public void selectTrack(int nowselecked) {
		if(selectedMusic !=null) 
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowselecked).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowselecked).getStartImage())).getImage();
		selectedMusic =new Music(trackList.get(nowselecked).getStartMusic(),true);
		selectedMusic.start();
		
			}
	public void selectedNext() {
		if(nowSelected == 0) 
			nowSelected = trackList.size()-1;
		else 
			nowSelected --;
		selectTrack(nowSelected);
	}
	public void selectedPrev() {
		if(nowSelected == trackList.size()-1) 
			nowSelected = 0;
		else 
			nowSelected ++;
		selectTrack(nowSelected);
	}
	public void gameStart (int nowSelected,String difficlty) {
		if(selectedMusic !=null)
		selectedMusic.close();
		isMainScreen =false;
		prevButton.setVisible(false);
		nextButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);	
		isGameScreen = true;
		setFocusable(true);
		game = new Game (trackList.get(nowSelected).getTitleName(),difficlty,trackList.get(nowSelected).getGameMusic());
		}
	public void backMain() {
		isMainScreen = true;
		prevButton.setVisible(true);
		nextButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		Background = new ImageIcon(Main.class.getResource("../images/music_Background.jpg")).getImage();
		backButton.setVisible(false);	
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
	}
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/music_Background.jpg")).getImage();
		isMainScreen = true;
		nextButton.setVisible(true);
		prevButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		
		selectTrack(0);
	}
}
