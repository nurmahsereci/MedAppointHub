package database;

// Class representing a doctor entity
public class Doctor {
	
	// Attributes of the doctor
	private int doctorId; // ID of the doctor
	private String doctorName; // Name of the doctor
	private int specialtyID; // ID of the doctor's specialty
	
	// Getter method for retrieving the doctor ID
	public int getDoctorId() {
		return doctorId;
	}
	
	// Setter method for setting the doctor ID
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	// Getter method for retrieving the doctor name
	public String getDoctorName() {
		return doctorName;
	}
	
	// Setter method for setting the doctor name
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	// Getter method for retrieving the specialty ID of the doctor
	public int getSpecialtyID() {
		return specialtyID;
	}
	
	// Setter method for setting the specialty ID of the doctor
	public void setSpecialtyID(int specialtyID) {
		this.specialtyID = specialtyID;
	}
}
