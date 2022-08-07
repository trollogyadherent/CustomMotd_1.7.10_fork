package cofh.api.energy;

public interface IEnergyStorage {
  int receiveEnergy(int paramInt, boolean paramBoolean);
  
  int extractEnergy(int paramInt, boolean paramBoolean);
  
  int getEnergyStored();
  
  int getMaxEnergyStored();
}


/* Location:              C:\Users\jf\Downloads\p455w0rdslib-1.7.10-1.0.2.jar!\cofh\api\energy\IEnergyStorage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */