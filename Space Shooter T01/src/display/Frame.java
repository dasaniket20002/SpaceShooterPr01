/*     */ package display;
/*     */ 
/*     */ import containers.SoundContainer;
/*     */ import java.awt.Color;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.SwingUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Frame
/*     */   extends JFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private MenuPanel menu;
/*     */   private GamePanel game;
/*     */   private Controller controller;
/*     */   
/*     */   public Frame() {
/*  22 */     setTitle("Space Shooter");
/*  23 */     setUndecorated(true);
/*  24 */     setSize(Toolkit.getDefaultToolkit().getScreenSize());
/*     */     
/*  26 */     setResizable(false);
/*  27 */     setBackground(new Color(0, 0, 0));
/*  28 */     setDefaultCloseOperation(3);
/*     */     
/*  30 */     this.controller = new Controller();
/*     */     
/*  32 */     this.menu = new MenuPanel();
/*  33 */     this.game = new GamePanel();
/*     */     
/*  35 */     setMenuVisible(false);
/*  36 */     setGameVisible(false);
/*     */   }
/*     */   
/*     */   public boolean isMenuVisible() {
/*  40 */     return this.menu.isVisible();
/*     */   }
/*     */   
/*     */   public boolean isGameVisible() {
/*  44 */     return this.game.isVisible();
/*     */   }
/*     */   
/*     */   public void setMenuVisible(boolean b) {
/*  48 */     if (b) {
/*     */       
/*  50 */       add(this.menu);
/*  51 */       SoundContainer.playBgMusic();
/*  52 */       this.menu.setVisible(b);
/*  53 */       this.menu.menuTimer.start();
/*     */     } else {
/*     */       
/*  56 */       if (SoundContainer.getbgMusic().isRunning()) {
/*  57 */         SoundContainer.getbgMusic().stop();
/*     */       }
/*     */       
/*  60 */       this.menu.setVisible(b);
/*  61 */       this.menu.menuTimer.stop();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setGameVisible(boolean b) {
/*  66 */     if (b) {
/*     */       
/*  68 */       add(this.game);
/*  69 */       addKeyListener(this.controller);
/*  70 */       this.game.setVisible(b);
/*  71 */       this.game.gameTimer.start();
/*     */     }
/*     */     else {
/*     */       
/*  75 */       this.game.setVisible(b);
/*  76 */       this.game.gameTimer.stop();
/*  77 */       removeKeyListener(this.controller);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void runFrame() {
/*  83 */     SwingUtilities.invokeLater(new Runnable()
/*     */         {
/*     */           
/*     */           public void run()
/*     */           {
/*  88 */             Frame.this.setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class Controller
/*     */     extends KeyAdapter
/*     */   {
/*     */     public void keyPressed(KeyEvent evt) {
/* 101 */       Frame.this.game.getFighter().keyPressed(evt);
/*     */       
/* 103 */       if (evt.getKeyCode() == 75 || evt.getKeyCode() == 76) {
/* 104 */         Frame.this.game.createNewFighter();
/*     */       }
/* 106 */       else if (evt.getKeyCode() == 27) {
/* 107 */         Frame.this.setGameVisible(false);
/* 108 */         Frame.this.setMenuVisible(true);
/* 109 */         Frame.this.menu.cannotBePlayed();
/*     */       }
/* 111 */       else if (evt.getKeyCode() == 66) {
/* 112 */         Frame.this.game.setShowHitbox(!Frame.this.game.getShowHitbox());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void keyReleased(KeyEvent evt) {
/* 119 */       Frame.this.game.getFighter().keyReleased(evt);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\display\Frame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */