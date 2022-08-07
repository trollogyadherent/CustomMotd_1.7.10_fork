/*    */ package p455w0rdslib.util;
/*    */ 
/*    */ import net.minecraft.entity.item.EntityItem;
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
/*    */ public class EntityItemUtils
/*    */ {
/*    */   public static boolean canPickup(EntityItem item) {
/* 30 */     return (item.delayBeforeCanPickup <= 0);
/*    */   }
/*    */   
/*    */   public static String getThrowerName(EntityItem item) {
/* 34 */     return item.func_145800_j();
/*    */   }
/*    */   
/*    */   public static String getOwnerName(EntityItem item) {
/* 38 */     return item.func_145798_i();
/*    */   }
/*    */   
/*    */   public static void setThrowerName(EntityItem item, String thrower) {
/* 42 */     item.func_145799_b(thrower);
/*    */   }
/*    */   
/*    */   public static void setOwnerName(EntityItem item, String owner) {
/* 46 */     item.func_145797_a(owner);
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\p455w0rdsli\\util\EntityItemUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */