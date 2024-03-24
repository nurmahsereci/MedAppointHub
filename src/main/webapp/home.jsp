<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="static/css/styles.css" />

<title>MedAppointHub</title>
</head>
<body>
	<div class="header">
		<h1>Medical Appointment Hub</h1>
		<p>
			<span class="small">S</span>
			<span class="medium">M</span>
			<span class="large">L</span>
		</p>
		<p>
			<button class="dark">Dark</button>
			<button class="light">Light</button>
		</p>		
	</div>
	<div style="width: 50%; margin: 0 auto;">
		<h2>Please fill out the form below to make an appointment.</h2> 
		<p>Doctors are available every hour between 08:00 and 17:00.
			They can accept appointments Monday through Friday.
		</p> 
	</div>
	
	<div class="forms">
		<form class="appointment_form" action="DoctorNamesBySpecialty"
			method="POST">
			<label>Specialty:</label> 
				<select name="specialty" id="specialty" onchange="this.form.submit()">
				<c:choose>
					<c:when test="${not empty requestScope.specialty}">
						<option value="${requestScope.specialty}" selected>
							<c:out value="${requestScope.specialty}" />
						</option>
					</c:when>
					<c:otherwise>
						<option value="" selected>Select specialty</option>
					</c:otherwise>
				</c:choose>

				<c:forEach items="${requestScope.specs}" var="spec">
					<c:if test="${not spec.getSpecialtyName().equals(requestScope.specialty)}">
						<option value="${spec.getSpecialtyID()}">
							<c:out value="${spec.getSpecialtyName()}" />
						</option>
					</c:if>
				</c:forEach>
			</select>
		</form>

		<form class="appointment_form">
			<label>Doctor Name:</label> 
				<select id="docName">
				<c:forEach items="${ requestScope.doctors }" var="doctor">
					<option value="${ doctor.getDoctorId() }">
						<c:out value=" ${ doctor.getDoctorName() }" />
					</option>
				</c:forEach>
				</select> 
				
			<label>Date and Time:</label> 
				<input type="datetime-local" name="date" id="datetime" /> 
			<label>Full Name:</label> 
				<input type="text" name="patientName" id="patientName" /> 
			<label>E-mail:</label> 
				<input type="text" name="patientEmail" id="patientEmail" /> 
			<label>Mobile Phone Number:</label>
				<input type="text" name="patientPhone" id="patientPhone" /> 	
			<input type="button" name="submit" id="makeAppointmentBtn" 
				value="MAKE AN APPOINTMENT" />
		</form>
	</div>

	<script src="static/js/app.js"></script>
</body>
</html>