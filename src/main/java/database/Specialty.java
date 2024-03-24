package database;

// Class representing a medical specialty
public class Specialty {
	
	// Attributes of the specialty
	private int specialtyID; // ID of the specialty
	private String specialtyName; // Name of the specialty
	
	// Getter method for retrieving the specialty ID
	public int getSpecialtyID() {
		return specialtyID;
	}
	
	// Setter method for setting the specialty ID
	public void setSpecialtyID(int specialtyID) {
		this.specialtyID = specialtyID;
	}
	
	// Getter method for retrieving the specialty name
	public String getSpecialtyName() {
		return specialtyName;
	}
	
	// Setter method for setting the specialty name
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
}
