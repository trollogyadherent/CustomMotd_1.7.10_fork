/*     */ package cofh.api.energy;
/*     */ 
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemEnergyContainer
/*     */   extends Item
/*     */   implements IEnergyContainerItem
/*     */ {
/*     */   protected int capacity;
/*     */   protected int maxReceive;
/*     */   protected int maxExtract;
/*     */   
/*     */   public ItemEnergyContainer() {}
/*     */   
/*     */   public ItemEnergyContainer(int capacity) {
/*  25 */     this(capacity, capacity, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemEnergyContainer(int capacity, int maxTransfer) {
/*  30 */     this(capacity, maxTransfer, maxTransfer);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemEnergyContainer(int capacity, int maxReceive, int maxExtract) {
/*  35 */     this.capacity = capacity;
/*  36 */     this.maxReceive = maxReceive;
/*  37 */     this.maxExtract = maxExtract;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemEnergyContainer setCapacity(int capacity) {
/*  42 */     this.capacity = capacity;
/*  43 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxTransfer(int maxTransfer) {
/*  48 */     setMaxReceive(maxTransfer);
/*  49 */     setMaxExtract(maxTransfer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxReceive(int maxReceive) {
/*  54 */     this.maxReceive = maxReceive;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxExtract(int maxExtract) {
/*  59 */     this.maxExtract = maxExtract;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
/*  66 */     if (container.stackTagCompound == null) {
/*  67 */       container.stackTagCompound = new NBTTagCompound();
/*     */     }
/*  69 */     int energy = container.stackTagCompound.getInteger("Energy");
/*  70 */     int energyReceived = Math.min(this.capacity - energy, Math.min(this.maxReceive, maxReceive));
/*     */     
/*  72 */     if (!simulate) {
/*  73 */       energy += energyReceived;
/*  74 */       container.stackTagCompound.setInteger("Energy", energy);
/*     */     } 
/*  76 */     return energyReceived;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
/*  82 */     if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
/*  83 */       return 0;
/*     */     }
/*  85 */     int energy = container.stackTagCompound.getInteger("Energy");
/*  86 */     int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
/*     */     
/*  88 */     if (!simulate) {
/*  89 */       energy -= energyExtracted;
/*  90 */       container.stackTagCompound.setInteger("Energy", energy);
/*     */     } 
/*  92 */     return energyExtracted;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEnergyStored(ItemStack container) {
/*  98 */     if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
/*  99 */       return 0;
/*     */     }
/* 101 */     return container.stackTagCompound.getInteger("Energy");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxEnergyStored(ItemStack container) {
/* 107 */     return this.capacity;
/*     */   }
/*     */ }


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\cofh\api\energy\ItemEnergyContainer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */