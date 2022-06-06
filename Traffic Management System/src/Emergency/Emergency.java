package Emergency;

import java.io.Serializable;

public class Emergency implements Serializable {
	
	private String emergencydate,emergencyname, emergencyphone, travellingfrom, travellingto, vehiclenumber, emergencytype;
	
	public Emergency(String emergencydate, String emergencyname, String emergencyphone, String travellingfrom, String travellingto, String vehiclenumber, String emergencytype) {
		
		this.emergencydate = emergencydate;
		this.emergencyname = emergencyname;
		this.emergencyphone = emergencyphone;
		this.travellingfrom = travellingfrom;
		this.travellingto = travellingto;
		this.vehiclenumber = vehiclenumber;
		this.emergencytype = emergencytype;

		
	}
	
	public String getEmergencydate() {
		return emergencydate;
	}

	public void setEmergencydate(String emergencydate) {
		this.emergencydate = emergencydate;
	}

	public String getEmergencyname() {
		return emergencyname;
	}

	public void setEmergencyname(String emergencyname) {
		this.emergencyname = emergencyname;
	}


	public String getEmergencyphone() {
		return emergencyphone;
	}

	public void setEmergencyphone(String emergencyphone) {
		this.emergencyphone = emergencyphone;
	}

	public String getTravellingfrom() {
		return travellingfrom;
	}

	public void setTravellingfrom(String travellingfrom) {
		this.travellingfrom = travellingfrom;
	}

	public String getTravellingto() {
		return travellingto;
	}

	public void setTravellingto(String travellingto) {
		this.travellingto = travellingto;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getEmergencytype() {
		return emergencytype;
	}

	public void setEmergencytype(String emergenncytype) {
		this.emergencytype = emergencytype;
	}
	
}
