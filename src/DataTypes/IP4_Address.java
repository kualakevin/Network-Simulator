package DataTypes;

public class IP4_Address {
	byte n1, n2, n3, n4;
	public IP4_Address(int n1, int n2, int n3, int n4){
		this.n1 = (byte)n1;
		this.n2 = (byte)n2;
		this.n3 = (byte)n3;
		this.n4 = (byte)n4;
	}
	
	public boolean equals(IP4_Address other_ip_address){
		if(this.n1 == other_ip_address.n1 &&
		   this.n2 == other_ip_address.n2 &&
		   this.n3 == other_ip_address.n3 &&
		   this.n4 == other_ip_address.n4)
		return true;
		return false;
	}
	
	public String toString()
	{
		int n1 = (int)this.n1;
		int n2 = (int)this.n2;
		int n3 = (int)this.n3;
		int n4 = (int)this.n4;
		if(n1<0) n1 = ((n1<<24)>>>24);
		if(n2<0) n2 = ((n2<<24)>>>24);
		if(n3<0) n3 = ((n3<<24)>>>24);
		if(n4<0) n4 = ((n4<<24)>>>24);
		String s = n1 + "." + n2 + "." + n3 + "." + n4;
		return s;
	}
}
