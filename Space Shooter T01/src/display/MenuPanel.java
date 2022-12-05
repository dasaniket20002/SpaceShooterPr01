/*     */ package display;
/*     */ 
/*     */ import containers.SpriteContainer;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.MouseInfo;
/*     */ import java.awt.Point;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.Timer;
/*     */ import loader.ImageLoader;
/*     */ import sprites.Button;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MenuPanel
/*     */   extends JPanel
/*     */   implements ActionListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final int BASE = 250;
/*     */   private static final int PARTITION = 115;
/*     */   private static int WIDTH;
/*     */   private static int HEIGHT;
/*     */   private Button playButton;
/*     */   private Button optionButton;
/*     */   private Button exitButton;
/*     */   private Button backButton;
/*     */   private BufferedImage playSpt;
/*     */   private BufferedImage optionSpt;
/*     */   private BufferedImage exitSpt;
/*     */   private BufferedImage backSpt;
/*     */   private int currentScale;
/*     */   private boolean isOptionClicked;
/*     */   private boolean canBePlayed;
/*     */   private BufferedImage background;
/*     */   public Timer menuTimer;
/*     */   
/*     */   public MenuPanel() {
/*  50 */     WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
/*  51 */     HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
/*     */     
/*  53 */     int PLAY_BUTTON_POS = 250;
/*  54 */     int OPTION_BUTTON_POS = 365;
/*  55 */     int EXIT_BUTTON_POS = 480;
/*     */     
/*  57 */     this.currentScale = 10;
/*  58 */     this.isOptionClicked = false;
/*  59 */     this.canBePlayed = true;
/*     */     
/*  61 */     int PLAY_ALIGN = (WIDTH - ((BufferedImage)SpriteContainer.getPlayButton().get(0)).getWidth()) / 2;
/*  62 */     int OPTION_ALIGN = (WIDTH - ((BufferedImage)SpriteContainer.getOptionButton().get(0)).getWidth()) / 2;
/*  63 */     int EXIT_ALIGN = (WIDTH - ((BufferedImage)SpriteContainer.getExitButton().get(0)).getWidth()) / 2;
/*     */     
/*  65 */     this.playButton = new Button();
/*  66 */     this.playButton.setButtonType("PLAY");
/*  67 */     this.playButton.setX(PLAY_ALIGN);
/*  68 */     this.playButton.setY(PLAY_BUTTON_POS);
/*     */     
/*  70 */     this.optionButton = new Button();
/*  71 */     this.optionButton.setButtonType("OPTION");
/*  72 */     this.optionButton.setX(OPTION_ALIGN);
/*  73 */     this.optionButton.setY(OPTION_BUTTON_POS);
/*     */     
/*  75 */     this.exitButton = new Button();
/*  76 */     this.exitButton.setButtonType("EXIT");
/*  77 */     this.exitButton.setX(EXIT_ALIGN);
/*  78 */     this.exitButton.setY(EXIT_BUTTON_POS);
/*     */     
/*  80 */     this.backButton = new Button();
/*  81 */     this.backButton.setButtonType("BACK");
/*  82 */     this.backButton.setX((int)(0.05D * WIDTH));
/*  83 */     this.backButton.setY((int)(0.05D * HEIGHT));
/*     */     
/*  85 */     this.background = ImageLoader.getResizedImage(SpriteContainer.getBackground(), WIDTH, HEIGHT);
/*     */     
/*  87 */     this.playSpt = new BufferedImage(this.playButton.getWIDTH(), this.playButton.getHEIGHT(), 2);
/*  88 */     this.optionSpt = new BufferedImage(this.optionButton.getWIDTH(), this.optionButton.getHEIGHT(), 2);
/*  89 */     this.exitSpt = new BufferedImage(this.exitButton.getWIDTH(), this.exitButton.getHEIGHT(), 2);
/*  90 */     this.backSpt = new BufferedImage(this.backButton.getWIDTH(), this.backButton.getHEIGHT(), 2);
/*     */     
/*  92 */     this.menuTimer = new Timer(2, this);
/*     */     
/*  94 */     setSize(WIDTH, HEIGHT);
/*     */     
/*  96 */     addMouseListener(new MouseAdapter()
/*     */         {
/*     */           
/*     */           public void mouseClicked(MouseEvent e)
/*     */           {
/* 101 */             MenuPanel.this.checkClicked(new Point(e.getX(), e.getY()));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintComponent(Graphics g) {
/* 111 */     super.paintComponent(g);
/*     */     
/* 113 */     Graphics2D g2d = (Graphics2D)g;
/*     */     
/* 115 */     doBackGroundDrawing(g2d);
/*     */     
/* 117 */     if (!this.isOptionClicked) {
/* 118 */       drawButtons(g2d);
/*     */     } else {
/*     */       
/* 121 */       drawOptionPanel(g2d);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void doBackGroundDrawing(Graphics2D g2d) {
/* 126 */     g2d.drawImage(this.background, 0, 0, null);
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawButtons(Graphics2D g2d) {
/* 131 */     g2d.drawImage(this.playSpt, this.playButton.getX(), this.playButton.getY(), null);
/* 132 */     g2d.drawImage(this.optionSpt, this.optionButton.getX(), this.optionButton.getY(), null);
/* 133 */     g2d.drawImage(this.exitSpt, this.exitButton.getX(), this.exitButton.getY(), null);
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawOptionPanel(Graphics2D g2d) {
/* 138 */     g2d.drawImage(this.backSpt, this.backButton.getX(), this.backButton.getY(), null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 144 */     if (this.currentScale > 1) {
/* 145 */       this.playSpt = ImageLoader.getResizedImage(this.playButton.getCurrentImage(), this.playButton.getWIDTH() / this.currentScale, this.playButton.getHEIGHT() / this.currentScale);
/* 146 */       this.optionSpt = ImageLoader.getResizedImage(this.optionButton.getCurrentImage(), this.optionButton.getWIDTH() / this.currentScale, this.optionButton.getHEIGHT() / this.currentScale);
/* 147 */       this.exitSpt = ImageLoader.getResizedImage(this.exitButton.getCurrentImage(), this.exitButton.getWIDTH() / this.currentScale, this.exitButton.getHEIGHT() / this.currentScale);
/* 148 */       this.backSpt = this.backButton.getCurrentImage();
/*     */       
/* 150 */       this.currentScale--;
/*     */     }
/*     */     else {
/*     */       
/* 154 */       this.playSpt = this.playButton.getCurrentImage();
/* 155 */       this.optionSpt = this.optionButton.getCurrentImage();
/* 156 */       this.exitSpt = this.exitButton.getCurrentImage();
/* 157 */       this.backSpt = this.backButton.getCurrentImage();
/*     */     } 
/*     */ 
/*     */     
/* 161 */     repaint();
/*     */     
/* 163 */     mouseEntered(MouseInfo.getPointerInfo().getLocation());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseEntered(Point e) {
/* 169 */     if (this.canBePlayed) {
/* 170 */       if (e.getX() >= this.playButton.getX() && e.getY() >= this.playButton.getY() && e.getX() < (this.playButton.getX() + this.playButton.getWIDTH()) && e.getY() < (this.playButton.getY() + this.playButton.getHEIGHT())) {
/* 171 */         this.playButton.setCurrentImageIndex(1);
/*     */       } else {
/* 173 */         this.playButton.setCurrentImageIndex(0);
/*     */       } 
/*     */     }
/* 176 */     if (e.getX() >= this.optionButton.getX() && e.getY() >= this.optionButton.getY() && e.getX() < (this.optionButton.getX() + this.optionButton.getWIDTH()) && e.getY() < (this.optionButton.getY() + this.optionButton.getHEIGHT())) {
/* 177 */       this.optionButton.setCurrentImageIndex(1);
/*     */     } else {
/* 179 */       this.optionButton.setCurrentImageIndex(0);
/*     */     } 
/* 181 */     if (e.getX() >= this.exitButton.getX() && e.getY() >= this.exitButton.getY() && e.getX() < (this.exitButton.getX() + this.exitButton.getWIDTH()) && e.getY() < (this.exitButton.getY() + this.exitButton.getHEIGHT())) {
/* 182 */       this.exitButton.setCurrentImageIndex(1);
/*     */     } else {
/* 184 */       this.exitButton.setCurrentImageIndex(0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void checkClicked(Point e) {
/* 189 */     if (!this.isOptionClicked) {
/* 190 */       if (this.canBePlayed && 
/* 191 */         e.getX() >= this.playButton.getX() && e.getY() >= this.playButton.getY() && e.getX() < (this.playButton.getX() + this.playButton.getWIDTH()) && e.getY() < (this.playButton.getY() + this.playButton.getHEIGHT())) {
/* 192 */         this.playButton.setCurrentImageIndex(2);
/*     */         
/*     */         try {
/* 195 */           Thread.sleep(100L);
/* 196 */         } catch (InterruptedException e1) {
/* 197 */           e1.printStackTrace();
/*     */         } 
/*     */         
/* 200 */         setVisible(false);
/* 201 */         this.menuTimer.stop();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 206 */       if (e.getX() >= this.optionButton.getX() && e.getY() >= this.optionButton.getY() && e.getX() < (this.optionButton.getX() + this.optionButton.getWIDTH()) && e.getY() < (this.optionButton.getY() + this.optionButton.getHEIGHT())) {
/* 207 */         this.optionButton.setCurrentImageIndex(1);
/* 208 */         this.isOptionClicked = true;
/*     */       } 
/*     */       
/* 211 */       if (e.getX() >= this.exitButton.getX() && e.getY() >= this.exitButton.getY() && e.getX() < (this.exitButton.getX() + this.exitButton.getWIDTH()) && e.getY() < (this.exitButton.getY() + this.exitButton.getHEIGHT())) {
/* 212 */         System.exit(0);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 217 */     else if (e.getX() >= this.backButton.getX() && e.getY() >= this.backButton.getY() && e.getX() < (this.backButton.getX() + this.backButton.getWIDTH()) && e.getY() < (this.backButton.getY() + this.backButton.getHEIGHT())) {
/* 218 */       this.isOptionClicked = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cannotBePlayed() {
/* 225 */     this.canBePlayed = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\display\MenuPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */