package Data;
import DataTypes.IP4_Address;
import DataTypes.IP_Address;
import DataTypes.MAC_Address;


public class ARP_Header extends Header {
	short HTYPE;
	short PTYPE;
	byte HLEN;
	byte PLEN;
	short OPER;
	MAC_Address SHA;
	IP_Address SPA;
	MAC_Address THA; 
	IP_Address TPA;
	
	public ARP_Header(int HTYPE, int PTYPE, int HLEN,
			int PLEN, int OPER, MAC_Address SHA, IP_Address SPA, 
			MAC_Address THA, IP_Address TPA)
	{
		this.HTYPE = (short)HTYPE;
		this.PTYPE = (short)PTYPE;
		this.HLEN = (byte)HLEN;
		this.PLEN = (byte)PLEN;
		this.OPER = (short)OPER;
		this.SHA = SHA;
		this.SPA = SPA;
		this.THA = THA;
		this.TPA = TPA;
	}
	
	public short getHTYPE()
	{
		return this.HTYPE;
	}
	
	public short getPTYPE()
	{
		return this.PTYPE;
	}
	
	public byte getHLEN()
	{
		return this.HLEN;
	}
	
	public byte getPLEN()
	{
		return this.PLEN;
	}
	
	public short getOPER()
	{
		return this.OPER;
	}
	
	public MAC_Address getSHA()
	{
		return this.SHA;
	}
	
	public IP_Address getSPA()
	{
		return this.SPA;
	}
	
	public MAC_Address getTHA()
	{
		return this.THA;
	}
	
	public IP_Address getTPA()
	{
		return this.TPA;
	}
	
	
	
	public String toString()
	{
		String s = 
			"HTYPE: 0x" + Integer.toHexString(HTYPE) + "\n" +
			"PTYPE: 0x" + Integer.toHexString(PTYPE) + "\n" +
			"HLEN: 0x" + Integer.toHexString(HLEN) + "\n" +
			"PLEN: 0x" + Integer.toHexString(PLEN) + "\n" +
			"OPER: 0x" + Integer.toHexString(OPER) + "\n" +
			"SHA: " + SHA.toString() +"\n" +
			"SPA: " + SPA.toString() +"\n" +
			"THA: " + THA.toString() +"\n" +
			"TPA: " + TPA.toString() +"\n";
		return s;
	}
}
