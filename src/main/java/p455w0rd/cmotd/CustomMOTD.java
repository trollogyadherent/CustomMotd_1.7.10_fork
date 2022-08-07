/*    */ package p455w0rd.cmotd;
/*    */ 
/*    */ import cpw.mods.fml.common.Mod;
/*    */ import cpw.mods.fml.common.Mod.EventHandler;
/*    */ import cpw.mods.fml.common.Mod.Instance;
/*    */ import cpw.mods.fml.common.SidedProxy;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLServerStartedEvent;
/*    */ import p455w0rd.cmotd.proxy.CommonProxy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod(modid = "cmotd", name = "p455w0rd's MOTD Customizer", version = "1.0.2", dependencies = "", acceptableRemoteVersions = "*", acceptedMinecraftVersions = "[1.7.10]")
/*    */ public class CustomMOTD
/*    */ {
/*    */   @SidedProxy(clientSide = "p455w0rd.cmotd.proxy.ClientProxy", serverSide = "p455w0rd.cmotd.proxy.CommonProxy")
/*    */   public static CommonProxy PROXY;
/*    */   @Instance("cmotd")
/*    */   public static CustomMOTD INSTANCE;
/*    */   
/*    */   @EventHandler
/*    */   public void preInit(FMLPreInitializationEvent e) {
/* 26 */     INSTANCE = this;
/* 27 */     PROXY.preInit(e);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void serverStarted(FMLServerStartedEvent e) {
/* 32 */     PROXY.serverStarted(e);
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Document\\ultramine\mods\CustomMOTD-1.7.10-1.0.2.jar!\p455w0rd\cmotd\CustomMOTD.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */