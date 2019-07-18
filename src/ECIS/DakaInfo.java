package ECIS;


public class DakaInfo {
	private int ID;
	private String dtime=null;
	private String ttime=null;
	
	DakaInfo(int ID){
		this.ID=ID;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	
	public String toString() {
		if(dtime == null) {
			return "Ç©ÍË£º "+ID+"  "+ttime;
		}else {
			return "Ç©µ½£º "+ID+"  "+dtime;
		}
	}
}
