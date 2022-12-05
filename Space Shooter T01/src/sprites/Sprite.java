/*     */ package sprites;
/*     */ 
/*     */ import containers.DataContainer;
/*     */ import containers.SpriteContainer;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.ArrayList;
/*     */ import loader.ImageLoader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Sprite
/*     */ {
/*     */   protected ArrayList<BufferedImage> sprites;
/*     */   private ArrayList<BufferedImage> destroySprites;
/*     */   protected int IMAGES;
/*     */   private int IMAGE_WIDTH;
/*     */   private int IMAGE_HEIGHT;
/*     */   protected int MIDDLE_INDEX;
/*     */   protected BufferedImage spriteSheet;
/*     */   private BufferedImage spriteSheet2;
/*     */   protected String TYPE;
/*     */   protected int HEALTH;
/*     */   protected int MAX_HEALTH;
/*     */   protected int DAMAGE_POINTS;
/*     */   private int DESTROY_WIDTH;
/*     */   private int DESTROY_HEIGHT;
/*     */   private int DESTROY_IMAGES;
/*     */   protected int currentImageIndex;
/*     */   protected int x_coor;
/*     */   protected int y_coor;
/*     */   protected boolean destroyed;
/*     */   protected boolean beingDestroyed;
/*     */   
/*     */   public Sprite(String name, int l) {
/*  39 */     this.TYPE = name;
/*  40 */     DataContainer dc = new DataContainer();
/*  41 */     DataContainer dc2 = new DataContainer();
/*     */     
/*  43 */     if (this.TYPE.equals("FIGHTER")) {
/*     */       
/*  45 */       this.spriteSheet = SpriteContainer.getFighter(l - 1);
/*  46 */       dc = SpriteContainer.getFighterData(l - 1);
/*     */       
/*  48 */       this.spriteSheet2 = SpriteContainer.getFighterDestroy(l - 1);
/*  49 */       dc2 = SpriteContainer.getFighterDestroyData(l - 1);
/*     */ 
/*     */     
/*     */     }
/*  53 */     else if (this.TYPE.equals("PROJECTILE")) {
/*     */       
/*  55 */       this.spriteSheet = SpriteContainer.getProjectile(l - 1);
/*  56 */       dc = SpriteContainer.getProjectileData(l - 1);
/*     */ 
/*     */     
/*     */     }
/*  60 */     else if (!this.TYPE.equals("MISSILE")) {
/*     */ 
/*     */ 
/*     */       
/*  64 */       if (this.TYPE.equals("WINGPROP")) {
/*     */         
/*  66 */         this.spriteSheet = SpriteContainer.getWingProjectile(l - 1);
/*  67 */         dc = SpriteContainer.getWingProjectileData(l - 1);
/*     */ 
/*     */       
/*     */       }
/*  71 */       else if (this.TYPE.equals("ALIEN")) {
/*     */         
/*  73 */         this.spriteSheet = SpriteContainer.getAlien(l - 1);
/*  74 */         dc = SpriteContainer.getAlienData(l - 1);
/*     */         
/*  76 */         this.spriteSheet2 = SpriteContainer.getAlienDestroy(l - 1);
/*  77 */         dc2 = SpriteContainer.getAlienDestroyData(l - 1);
/*     */ 
/*     */       
/*     */       }
/*  81 */       else if (this.TYPE.equals("ALIENPROP")) {
/*     */         
/*  83 */         this.spriteSheet = SpriteContainer.getAlienProjectile(l - 1);
/*  84 */         dc = SpriteContainer.getAlienProjectileData(l - 1);
/*     */ 
/*     */       
/*     */       }
/*  88 */       else if (!this.TYPE.equals("BUTTON")) {
/*     */ 
/*     */ 
/*     */         
/*  92 */         this.TYPE.equals("DROPS");
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     this.IMAGE_WIDTH = dc.getWIDTH();
/*  97 */     this.IMAGE_HEIGHT = dc.getHEIGHT();
/*  98 */     this.IMAGES = dc.getNUMBER();
/*     */     
/* 100 */     this.HEALTH = dc.getHEALTH();
/* 101 */     this.MAX_HEALTH = this.HEALTH;
/* 102 */     this.DAMAGE_POINTS = dc.getDAMAGEPOINTS();
/*     */     
/* 104 */     this.DESTROY_WIDTH = dc2.getWIDTH();
/* 105 */     this.DESTROY_HEIGHT = dc2.getHEIGHT();
/* 106 */     this.DESTROY_IMAGES = dc2.getNUMBER();
/*     */     
/* 108 */     this.MIDDLE_INDEX = this.IMAGES / 2;
/*     */     
/* 110 */     initComponents();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initComponents() {
/* 117 */     this.sprites = ImageLoader.splitSprites(this.spriteSheet, this.IMAGES, this.IMAGE_WIDTH, this.IMAGE_HEIGHT);
/*     */     
/* 119 */     this.destroySprites = ImageLoader.splitSprites(this.spriteSheet2, this.DESTROY_IMAGES, this.DESTROY_WIDTH, this.DESTROY_HEIGHT);
/*     */     
/* 121 */     this.currentImageIndex = this.MIDDLE_INDEX;
/* 122 */     this.destroyed = false;
/* 123 */     this.beingDestroyed = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setButton(ArrayList<BufferedImage> i, int w, int h) {
/* 129 */     this.IMAGES = 1;
/* 130 */     this.IMAGE_WIDTH = w;
/* 131 */     this.IMAGE_HEIGHT = h;
/*     */     
/* 133 */     this.MIDDLE_INDEX = 1;
/*     */     
/* 135 */     this.sprites = i;
/* 136 */     this.currentImageIndex = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInitialPos(int x, int y) {
/* 141 */     setX(x);
/* 142 */     setY(y);
/*     */   }
/*     */   
/*     */   public int getX() {
/* 146 */     return this.x_coor;
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/* 150 */     this.x_coor = x;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 154 */     return this.y_coor;
/*     */   }
/*     */   
/*     */   public void setY(int y) {
/* 158 */     this.y_coor = y;
/*     */   }
/*     */   
/*     */   public int getWIDTH() {
/* 162 */     return this.IMAGE_WIDTH;
/*     */   }
/*     */   
/*     */   public int getHEIGHT() {
/* 166 */     return this.IMAGE_HEIGHT;
/*     */   }
/*     */   
/*     */   public int getCurrentImageIndex() {
/* 170 */     return this.currentImageIndex;
/*     */   }
/*     */   
/*     */   public void setCurrentImageIndex(int currentImageIndex) {
/* 174 */     this.currentImageIndex = currentImageIndex;
/*     */   }
/*     */   
/*     */   public BufferedImage getCurrentImage() {
/* 178 */     return this.sprites.get(this.currentImageIndex);
/*     */   }
/*     */   
/*     */   protected void setSprite(BufferedImage s) {
/* 182 */     ArrayList<BufferedImage> sp = new ArrayList<>();
/* 183 */     sp.add(s);
/* 184 */     this.sprites = sp;
/*     */   }
/*     */   
/*     */   public void decrementHealthBy(int dp) {
/* 188 */     this.HEALTH -= dp;
/*     */   }
/*     */   
/*     */   public int getHealth() {
/* 192 */     return this.HEALTH;
/*     */   }
/*     */   
/*     */   public int getDamagePoints() {
/* 196 */     return this.DAMAGE_POINTS;
/*     */   }
/*     */   
/*     */   public int getMaxHealth() {
/* 200 */     return this.MAX_HEALTH;
/*     */   }
/*     */   
/*     */   public boolean isDestroyed() {
/* 204 */     return this.destroyed;
/*     */   }
/*     */   
/*     */   public boolean isBeingDestroyed() {
/* 208 */     return this.beingDestroyed;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getResizedImage(int width, int height) {
/* 213 */     ArrayList<BufferedImage> teSprites = new ArrayList<>();
/* 214 */     for (BufferedImage teImg : this.sprites) {
/* 215 */       BufferedImage scale = ImageLoader.getResizedImage(teImg, width, height);
/* 216 */       teSprites.add(scale);
/*     */     } 
/*     */ 
/*     */     
/* 220 */     this.sprites = teSprites;
/* 221 */     this.IMAGE_WIDTH = width;
/* 222 */     this.IMAGE_HEIGHT = height;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void getResizedDestroy(int width, int height) {
/* 228 */     ArrayList<BufferedImage> teSprites = new ArrayList<>();
/* 229 */     for (BufferedImage teImg : this.destroySprites) {
/* 230 */       BufferedImage scale = ImageLoader.getResizedImage(teImg, width, height);
/* 231 */       teSprites.add(scale);
/*     */     } 
/*     */ 
/*     */     
/* 235 */     this.destroySprites = teSprites;
/* 236 */     this.DESTROY_WIDTH = width;
/* 237 */     this.DESTROY_HEIGHT = height;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initiateDestroySequence() {
/* 243 */     if (this.destroySprites.size() == 0) {
/*     */       
/* 245 */       BufferedImage clear = new BufferedImage(this.IMAGE_WIDTH, this.IMAGE_HEIGHT, 2);
/* 246 */       ArrayList<BufferedImage> te = new ArrayList<>();
/* 247 */       te.add(clear);
/*     */       
/* 249 */       this.currentImageIndex = 0;
/* 250 */       this.sprites = te;
/*     */       
/* 252 */       this.destroyed = true;
/*     */     }
/*     */     else {
/*     */       
/* 256 */       this.sprites = this.destroySprites;
/* 257 */       this.currentImageIndex = 0;
/*     */       
/* 259 */       this.IMAGES = this.DESTROY_IMAGES;
/*     */       
/* 261 */       int xDist = (Math.max(this.IMAGE_WIDTH, this.DESTROY_WIDTH) - Math.min(this.IMAGE_WIDTH, this.DESTROY_WIDTH)) / 2;
/* 262 */       int yDist = (Math.max(this.IMAGE_HEIGHT, this.DESTROY_HEIGHT) - Math.min(this.IMAGE_HEIGHT, this.DESTROY_HEIGHT)) / 2;
/*     */       
/* 264 */       setX(getX() - xDist);
/* 265 */       setY(getY() - yDist);
/*     */       
/* 267 */       this.IMAGE_WIDTH = this.DESTROY_WIDTH;
/* 268 */       this.IMAGE_HEIGHT = this.DESTROY_HEIGHT;
/*     */       
/* 270 */       this.beingDestroyed = true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\sprites\Sprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */