package cofh.api.energy;

import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergyReceiver extends IEnergyConnection {
  int receiveEnergy(ForgeDirection paramForgeDirection, int paramInt, boolean paramBoolean);
  
  int getEnergyStored(ForgeDirection paramForgeDirection);
  
  int getMaxEnergyStored(ForgeDirection paramForgeDirection);
}


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\cofh\api\energy\IEnergyReceiver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */