/*     */ package p455w0rd.cmotd.handler;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.server.MinecraftServer;
import org.lwjgl.Sys;

public class FileHandler
 {
   private static File MOTD_DIR;
   private static File MOTD_PLAYERLIST_FILE;
   private static File MOTD_LIST_FILE;
   private static String[] DEFAULT_PLAYERLIST_STRING = new String[] {"&6&k{radio}&r&f&l My Awesome Server &r&6&k{radio}&r", "&a==========================&r", "&7- &4&oSome", "&7- &6&oSample", "&7- &9&otext && more text", "&a==========================&r", "&l&oPlayers Online: {playercount}/{maxplayers}", "Difficulty: {difficulty}", "&2Minecraft Version: &d{mcversion}"};



   private static String[] DEFAULT_MOTDLIST_STRING = new String[] {"&6{radio} &9&lMy Custom Server &r&6{radio}|&l&cFACTIONS RESET!", "&l&7-=*=- &r&7[&e1.10.2&7]&aMy Custom Server &r&l&7-=*=-|&2Christmas &4Special! &9shop.myserver.com", "&a&l//- &b&lMy Custom Server &r&a&l-\\\\\\\\|&a{radio}&l&eSF3 &7- &l&ePO2 &7- &l&eFTB Retro&a{radio}"};


   public static void init() {
     MOTD_DIR = new File(MinecraftServer.field_152367_a.getParent(), "CustomMOTD");
     if (!MOTD_DIR.exists()) {
       MOTD_DIR.mkdirs();
     }
     MOTD_PLAYERLIST_FILE = new File(MOTD_DIR.getPath(), "customplayerlist.txt");
     MOTD_LIST_FILE = new File(MOTD_DIR.getPath(), "custommotdlist.txt");
     checkPlayerListFile();
     checkMOTDListFile();
   }

   private static void checkMOTDDir() {
     if (!MOTD_DIR.exists()) {
       MOTD_DIR.mkdirs();
     }
   }

   private static void checkPlayerListFile() {
     checkMOTDDir();
     if (!MOTD_PLAYERLIST_FILE.exists()) {
           //System.out.println("File doesn't exist bruh");
       try {
         MOTD_PLAYERLIST_FILE.createNewFile();
         writeDefaultPlayerListFile();
       }
       catch (IOException iOException) {}
     } else {
       //System.out.println("File exists bruh");
       }

     if (MOTD_PLAYERLIST_FILE.length() == 0L) {
       writeDefaultPlayerListFile();
     } else {
        //System.out.println("not writing default file");
     }
   }

   private static void checkMOTDListFile() {
     checkMOTDDir();
     if (!MOTD_LIST_FILE.exists()) {
       try {
         MOTD_LIST_FILE.createNewFile();
         writeDefaultMOTDListFile();
       }
       catch (IOException iOException) {}
     }

     if (MOTD_LIST_FILE.length() == 0L) {
       writeDefaultMOTDListFile();
     }
   }


   private static void writeDefaultPlayerListFile() {
     try {
       BufferedWriter output = new BufferedWriter(new FileWriter(MOTD_PLAYERLIST_FILE, true));
       for (String line : DEFAULT_PLAYERLIST_STRING) {
         output.write(line);
         output.newLine();
           //System.out.println("writing line to players");
       }
       output.close();
     }
     catch (IOException iOException) {}
   }



   private static void writeDefaultMOTDListFile() {
   //System.out.println("writing default motd file (" + DEFAULT_MOTDLIST_STRING + ")");
     try {
       BufferedWriter output = new BufferedWriter(new FileWriter(MOTD_LIST_FILE, true));
       for (String line : DEFAULT_MOTDLIST_STRING) {
         output.write(line);
         output.newLine();
       }
       output.close();
     }
     catch (IOException iOException) {
           //System.out.println("Couldn't write file bruh");
       }
   }


   public static List<String> readPlayerListFile() {
     checkPlayerListFile();
     List<String> stringList = new ArrayList<>();
     try {
       BufferedReader reader = new BufferedReader(new FileReader(MOTD_PLAYERLIST_FILE));
       String currentLine;
       while ((currentLine = reader.readLine()) != null) {
         String trimmedLine = currentLine.trim();
         stringList.add(trimmedLine);
       }
       reader.close();
     }
     catch (IOException iOException) {}

     if (stringList.size() == 0) {
       writeDefaultPlayerListFile();
       stringList = Arrays.asList(DEFAULT_PLAYERLIST_STRING);
     }
     return stringList;
   }

   public static List<String> readMOTDListFile() {
     checkMOTDListFile();
     List<String> stringList = new ArrayList<>();
     try {
       BufferedReader reader = new BufferedReader(new FileReader(MOTD_LIST_FILE));
       String currentLine;
       while ((currentLine = reader.readLine()) != null) {
         String trimmedLine = currentLine.trim();
         stringList.add(trimmedLine);
       }
       reader.close();
     }
     catch (IOException iOException) {}

     if (stringList.size() == 0) {
       writeDefaultPlayerListFile();
       stringList = Arrays.asList(DEFAULT_MOTDLIST_STRING);
     }
     return stringList;
   }
 }


/* Location:              C:\Users\jf\Document\\ultramine\mods\CustomMOTD-1.7.10-1.0.2.jar!\p455w0rd\cmotd\handler\FileHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */