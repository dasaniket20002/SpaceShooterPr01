/*    */ package loader;
/*    */ 
/*    */ import containers.DataContainer;
/*    */ import java.awt.Point;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FileLoader
/*    */ {
/*    */   public static DataContainer readData(String loc) {
/* 15 */     DataContainer ret = new DataContainer();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 21 */       FileReader fr = new FileReader(loc);
/* 22 */       BufferedReader br = new BufferedReader(fr);
/*    */       
/*    */       String text;
/*    */       
/* 26 */       while ((text = br.readLine()) != null) {
/*    */         
/* 28 */         if (text.equals("WIDTH")) {
/* 29 */           ret.setWIDTH(Integer.parseInt(br.readLine())); continue;
/*    */         } 
/* 31 */         if (text.equals("HEIGHT")) {
/* 32 */           ret.setHEIGHT(Integer.parseInt(br.readLine())); continue;
/*    */         } 
/* 34 */         if (text.equals("REQ_WIDTH")) {
/* 35 */           ret.setREQ_WIDTH(Integer.parseInt(br.readLine())); continue;
/*    */         } 
/* 37 */         if (text.equals("REQ_HEIGHT")) {
/* 38 */           ret.setREQ_HEIGHT(Integer.parseInt(br.readLine())); continue;
/*    */         } 
/* 40 */         if (text.equals("NUMBER")) {
/* 41 */           ret.setNUMBER(Integer.parseInt(br.readLine())); continue;
/*    */         } 
/* 43 */         if (text.equals("PROP_POS")) {
/* 44 */           Point d = new Point();
/* 45 */           d.setLocation(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
/* 46 */           ret.setPROP_POS(d); continue;
/*    */         } 
/* 48 */         if (text.equals("WING_PROP_POS1")) {
/* 49 */           Point d = new Point();
/* 50 */           d.setLocation(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
/* 51 */           ret.setWING_PROP_POS1(d); continue;
/*    */         } 
/* 53 */         if (text.equals("WING_PROP_POS2")) {
/* 54 */           Point d = new Point();
/* 55 */           d.setLocation(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
/* 56 */           ret.setWING_PROP_POS2(d); continue;
/*    */         } 
/* 58 */         if (text.equals("HEALTH")) {
/* 59 */           ret.setHEALTH(Integer.parseInt(br.readLine())); continue;
/*    */         } 
/* 61 */         if (text.equals("DAMAGE_POINTS")) {
/* 62 */           ret.setDAMAGEPOINTS(Integer.parseInt(br.readLine()));
/*    */         }
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 68 */       br.close();
/* 69 */       fr.close();
/*    */     }
/* 71 */     catch (FileNotFoundException e) {
/* 72 */       e.printStackTrace();
/* 73 */     } catch (IOException e) {
/* 74 */       e.printStackTrace();
/* 75 */     } catch (NumberFormatException e) {
/* 76 */       e.printStackTrace();
/*    */     } 
/*    */ 
/*    */     
/* 80 */     return ret;
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\loader\FileLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */