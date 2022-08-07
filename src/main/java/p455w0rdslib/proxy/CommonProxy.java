/*    */ package p455w0rdslib.proxy;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.relauncher.Side;
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
/*    */ public class CommonProxy
/*    */ {
/*    */   public boolean isSMP() {
/* 33 */     return (FMLCommonHandler.instance().getMinecraftServerInstance() != null && FMLCommonHandler.instance().getMinecraftServerInstance().isDedicatedServer());
/*    */   }
/*    */   
/*    */   public World getWorld() {
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public EntityPlayer getPlayer() {
/* 41 */     return null;
/*    */   }
/*    */   
/*    */   public boolean isClientSide() {
/* 45 */     return (FMLCommonHandler.instance().getSide() == Side.CLIENT);
/*    */   }
/*    */   
/*    */   public Object getServer() {
/* 49 */     return FMLCommonHandler.instance().getMinecraftServerInstance();
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdslib\proxy\CommonProxy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */