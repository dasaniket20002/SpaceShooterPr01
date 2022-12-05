/*    */ package display;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Toolkit;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ public class ProgressFrame
/*    */   extends JFrame
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static int WIDTH;
/*    */   public static int HEIGHT;
/*    */   private ProgressBarPanel progress;
/*    */   
/*    */   public ProgressFrame() {
/* 18 */     WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3;
/* 19 */     HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3;
/*    */     
/* 21 */     setSize(WIDTH, HEIGHT);
/* 22 */     setUndecorated(true);
/* 23 */     setBackground(new Color(0, 0, 0, 0));
/* 24 */     setLocationRelativeTo((Component)null);
/*    */     
/* 26 */     this.progress = new ProgressBarPanel();
/*    */     
/* 28 */     add(this.progress);
/*    */   }
/*    */ 
/*    */   
/*    */   public double getProgress() {
/* 33 */     return this.progress.getProgress();
/*    */   }
/*    */   
/*    */   public void updateProgress(double n) {
/* 37 */     this.progress.update(n);
/*    */   }
/*    */   
/*    */   public void runFrame() {
/* 41 */     SwingUtilities.invokeLater(new Runnable()
/*    */         {
/*    */           public void run()
/*    */           {
/* 45 */             ProgressFrame.this.setVisible(true);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\display\ProgressFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */