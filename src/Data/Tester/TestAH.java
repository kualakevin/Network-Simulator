package Data.Tester;

import Data.ARP_Header;
import DataTypes.IP4_Address;
import DataTypes.IP6_Address;
import DataTypes.IP_Address;
import DataTypes.MAC_Address;

public class TestAH {
	public static void main(String[] args)
	{
		MAC_Address SHA_1 = new MAC_Address(0,0,0,0,0,1);
		MAC_Address THA_1 = new MAC_Address(0,0,0,0,0,2);
		IP_Address SPA_1 = new IP6_Address(192,255,0,0,0,0,0,0);
		IP_Address TPA_1 = new IP6_Address(255,168,0,1,0,0,0,0);
		ARP_Header AH_1 = new ARP_Header(1,0x800,6,4,1,SHA_1, SPA_1, THA_1, TPA_1);
		System.out.println(AH_1.toString());
	}
}
