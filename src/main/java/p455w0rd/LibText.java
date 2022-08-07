/*    */ package p455w0rdslib;
/*    */ 
/*    */ import net.minecraft.util.EnumChatFormatting;
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
/*    */ public class LibText
/*    */ {
/* 29 */   public static final String RADIO_BARS = EnumChatFormatting.OBFUSCATED + "|||||||" + EnumChatFormatting.RESET;
/*    */   public static final String LINE_SEP = "==========================";
/* 31 */   public static final String BLACK = EnumChatFormatting.BLACK.toString();
/* 32 */   public static final String D_BLUE = EnumChatFormatting.DARK_BLUE.toString();
/* 33 */   public static final String D_GREEN = EnumChatFormatting.DARK_GREEN.toString();
/* 34 */   public static final String D_AQUA = EnumChatFormatting.DARK_AQUA.toString();
/* 35 */   public static final String D_RED = EnumChatFormatting.DARK_RED.toString();
/* 36 */   public static final String D_PURPLE = EnumChatFormatting.DARK_PURPLE.toString();
/* 37 */   public static final String GOLD = EnumChatFormatting.GOLD.toString();
/* 38 */   public static final String GRAY = EnumChatFormatting.GRAY.toString();
/* 39 */   public static final String D_GRAY = EnumChatFormatting.DARK_GRAY.toString();
/* 40 */   public static final String BLUE = EnumChatFormatting.BLUE.toString();
/* 41 */   public static final String GREEN = EnumChatFormatting.GREEN.toString();
/* 42 */   public static final String AQUA = EnumChatFormatting.AQUA.toString();
/* 43 */   public static final String RED = EnumChatFormatting.RED.toString();
/* 44 */   public static final String L_PURPLE = EnumChatFormatting.LIGHT_PURPLE.toString();
/* 45 */   public static final String YELLOW = EnumChatFormatting.YELLOW.toString();
/* 46 */   public static final String WHITE = EnumChatFormatting.WHITE.toString();
/* 47 */   public static final String RESET = EnumChatFormatting.RESET.toString();
/* 48 */   public static final String OBF = EnumChatFormatting.OBFUSCATED.toString();
/* 49 */   public static final String BOLD = EnumChatFormatting.BOLD.toString();
/* 50 */   public static final String UNDER = EnumChatFormatting.UNDERLINE.toString();
/* 51 */   public static final String STRIKE = EnumChatFormatting.STRIKETHROUGH.toString();
/* 52 */   public static final String ITALIC = EnumChatFormatting.ITALIC.toString();
/*    */   
/*    */   public static String wrapRadioBars(String text) {
/* 55 */     return GOLD + RADIO_BARS + WHITE + BOLD + text + RESET + GOLD + RADIO_BARS;
/*    */   }
/*    */   
/*    */   public static String lineSep(String color) {
/* 59 */     return color + "==========================" + RESET;
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdslib\LibText.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */