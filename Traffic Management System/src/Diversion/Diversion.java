package Diversion;

import java.io.Serializable;

public class Diversion implements Serializable  {
	
	private String diversionid, diversiondate, diversionname, diversiondescription, diversionroute;
	
	public Diversion(String diversionid, String diversiondate, String diversionname, String diversionroute,String diversiondescription) {
		
		this.diversionid = diversionid;
		this.diversiondate = diversiondate;
		this.diversionname = diversionname;
		this.diversionroute = diversionroute;
		this.diversiondescription = diversiondescription;

		
	}

	public String getDiversionid() {
		return diversionid;
	}

	public void setDiversionid(String diversionid) {
		this.diversionid = diversionid;
	}

	public String getDiversiondate() {
		return diversiondate;
	}

	public void setDiversiondate(String diversiondate) {
		this.diversiondate = diversiondate;
	}

	public String getDiversionname() {
		return diversionname;
	}

	public void setDiversionname(String diversionname) {
		this.diversionname = diversionname;
	}

	public String getDiversiondescription() {
		return diversiondescription;
	}

	public void setDiversiondescription(String diversiondescription) {
		this.diversiondescription = diversiondescription;
	}

	public String getDiversionroute() {
		return diversionroute;
	}

	public void setDiversionroute(String diversionroute) {
		this.diversionroute = diversionroute;
	}


}
