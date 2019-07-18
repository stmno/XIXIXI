package ECIS;

public class Emp {
	private int ID;
	private String name;
	private boolean dstate=false;
	private boolean tstate=false;
	Emp(int ID,String name){
		this.ID=ID;
		this.name=name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDstate() {
		return dstate;
	}
	public void setDstate(boolean dstate) {
		this.dstate = dstate;
	}
	public boolean isTstate() {
		return tstate;
	}
	public void setTstate(boolean tstate) {
		this.tstate = tstate;
	}
	public String toString() {
		return "ID£º"+ID+"   ÐÕÃû£º"+name;
	}
}
