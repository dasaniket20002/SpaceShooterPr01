/*     */ package containers;
/*     */ 
/*     */ import java.io.File;
/*     */ import javax.sound.sampled.AudioInputStream;
/*     */ import javax.sound.sampled.AudioSystem;
/*     */ import javax.sound.sampled.Clip;
/*     */ import javax.sound.sampled.FloatControl;
/*     */ import javax.sound.sampled.UnsupportedAudioFileException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoundContainer
/*     */ {
/*     */   private static Clip backgroundMusic;
/*     */   private static Clip propSound;
/*     */   private static Clip wingPropSound;
/*     */   private static Clip alienPropSound;
/*     */   
/*     */   public static void loadAllSounds() {
/*     */     try {
/*  26 */       File f = new File(FileContainer.BACKGROUNDSOUND);
/*  27 */       AudioInputStream ais = AudioSystem.getAudioInputStream(f);
/*     */       
/*  29 */       backgroundMusic = AudioSystem.getClip();
/*  30 */       backgroundMusic.open(ais);
/*  31 */       backgroundMusic.stop();
/*  32 */       backgroundMusic.loop(-1);
/*  33 */       FloatControl gainControl1 = (FloatControl)backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
/*  34 */       gainControl1.setValue(-10.0F);
/*     */ 
/*     */       
/*  37 */       f = new File(FileContainer.FIGHTERPROJECTILESOUND);
/*  38 */       ais = AudioSystem.getAudioInputStream(f);
/*     */       
/*  40 */       propSound = AudioSystem.getClip();
/*  41 */       propSound.open(ais);
/*  42 */       propSound.stop();
/*  43 */       FloatControl gainControl2 = (FloatControl)propSound.getControl(FloatControl.Type.MASTER_GAIN);
/*  44 */       gainControl2.setValue(-5.0F);
/*     */ 
/*     */       
/*  47 */       f = new File(FileContainer.FIGHTERWINGPROJECTILESOUND);
/*  48 */       ais = AudioSystem.getAudioInputStream(f);
/*     */       
/*  50 */       wingPropSound = AudioSystem.getClip();
/*  51 */       wingPropSound.open(ais);
/*  52 */       wingPropSound.stop();
/*  53 */       FloatControl gainControl3 = (FloatControl)wingPropSound.getControl(FloatControl.Type.MASTER_GAIN);
/*  54 */       gainControl3.setValue(-5.0F);
/*     */ 
/*     */       
/*  57 */       f = new File(FileContainer.ALIENPROJECTILESOUND);
/*  58 */       ais = AudioSystem.getAudioInputStream(f);
/*     */       
/*  60 */       alienPropSound = AudioSystem.getClip();
/*  61 */       alienPropSound.open(ais);
/*  62 */       alienPropSound.stop();
/*  63 */       FloatControl gainControl4 = (FloatControl)alienPropSound.getControl(FloatControl.Type.MASTER_GAIN);
/*  64 */       gainControl4.setValue(-5.0F);
/*     */     }
/*  66 */     catch (UnsupportedAudioFileException|java.io.IOException|javax.sound.sampled.LineUnavailableException e) {
/*  67 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Clip getbgMusic() {
/*  73 */     return backgroundMusic;
/*     */   }
/*     */   public static void playBgMusic() {
/*  76 */     backgroundMusic.setMicrosecondPosition(0L);
/*  77 */     backgroundMusic.start();
/*     */   }
/*     */   
/*     */   public static Clip getPropSound() {
/*  81 */     return propSound;
/*     */   }
/*     */   public static void playPropSound() {
/*  84 */     propSound.setMicrosecondPosition(0L);
/*  85 */     propSound.start();
/*     */   }
/*     */   
/*     */   public static Clip getWingPropSound() {
/*  89 */     return wingPropSound;
/*     */   }
/*     */   public static void playWingPropSound() {
/*  92 */     wingPropSound.setMicrosecondPosition(0L);
/*  93 */     wingPropSound.start();
/*     */   }
/*     */   
/*     */   public static Clip getAlienPropSound() {
/*  97 */     return alienPropSound;
/*     */   }
/*     */   public static void playAlienPropSound() {
/* 100 */     alienPropSound.setMicrosecondPosition(0L);
/* 101 */     alienPropSound.start();
/*     */   }
/*     */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\containers\SoundContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */