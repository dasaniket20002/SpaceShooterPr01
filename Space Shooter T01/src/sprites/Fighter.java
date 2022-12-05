/*     */ package sprites;
/*     */ 
/*     */ import containers.DataContainer;
/*     */ import containers.SoundContainer;
/*     */ import containers.SpriteContainer;
/*     */ import display.GamePanel;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.sound.sampled.Clip;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Fighter
/*     */   extends Sprite
/*     */ {
/*     */   private static final int SPEED = 20;
/*     */   private int dx;
/*  20 */   private int level = 1;
/*     */   
/*     */   private ArrayList<Projectile> projectiles;
/*     */   
/*     */   private ArrayList<Missile> missiles;
/*     */   
/*     */   private ArrayList<WingProjectile> wingProps;
/*     */   
/*     */   private Point propLoc;
/*     */   private Point wingLoc1;
/*     */   private Point wingLoc2;
/*     */   private boolean allowWingProps;
/*     */   private boolean allowProps;
/*     */   
/*     */   public Fighter() {
/*  35 */     super("FIGHTER", 1);
/*     */     
/*  37 */     DataContainer dc = SpriteContainer.getFighterData(getLevel() - 1);
/*     */     
/*  39 */     this.propLoc = dc.getPROP_POS();
/*  40 */     this.wingLoc1 = dc.getWING_PROP_POS1();
/*  41 */     this.wingLoc2 = dc.getWING_PROP_POS2();
/*     */     
/*  43 */     getResizedImage(dc.getREQ_WIDTH(), dc.getREQ_HEIGHT());
/*     */     
/*  45 */     this.dx = 0;
/*     */     
/*  47 */     this.projectiles = new ArrayList<>();
/*  48 */     this.missiles = new ArrayList<>();
/*  49 */     this.wingProps = new ArrayList<>();
/*     */     
/*  51 */     this.allowWingProps = true;
/*  52 */     this.allowProps = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<WingProjectile> getWingProps() {
/*  59 */     return this.wingProps;
/*     */   }
/*     */   
/*     */   public void addWingProps(WingProjectile wingProp) {
/*  63 */     this.wingProps.add(wingProp);
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Missile> getMissiles() {
/*  68 */     return this.missiles;
/*     */   }
/*     */   
/*     */   public void addMissiles(Missile missile) {
/*  72 */     this.missiles.add(missile);
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Projectile> getProjectiles() {
/*  77 */     return this.projectiles;
/*     */   }
/*     */   
/*     */   public void addProjectiles(Projectile projectile) {
/*  81 */     this.projectiles.add(projectile);
/*     */   }
/*     */   
/*     */   public void allowProps(boolean b) {
/*  85 */     this.allowProps = b;
/*     */   }
/*     */   public boolean getAllowProps() {
/*  88 */     return this.allowProps;
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/*  93 */     switch (e.getKeyCode()) {
/*     */       
/*     */       case 37:
/*  96 */         this.dx = -20;
/*  97 */         if (this.currentImageIndex > 0) {
/*  98 */           this.currentImageIndex--;
/*     */         }
/*     */         break;
/*     */       case 39:
/* 102 */         this.dx = 20;
/* 103 */         if (this.currentImageIndex < this.IMAGES - 1) {
/* 104 */           this.currentImageIndex++;
/*     */         }
/*     */         break;
/*     */       case 32:
/* 108 */         fire();
/*     */         break;
/*     */       
/*     */       case 80:
/* 112 */         Projectile.decreaseLevel();
/*     */         break;
/*     */       
/*     */       case 79:
/* 116 */         Projectile.increaseLevel();
/*     */         break;
/*     */       
/*     */       case 73:
/* 120 */         WingProjectile.decreaseLevel();
/*     */         break;
/*     */       
/*     */       case 85:
/* 124 */         WingProjectile.increaseLevel();
/*     */         break;
/*     */       
/*     */       case 75:
/* 128 */         increaseLevel();
/*     */         break;
/*     */       
/*     */       case 76:
/* 132 */         decreaseLevel();
/*     */         break;
/*     */       
/*     */       case 68:
/* 136 */         this.HEALTH = 0;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 147 */     switch (e.getKeyCode()) {
/*     */       
/*     */       case 37:
/* 150 */         this.dx = 0;
/* 151 */         (new Thread(new Runnable()
/*     */             {
/*     */               public void run() {
/* 154 */                 while (Fighter.this.currentImageIndex < Fighter.this.MIDDLE_INDEX) {
/* 155 */                   Fighter.this.currentImageIndex++;
/*     */                   try {
/* 157 */                     Thread.sleep(80L);
/* 158 */                   } catch (InterruptedException e) {
/* 159 */                     e.printStackTrace();
/*     */                   } 
/*     */                 } 
/*     */               }
/* 163 */             })).start();
/*     */         break;
/*     */       
/*     */       case 39:
/* 167 */         this.dx = 0;
/* 168 */         (new Thread(new Runnable()
/*     */             {
/*     */               public void run() {
/* 171 */                 while (Fighter.this.currentImageIndex > Fighter.this.MIDDLE_INDEX) {
/* 172 */                   Fighter.this.currentImageIndex--;
/*     */                   try {
/* 174 */                     Thread.sleep(80L);
/* 175 */                   } catch (InterruptedException e) {
/* 176 */                     e.printStackTrace();
/*     */                   } 
/*     */                 } 
/*     */               }
/* 180 */             })).start();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fire() {
/* 188 */     if (this.allowProps) {
/* 189 */       this.allowProps = false;
/* 190 */       if (this.allowWingProps) {
/*     */         
/* 192 */         WingProjectile wprop1 = new WingProjectile();
/* 193 */         wprop1.setInitialPos((int)(getX() + this.wingLoc1.getX() - (wprop1.getWIDTH() / 2)), (int)(getY() + this.wingLoc1.getY()));
/*     */         
/* 195 */         WingProjectile wprop2 = new WingProjectile();
/* 196 */         wprop2.setInitialPos((int)(getX() + this.wingLoc2.getX() - (wprop1.getWIDTH() / 2)), (int)(getY() + this.wingLoc1.getY()));
/*     */         
/* 198 */         addWingProps(wprop1);
/*     */         
/* 200 */         addWingProps(wprop2);
/*     */ 
/*     */         
/* 203 */         if (SoundContainer.getWingPropSound().isActive() || SoundContainer.getWingPropSound().isRunning()) {
/* 204 */           Clip teClip = SoundContainer.getWingPropSound();
/* 205 */           teClip.start();
/*     */         } else {
/* 207 */           SoundContainer.playWingPropSound();
/*     */         } 
/*     */       } 
/*     */       
/* 211 */       Projectile prop = new Projectile();
/* 212 */       prop.setInitialPos((int)(getX() + this.propLoc.getX() - (prop.getWIDTH() / 2)), (int)(getY() + this.propLoc.getY()));
/* 213 */       addProjectiles(prop);
/*     */ 
/*     */       
/* 216 */       if (SoundContainer.getPropSound().isActive() || SoundContainer.getPropSound().isRunning()) {
/* 217 */         Clip teClip = SoundContainer.getPropSound();
/* 218 */         teClip.start();
/*     */       } else {
/* 220 */         SoundContainer.playPropSound();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void increaseLevel() {
/* 228 */     if (getLevel() < SpriteContainer.getFIGHTERS().size()) setLevel(getLevel() + 1); 
/*     */   }
/*     */   public void decreaseLevel() {
/* 231 */     if (getLevel() > 1) setLevel(getLevel() - 1); 
/*     */   }
/*     */   
/*     */   public int getLevel() {
/* 235 */     return this.level;
/*     */   }
/*     */   public void setLevel(int level) {
/* 238 */     this.level = level;
/*     */   }
/*     */ 
/*     */   
/*     */   public void move() {
/* 243 */     if (!isBeingDestroyed()) {
/*     */       
/* 245 */       if (this.x_coor <= 0) {
/* 246 */         this.dx = 0;
/* 247 */         this.x_coor++;
/*     */       }
/* 249 */       else if (this.x_coor >= GamePanel.WIDTH - getWIDTH()) {
/* 250 */         this.dx = 0;
/* 251 */         this.x_coor--;
/*     */       } 
/*     */       
/* 254 */       this.x_coor += this.dx;
/*     */     
/*     */     }
/* 257 */     else if (this.currentImageIndex >= this.IMAGES - 1) {
/* 258 */       this.destroyed = true;
/*     */     } else {
/* 260 */       this.currentImageIndex++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void initiateDestroySequence() {
/* 266 */     this.dx = 0;
/*     */     
/* 268 */     super.initiateDestroySequence();
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\sprites\Fighter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */