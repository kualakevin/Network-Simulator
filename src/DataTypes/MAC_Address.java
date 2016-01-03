package DataTypes;

public class MAC_Address {
	byte n1, n2, n3, n4, n5, n6;
	public MAC_Address(int n1, int n2, int n3, int n4, int n5, int n6){
		this.n1 = (byte)n1;
		this.n2 = (byte)n2;
		this.n3 = (byte)n3;
		this.n4 = (byte)n4;
		this.n5 = (byte)n5;
		this.n6 = (byte)n6;
	}
	
	public MAC_Address(MAC_Address other){
		this.n1 = other.n1;
		this.n2 = other.n2;
		this.n3 = other.n3;
		this.n4 = other.n4;
		this.n5 = other.n5;
		this.n6 = other.n6;
	}
	
	public boolean equals(MAC_Address other_mac_address){
		if(this.n1 == other_mac_address.n1 &&
		   this.n2 == other_mac_address.n2 &&
		   this.n3 == other_mac_address.n3 &&
		   this.n4 == other_mac_address.n4 &&
		   this.n5 == other_mac_address.n5 &&
		   this.n6 == other_mac_address.n6)
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
		
		n1 = ((n1<<24)>>>24);
		n2 = ((n2<<24)>>>24);
		n3 = ((n3<<24)>>>24);
		n4 = ((n4<<24)>>>24);
		n5 = ((n5<<24)>>>24);
		n6 = ((n6<<24)>>>24);
		
		String s = n1 + ";" + n2 + ";" + n3 + ";" + n4 + ";" + n5 + ";" + n6;
		return s;
	}
	
	public byte[] toByte(){
		byte[] temp = new byte[6];
		temp[0] = n1;
		temp[1] = n2;
		temp[2] = n3;
		temp[3] = n4;
		temp[4] = n5;
		temp[5] = n6;
		return temp;
	}
	
	public int compare(MAC_Address other)
	{
		if(this.n1 > other.n1) return 1;
		if(this.n1 < other.n1) return -1;
		if(this.n2 > other.n2) return 1;
		if(this.n2 < other.n2) return -1;
		if(this.n3 > other.n3) return 1;
		if(this.n3 < other.n3) return -1;
		if(this.n4 > other.n4) return 1;
		if(this.n4 < other.n4) return -1;
		if(this.n5 > other.n5) return 1;
		if(this.n5 < other.n5) return -1;
		if(this.n6 > other.n6) return 1;
		if(this.n6 < other.n6) return -1;
		return 0;	
	}
}
