/*    */ package sprites;
/*    */ 
/*    */ import containers.SpriteContainer;
/*    */ 
/*    */ public class Button
/*    */   extends Sprite {
/*    */   public Button() {
/*  8 */     super("BUTTON", 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setButtonType(String type) {
/* 13 */     if (type.equals("PLAY")) {
/* 14 */       setButton(SpriteContainer.getPlayButton(), 169, 107);
/*    */     
/*    */     }
/* 17 */     else if (type.equals("OPTION")) {
/* 18 */       setButton(SpriteContainer.getOptionButton(), 169, 107);
/*    */     
/*    */     }
/* 21 */     else if (type.equals("EXIT")) {
/* 22 */       setButton(SpriteContainer.getExitButton(), 169, 107);
/*    */     
/*    */     }
/* 25 */     else if (type.equals("BACK")) {
/* 26 */       setButton(SpriteContainer.getBackButton(), 52, 52);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\dasan\Desktop\New folder\Space Shooter\Space Shooter jars\Space Shooter T4.jar!\sprites\Button.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */