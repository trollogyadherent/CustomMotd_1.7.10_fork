/*    */ package p455w0rdslib.util;
/*    */ 
/*    */ import com.mojang.authlib.minecraft.MinecraftProfileTexture;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerTextureUtils
/*    */ {
/*    */   public static void setCape(AbstractClientPlayer player, ResourceLocation texture) {
/* 33 */     player.func_152121_a(MinecraftProfileTexture.Type.CAPE, texture);
/*    */   }
/*    */   
/*    */   public static void setSkin(AbstractClientPlayer player, ResourceLocation texture) {
/* 37 */     player.func_152121_a(MinecraftProfileTexture.Type.SKIN, texture);
/*    */   }
/*    */   
/*    */   public static boolean hasCape(AbstractClientPlayer player) {
/* 41 */     return player.func_152122_n();
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdsli\\util\PlayerTextureUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */