/*    */ package sprites;
/*    */ 
/*    */ import containers.DataContainer;
/*    */ import containers.SpriteContainer;
/*    */ 
/*    */ public class Projectile
/*    */   extends Sprite {
/*    */   private int dy;
/*  9 */   private static int level = 1;
/*    */   
/*    */   private boolean shotByFighter;
/*    */   
/*    */   public Projectile() {
/* 14 */     super("PROJECTILE", level);
/*    */     
/* 16 */     DataContainer dc = SpriteContainer.getProjectileData(level - 1);
/*    */     
/* 18 */     getResizedImage(dc.getREQ_WIDTH(), dc.getREQ_HEIGHT());
/*    */     
/* 20 */     this.dy = 20;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getLevel() {
/* 25 */     return level;
/*    */   }
/*    */   
/*    */   public static void increaseLevel() {
/* 29 */     if (level < SpriteContainer.getPROJECTILES().size()) {
/* 30 */       level++;
/*    */     }
/*    */   }
/*    */   
/*    */   public static void decreaseLevel() {
/* 35 */     if (level > 1) {
/* 36 */       level--;
/*    */     }
/*    */   }
/*    */   
/*    */   public static void setLevel(int level) {
/* 41 */     Projectile.level = level;
/*    */   }
/*    */   
/*    */   public void setShotBy(boolean b) {
/* 45 */     this.shotByFighter = b;
/*    */   }
/*    */   public boolean getShotBy() {
/* 48 */     return this.shotByFighter;
/*    */   }
/*    */ 
/*    */   
/*    */   public void move() {
/* 53 */     this.y_coor -= this.dy;
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\sprites\Projectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */