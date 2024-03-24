package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.DbConnection;
import database.Doctor;
import database.Specialty;

// Service class for handling doctor-related operations
public class DoctorService {

	// Static variables for database connection and prepared statement
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	// Method to retrieve all doctors by their specialty
	// Takes specialty ID as parameter
	public static ArrayList<Doctor> getAllDoctorsBySpecialty(int id){
		
		ArrayList<Doctor> doctors = new ArrayList<Doctor>(); // ArrayList to store doctors
		
		try {
			connection = DbConnection.getDbConnection(); // Get database connection
			String query = "SELECT * FROM Doctors WHERE SpecialtyID=?"; // SQL query
			preparedStatement = connection.prepareStatement(query); // Create prepared statement
			preparedStatement.setInt(1, id); // Set specialty ID parameter
			resultSet = preparedStatement.executeQuery(); // Execute query
			
			// Iterate through result set and populate doctor objects
			while(resultSet.next()) {
				Doctor doc = new Doctor();
				doc.setDoctorId(resultSet.getInt("DoctorID"));
				doc.setDoctorName(resultSet.getString("DoctorName"));
				doctors.add(doc); // Add doctor to list
			}
			
		}catch(Exception e) {
			e.printStackTrace(); // Print stack trace if an exception occurs
		}
		
		return doctors; // Return list of doctors
	}
	
	// Method to retrieve all specialties from the database
	public static ArrayList<Specialty> getAllSpecialties(){
		
		ArrayList<Specialty> specialties = new ArrayList<Specialty>(); // ArrayList to store specialties
		
		try {
			connection = DbConnection.getDbConnection(); // Get database connection
			
			// SQL query to retrieve all specialties
			String query = "SELECT * FROM Specialties";
			preparedStatement = connection.prepareStatement(query); // Create prepared statement
			resultSet = preparedStatement.executeQuery(); // Execute query
			
			// Iterate through result set and populate specialty objects
			while(resultSet.next()) {
				Specialty specialty = new Specialty();
				specialty.setSpecialtyID(resultSet.getInt("SpecialtyID"));
				specialty.setSpecialtyName(resultSet.getString("SpecialtyName"));
				specialties.add(specialty); // Add specialty to list
			}
			
		}catch(Exception e) {
			e.printStackTrace(); // Print stack trace if an exception occurs
		}
		
		return specialties; // Return list of specialties
	}
	
	// Method to retrieve specialty name by its ID
	public static String getSpecialtyById(int id) {
		String specialty = null; // Initialize specialty name variable
		
		try {
			connection = DbConnection.getDbConnection(); // Get database connection
			
			// SQL query to retrieve specialty by ID
			String query = "SELECT * FROM Specialties WHERE SpecialtyID=?";
			preparedStatement = connection.prepareStatement(query); // Create prepared statement
			preparedStatement.setInt(1, id); // Set specialty ID parameter
			resultSet = preparedStatement.executeQuery(); // Execute query
			
			// Extract specialty name from result set
			while(resultSet.next()) {
				specialty = resultSet.getString("SpecialtyName");
			}
			
		}catch(Exception e) {
			e.printStackTrace(); // Print stack trace if an exception occurs
		}
		
		return specialty; // Return specialty name
	}
}
