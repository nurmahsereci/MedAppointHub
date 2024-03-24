package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.DoctorService;

import java.io.IOException;
import java.util.ArrayList;

import database.Specialty;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // This method is invoked when the servlet receives a GET request.
    // It is responsible for loading all specialties to the home.jsp file and displaying them in the web browser.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve all specialties using the DoctorService class
		ArrayList<Specialty> specs = DoctorService.getAllSpecialties();
		
		// Set specialties as a request attribute to make them accessible in the JSP file
		request.setAttribute("specs", specs);
		
		// Forward the request to the home.jsp file for rendering
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// This method is invoked when the servlet receives a POST request.
	// Since it has no specific implementation for POST requests, it delegates to the doGet method.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
