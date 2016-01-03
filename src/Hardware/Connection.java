package Hardware;
import Data.Frame;

public class Connection {
	Router r2;
	Router r1;
	int p1;
	int p2;
	int status;
	public Connection (Router r1, int p1, Router r2, int p2){
		this.r1=r1;
		this.p1=p1;
		this.r2=r2;
		this.p2=p2;
		this.status = 0;
	}
	
	public void connect(){
		r1.addPort(this,p1);
		r2.addPort(this, p2);
	}
	
	public void sendFrame(Router r, Frame f){
		if(r.equals(r1))
		{
			r2.receiveFrame(f, p2);
		}
		if(r.equals(r2))
		{
			r1.receiveFrame(f, p1);
		}
	}
	
	public void disable_connection(){
		this.status = 0;
	}
	
	public void enable_connection(){
		this.status = 1;
	}
	
	public void remove_connection(){
		r1.removePort(p1);
		r2.removePort(p2);
		this.r1=null;
		this.r2=null;
		this.status = 0;
	}
	
	public int getStatus(){
		return this.status;
	}
	public String toString(){
		String s = "Router with mac: " + r1.mac_address + " and port " + p1 + " is connected to" + 
				   "Router with mac: " + r2.mac_address + " and port " + p2;
		return s;
	}
}
