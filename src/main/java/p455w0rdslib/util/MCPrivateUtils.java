/*    */ package p455w0rdslib.util;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.ReflectionHelper;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.resources.IResourcePack;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MCPrivateUtils
/*    */ {
/*    */   public static void addResourcePack(IResourcePack pack) {
/* 38 */     List<Object> packList = (List<Object>)ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), new String[] { "defaultResourcePacks" });
/* 39 */     packList.add(pack);
/* 40 */     ReflectionHelper.setPrivateValue(Minecraft.class, Minecraft.getMinecraft(), packList, new String[] { "defaultResourcePacks" });
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdsli\\util\MCPrivateUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */