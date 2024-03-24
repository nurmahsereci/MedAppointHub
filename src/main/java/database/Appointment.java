package database;

// Class representing an appointment
public class Appointment {
	
	// Attributes of the appointment
	private String patientName; // Name of the patient
	private String patientEmail; // Email of the patient
	private String patientPhone; // Phone number of the patient
	private String dateAndTime; // Date and time of the appointment
	private int doctorId; // ID of the doctor

	// Getter method for retrieving patient name
	public String getPatientName() {
		return patientName;
	}

	// Setter method for setting patient name
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	// Getter method for retrieving date and time of the appointment
	public String getDateAndTime() {
		return dateAndTime;
	}

	// Setter method for setting date and time of the appointment
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	// Getter method for retrieving doctor ID
	public int getDoctorId() {
		return doctorId;
	}

	// Setter method for setting doctor ID
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	// Getter method for retrieving patient email
	public String getPatientEmail() {
		return patientEmail;
	}

	// Setter method for setting patient email
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	// Getter method for retrieving patient phone number
	public String getPatientPhone() {
		return patientPhone;
	}

	// Setter method for setting patient phone number
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
}
