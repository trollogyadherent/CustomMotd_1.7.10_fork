/*    */ package p455w0rdslib.util;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.World;
/*    */ import p455w0rdslib.P455w0rdsLib;
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
/*    */ public class ProxiedUtils
/*    */ {
/*    */   public static boolean isSMP() {
/* 33 */     return P455w0rdsLib.PROXY.isSMP();
/*    */   }
/*    */   
/*    */   public static World getWorld() {
/* 37 */     return P455w0rdsLib.PROXY.getWorld();
/*    */   }
/*    */   
/*    */   public static EntityPlayer getPlayer() {
/* 41 */     return P455w0rdsLib.PROXY.getPlayer();
/*    */   }
/*    */   
/*    */   public static boolean isClientSide() {
/* 45 */     return P455w0rdsLib.PROXY.isClientSide();
/*    */   }
/*    */   
/*    */   public static MinecraftServer getServer() {
/* 49 */     return (MinecraftServer)P455w0rdsLib.PROXY.getServer();
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdsli\\util\ProxiedUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */