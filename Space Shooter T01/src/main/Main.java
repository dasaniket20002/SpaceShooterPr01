/*    */ package main;
/*    */ 
/*    */ import containers.SoundContainer;
/*    */ import containers.SpriteContainer;
/*    */ import display.Frame;
/*    */ import display.ProgressFrame;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.SwingUtilities;
/*    */ import javax.swing.Timer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main
/*    */   implements ActionListener
/*    */ {
/*    */   public ProgressFrame splash;
/*    */   private Frame gameFrame;
/*    */   private Timer timer;
/*    */   public static final int MAX = 13;
/* 21 */   public static int CURRENT = 0;
/*    */ 
/*    */   
/*    */   public Main() {
/* 25 */     this.splash = new ProgressFrame();
/*    */     
/* 27 */     this.timer = new Timer(400, this);
/*    */     
/* 29 */     this.timer.start();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 35 */     SwingUtilities.invokeLater(new Runnable()
/*    */         {
/*    */           	public void run() {
					}
/*    */         });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 46 */     SoundContainer.loadAllSounds();
/* 47 */     SpriteContainer.loadSpriteSheets();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 54 */     if (this.splash.getProgress() < 100.0D) {
/* 55 */       if (SoundContainer.getbgMusic().isRunning()) {
/* 56 */         SoundContainer.getbgMusic().stop();
/*    */       }
/* 58 */       this.splash.runFrame();
/* 59 */       this.splash.updateProgress(CURRENT / 13.0D * 100.0D);
/*    */     }
/* 61 */     else if (this.splash.getProgress() >= 100.0D) {
/*    */       
/* 63 */       if (this.gameFrame == null) {
/*    */         
/* 65 */         this.gameFrame = new Frame();
/*    */         
/* 67 */         this.splash.setVisible(false);
/*    */         
/* 69 */         this.gameFrame.runFrame();
/* 70 */         this.gameFrame.setMenuVisible(true);
/*    */       }
/* 72 */       else if (!this.gameFrame.isMenuVisible()) {
/* 73 */         this.gameFrame.setMenuVisible(false);
/*    */         
/* 75 */         this.gameFrame.setGameVisible(true);
/*    */         
/* 77 */         this.timer.stop();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\main\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */