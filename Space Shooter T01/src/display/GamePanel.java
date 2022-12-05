/*     */ package display;
/*     */ 
/*     */ import containers.SpriteContainer;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontFormatException;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.ImageObserver;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.Timer;
/*     */ import loader.ImageLoader;
/*     */ import physics.Collision;
/*     */ import powerups.Drops;
/*     */ import sprites.Alien;
/*     */ import sprites.AlienProjectile;
/*     */ import sprites.Fighter;
/*     */ import sprites.Projectile;
/*     */ import sprites.WingProjectile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GamePanel
/*     */   extends JPanel
/*     */   implements ActionListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final int DELAY = 10;
/*     */   public static int WIDTH;
/*     */   public static int HEIGHT;
/*     */   public Timer gameTimer;
/*     */   private Fighter fighter;
/*     */   private ArrayList<Alien> aliens;
/*     */   private ArrayList<Drops> drops;
/*     */   private BufferedImage background;
/*     */   private Collision collision;
/*     */   private boolean showHitbox;
/*     */   private boolean gameOver;
/*     */   private int fontSize;
/*     */   private Rectangle peekBar;
/*     */   private int drawHealthPos;
/*     */   private int drawMissilePos;
/*     */   private int fighterShootingTimer;
/*     */   
/*     */   public GamePanel() {
/*  63 */     WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
/*  64 */     WIDTH = (int)(WIDTH - 0.1D * WIDTH);
/*  65 */     HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
/*     */     
/*  67 */     this.background = SpriteContainer.getBackground();
/*  68 */     this.background = ImageLoader.getResizedImage(this.background, WIDTH, HEIGHT);
/*     */     
/*  70 */     this.gameTimer = new Timer(10, this);
/*  71 */     this.fighter = new Fighter();
/*  72 */     this.aliens = new ArrayList<>();
/*  73 */     this.drops = new ArrayList<>();
/*     */     
/*  75 */     this.collision = new Collision();
/*     */     
/*  77 */     this.showHitbox = false;
/*  78 */     this.gameOver = false;
/*  79 */     this.fontSize = 0;
/*     */     
/*  81 */     initComponents();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initComponents() {
/*  87 */     setSize(WIDTH, HEIGHT);
/*  88 */     setDoubleBuffered(true);
/*     */     
/*  90 */     this.fighter.setInitialPos((WIDTH - this.fighter.getWIDTH()) / 2, HEIGHT - this.fighter.getHEIGHT() - 100);
/*  91 */     initAliens();
/*     */     
/*  93 */     this.peekBar = new Rectangle((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() - WIDTH), HEIGHT);
/*  94 */     this.drawHealthPos = HEIGHT - HEIGHT / 3;
/*  95 */     this.drawMissilePos = HEIGHT - HEIGHT / 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initAliens() {
/* 101 */     for (int i = 0; i < 8; i++) {
/* 102 */       Alien a = new Alien(i + 1);
/* 103 */       a.setInitialPos(generateRandomCoordinate('x'), generateRandomCoordinate('y'));
/* 104 */       this.aliens.add(a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int generateRandomCoordinate(char c) {
/* 111 */     int baseE = this.fighter.getY() - getLargestAlienHeight() * 2;
/* 112 */     Random r = new Random();
/*     */     
/* 114 */     if (c == 'x' || c == 'X') {
/* 115 */       return r.nextInt(WIDTH - getLargestAlienWidth() * 2);
/*     */     }
/* 117 */     if (c == 'y' || c == 'Y') {
/* 118 */       return r.nextInt(Math.abs(baseE));
/*     */     }
/*     */     
/* 121 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintComponent(Graphics g) {
/* 127 */     super.paintComponent(g);
/*     */     
/* 129 */     Graphics2D g2d = (Graphics2D)g;
/* 130 */     doDrawing(g2d);
/*     */     
/* 132 */     g.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doDrawing(Graphics2D g2d) {
/* 140 */     g2d.drawImage(this.background, 0, 0, (ImageObserver)null);
/* 141 */     drawPeekBar(g2d);
/*     */     
/* 143 */     drawPowerUps(g2d);
/*     */     
/* 145 */     if (this.aliens.size() > 0 || this.gameOver) { doAlienDrawing(g2d); }
/* 146 */     else { drawCongo(g2d); }
/*     */     
/* 148 */     if (!this.gameOver) {
/* 149 */       for (Projectile prop : this.fighter.getProjectiles()) {
/* 150 */         g2d.drawImage(prop.getCurrentImage(), prop.getX(), prop.getY(), (ImageObserver)null);
/*     */       }
/*     */       
/* 153 */       for (WingProjectile wprop : this.fighter.getWingProps()) {
/* 154 */         g2d.drawImage(wprop.getCurrentImage(), wprop.getX(), wprop.getY(), (ImageObserver)null);
/*     */       }
/*     */       
/* 157 */       g2d.drawImage(this.fighter.getCurrentImage(), this.fighter.getX(), this.fighter.getY(), (ImageObserver)null);
/*     */     } else {
/* 159 */       drawGameOver(g2d);
/*     */     } 
/*     */     
/* 162 */     if (this.showHitbox) drawHitbox(g2d);
/*     */     
/* 164 */     g2d.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   private void doAlienDrawing(Graphics2D g2d) {
/* 169 */     for (Alien alien : this.aliens) {
/*     */       
/* 171 */       g2d.drawImage(alien.getCurrentImage(), alien.getX(), alien.getY(), (ImageObserver)null);
/* 172 */       for (AlienProjectile ap : alien.getProjectiles()) {
/* 173 */         g2d.drawImage(ap.getCurrentImage(), ap.getX(), ap.getY(), (ImageObserver)null);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawHitbox(Graphics2D g2d) {
/* 182 */     for (int i = 0; i < this.aliens.size(); i++) {
/*     */       
/* 184 */       g2d.setColor(Color.WHITE);
/*     */       
/* 186 */       if (((Alien)this.aliens.get(i)).getHealth() < ((Alien)this.aliens.get(i)).getMaxHealth() * 0.5D)
/* 187 */         g2d.setColor(Color.GREEN); 
/* 188 */       if (((Alien)this.aliens.get(i)).getHealth() < ((Alien)this.aliens.get(i)).getMaxHealth() * 0.1D) {
/* 189 */         g2d.setColor(Color.RED);
/*     */       }
/* 191 */       g2d.setFont(new Font("Comic Sans MS", 0, 15));
/* 192 */       g2d.drawString("Health: " + ((Alien)this.aliens.get(i)).getHealth(), ((Alien)this.aliens.get(i)).getX(), ((Alien)this.aliens.get(i)).getY() - 3);
/*     */       
/* 194 */       if (i < this.collision.alienRects.size()) {
/* 195 */         g2d.draw(this.collision.alienRects.get(i));
/*     */       }
/*     */     } 
/*     */     
/* 199 */     g2d.setColor(Color.WHITE);
/*     */     
/* 201 */     if (this.fighter.getHealth() < this.fighter.getMaxHealth() * 0.5D)
/* 202 */       g2d.setColor(Color.GREEN); 
/* 203 */     if (this.fighter.getHealth() < this.fighter.getMaxHealth() * 0.1D) {
/* 204 */       g2d.setColor(Color.RED);
/*     */     }
/* 206 */     g2d.setFont(new Font("Comic Sans MS", 0, 15));
/* 207 */     g2d.drawString("Health: " + this.fighter.getHealth(), this.fighter.getX(), this.fighter.getY());
/*     */     
/* 209 */     g2d.draw(this.collision.fighterRect);
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawPowerUps(Graphics2D g2d) {
/* 214 */     for (Drops d : this.drops) {
/* 215 */       g2d.drawImage(d.getCurrentImage(), d.getX(), d.getY(), (ImageObserver)null);
/*     */     }
/*     */   }
/*     */   
/*     */   private void drawCongo(Graphics2D g2d) {
/* 220 */     Font f = null;
/*     */     
/*     */     try {
/* 223 */       f = Font.createFont(0, GamePanel.class.getClassLoader().getResourceAsStream("/res/CIRCUIT.TTF"));
/* 224 */       f = f.deriveFont(0, 20.0F);
/* 225 */     } catch (FontFormatException|java.io.IOException e) {
/*     */       
/* 227 */       f = new Font("Comic Sans MS", 0, this.fontSize);
/*     */     } 
/* 229 */     g2d.setFont(f);
/*     */     
/* 231 */     g2d.setColor(new Color(255, 255, 255));
/* 232 */     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */     
/* 234 */     FontMetrics fm = g2d.getFontMetrics();
/* 235 */     Rectangle2D r = fm.getStringBounds("Congratulation", g2d);
/* 236 */     int x = (WIDTH - (int)r.getWidth()) / 2;
/* 237 */     int y = (HEIGHT - (int)r.getHeight()) / 2 + fm.getAscent();
/* 238 */     g2d.drawString("Congratulation", x, y);
/*     */     
/* 240 */     if (this.fontSize < 90) {
/* 241 */       this.fontSize += 10;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawGameOver(Graphics2D g2d) {
/* 248 */     g2d.setFont(new Font("Comic Sans MS", 0, this.fontSize));
/* 249 */     g2d.setColor(new Color(255, 255, 255));
/* 250 */     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */     
/* 252 */     FontMetrics fm = g2d.getFontMetrics();
/* 253 */     Rectangle2D r = fm.getStringBounds("Game Over", g2d);
/* 254 */     int x = (WIDTH - (int)r.getWidth()) / 2;
/* 255 */     int y = (HEIGHT - (int)r.getHeight()) / 2 + fm.getAscent();
/* 256 */     g2d.drawString("Game Over", x, y);
/*     */     
/* 258 */     if (this.fontSize < 90) {
/* 259 */       this.fontSize += 10;
/*     */     } else {
/*     */       
/* 262 */       for (Alien alien : this.aliens) {
/* 263 */         alien.setHealth(0);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawPeekBar(Graphics2D g2d) {
/* 270 */     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 271 */     g2d.setColor(Color.GRAY);
/* 272 */     g2d.fill3DRect(WIDTH, 0, (int)this.peekBar.getWidth(), (int)this.peekBar.getHeight(), true);
/*     */     
/* 274 */     Font f = null;
/*     */     
/*     */     try {
/* 277 */       f = Font.createFont(0, GamePanel.class.getClassLoader().getResourceAsStream("/res/CIRCUIT.TTF"));
/* 278 */       f = f.deriveFont(0, 20.0F);
/* 279 */     } catch (FontFormatException|java.io.IOException e) {
/*     */       
/* 281 */       f = new Font("Comic Sans MS", 0, 20);
/*     */     } 
/*     */     
/* 284 */     if (f == null) {
/* 285 */       System.out.println("f is null");
/* 286 */       f = new Font("Comic Sans MS", 0, 20);
/*     */     } 
/*     */     
/* 289 */     g2d.setFont(f);
/* 290 */     g2d.setColor(Color.WHITE);
/*     */     
/* 292 */     FontMetrics fm = g2d.getFontMetrics();
/* 293 */     Rectangle2D r = fm.getStringBounds("Missiles", g2d);
/*     */     
/* 295 */     int x = (int)r.getWidth() / 2;
/* 296 */     int y = (int)r.getHeight() / 2 + fm.getAscent();
/*     */     
/* 298 */     g2d.drawString("Missiles", WIDTH + x, this.drawMissilePos + y - 25);
/* 299 */     g2d.drawString((new StringBuilder(String.valueOf(this.fighter.getMissiles().size()))).toString(), WIDTH + x, this.drawMissilePos + y);
/*     */     
/* 301 */     if (this.fighter.getHealth() < this.fighter.getMaxHealth() * 0.5D)
/* 302 */       g2d.setColor(Color.GREEN); 
/* 303 */     if (this.fighter.getHealth() < this.fighter.getMaxHealth() * 0.1D) {
/* 304 */       g2d.setColor(Color.RED);
/*     */     }
/* 306 */     FontMetrics fm2 = g2d.getFontMetrics();
/* 307 */     Rectangle2D r2 = fm2.getStringBounds((new StringBuilder(String.valueOf(this.fighter.getHealth()))).toString(), g2d);
/*     */     
/* 309 */     int x2 = (int)r2.getWidth() / 2;
/* 310 */     int y2 = (int)r2.getHeight() / 2 + fm2.getAscent();
/*     */     
/* 312 */     g2d.drawString("Health", WIDTH + x2, this.drawHealthPos + y2 - 25);
/* 313 */     g2d.drawString((new StringBuilder(String.valueOf(this.fighter.getHealth()))).toString(), WIDTH + x2, this.drawHealthPos + y2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent arg0) {
/* 319 */     updateProjectiles();
/* 320 */     updateMissiles();
/* 321 */     updateWingProjectiles();
/* 322 */     updateFighter();
/*     */     
/* 324 */     updateAlien();
/* 325 */     updateAlienProjectiles();
/* 326 */     shootAlienProjectiles();
/*     */     
/* 328 */     updateDrops();
/*     */     
/* 330 */     int l = this.fighter.getLevel();
/* 331 */     this.collision.update(this.fighter, this.aliens, this.drops);
/* 332 */     this.fighter = this.collision.getFighter();
/* 333 */     if (this.fighter.getLevel() != l) {
/* 334 */       createNewFighter();
/*     */     }
/*     */     
/* 337 */     repaint();
/*     */   }
/*     */   
/*     */   private void updateDrops() {
/* 341 */     ArrayList<Drops> te = new ArrayList<>();
/*     */     
/* 343 */     for (Drops d : this.drops) {
/* 344 */       d.move();
/*     */       
/* 346 */       if (d.getY() <= HEIGHT || !d.isDestroyed()) {
/* 347 */         te.add(d);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 352 */     this.drops = te;
/*     */   }
/*     */   
/*     */   private void shootAlienProjectiles() {
/* 356 */     for (Alien alien : this.aliens) {
/* 357 */       alien.fire();
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateAlienProjectiles() {
/* 362 */     for (Alien alien : this.aliens) {
/* 363 */       for (int i = 0; i < alien.getProjectiles().size(); i++) {
/*     */         
/* 365 */         ((AlienProjectile)alien.getProjectiles().get(i)).move();
/*     */         
/* 367 */         if (((AlienProjectile)alien.getProjectiles().get(i)).getHealth() <= 0) {
/* 368 */           ((AlienProjectile)alien.getProjectiles().get(i)).initiateDestroySequence();
/*     */         }
/* 370 */         else if (((AlienProjectile)alien.getProjectiles().get(i)).getY() < 0) {
/* 371 */           alien.getProjectiles().remove(i);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateAlien() {
/* 380 */     ArrayList<Alien> teAliens = new ArrayList<>();
/*     */     
/* 382 */     for (Alien alien : this.aliens) {
/* 383 */       alien.move();
/* 384 */       if (alien.getHealth() <= 0)
/*     */       {
/* 386 */         if (!alien.isBeingDestroyed()) {
/* 387 */           alien.initiateDestroySequence();
/*     */           
/* 389 */           Drops d = new Drops();
/* 390 */           d.generateRandomType();
/* 391 */           d.setInitialPos(alien.getX(), alien.getY());
/*     */           
/* 393 */           this.drops.add(d);
/*     */         } 
/*     */       }
/*     */       
/* 397 */       if (!alien.isDestroyed())
/*     */       {
/* 399 */         teAliens.add(alien);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 404 */     this.aliens = teAliens;
/*     */   }
/*     */   
/*     */   private void updateFighter() {
/* 408 */     this.fighter.move();
/*     */     
/* 410 */     if (this.fighterShootingTimer >= 10) {
/* 411 */       this.fighterShootingTimer = 0;
/* 412 */       this.fighter.allowProps(true);
/*     */     } 
/* 414 */     if (!this.fighter.getAllowProps()) {
/* 415 */       this.fighterShootingTimer++;
/*     */     }
/* 417 */     if (this.fighter.getHealth() <= 0 && 
/* 418 */       !this.fighter.isBeingDestroyed()) {
/* 419 */       this.fighter.initiateDestroySequence();
/*     */     }
/* 421 */     if (this.fighter.isDestroyed()) {
/* 422 */       this.gameOver = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void createNewFighter() {
/* 428 */     int saveX = this.fighter.getX();
/* 429 */     int saveY = this.fighter.getY();
/*     */     
/* 431 */     this.fighter = new Fighter();
/* 432 */     this.fighter.setInitialPos(saveX, saveY);
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateWingProjectiles() {
/* 437 */     for (int i = 0; i < this.fighter.getWingProps().size(); i++) {
/*     */       
/* 439 */       ((WingProjectile)this.fighter.getWingProps().get(i)).move();
/*     */       
/* 441 */       if (((WingProjectile)this.fighter.getWingProps().get(i)).getHealth() <= 0) {
/* 442 */         ((WingProjectile)this.fighter.getWingProps().get(i)).initiateDestroySequence();
/*     */       }
/* 444 */       else if (((WingProjectile)this.fighter.getWingProps().get(i)).getY() < 0) {
/* 445 */         this.fighter.getWingProps().remove(i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateMissiles() {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateProjectiles() {
/* 458 */     for (int i = 0; i < this.fighter.getProjectiles().size(); i++) {
/*     */       
/* 460 */       ((Projectile)this.fighter.getProjectiles().get(i)).move();
/*     */       
/* 462 */       if (((Projectile)this.fighter.getProjectiles().get(i)).getHealth() <= 0) {
/* 463 */         ((Projectile)this.fighter.getProjectiles().get(i)).initiateDestroySequence();
/*     */       }
/* 465 */       else if (((Projectile)this.fighter.getProjectiles().get(i)).getY() < 0) {
/* 466 */         this.fighter.getProjectiles().remove(i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getShowHitbox() {
/* 474 */     return this.showHitbox;
/*     */   }
/*     */   public void setShowHitbox(boolean b) {
/* 477 */     this.showHitbox = b;
/*     */   }
/*     */   
/*     */   private int getLargestAlienWidth() {
/* 481 */     int largest = 0;
/* 482 */     for (Alien a : this.aliens) {
/* 483 */       if (a.getWIDTH() > largest) {
/* 484 */         largest = a.getWIDTH();
/*     */       }
/*     */     } 
/* 487 */     return largest;
/*     */   }
/*     */   
/*     */   private int getLargestAlienHeight() {
/* 491 */     int largest = 0;
/* 492 */     for (Alien a : this.aliens) {
/* 493 */       if (a.getHEIGHT() > largest) {
/* 494 */         largest = a.getHEIGHT();
/*     */       }
/*     */     } 
/* 497 */     return largest;
/*     */   }
/*     */   
/*     */   public int getFighterShootingTimer() {
/* 501 */     return this.fighterShootingTimer;
/*     */   }
/*     */   
/*     */   public Fighter getFighter() {
/* 505 */     return this.fighter;
/*     */   }
/*     */   
/*     */   public void setFighter(Fighter f) {
/* 509 */     this.fighter = f;
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\display\GamePanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */