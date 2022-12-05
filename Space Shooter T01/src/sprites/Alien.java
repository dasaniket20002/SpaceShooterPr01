/*    */ package sprites;
/*    */ 
/*    */ import containers.DataContainer;
/*    */ import containers.SpriteContainer;
/*    */ import display.GamePanel;
/*    */ import java.awt.Point;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class Alien
/*    */   extends Sprite
/*    */ {
/* 13 */   public static int level = 1;
/*    */   
/*    */   private int dx;
/*    */   
/*    */   private int firingTime;
/*    */   
/*    */   private ArrayList<AlienProjectile> projectiles;
/*    */   
/*    */   private Point propLoc;
/*    */   
/*    */   public Alien() {
/* 24 */     super("ALIEN", level);
/* 25 */     initAlien();
/*    */   }
/*    */   
/*    */   public Alien(int l) {
/* 29 */     super("ALIEN", l);
/* 30 */     level = l;
/* 31 */     initAlien();
/*    */   }
/*    */ 
/*    */   
/*    */   private void initAlien() {
/* 36 */     DataContainer dc = SpriteContainer.getAlienData(level - 1);
/*    */     
/* 38 */     this.propLoc = dc.getPROP_POS();
/*    */     
/* 40 */     getResizedImage(dc.getREQ_WIDTH(), dc.getREQ_HEIGHT());
/*    */     
/* 42 */     this.dx = 5;
/*    */     
/* 44 */     this.projectiles = new ArrayList<>();
/*    */   }
/*    */ 
/*    */   
/*    */   public ArrayList<AlienProjectile> getProjectiles() {
/* 49 */     return this.projectiles;
/*    */   }
/*    */   
/*    */   public void addProjectiles(AlienProjectile projectile) {
/* 53 */     this.projectiles.add(projectile);
/*    */   }
/*    */ 
/*    */   
/*    */   public void move() {
/* 58 */     if (isBeingDestroyed()) {
/* 59 */       if (this.currentImageIndex >= this.IMAGES - 1) {
/* 60 */         this.destroyed = true;
/*    */       } else {
/* 62 */         this.currentImageIndex++;
/*    */       } 
/* 64 */     } else if (this.x_coor <= 0) {
/* 65 */       this.dx = -this.dx;
/* 66 */       this.x_coor++;
/*    */     }
/* 68 */     else if (this.x_coor >= GamePanel.WIDTH - getWIDTH()) {
/* 69 */       this.dx = -this.dx;
/* 70 */       this.x_coor--;
/*    */     } 
/*    */     
/* 73 */     this.x_coor += this.dx;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setHealth(int n) {
/* 78 */     this.HEALTH = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void fire() {
/* 83 */     if (this.firingTime >= 100) {
/* 84 */       this.firingTime = 0;
/*    */       
/* 86 */       AlienProjectile ap = new AlienProjectile();
/* 87 */       ap.setInitialPos(getX() + ap.getWIDTH() / 2, getY() + ap.getY());
/* 88 */       this.projectiles.add(ap);
/*    */     } 
/*    */     
/* 91 */     this.firingTime++;
/*    */   }
/*    */ 
/*    */   
/*    */   public void initiateDestroySequence() {
/* 96 */     this.dx = 0;
/* 97 */     super.initiateDestroySequence();
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\sprites\Alien.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */