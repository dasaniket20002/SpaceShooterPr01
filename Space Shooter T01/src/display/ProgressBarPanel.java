/*    */ package display;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Point;
/*    */ import java.awt.RenderingHints;
/*    */ import java.awt.geom.Arc2D;
/*    */ import java.awt.geom.Ellipse2D;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ public class ProgressBarPanel
/*    */   extends JPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Arc2D.Float arc;
/*    */   private int progress;
/*    */   private Ellipse2D.Float circle;
/*    */   
/*    */   public ProgressBarPanel() {
/* 25 */     setSize(ProgressFrame.WIDTH, ProgressFrame.HEIGHT);
/* 26 */     setBackground(new Color(0, 0, 0, 0));
/*    */     
/* 28 */     this.arc = new Arc2D.Float(2);
/* 29 */     this.arc.setFrameFromCenter(new Point(0, 0), new Point(120, 120));
/*    */     
/* 31 */     this.circle = new Ellipse2D.Float();
/* 32 */     this.circle.setFrameFromCenter(new Point(0, 0), new Point(110, 110));
/*    */     
/* 34 */     this.progress = 0;
/* 35 */     this.arc.setAngleExtent(-this.progress);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(double p) {
/* 40 */     this.progress = (int)p;
/* 41 */     this.arc.setAngleExtent(-this.progress * 3.6D);
/* 42 */     repaint();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 48 */     Graphics2D g2d = (Graphics2D)g;
/* 49 */     super.paint(g2d);
/*    */     
/* 51 */     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 52 */     g2d.translate(getWidth() / 2, getHeight() / 2);
/* 53 */     g2d.rotate(Math.toRadians(270.0D));
/*    */     
/* 55 */     g2d.setColor(Color.RED);
/* 56 */     g2d.fill(this.arc);
/*    */     
/* 58 */     g2d.setColor(Color.WHITE);
/* 59 */     g2d.fill(this.circle);
/*    */     
/* 61 */     g2d.setColor(Color.RED);
/* 62 */     g2d.setFont(new Font("Comic Sans MS", 0, 70));
/* 63 */     g2d.rotate(Math.toRadians(90.0D));
/* 64 */     FontMetrics fm = g2d.getFontMetrics();
/* 65 */     Rectangle2D r = fm.getStringBounds(String.valueOf(this.progress) + "%", g2d);
/* 66 */     int x = -((int)r.getWidth()) / 2;
/* 67 */     int y = -((int)r.getHeight()) / 2 + fm.getAscent();
/* 68 */     g2d.drawString(String.valueOf(this.progress) + "%", x, y);
/*    */     
/* 70 */     g2d.dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   public double getProgress() {
/* 75 */     return this.progress;
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\display\ProgressBarPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */