/*     */ package containers;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JOptionPane;
/*     */ import loader.FileLoader;
/*     */ import loader.ImageLoader;
/*     */ import main.Main;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpriteContainer
/*     */ {
/*  19 */   private static ArrayList<BufferedImage> PLAY_BUTTONS = new ArrayList<>();
/*  20 */   private static ArrayList<BufferedImage> EXIT_BUTTONS = new ArrayList<>();
/*  21 */   private static ArrayList<BufferedImage> OPTION_BUTTONS = new ArrayList<>();
/*  22 */   private static ArrayList<BufferedImage> BACK_BUTTONS = new ArrayList<>();
/*     */   
/*  24 */   private static ArrayList<BufferedImage> FIGHTERS = new ArrayList<>();
/*  25 */   private static ArrayList<DataContainer> FIGHTERDATA = new ArrayList<>();
/*  26 */   private static ArrayList<BufferedImage> FIGTHERDESTROYSEQUENCE = new ArrayList<>();
/*  27 */   private static ArrayList<DataContainer> FIGTHERDESTROYSEQUENCEDATA = new ArrayList<>();
/*     */   
/*  29 */   private static ArrayList<BufferedImage> FIGHTERLEVELUP = new ArrayList<>();
/*  30 */   private static ArrayList<BufferedImage> FIGHTERLEVELDOWN = new ArrayList<>();
/*     */   
/*  32 */   private static ArrayList<BufferedImage> PROJECTILES = new ArrayList<>();
/*  33 */   private static ArrayList<DataContainer> PROJECTILEDATA = new ArrayList<>();
/*     */   
/*  35 */   private static ArrayList<BufferedImage> PROJECTILELEVELUP = new ArrayList<>();
/*  36 */   private static ArrayList<BufferedImage> PROJECTILELEVELDOWN = new ArrayList<>();
/*     */   
/*  38 */   private static ArrayList<BufferedImage> WINGPROJECTILES = new ArrayList<>();
/*  39 */   private static ArrayList<DataContainer> WINGPROJECTILEDATA = new ArrayList<>();
/*     */   
/*  41 */   private static ArrayList<BufferedImage> MISSILES = new ArrayList<>();
/*  42 */   private static ArrayList<DataContainer> MISSILEDATA = new ArrayList<>();
/*     */   
/*  44 */   private static ArrayList<BufferedImage> ALIENS = new ArrayList<>();
/*  45 */   private static ArrayList<DataContainer> ALIENDATA = new ArrayList<>();
/*  46 */   private static ArrayList<BufferedImage> ALIENDESTROYSEQUENCE = new ArrayList<>();
/*  47 */   private static ArrayList<DataContainer> ALIENDESTROYSEQUENCEDATA = new ArrayList<>();
/*     */   
/*  49 */   private static ArrayList<BufferedImage> ALIENPROJECTILES = new ArrayList<>();
/*  50 */   private static ArrayList<DataContainer> ALIENPROJECTILEDATA = new ArrayList<>();
/*     */   
/*  52 */   private static BufferedImage BACKGROUND = new BufferedImage(1, 2, 2);
/*     */ 
/*     */   
/*     */   public static void loadSpriteSheets() {
/*  56 */     System.out.println("Loading Sprites...");
/*     */     
/*  58 */     if (!Files.exists(Paths.get(FileContainer.HOME, new String[0]), new java.nio.file.LinkOption[0])) {
/*  59 */       JOptionPane.showMessageDialog(null, "%appdata%/Sprites path not found in the computer", "Path not found", 0);
/*  60 */       System.exit(-1);
/*     */     } 
/*     */     
/*  63 */     int i = 1;
/*     */ 
/*     */     
/*  66 */     PLAY_BUTTONS.add(ImageLoader.loadImage(FileContainer.PLAY_BUTTON_IDLE));
/*  67 */     PLAY_BUTTONS.add(ImageLoader.loadImage(FileContainer.PLAY_BUTTON_MOUSE_OVER));
/*  68 */     PLAY_BUTTONS.add(ImageLoader.loadImage(FileContainer.PLAY_BUTTON_PRESSED));
/*     */     
/*  70 */     Main.CURRENT++;
/*     */     
/*     */     try {
/*  73 */       Thread.sleep(500L);
/*  74 */     } catch (InterruptedException e1) {
/*  75 */       e1.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/*  79 */     OPTION_BUTTONS.add(ImageLoader.loadImage(FileContainer.OPTION_BUTTON_IDLE));
/*  80 */     OPTION_BUTTONS.add(ImageLoader.loadImage(FileContainer.OPTION_BUTTON_PRESSED));
/*     */     
/*  82 */     Main.CURRENT++;
/*     */     
/*     */     try {
/*  85 */       Thread.sleep(500L);
/*  86 */     } catch (InterruptedException e1) {
/*  87 */       e1.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/*  91 */     EXIT_BUTTONS.add(ImageLoader.loadImage(FileContainer.EXIT_BUTTON_IDLE));
/*  92 */     EXIT_BUTTONS.add(ImageLoader.loadImage(FileContainer.EXIT_BUTTON_PRESSED));
/*     */     
/*  94 */     Main.CURRENT++;
/*     */     
/*     */     try {
/*  97 */       Thread.sleep(500L);
/*  98 */     } catch (InterruptedException e1) {
/*  99 */       e1.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/* 103 */     BACK_BUTTONS.add(ImageLoader.loadImage(FileContainer.BACK_BUTTON_IDLE));
/*     */     
/* 105 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 108 */       Thread.sleep(500L);
/* 109 */     } catch (InterruptedException e1) {
/* 110 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 113 */     i = 1;
/*     */     
/*     */     while (true) {
/* 116 */       String currPath = String.valueOf(FileContainer.FIGHTERSHOME) + i;
/*     */       
/* 118 */       if (Files.exists(Paths.get(currPath, new String[0]), new java.nio.file.LinkOption[0])) {
/*     */         
/* 120 */         BufferedImage e = ImageLoader.loadImage(String.valueOf(currPath) + "\\spaceship_sprites_final.png");
/* 121 */         if (e == null)
/* 122 */           break;  getFIGHTERS().add(e);
/*     */         
/* 124 */         DataContainer d = FileLoader.readData(String.valueOf(currPath) + "\\Data.txt");
/* 125 */         FIGHTERDATA.add(d);
/*     */         
/* 127 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 133 */     FIGHTERLEVELUP.add(ImageLoader.loadImage(FileContainer.FIGHTERLEVELUP));
/* 134 */     FIGHTERLEVELDOWN.add(ImageLoader.loadImage(FileContainer.FIGHTERLEVELDOWN));
/*     */     
/* 136 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 139 */       Thread.sleep(500L);
/* 140 */     } catch (InterruptedException e1) {
/* 141 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 144 */     i = 1;
/*     */     
/*     */     while (true) {
/* 147 */       String currPath = String.valueOf(FileContainer.FIGHTERDESTROYSEQUENCE) + i;
/*     */       
/* 149 */       if (Files.exists(Paths.get(currPath, new String[0]), new java.nio.file.LinkOption[0])) {
/*     */         
/* 151 */         BufferedImage e = ImageLoader.loadImage(String.valueOf(currPath) + "\\destroy_sequence_final.png");
/* 152 */         if (e == null)
/* 153 */           break;  getFIGTHERDESTROYSEQUENCE().add(e);
/*     */         
/* 155 */         DataContainer d = FileLoader.readData(String.valueOf(currPath) + "\\Data.txt");
/* 156 */         FIGTHERDESTROYSEQUENCEDATA.add(d);
/*     */         
/* 158 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 164 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 167 */       Thread.sleep(500L);
/* 168 */     } catch (InterruptedException e1) {
/* 169 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 172 */     i = 1;
/*     */     
/*     */     while (true) {
/* 175 */       String currPath = String.valueOf(FileContainer.PROJECTILESHOME) + i;
/*     */       
/* 177 */       if (Files.exists(Paths.get(currPath, new String[0]), new java.nio.file.LinkOption[0])) {
/*     */         
/* 179 */         BufferedImage e = ImageLoader.loadImage(String.valueOf(currPath) + "\\Projectile.png");
/* 180 */         if (e == null)
/* 181 */           break;  getPROJECTILES().add(e);
/*     */         
/* 183 */         DataContainer d = FileLoader.readData(String.valueOf(currPath) + "\\Data.txt");
/* 184 */         PROJECTILEDATA.add(d);
/*     */         
/* 186 */         i++;
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 191 */     PROJECTILELEVELDOWN.add(ImageLoader.loadImage(FileContainer.PROJECTILELEVELDOWN));
/* 192 */     PROJECTILELEVELUP.add(ImageLoader.loadImage(FileContainer.PROJECTILELEVELUP));
/*     */     
/* 194 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 197 */       Thread.sleep(500L);
/* 198 */     } catch (InterruptedException e1) {
/* 199 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 202 */     i = 1;
/*     */ 
/*     */     
/*     */     while (true) {
/* 206 */       String currPath = String.valueOf(FileContainer.WINGPROJECTILESHOME) + i;
/*     */       
/* 208 */       if (Files.exists(Paths.get(currPath, new String[0]), new java.nio.file.LinkOption[0])) {
/*     */         
/* 210 */         BufferedImage e = ImageLoader.loadImage(String.valueOf(currPath) + "\\Wing Projectile.png");
/* 211 */         if (e == null)
/* 212 */           break;  getWINGPROJECTILES().add(e);
/*     */         
/* 214 */         DataContainer d = FileLoader.readData(String.valueOf(currPath) + "\\Data.txt");
/* 215 */         WINGPROJECTILEDATA.add(d);
/*     */         
/* 217 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 223 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 226 */       Thread.sleep(500L);
/* 227 */     } catch (InterruptedException e1) {
/* 228 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 231 */     i = 1;
/*     */ 
/*     */     
/*     */     while (true) {
/* 235 */       String currPath = String.valueOf(FileContainer.MISSILESHOME) + i;
/*     */       
/* 237 */       if (Files.exists(Paths.get(currPath, new String[0]), new java.nio.file.LinkOption[0])) {
/*     */         
/* 239 */         BufferedImage e = ImageLoader.loadImage(String.valueOf(currPath) + "\\Missile_sprite.png");
/* 240 */         if (e == null)
/* 241 */           break;  getWINGPROJECTILES().add(e);
/*     */         
/* 243 */         DataContainer d = FileLoader.readData(String.valueOf(currPath) + "\\Data.txt");
/* 244 */         WINGPROJECTILEDATA.add(d);
/*     */         
/* 246 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 252 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 255 */       Thread.sleep(500L);
/* 256 */     } catch (InterruptedException e1) {
/* 257 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 260 */     i = 1;
/*     */ 
/*     */     
/*     */     while (true) {
/* 264 */       String currPath = String.valueOf(FileContainer.ALIENHOME) + i;
/*     */       
/* 266 */       if (Files.exists(Paths.get(currPath, new String[0]), new java.nio.file.LinkOption[0])) {
/*     */         
/* 268 */         BufferedImage e = ImageLoader.loadImage(String.valueOf(currPath) + "\\alien_sprites_final.png");
/* 269 */         if (e == null)
/* 270 */           break;  getALIENS().add(e);
/*     */         
/* 272 */         DataContainer d = FileLoader.readData(String.valueOf(currPath) + "\\Data.txt");
/* 273 */         ALIENDATA.add(d);
/*     */         
/* 275 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 281 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 284 */       Thread.sleep(500L);
/* 285 */     } catch (InterruptedException e1) {
/* 286 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 289 */     i = 1;
/*     */ 
/*     */     
/*     */     while (true) {
/* 293 */       String currPath = String.valueOf(FileContainer.ALIENDESTROYSEQUENCE) + i;
/*     */       
/* 295 */       if (Files.exists(Paths.get(currPath, new String[0]), new java.nio.file.LinkOption[0])) {
/* 296 */         BufferedImage e = ImageLoader.loadImage(String.valueOf(currPath) + "\\destroy_sequence_final.png");
/* 297 */         if (e == null) {
/*     */           break;
/*     */         }
/* 300 */         getALIENDESTROYSEQUENCE().add(e);
/*     */         
/* 302 */         DataContainer d = FileLoader.readData(String.valueOf(currPath) + "\\Data.txt");
/* 303 */         ALIENDESTROYSEQUENCEDATA.add(d);
/*     */         
/* 305 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 311 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 314 */       Thread.sleep(500L);
/* 315 */     } catch (InterruptedException e1) {
/* 316 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 319 */     i = 1;
/*     */ 
/*     */     
/*     */     while (true) {
/* 323 */       String currPath = String.valueOf(FileContainer.ALIENPROJECTILEHOME) + i;
/*     */       
/* 325 */       if (Files.exists(Paths.get(currPath, new String[0]), new java.nio.file.LinkOption[0])) {
/*     */         
/* 327 */         BufferedImage e = ImageLoader.loadImage(String.valueOf(currPath) + "\\projectile_final.png");
/* 328 */         if (e == null)
/* 329 */           break;  getALIENPROJECTILES().add(e);
/*     */         
/* 331 */         DataContainer d = FileLoader.readData(String.valueOf(currPath) + "\\Data.txt");
/* 332 */         ALIENPROJECTILEDATA.add(d);
/*     */         
/* 334 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 340 */     Main.CURRENT++;
/*     */     
/*     */     try {
/* 343 */       Thread.sleep(500L);
/* 344 */     } catch (InterruptedException e1) {
/* 345 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 348 */     i = 1;
/*     */ 
/*     */     
/* 351 */     FIGHTERLEVELUP.add(ImageLoader.loadImage(FileContainer.FIGHTERLEVELUP));
/* 352 */     FIGHTERLEVELDOWN.add(ImageLoader.loadImage(FileContainer.FIGHTERLEVELDOWN));
/*     */ 
/*     */     
/* 355 */     BACKGROUND = ImageLoader.loadImage(FileContainer.BACKGROUND);
/*     */     
/* 357 */     Main.CURRENT++;
/* 358 */     i = 1;
/*     */     
/* 360 */     System.out.println("All Sprites are now Loaded");
/* 361 */     System.out.println("No. of processes completed = " + Main.CURRENT);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BufferedImage getFighter(int index) {
/* 366 */     return getFIGHTERS().get(index);
/*     */   }
/*     */   public static DataContainer getFighterData(int index) {
/* 369 */     return FIGHTERDATA.get(index);
/*     */   }
/*     */   
/*     */   public static BufferedImage getFighterDestroy(int index) {
/* 373 */     return getFIGTHERDESTROYSEQUENCE().get(0);
/*     */   }
/*     */   public static DataContainer getFighterDestroyData(int index) {
/* 376 */     return FIGTHERDESTROYSEQUENCEDATA.get(0);
/*     */   }
/*     */   
/*     */   public static BufferedImage getProjectile(int index) {
/* 380 */     return getPROJECTILES().get(index);
/*     */   }
/*     */   public static DataContainer getProjectileData(int index) {
/* 383 */     return PROJECTILEDATA.get(index);
/*     */   }
/*     */   
/*     */   public static BufferedImage getWingProjectile(int index) {
/* 387 */     return getWINGPROJECTILES().get(index);
/*     */   }
/*     */   public static DataContainer getWingProjectileData(int index) {
/* 390 */     return WINGPROJECTILEDATA.get(index);
/*     */   }
/*     */   
/*     */   public static BufferedImage getMissile(int index) {
/* 394 */     return getMISSILES().get(index);
/*     */   }
/*     */   public static DataContainer getMissileData(int index) {
/* 397 */     return MISSILEDATA.get(index);
/*     */   }
/*     */   
/*     */   public static BufferedImage getAlien(int index) {
/* 401 */     return getALIENS().get(index);
/*     */   }
/*     */   public static DataContainer getAlienData(int index) {
/* 404 */     return ALIENDATA.get(index);
/*     */   }
/*     */   
/*     */   public static BufferedImage getAlienDestroy(int index) {
/* 408 */     return getALIENDESTROYSEQUENCE().get(0);
/*     */   }
/*     */   
/*     */   public static DataContainer getAlienDestroyData(int index) {
/* 412 */     return ALIENDESTROYSEQUENCEDATA.get(0);
/*     */   }
/*     */   
/*     */   public static BufferedImage getAlienProjectile(int index) {
/* 416 */     return getALIENPROJECTILES().get(index);
/*     */   }
/*     */   public static DataContainer getAlienProjectileData(int index) {
/* 419 */     return ALIENPROJECTILEDATA.get(index);
/*     */   }
/*     */   
/*     */   public static BufferedImage getFighterLevelUp(int index) {
/* 423 */     return FIGHTERLEVELUP.get(index);
/*     */   }
/*     */   public static BufferedImage getFighterLevelDown(int index) {
/* 426 */     return FIGHTERLEVELDOWN.get(index);
/*     */   }
/*     */   
/*     */   public static BufferedImage getProjectileLevelUp(int index) {
/* 430 */     return PROJECTILELEVELUP.get(index);
/*     */   }
/*     */   public static BufferedImage getProjectileLevelDown(int index) {
/* 433 */     return PROJECTILELEVELDOWN.get(index);
/*     */   }
/*     */   
/*     */   public static BufferedImage getBackground() {
/* 437 */     return BACKGROUND;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getPROJECTILES() {
/* 441 */     return PROJECTILES;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getFIGHTERS() {
/* 445 */     return FIGHTERS;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getFIGTHERDESTROYSEQUENCE() {
/* 449 */     return FIGTHERDESTROYSEQUENCE;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getWINGPROJECTILES() {
/* 453 */     return WINGPROJECTILES;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getMISSILES() {
/* 457 */     return MISSILES;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getALIENS() {
/* 461 */     return ALIENS;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getALIENDESTROYSEQUENCE() {
/* 465 */     return ALIENDESTROYSEQUENCE;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getALIENPROJECTILES() {
/* 469 */     return ALIENPROJECTILES;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getPlayButton() {
/* 473 */     return PLAY_BUTTONS;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getOptionButton() {
/* 477 */     return OPTION_BUTTONS;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getExitButton() {
/* 481 */     return EXIT_BUTTONS;
/*     */   }
/*     */   
/*     */   public static ArrayList<BufferedImage> getBackButton() {
/* 485 */     return BACK_BUTTONS;
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\containers\SpriteContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */