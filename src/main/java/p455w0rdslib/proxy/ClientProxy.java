/*    */ package p455w0rdslib.proxy;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
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
/*    */ public class ClientProxy
/*    */   extends p455w0rdslib.proxy.CommonProxy
/*    */ {
/*    */   public boolean isSMP() {
/* 33 */     return super.isSMP();
/*    */   }
/*    */ 
/*    */   
/*    */   public World getWorld() {
/* 38 */     return (World)(Minecraft.getMinecraft()).theWorld;
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityPlayer getPlayer() {
/* 43 */     return (EntityPlayer)(Minecraft.getMinecraft()).thePlayer;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getServer() {
/* 48 */     return super.getServer();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isClientSide() {
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdslib\proxy\ClientProxy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */