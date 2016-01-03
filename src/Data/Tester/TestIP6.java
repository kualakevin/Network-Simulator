package Data.Tester;

import Data.IP6_Header;
import DataTypes.IP6_Address;

public class TestIP6 {
	
	public static void main(String[] args)
	{
		IP6_Address source_ip = new IP6_Address(0xff,0x00,0x00,0xdd,0xbb,0xee,0xee,0xff);
		IP6_Address dest_ip = new IP6_Address(0xbb,0xee,0xee,0xff,0xff,0x00,0x00,0xdd);
		IP6_Header ip_header = new IP6_Header(6,0,0,40,6,3, source_ip, source_ip);
		System.out.println(ip_header.toString());
	}
}
