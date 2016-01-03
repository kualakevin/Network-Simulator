package DataTypes;

public class IP6_Address extends IP_Address{
	short n1, n2, n3, n4, n5, n6, n7, n8;
	public IP6_Address(int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8){
		this.n1 = (short)n1;
		this.n2 = (short)n2;
		this.n3 = (short)n3;
		this.n4 = (short)n4;
		this.n5 = (short)n5;
		this.n6 = (short)n6;
		this.n7 = (short)n7;
		this.n8 = (short)n8;
	}
	
	public boolean equals(IP6_Address other_ip_address){
		if(this.n1 == other_ip_address.n1 &&
		   this.n2 == other_ip_address.n2 &&
		   this.n3 == other_ip_address.n3 &&
		   this.n4 == other_ip_address.n4 &&
		   this.n5 == other_ip_address.n5 &&
		   this.n6 == other_ip_address.n6 &&
		   this.n7 == other_ip_address.n7 &&
		   this.n8 == other_ip_address.n8)
		return true;
		return false;
	}
	
	public String toString()
	{
		int n1 = (int)this.n1;
		int n2 = (int)this.n2;
		int n3 = (int)this.n3;
		int n4 = (int)this.n4;
		int n5 = (int)this.n5;
		int n6 = (int)this.n6;
		int n7 = (int)this.n7;
		int n8 = (int)this.n8;
		String s = Integer.toHexString(n1) + "." + Integer.toHexString(n2) + "." + 
				   Integer.toHexString(n3) + "." + Integer.toHexString(n4) + "." + 
				   Integer.toHexString(n5) + "." + Integer.toHexString(n6) + "." + 
				   Integer.toHexString(n7) + "." + Integer.toHexString(n8);
		return s;
	}
}
