/*     */ package p455w0rdslib.util;
/*     */ 
/*     */ import com.google.common.base.CharMatcher;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.io.Resources;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ import p455w0rdslib.LibGlobals;
/*     */ import p455w0rdslib.LibRegistry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerUUIDUtils
/*     */ {
/*     */   public static String getPlayerName(final UUID uuid) throws InterruptedException, ExecutionException {
/*  35 */     return (String) LibGlobals.THREAD_POOL.<String>submit(new Callable()
/*     */         {
/*     */           public Object call() throws Exception {
/*  38 */             return PlayerUUIDUtils.fetchPlayerName(uuid);
/*     */           }
/*  40 */         }).get();
/*     */   }
/*     */   
/*     */   public static UUID getPlayerUUID(final String name) throws InterruptedException, ExecutionException {
/*  44 */     return (UUID) LibGlobals.THREAD_POOL.<UUID>submit(new Callable()
/*     */         {
/*     */           public Object call() throws Exception {
/*  47 */             return PlayerUUIDUtils.fetchPlayerUUID(name);
/*     */           }
/*  49 */         }).get();
/*     */   }
/*     */   
/*     */   public static EntityPlayer getPlayerFromWorld(World world, UUID player) {
/*  53 */     if (player == null || world == null) {
/*  54 */       return null;
/*     */     }
/*  56 */     return world.func_152378_a(player);
/*     */   }
/*     */   
/*     */   private static String fetchPlayerName(UUID uuid) throws IOException {
/*  60 */     if (LibRegistry.getNameRegistry().containsKey(uuid)) {
/*  61 */       return (String)LibRegistry.getNameRegistry().get(uuid);
/*     */     }
/*  63 */     if (!p455w0rdslib.util.ProxiedUtils.isSMP() &&
/*  64 */       p455w0rdslib.util.ProxiedUtils.isClientSide() && p455w0rdslib.util.ProxiedUtils.getWorld() != null && p455w0rdslib.util.ProxiedUtils.getPlayer() != null) {
/*  65 */       String name = p455w0rdslib.util.ProxiedUtils.getPlayer().getCommandSenderName();
/*  66 */       LibRegistry.registerName(uuid, name);
/*  67 */       return name;
/*     */     } 
/*     */     
/*  70 */     String USERNAME_API_URL = "https://api.mojang.com/user/profiles/%s/names";
/*  71 */     CharMatcher DASH_MATCHER = CharMatcher.is('-');
/*  72 */     String uuidString = DASH_MATCHER.removeFrom(uuid.toString());
/*  73 */     try (BufferedReader reader = Resources.asCharSource(new URL(String.format(USERNAME_API_URL, new Object[] { uuidString })), StandardCharsets.UTF_8).openBufferedStream()) {
/*  74 */       JsonReader json = new JsonReader(reader);
/*  75 */       json.beginArray();
/*     */       
/*  77 */       String name = null;
/*  78 */       long when = 0L;
/*     */       
/*  80 */       while (json.hasNext()) {
/*  81 */         String nameObj = null;
/*  82 */         long timeObj = 0L;
/*  83 */         json.beginObject();
/*  84 */         while (json.hasNext()) {
/*  85 */           String key = json.nextName();
/*  86 */           switch (key) {
/*     */             case "name":
/*  88 */               nameObj = json.nextString();
/*     */               continue;
/*     */             case "changedToAt":
/*  91 */               timeObj = json.nextLong();
/*     */               continue;
/*     */           } 
/*  94 */           json.skipValue();
/*     */         } 
/*     */ 
/*     */         
/*  98 */         json.endObject();
/*     */         
/* 100 */         if (nameObj != null && timeObj >= when) {
/* 101 */           name = nameObj;
/*     */         }
/*     */       } 
/*     */       
/* 105 */       json.endArray();
/* 106 */       json.close();
/* 107 */       name = (name == null) ? "" : name;
/* 108 */       LibRegistry.registerName(uuid, name);
/* 109 */       return name;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static UUID fetchPlayerUUID(String name) {
/* 114 */     if (LibRegistry.getUUIDRegistry().containsKey(name)) {
/* 115 */       return (UUID)LibRegistry.getUUIDRegistry().get(name);
/*     */     }
/* 117 */     if (!p455w0rdslib.util.ProxiedUtils.isSMP() &&
/* 118 */       p455w0rdslib.util.ProxiedUtils.isClientSide() && p455w0rdslib.util.ProxiedUtils.getWorld() != null && p455w0rdslib.util.ProxiedUtils.getPlayer() != null) {
/* 119 */       UUID uuid = p455w0rdslib.util.ProxiedUtils.getPlayer().getUniqueID();
/* 120 */       LibRegistry.registerUUID(name, uuid);
/* 121 */       return uuid;
/*     */     } 
/*     */     
/* 124 */     if (!Strings.isNullOrEmpty(name)) {
/*     */       try {
/* 126 */         URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
/* 127 */         HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/* 128 */         connection.setRequestMethod("GET");
/* 129 */         connection.setRequestProperty("Content-Type", "application/json");
/* 130 */         connection.setUseCaches(false);
/* 131 */         connection.setDoInput(true);
/* 132 */         connection.setDoOutput(true);
/* 133 */         JsonObject profile = (JsonObject)(new JsonParser()).parse(new InputStreamReader(connection.getInputStream()));
/* 134 */         UUID uuid = UUID.fromString(fullUUID(profile.get("id").toString()));
/* 135 */         LibRegistry.registerUUID(name, uuid);
/* 136 */         return uuid;
/*     */       }
/* 138 */       catch (Exception exception) {}
/*     */     }
/*     */     
/* 141 */     return null;
/*     */   }
/*     */   
/*     */   private static String fullUUID(String uuid) {
/* 145 */     uuid = cleanUUID(uuid);
/* 146 */     uuid = uuid.substring(0, 8) + "-" + uuid.substring(8, 12) + "-" + uuid.substring(12, 16) + "-" + uuid.substring(16, 20) + "-" + uuid.substring(20, 32);
/* 147 */     return uuid;
/*     */   }
/*     */   
/*     */   private static String cleanUUID(String uuid) {
/* 151 */     return uuid.replaceAll("[^a-zA-Z0-9]", "");
/*     */   }
/*     */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdsli\\util\PlayerUUIDUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */