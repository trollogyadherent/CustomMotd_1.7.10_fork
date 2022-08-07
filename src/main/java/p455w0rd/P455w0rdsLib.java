/*    */ package p455w0rdslib;
/*    */ 
/*    */ import cpw.mods.fml.common.Mod;
/*    */ import cpw.mods.fml.common.Mod.EventHandler;
/*    */ import cpw.mods.fml.common.Mod.Instance;
/*    */ import cpw.mods.fml.common.SidedProxy;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import p455w0rdslib.proxy.CommonProxy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
 //@Mod(modid = "p455w0rdslib", name = "p455w0rd's Library", version = "1.0.2", acceptedMinecraftVersions = "[1.7.10]")
 public class P455w0rdsLib
 {
 @SidedProxy(clientSide = "p455w0rdslib.proxy.ClientProxy", serverSide = "p455w0rdslib.proxy.CommonProxy")
  public static CommonProxy PROXY;
   @Instance("p455w0rdslib")
   public static P455w0rdsLib INSTANCE;

   @EventHandler
  public void preInit(FMLPreInitializationEvent e) {
    INSTANCE = this;
  }
 }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdslib\P455w0rdsLib.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */