/*     */ package physics;
/*     */ 
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
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
/*     */ public class Collision
/*     */ {
/*     */   private Fighter fighter;
/*     */   private ArrayList<Alien> aliens;
/*     */   private ArrayList<Drops> drops;
/*     */   public ArrayList<Rectangle> alienRects;
/*     */   public Rectangle fighterRect;
/*     */   public ArrayList<Rectangle> dropRects;
/*     */   
/*     */   public void update(Fighter f, ArrayList<Alien> a, ArrayList<Drops> d) {
/*  25 */     this.fighter = f;
/*  26 */     this.aliens = a;
/*  27 */     this.drops = d;
/*     */     
/*  29 */     this.fighterRect = new Rectangle(this.fighter.getX(), this.fighter.getY(), this.fighter.getWIDTH(), this.fighter.getHEIGHT());
/*  30 */     this.alienRects = new ArrayList<>();
/*  31 */     this.dropRects = new ArrayList<>();
/*     */     
/*  33 */     for (Alien alien : this.aliens) {
/*  34 */       if (!alien.isBeingDestroyed()) {
/*  35 */         this.alienRects.add(new Rectangle(alien.getX(), alien.getY(), alien.getWIDTH(), alien.getHEIGHT()));
/*     */       }
/*     */     } 
/*     */     
/*  39 */     for (Drops dr : this.drops) {
/*  40 */       this.dropRects.add(new Rectangle(dr.getX(), dr.getY(), dr.getWIDTH(), dr.getHEIGHT()));
/*     */     }
/*     */     
/*  43 */     checkAlienProjectileCollision();
/*  44 */     checkFighterProjectileCollision();
/*  45 */     checkFighterPowerUpCollision();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkAlienProjectileCollision() {
/*  51 */     int i = 0;
/*     */     
/*  53 */     for (Rectangle alienRect : this.alienRects) {
/*     */       
/*  55 */       for (Projectile p : this.fighter.getProjectiles()) {
/*     */         
/*  57 */         Rectangle projectileRect = new Rectangle(p.getX(), p.getY(), p.getWIDTH(), p.getHEIGHT());
/*     */         
/*  59 */         if (alienRect.intersects(projectileRect)) {
/*  60 */           ((Alien)this.aliens.get(i)).decrementHealthBy(p.getDamagePoints());
/*  61 */           p.decrementHealthBy(((Alien)this.aliens.get(i)).getDamagePoints());
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  66 */       for (WingProjectile wp : this.fighter.getWingProps()) {
/*     */         
/*  68 */         Rectangle wingprojectileRect = new Rectangle(wp.getX(), wp.getY(), wp.getWIDTH(), wp.getHEIGHT());
/*     */         
/*  70 */         if (alienRect.intersects(wingprojectileRect)) {
/*  71 */           ((Alien)this.aliens.get(i)).decrementHealthBy(wp.getDamagePoints());
/*  72 */           wp.decrementHealthBy(((Alien)this.aliens.get(i)).getDamagePoints());
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  77 */       i++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkFighterProjectileCollision() {
/*  84 */     for (Alien alien : this.aliens) {
/*     */       
/*  86 */       for (AlienProjectile ap : alien.getProjectiles()) {
/*     */         
/*  88 */         Rectangle propRect = new Rectangle(ap.getX(), ap.getY(), ap.getWIDTH(), ap.getHEIGHT());
/*     */         
/*  90 */         if (this.fighterRect.intersects(propRect)) {
/*  91 */           this.fighter.decrementHealthBy(ap.getDamagePoints());
/*  92 */           ap.decrementHealthBy(this.fighter.getDamagePoints());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkFighterPowerUpCollision() {
/* 102 */     for (int i = 0; i < this.dropRects.size(); i++) {
/* 103 */       if (this.fighterRect.intersects(this.dropRects.get(i))) {
/* 104 */         this.fighter = ((Drops)this.drops.get(i)).getCharecteristic(this.fighter);
/* 105 */         ((Drops)this.drops.get(i)).initiateDestroySequence();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Fighter getFighter() {
/* 111 */     return this.fighter;
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\physics\Collision.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */