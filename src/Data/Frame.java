package Data;
import Data.ARP_Header;
import DataTypes.IP4_Address;
import DataTypes.IP_Address;
import DataTypes.MAC_Address;


public class Frame {
	Object data;
	ARP_Header arp_header;
	
	public Frame(Object data, int HTYPE, int PTYPE, int HLEN,
			int PLEN, int OPER, MAC_Address SHA, IP_Address SPA, 
			MAC_Address THA, IP_Address TPA)
	{
		this.data = data;
		this.arp_header = new ARP_Header((short)HTYPE, (short)PTYPE, (byte)HLEN, 
				(byte)PLEN, (byte)OPER, SHA, SPA, THA, TPA);
	}
	
	public ARP_Header getAH()
	{
		return this.arp_header;
	}
	
	public Object getData()
	{
		return this.data;
	}
	
	
	public String toString(){
		return arp_header.toString()/*packet.toString()*/;
	}
}
