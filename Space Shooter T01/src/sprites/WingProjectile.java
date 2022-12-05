/*    */ package sprites;
/*    */ 
/*    */ import containers.DataContainer;
/*    */ import containers.SpriteContainer;
/*    */ 
/*    */ public class WingProjectile
/*    */   extends Sprite {
/*  8 */   private static int level = 1;
/*    */   
/*    */   private int dx;
/*    */   
/*    */   public WingProjectile() {
/* 13 */     super("WINGPROP", level);
/*    */     
/* 15 */     DataContainer dc = SpriteContainer.getWingProjectileData(level - 1);
/*    */     
/* 17 */     getResizedImage(dc.getREQ_WIDTH(), dc.getREQ_HEIGHT());
/*    */     
/* 19 */     this.dx = 20;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getLevel() {
/* 24 */     return level;
/*    */   }
/*    */   
/*    */   public static void increaseLevel() {
/* 28 */     if (level < SpriteContainer.getWINGPROJECTILES().size()) {
/* 29 */       level++;
/*    */     }
/*    */   }
/*    */   
/*    */   public static void decreaseLevel() {
/* 34 */     if (level > 1) {
/* 35 */       level--;
/*    */     }
/*    */   }
/*    */   
/*    */   public static void setLevel(int level) {
/* 40 */     WingProjectile.level = level;
/*    */   }
/*    */ 
/*    */   
/*    */   public void move() {
/* 45 */     this.y_coor -= this.dx;
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\sprites\WingProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */