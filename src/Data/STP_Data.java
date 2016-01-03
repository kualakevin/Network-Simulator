package Data;

import DataTypes.MAC_Address;

public class STP_Data {
	int priority;
	MAC_Address lowest_mac_address;
	int hop_count;
	
	public STP_Data(int priority, MAC_Address lowest_mac_address, int hop_count)
	{
		this.priority = priority;
		this.lowest_mac_address = lowest_mac_address;
		this.hop_count = hop_count;
	}
	
	public MAC_Address getLMA()
	{
		return this.lowest_mac_address;
	}
	
	public int getPriority ()
	{
		return this.priority;
	}
	
	public int getHC()
	{
		return this.hop_count;
	}
}
