/*    */ package p455w0rd.cmotd.proxy;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLServerStartedEvent;
/*    */ import p455w0rd.cmotd.handler.EventsHandler;
/*    */ import p455w0rd.cmotd.handler.FileHandler;
/*    */ import p455w0rdslib.util.ProxiedUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonProxy
/*    */ {
/*    */   public void preInit(FMLPreInitializationEvent e) {
/* 17 */     FileHandler.init();
/*    */   }
/*    */   
/*    */   public void serverStarted(FMLServerStartedEvent e) {
/* 21 */     if (ProxiedUtils.isSMP() && !ProxiedUtils.isClientSide())
/* 22 */       FMLCommonHandler.instance().bus().register(new EventsHandler()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Document\\ultramine\mods\CustomMOTD-1.7.10-1.0.2.jar!\p455w0rd\cmotd\proxy\CommonProxy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */