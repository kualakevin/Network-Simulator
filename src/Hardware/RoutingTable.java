package Hardware;
import DataTypes.IP4_Address;
import DataTypes.IP_Address;
import DataTypes.MAC_Address;


public class RoutingTable {
	MAC_Address[] mac_address_table;
	IP_Address[] ip_address_table;
	int[] port;
	
	public RoutingTable(){
		mac_address_table = new MAC_Address[20];
		ip_address_table = new IP_Address[20];
		port = new int[20];
	}
	
	public boolean has_mac(MAC_Address mac)
	{
		for(int i=0; i<mac_address_table.length; ++i)
		{
			if(mac_address_table[i] != null && mac_address_table[i].equals(mac))
			{
				return true;
			}
		}
		return false;
	}
	
	public IP_Address mac_to_ip(MAC_Address mac)
	{
		for(int i=0; i<mac_address_table.length; ++i)
		{
			if(mac_address_table[i] != null &&  mac_address_table[i].equals(mac))
			{
				return ip_address_table[i];
			}
		}
		return null;
	}
	
	public boolean has_ip(IP_Address ip)
	{
		for(int i=0; i<ip_address_table.length; ++i)
		{
			if(ip_address_table[i] != null && ip_address_table[i].equals(ip))
			{
				return true;
			}
		}
		return false;
	}
	
	public MAC_Address ip_to_mac(IP_Address ip)
	{
		for(int i=0; i<ip_address_table.length; ++i)
		{
			if(ip_address_table[i] != null && ip_address_table[i].equals(ip))
			{
				return mac_address_table[i];
			}
		}
		return null;
	}
	
	public boolean insert(MAC_Address mac, IP_Address ip, int port_id){
		for(int i=0; i<mac_address_table.length; ++i)
		{
			if(mac_address_table[i] == null)
			{
				mac_address_table[i] = mac;
				ip_address_table[i] = ip;
				port[i] = port_id;
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(MAC_Address mac)
	{
		for(int i=0; i<mac_address_table.length; ++i)
		{
			if(mac_address_table[i] != null && mac_address_table[i].equals(mac))
			{
				mac_address_table[i] = null;
				ip_address_table[i] = null;
				port[i] = 0;
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(IP_Address ip)
	{
		for(int i=0; i<ip_address_table.length; ++i)
		{
			if(ip_address_table[i] != null && ip_address_table[i].equals(ip))
			{
				mac_address_table[i] = null;
				ip_address_table[i] = null;
				port[i] = 0;
				return true;
			}
		}
		return false;
	}
	
	public void update(MAC_Address mac, IP_Address ip, int port_id)
	{
		for(int i=0; i< mac_address_table.length; ++i)
		{
			if(mac_address_table[i] != null && mac_address_table[i].equals(mac))
			{
				mac_address_table[i] = mac;
				ip_address_table[i] = ip;
				port[i] = port_id;
				return;
			}
		}
	}
	
	public String toString()
	{
		String s = "";
		for(int i=0; i< mac_address_table.length; ++i)
		{
			if(mac_address_table[i] != null)
			{
				s = s + mac_address_table[i].toString() + "  " + ip_address_table[i].toString() +
						"  " + port[i] +"\n";
			}
		}
		return s;
	}
}
