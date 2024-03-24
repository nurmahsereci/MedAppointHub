package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import database.Appointment;
import database.DbConnection;

// Service class for handling patient-related operations
public class PatientService {
	
	// Static variables for database connection and prepared statement
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	// Method to check doctor availability for a given date and time
	// Takes doctor ID and appointment date and time as parameters
	public static boolean checkDoctorAvailability(int doctorId, String dateAndTime) {
		// Translate the date and time string to LocalDateTime object
		LocalDateTime appointmentDateTime = LocalDateTime.parse(dateAndTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		boolean result = false; // Initialize result variable

		try {
			connection = DbConnection.getDbConnection(); // Get database connection
			
			// SQL query to check if the doctor is available at the given date and time
			String query = "SELECT COUNT(*) FROM DoctorAvailability WHERE DoctorID = ? AND AvailableDateTime = ?";
			preparedStatement = connection.prepareStatement(query); // Create prepared statement
			preparedStatement.setInt(1, doctorId); // Set doctor ID parameter
			preparedStatement.setString(2, appointmentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); // Set date and time parameter
			resultSet = preparedStatement.executeQuery(); // Execute query
			result = resultSet.next() && resultSet.getInt(1) > 0; // Check if result set contains data
			
		} catch (Exception e) {
			e.printStackTrace(); // Print stack trace if an exception occurs
		}
		return result; // Return availability status
	}

	// Method to check if an appointment is already booked for a given doctor and date/time
	public static boolean checkAlreadyReserved(int doctorId, String dateAndTime) {
		// Convert date and time string to LocalDateTime object
		LocalDateTime appointmentDateTime = LocalDateTime.parse(dateAndTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		boolean result = false; // Initialize result variable

		try {
			connection = DbConnection.getDbConnection(); // Get database connection
			
			// SQL query to check if an appointment is already booked for the given doctor and date/time
			String query = "SELECT COUNT(*) FROM Appointments WHERE DoctorID = ? AND AppointmentDateTime = ?";
			preparedStatement = connection.prepareStatement(query); // Create prepared statement
			preparedStatement.setInt(1, doctorId); // Set doctor ID parameter
			preparedStatement.setString(2, appointmentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); // Set date and time parameter
			resultSet = preparedStatement.executeQuery(); // Execute query
			result = resultSet.next() && resultSet.getInt(1) > 0; // Check if result set contains data
			
		} catch (Exception e) {
			e.printStackTrace(); // Print stack trace if an exception occurs
		}
		return result; // Return reservation status
	}

	// Method to make a new appointment
	// Takes an Appointment object as parameter
	public static String makeAnAppointment(Appointment appointment) {
		String result = null; // Initialize result variable
		
		// Check doctor availability and appointment reservation status
		boolean isAvailable = PatientService.checkDoctorAvailability(appointment.getDoctorId(), appointment.getDateAndTime());
		boolean isReserved = PatientService.checkAlreadyReserved(appointment.getDoctorId(), appointment.getDateAndTime());

		// If the doctor is available and the appointment slot is not already reserved, proceed to make the appointment
		if (isAvailable && !isReserved) {
			try {
				connection = DbConnection.getDbConnection(); // Get database connection
				
				// SQL query to insert patient details into the Appointments table
				String query = "INSERT INTO Appointments (PatientName, PatientEmail, PatientPhone, AppointmentDateTime, DoctorID) VALUES(?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query); // Create prepared statement
				preparedStatement.setString(1, appointment.getPatientName()); // Set patient name parameter
				preparedStatement.setString(2, appointment.getPatientEmail()); // Set patient email parameter
				preparedStatement.setString(3, appointment.getPatientPhone()); // Set patient phone parameter
				preparedStatement.setString(4, appointment.getDateAndTime()); // Set appointment date/time parameter
				preparedStatement.setInt(5, appointment.getDoctorId()); // Set doctor ID parameter
				preparedStatement.executeUpdate(); // Execute update query to insert appointment details
				
				result = "OK"; // Appointment made successfully
				
			} catch (Exception e) {
				e.printStackTrace(); // Print stack trace if an exception occurs
			}
		} else if (!isAvailable) {
			result = "Unavailable"; // Doctor is not available at the given date/time
		} else if (isReserved) {
			result = "Reserved"; // Appointment slot is already reserved by another patient
		}

		return result; // Return result of appointment booking attempt
	}
}
