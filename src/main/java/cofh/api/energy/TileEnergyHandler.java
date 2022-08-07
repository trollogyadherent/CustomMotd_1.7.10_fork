/*    */ package cofh.api.energy;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileEnergyHandler
/*    */   extends TileEntity
/*    */   implements IEnergyHandler
/*    */ {
/* 15 */   protected EnergyStorage storage = new EnergyStorage(32000);
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 20 */     super.readFromNBT(nbt);
/* 21 */     this.storage.readFromNBT(nbt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 27 */     super.writeToNBT(nbt);
/* 28 */     this.storage.writeToNBT(nbt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canConnectEnergy(ForgeDirection from) {
/* 35 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
/* 42 */     return this.storage.receiveEnergy(maxReceive, simulate);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
/* 49 */     return this.storage.extractEnergy(maxExtract, simulate);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getEnergyStored(ForgeDirection from) {
/* 56 */     return this.storage.getEnergyStored();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxEnergyStored(ForgeDirection from) {
/* 62 */     return this.storage.getMaxEnergyStored();
/*    */   }
/*    */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\cofh\api\energy\TileEnergyHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */