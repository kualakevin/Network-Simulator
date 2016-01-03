package Data;

import DataTypes.IP6_Address;

public class Packet {
	IP_Header IP_Header;
	Object data;
	public Packet(Object data, int version, int traffic_class, int flow_lable, int payload_length,
			int next_header, int hop_limit, IP6_Address source_ip, IP6_Address dest_ip)
	{
		this.IP_Header = new IP6_Header(version, traffic_class, flow_lable, 
				payload_length, next_header, hop_limit,source_ip, dest_ip);
		this.data = data;
	}
	
	public IP_Header getIH(){
		return this.IP_Header;
	}
	
	public Object getData(){
		return this.data;
	}
}
