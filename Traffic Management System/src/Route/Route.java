package Route;

import java.io.Serializable;


public class Route implements Serializable {
	
	private String routeid, routename, routeinformation, routelength;
	
	public Route(String routeid, String routename, String routeinformation, String routelength) {
		
		this.routeid = routeid;
		this.routename = routename;
		this.routeinformation = routeinformation;
		this.routelength = routelength;
		
	}

	public String getRouteid() {
		return routeid;
	}

	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}

	public String getRoutename() {
		return routename;
	}

	public void setRoutename(String routename) {
		this.routename = routename;
	}

	public String getRouteinformation() {
		return routeinformation;
	}

	public void setRouteinformation(String routeinformation) {
		this.routeinformation = routeinformation;
	}

	public String getRoutelength() {
		return routelength;
	}

	public void setRoutelength(String routelength) {
		this.routelength = routelength;
	}
	
	
	

}
