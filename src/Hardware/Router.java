package Hardware;

import Data.Frame;
import java.util.*;

import Data.IP6_Header;
import Data.Packet;
import Data.STP_Data;
import DataTypes.IP4_Address;
import DataTypes.IP6_Address;
import DataTypes.IP_Address;
import DataTypes.MAC_Address;


public class Router {
	MAC_Address mac_address;
	int priority;
	Connection[] ports;
	RoutingTable routing_table;
	MAC_Address lowest_mac_address;
	int lowest_hop;
	int lowest_priority;
	int lowest_port;
	
	final MAC_Address broadcast_mac_address = new MAC_Address(0,0,0,0,0,0);
	final IP6_Address broadcast_ip6_address = new IP6_Address(0,0,0,0,0,0,0,0);
	
	public Router(MAC_Address mac_address, int priority){
		this.mac_address = mac_address;
		this.priority = priority;
		this.ports = new Connection[8];
		this.routing_table = new RoutingTable();
		this.lowest_mac_address = mac_address;
		this.lowest_hop = 0;
		this.lowest_priority = priority;
		this.lowest_port = -1;
	}
	
	public void addPort(Connection c, int port){
		this.ports[port] = c;
	}
	
	public void removePort(int port){
		this.ports[port] = null;
	}
	
	public void sendFrame(Frame f, int port_id){
		ports[port_id].sendFrame(this,f);
	}
	
	public void receiveFrame(Frame f, int port_id){
		MAC_Address broadcast_mac_address = new MAC_Address(0,0,0,0,0,0);
		if(f.getAH().getTHA().equals(broadcast_mac_address)){
			if(f.getData() instanceof STP_Data)
			{
				spanning_tree_protocol_receive(f, port_id);
			}else if(f.getData() instanceof Packet)
			{
				if(f.getAH().getPTYPE() == 6)
				{
					//update routing table's SPA
					updateRT(f.getAH().getSHA(), ((IP6_Header)((Packet)f.getData()).getIH()).getSourceIP(), port_id);
					if(routing_table.has_ip(((IP6_Header)((Packet)f.getData()).getIH()).getDestIP()))
					{
						//make new frame
						//send it out
					}else
					{
						//broadcast new frame
					}
				}
			}
		}else
		{
			//extract arp_header & ip_header
			//look TPA in routing_table
			//update routing table's SPA
			//if found, build ip_header and arp_header and forward it out that port.
			//else broadcast out all ports except port_id.
			
		}
		
	}
	
	public void spanning_tree_protocol_receive(Frame f, int port_id){
		if(lowest_priority > ((STP_Data)f.getData()).getPriority())
		{
			lowest_mac_address = new MAC_Address(((STP_Data)f.getData()).getLMA());
			lowest_hop = ((STP_Data)f.getData()).getHC()+1;
			lowest_priority = ((STP_Data)f.getData()).getPriority();
			lowest_port = port_id;
			spanning_tree_protocol_root(port_id);
		}
		if(lowest_priority == ((STP_Data)f.getData()).getPriority())
		{
			if(lowest_mac_address.compare(((STP_Data)f.getData()).getLMA()) == 1)
			{
				lowest_mac_address = new MAC_Address(((STP_Data)f.getData()).getLMA());
				lowest_hop = ((STP_Data)f.getData()).getHC()+1;
				lowest_priority = ((STP_Data)f.getData()).getPriority();
				lowest_port = port_id;
				spanning_tree_protocol_root(port_id);
			}
			if(lowest_mac_address.compare(((STP_Data)f.getData()).getLMA()) == 0)
			{
				if(this.lowest_hop > ((STP_Data)f.getData()).getHC()+1 )
				{
					lowest_hop = ((STP_Data)f.getData()).getHC()+1;
					lowest_port = port_id;
				}
			}
		}
		if(lowest_priority < ((STP_Data)f.getData()).getPriority())
		{
			spanning_tree_protocol_root(8);
		}
	}
	
	public void spanning_tree_protocol(){
		spanning_tree_protocol_root(8);
	}
	
	public void spanning_tree_protocol_root(int incoming_port_id){
		//broadcast lowest MAC_Adress known.
		for(int port_id =0; port_id<this.ports.length; ++port_id)
		{
			if(this.ports[port_id] != null && incoming_port_id != port_id)
			{
				STP_Data data = new STP_Data(this.lowest_priority, this.lowest_mac_address, this.lowest_hop);
				MAC_Address SHA = new MAC_Address(this.mac_address);
				MAC_Address THA = new MAC_Address(0,0,0,0,0,0);
				IP_Address SPA = new IP6_Address(0,0,0,0,0,0,0,0);
				IP_Address TPA = new IP6_Address(0,0,0,0,0,0,0,0);
				
				Frame f = new Frame(data, 1, 0x800, 6, 6, 1, SHA, SPA, THA, TPA);
				sendFrame(f, port_id);
			}
		}
	}
	
	public void spanning_tree_protocol_path(){
		for(int i =0; i<ports.length; ++i)
		{
			if(i==lowest_port && lowest_mac_address.compare(mac_address)!= 0)
			{
				ports[i].enable_connection();
			}
		}
	}
	
	public MAC_Address getLowestMacAddress(){
		return this.lowest_mac_address;
	}
	
	public int getLowestHop()
	{
		return this.lowest_hop;
	}
	
	public int getLowestPort()
	{
		return this.lowest_port;
	}
	
	public RoutingTable getRT()
	{
		return this.routing_table;
	}
	
	public boolean equals(Router other){
		return this.mac_address.equals(other.mac_address);
	}
	
	public void updateRT(MAC_Address mac, IP_Address ip, int port_id){
		if(routing_table.has_mac(mac)){
			//update routing table;
			routing_table.update(mac, ip, port_id);
		}else
		{
			//insert into routing table;
			routing_table.insert(mac, ip, port_id);
		}
	}
	
}
