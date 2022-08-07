/*    */ package p455w0rd.cmotd;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import p455w0rd.cmotd.handler.FileHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModCache
/*    */ {
/* 14 */   private static List<String> MOTD_PLAYERLIST_CACHE = new ArrayList<>();
/* 15 */   private static List<String> MOTD_LIST_CACHE = new ArrayList<>();
/*    */   
/*    */   public static void cachePlayerListFile() {
/* 18 */     //MOTD_PLAYERLIST_CACHE = !FileHandler.readPlayerListFile().isEmpty() ? FileHandler.readPlayerListFile() : (List<String>) new ArrayList<>();
                if (!FileHandler.readPlayerListFile().isEmpty()) {
                    MOTD_PLAYERLIST_CACHE = FileHandler.readPlayerListFile();
                } else {
                    MOTD_PLAYERLIST_CACHE = new ArrayList<>();
                }
/*    */   }
/*    */
/*    */   public static void cacheMOTDListFile() {
/* 22 */     //MOTD_LIST_CACHE = !FileHandler.readMOTDListFile().isEmpty() ? FileHandler.readMOTDListFile() : (List<String>) new ArrayList<>();
                if (!FileHandler.readMOTDListFile().isEmpty()) {
                    MOTD_LIST_CACHE = FileHandler.readMOTDListFile();
                } else {
                    MOTD_LIST_CACHE = new ArrayList<>();
                }
/*    */   }
/*    */   
/*    */   public static List<String> getPlayerListFileCache() {
/* 26 */     return MOTD_PLAYERLIST_CACHE;
/*    */   }
/*    */   
/*    */   public static List<String> getMOTDListFileCache() {
/* 30 */     return MOTD_LIST_CACHE;
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Document\\ultramine\mods\CustomMOTD-1.7.10-1.0.2.jar!\p455w0rd\cmotd\ModCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */