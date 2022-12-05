/*     */ package powerups;
/*     */ 
/*     */ import containers.SpriteContainer;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.ArrayList;
/*     */ import loader.ImageLoader;
/*     */ import sprites.Fighter;
/*     */ import sprites.Projectile;
/*     */ import sprites.Sprite;
/*     */ import sprites.WingProjectile;
/*     */ 
/*     */ 
/*     */ public class Drops
/*     */   extends Sprite
/*     */ {
/*     */   private int SPEED;
/*     */   private String TYPE;
/*     */   private int typeNum;
/*     */   
/*     */   public Drops() {
/*  21 */     super("DROPS", 0);
/*  22 */     this.SPEED = 10;
/*  23 */     this.typeNum = 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSprite(BufferedImage img) {
/*  28 */     ArrayList<BufferedImage> te = ImageLoader.splitSprites(img, 1, img.getWidth(), img.getHeight());
/*  29 */     for (BufferedImage b : te) {
/*  30 */       b = ImageLoader.getResizedImage(b, 16, 16);
/*     */     }
/*  32 */     this.sprites = te;
/*     */     
/*  34 */     this.currentImageIndex = 0;
/*  35 */     this.destroyed = false;
/*  36 */     this.beingDestroyed = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String generateRandomType() {
/*  41 */     int num = (int)(Math.random() * this.typeNum + 1.0D);
/*     */     
/*  43 */     switch (num) {
/*     */       case 1:
/*  45 */         this.TYPE = "FIGHTER_LEVEL_DOWN";
/*  46 */         setSprite(SpriteContainer.getFighterLevelDown(0));
/*     */         break;
/*     */       case 2:
/*  49 */         this.TYPE = "FIGHTER_LEVEL_UP";
/*  50 */         setSprite(SpriteContainer.getFighterLevelUp(0));
/*     */         break;
/*     */       case 3:
/*  53 */         this.TYPE = "PROJECTILE_LEVEL_DOWN";
/*  54 */         setSprite(SpriteContainer.getProjectileLevelDown(0));
/*     */         break;
/*     */       case 4:
/*  57 */         this.TYPE = "PROJECTILE_LEVEL_UP";
/*  58 */         setSprite(SpriteContainer.getProjectileLevelUp(0));
/*     */         break;
/*     */       case 5:
/*  61 */         this.TYPE = "WING_PROJECTILE_LEVEL_DOWN";
/*     */         break;
/*     */       
/*     */       case 6:
/*  65 */         this.TYPE = "WING_PROJECTILE_LEVEL_UP";
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  71 */     return this.TYPE;
/*     */   }
/*     */   
/*     */   public void move() {
/*  75 */     this.y_coor += this.SPEED;
/*     */   }
/*     */   
/*     */   public void setCharecteristic(String t) {
/*  79 */     this.TYPE = t;
/*     */   }
/*     */   
/*     */   public Fighter getCharecteristic(Fighter f) {
/*     */     String str;
/*  84 */     switch ((str = this.TYPE).hashCode()) { case -1555892552: if (!str.equals("FIGHTER_LEVEL_UP")) {
/*     */           break;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*  90 */         f.increaseLevel(); break;
/*     */       case -564628097:
/*     */         if (!str.equals("FIGHTER_LEVEL_DOWN"))
/*     */           break;  f.decreaseLevel(); break;
/*     */       case -552439060:
/*     */         if (!str.equals("PROJECTILE_LEVEL_UP"))
/*  96 */           break;  Projectile.increaseLevel(); break;
/*     */       case -21613697:
/*     */         if (!str.equals("WING_PROJECTILE_LEVEL_DOWN"))
/*  99 */           break;  WingProjectile.decreaseLevel(); break;
/*     */       case 469251256:
/*     */         if (!str.equals("WING_PROJECTILE_LEVEL_UP"))
/* 102 */           break;  WingProjectile.increaseLevel(); break;
/*     */       case 1681503411:
/*     */         if (!str.equals("PROJECTILE_LEVEL_DOWN"))
/*     */           break; 
/*     */         Projectile.decreaseLevel();
/*     */         break; }
/*     */     
/* 109 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\powerups\Drops.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */