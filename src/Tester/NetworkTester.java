package Tester;
import DataTypes.IP4_Address;
import DataTypes.MAC_Address;
import Hardware.Connection;
import Hardware.Router;


public class NetworkTester {
	public static void main(String[] args)
	{
		MAC_Address r0_mac = new MAC_Address(00,00,00,00,00,00);
		MAC_Address r1_mac = new MAC_Address(00,00,00,00,00,01);
		MAC_Address r2_mac = new MAC_Address(00,00,00,00,00,02);
		MAC_Address r3_mac = new MAC_Address(00,00,00,00,00,03);
		MAC_Address r4_mac = new MAC_Address(00,00,00,00,00,04);
		MAC_Address r5_mac = new MAC_Address(00,00,00,00,00,05);
		
		IP4_Address ip_1 = new IP4_Address(129,168,0,1);
		IP4_Address ip_2 = new IP4_Address(123,123,123,123);
		
		Router r1 = new Router(r1_mac, 100);
		Router r2 = new Router(r2_mac, 100);
		Router r3 = new Router(r3_mac, 100);
		Router r4 = new Router(r4_mac, 100);
		Router r5 = new Router(r5_mac, 100);
		
		Connection c_r1_r4 = new Connection(r1,0,r4,2);
		Connection c_r1_r2 = new Connection(r1,1,r2,2);
		Connection c_r2_r3 = new Connection(r2,0,r3,0);
		Connection c_r2_r4 = new Connection(r2,1,r4,1);
		Connection c_r3_r4 = new Connection(r3,1,r4,0);
		Connection c_r3_r5 = new Connection(r3,2,r5,0);
		c_r1_r4.connect();
		c_r1_r2.connect();
		c_r2_r3.connect();
		c_r3_r4.connect();
		c_r2_r4.connect();
		c_r3_r5.connect();
		
		r1.spanning_tree_protocol();
		r1.spanning_tree_protocol_path();
		r2.spanning_tree_protocol_path();
		r3.spanning_tree_protocol_path();
		r4.spanning_tree_protocol_path();
		r5.spanning_tree_protocol_path();
		
		System.out.println("***** after 2nd STP *******");
		System.out.println(r1.getLowestMacAddress() + " " +r1.getLowestPort());
		System.out.println(r2.getLowestMacAddress() + " " +r2.getLowestPort());
		System.out.println(r3.getLowestMacAddress() + " " +r3.getLowestPort());
		System.out.println(r4.getLowestMacAddress() + " " +r4.getLowestPort());
		System.out.println(r5.getLowestMacAddress() + " " +r5.getLowestPort());
		
		if(c_r1_r4.getStatus() == 1) System.out.println(c_r1_r4);
		if(c_r1_r2.getStatus() == 1) System.out.println(c_r1_r2);
		if(c_r2_r3.getStatus() == 1) System.out.println(c_r2_r3);
		if(c_r3_r4.getStatus() == 1) System.out.println(c_r3_r4);
		if(c_r2_r4.getStatus() == 1) System.out.println(c_r2_r4);
		if(c_r3_r5.getStatus() == 1) System.out.println(c_r3_r5);
	}
}
