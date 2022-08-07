package cofh.api.energy;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IEnergyContainerItem {
  int receiveEnergy(ItemStack paramItemStack, int paramInt, boolean paramBoolean);
  
  int extractEnergy(ItemStack paramItemStack, int paramInt, boolean paramBoolean);
  
  int getEnergyStored(ItemStack paramItemStack);
  
  int getMaxEnergyStored(ItemStack paramItemStack);
  
  void addInformation(ItemStack paramItemStack, EntityPlayer paramEntityPlayer, List<String> paramList, boolean paramBoolean);
}


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\cofh\api\energy\IEnergyContainerItem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */