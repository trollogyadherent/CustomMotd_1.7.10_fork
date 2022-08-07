/*    */ package p455w0rdslib;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
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
/*    */ public class LibRegistry
/*    */ {
/* 31 */   private static Map<UUID, String> NAME_REGISTRY = new HashMap<>();
/* 32 */   private static Map<String, UUID> UUID_REGISTRY = new HashMap<>();
/*    */   
/*    */   public static Map<UUID, String> getNameRegistry() {
/* 35 */     return NAME_REGISTRY;
/*    */   }
/*    */   
/*    */   public static Map<String, UUID> getUUIDRegistry() {
/* 39 */     return UUID_REGISTRY;
/*    */   }
/*    */   
/*    */   public static String getPlayerName(UUID uuid) {
/* 43 */     return NAME_REGISTRY.get(uuid);
/*    */   }
/*    */   
/*    */   public static boolean registerName(UUID uuid, String name) {
/* 47 */     boolean hasChanged = false;
/* 48 */     if (!NAME_REGISTRY.containsKey(uuid)) {
/* 49 */       NAME_REGISTRY.put(uuid, name);
/* 50 */       hasChanged = true;
/*    */     } 
/* 52 */     if (!UUID_REGISTRY.containsKey(name)) {
/* 53 */       UUID_REGISTRY.put(name, uuid);
/*    */     }
/* 55 */     return hasChanged;
/*    */   }
/*    */   
/*    */   public static void registerUUID(String name, UUID uuid) {
/* 59 */     registerName(uuid, name);
/*    */   }
/*    */   
/*    */   public static void clearNameRegistry() {
/* 63 */     NAME_REGISTRY = new HashMap<>();
/* 64 */     UUID_REGISTRY = new HashMap<>();
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdslib\LibRegistry.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */