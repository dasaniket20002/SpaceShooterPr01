/*    */ package loader;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Image;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.awt.image.ImageObserver;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ImageLoader
/*    */ {
/*    */   public static BufferedImage loadImage(String fileLocation) {
/*    */     try {
/* 19 */       BufferedImage img = ImageIO.read(new File(fileLocation));
/*    */       
/* 21 */       return img;
/*    */     }
/* 23 */     catch (IOException e) {
/* 24 */       e.printStackTrace();
/*    */ 
/*    */       
/* 27 */       return null;
/*    */     } 
/*    */   }
/*    */   public static BufferedImage getResizedImage(BufferedImage img, int scaleWidth, int scaleHeight) {
/* 31 */     if (img == null) {
/* 32 */       System.out.println("img is null");
/* 33 */       return null;
/*    */     } 
/* 35 */     Image image = img.getScaledInstance(scaleWidth, scaleHeight, 1);
/*    */     
/* 37 */     BufferedImage scaled = new BufferedImage(scaleWidth, scaleHeight, 2);
/* 38 */     Graphics2D g2d = scaled.createGraphics();
/* 39 */     g2d.drawImage(image, 0, 0, (ImageObserver)null);
/* 40 */     g2d.dispose();
/*    */     
/* 42 */     return scaled;
/*    */   }
/*    */ 
/*    */   
/*    */   public static ArrayList<BufferedImage> splitSprites(BufferedImage spriteSheet, int cols, int width, int height) {
/* 47 */     ArrayList<BufferedImage> ret = new ArrayList<>();
/* 48 */     for (int i = 0; i < 1; i++) {
/* 49 */       for (int j = 0; j < cols; j++) {
/* 50 */         BufferedImage subImg = spriteSheet.getSubimage(j * width, i * height, width, height);
/*    */         
/* 52 */         ret.add(subImg);
/*    */       } 
/*    */     } 
/*    */     
/* 56 */     return ret;
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\loader\ImageLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */