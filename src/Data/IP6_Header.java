package Data;

import DataTypes.IP4_Address;
import DataTypes.IP6_Address;
import DataTypes.IP_Address;

public class IP6_Header extends IP_Header{
	byte version;
	byte traffic_class;
	int flow_lable;
	short payload_length;
	byte next_header;
	byte hop_limit;
	IP6_Address source_ip;
	IP6_Address dest_ip;
	
	public IP6_Header(int version, int traffic_class, int flow_lable,
			int payload_length, int next_header, int hop_limit,
			IP6_Address source_ip, IP6_Address dest_ip)
	{
			this.version = (byte)version;
			this.traffic_class = (byte)traffic_class;
			this.flow_lable = flow_lable;
			this.payload_length = (short)payload_length;
			this.next_header = (byte)next_header;
			this.hop_limit = (byte) hop_limit;
			this.source_ip = source_ip;
			this.dest_ip = dest_ip;
	}
	
	public IP6_Address getSourceIP(){
		return this.source_ip;
	}
	
	public IP6_Address getDestIP(){
		return this.dest_ip;
	}
	
	public String toString()
	{
		String s = 
				"version: 0x" + Integer.toHexString(version) + "\n" +
				"traffic_class: 0x" + Integer.toHexString(traffic_class) + "\n" +
				"flow_lable: 0x" + Integer.toHexString(flow_lable) + "\n" +
				"payload_length: 0x" + Integer.toHexString(payload_length) + "\n" +
				"next_header: 0x" + Integer.toHexString(next_header) + "\n" +
				"hop_limit: 0x" + Integer.toHexString(hop_limit) + "\n" +
				"source_ip: " + source_ip.toString() +"\n" +
				"dest_ip: " + dest_ip.toString() +"\n";
		return s;
	}
}
