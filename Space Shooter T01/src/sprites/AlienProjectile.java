/*    */ package sprites;
/*    */ 
/*    */ import containers.DataContainer;
/*    */ import containers.SpriteContainer;
/*    */ 
/*    */ public class AlienProjectile
/*    */   extends Sprite {
/*  8 */   public static int level = 1;
/*    */   public int dy;
/*    */   
/*    */   public AlienProjectile() {
/* 12 */     super("ALIENPROP", level);
/*    */     
/* 14 */     DataContainer dc = SpriteContainer.getAlienProjectileData(level - 1);
/*    */     
/* 16 */     getResizedImage(dc.getREQ_WIDTH(), dc.getREQ_HEIGHT());
/*    */     
/* 18 */     this.dy = 20;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void move() {
/* 24 */     this.y_coor += this.dy;
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\sprites\AlienProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */