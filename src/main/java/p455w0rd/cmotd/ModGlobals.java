/*    */ package p455w0rd.cmotd;
/*    */ 
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ import java.util.concurrent.ThreadPoolExecutor;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ public class ModGlobals {
/*    */   public static final String MODID = "cmotd";
/*    */   public static final String VERSION = "1.0.2";
/*    */   public static final String NAME = "p455w0rd's MOTD Customizer";
/*    */   public static final String SERVER_PROXY = "p455w0rd.cmotd.proxy.CommonProxy";
/*    */   public static final String CLIENT_PROXY = "p455w0rd.cmotd.proxy.ClientProxy";
/*    */   public static final String DEPENDENCIES = "required-after:p455w0rdslib";
/* 15 */   public static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
/*    */ }


/* Location:              C:\Users\jf\Document\\ultramine\mods\CustomMOTD-1.7.10-1.0.2.jar!\p455w0rd\cmotd\ModGlobals.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */