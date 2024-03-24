// Execute when the DOM content is fully loaded
window.addEventListener("DOMContentLoaded", function() {

	// Select required html elements from home.jsp
	const submitBtn = document.getElementById("makeAppointmentBtn");
	const smallFontBtn = document.querySelector(".small");
	const mediumFontBtn = document.querySelector(".medium");
	const largeFontBtn = document.querySelector(".large");
	const labels = document.querySelectorAll("label");
	const inputBoxes = document.querySelectorAll("input");
	const darkBtn = document.querySelector(".dark");
	const lightBtn = document.querySelector(".light");
	const formsContainer = document.querySelector(".forms");


	// Check if local storage has any size variable or not
    // If there is a size variable, change the font sizes according to that size
	if (localStorage.getItem("size") != null) {
	
		// get the size to style variable
		let style = localStorage.getItem("size");

		// iterate all the labels and assign the specific font size to each label
		labels.forEach(function(label) {
			label.style.fontSize = style;
		})
		
		// do it for input boxes
		inputBoxes.forEach(function(inputBox) {
			inputBox.style.fontSize = style;
		})

		// change the font size of submit button
		submitBtn.style.fontSize = style;
	}
	
	// Check if local storage has any labels variable or not
    // If there is a labels variable, change the font colors according to that color
	// This is the same as above 
	if (localStorage.getItem("labels") != null) {
		
		let labelStyle = localStorage.getItem("labels");

		labels.forEach(function(label) {
			label.style.color = labelStyle;
		})

	}

	// Check if local storage has any forms variable or not
    // If there is a forms variable, change the background color of forms container
	if (localStorage.getItem("forms") != null) {
		let formsStyle = localStorage.getItem("forms");
		formsContainer.style.backgroundColor = formsStyle;
	}

	
	// Event listener for clicking the small font button
	smallFontBtn.addEventListener("click", function() {
		labels.forEach(function(label) {
			label.style.fontSize = "15px";
		})
		inputBoxes.forEach(function(inputBox) {
			inputBox.style.fontSize = "15px";
		})

		submitBtn.style.fontSize = "15px";
		
		// Finally store the size as 15px in localstorage
		// This can keep changed styles unchanged even after refreshing
		// Thats why the program checks the localstorage in the initally
		localStorage.setItem("size", "15px");

	})

	// Event listener for clicking the medium font button
	mediumFontBtn.addEventListener("click", function() {
		labels.forEach(function(label) {
			label.style.fontSize = "20px";
		})
		inputBoxes.forEach(function(inputBox) {
			inputBox.style.fontSize = "20px";
		})
		submitBtn.style.fontSize = "20px";

		localStorage.setItem("size", "20px");

	})

	// Event listener for clicking the large font button
	largeFontBtn.addEventListener("click", function() {
		labels.forEach(function(label) {
			label.style.fontSize = "25px";
		})
		inputBoxes.forEach(function(inputBox) {
			inputBox.style.fontSize = "25px";
		})
		submitBtn.style.fontSize = "25px";

		localStorage.setItem("size", "25px");

	})
	
	
	// Event listener for clicking the dark theme button
	darkBtn.addEventListener("click", function() {
		
		// Turn label colors to white
		labels.forEach(function(label) {
			label.style.color = "#fff";
		})
		
		// Form container to dark gray
		formsContainer.style.backgroundColor = "#333";
		
		// Store styles in the localstorage
		localStorage.setItem("labels", "#fff");
		localStorage.setItem("forms", "#333");
	})
	
	
	// Event listener for clicking the light theme button
	lightBtn.addEventListener("click", function() {
		labels.forEach(function(label) {
			label.style.color = "black";
		})
		formsContainer.style.backgroundColor = "#f2f2f2";
		localStorage.setItem("labels", "black");
		localStorage.setItem("forms", "#f2f2f2");
	})
	
	// Event listener for clicking the submit appointment button
	submitBtn.addEventListener("click", function() {
		
		// Get all necessary elements and their values
		const specialtyElement = document.getElementById("specialty");
		const docNameElement = document.getElementById("docName");
		const dateTimeElement = document.getElementById("datetime");
		const patientNameElement = document.getElementById("patientName");
		const patientEmailElement = document.getElementById("patientEmail");
		const patientPhoneElement = document.getElementById("patientPhone");
	
		// Get the values of that elements
		const speciality = specialtyElement.value;
		const doctor = docNameElement.value;
		const patientName = patientNameElement.value;
		const patientEmail = patientEmailElement.value;
		const patientPhone = patientPhoneElement.value;
		const dateAndTime = dateTimeElement.value;

		// Basic validations
		if (speciality === "Select specialty") {
			alert("Please choose a specialty that meets your medical need! ");
			return;
		} else if (doctor === "") {
			alert("Please choose a doctor from the list! ");
			return;
		} else if (patientName === "") {
			alert("Please write your first name and lastname! ");
			return;
		} else if (patientEmail === "") {
			alert("Please write your e-mail address! ");
			return;
		} else if (patientPhone === "") {
			alert("Please write your mobile phone number");
			return;
		} else if (dateAndTime === "") {
			alert("Please choose a date and time! ");
			return;
		}

		// Process date and time for doctor availability
		var selectedDate = new Date(dateAndTime);
		var selectedHours = selectedDate.getHours();
		var dayOfWeek = selectedDate.getDay();
	
		// Check if selected time is between 8 AM and 5 PM 
		if (selectedHours >= 8 && selectedHours < 17) {
			console.log("Selected time is between 8 AM and 5 PM.");
		} else {
			alert("Working hours are 8 AM to 5 PM. Please choose a time between 8:00-17:00! ")
			return;
		}
	
		// Check if selected date is a weekday (Monday to Friday)
		if (dayOfWeek >= 1 && dayOfWeek <= 5) {
			console.log("Selected date is a weekday (Monday to Friday).");
		} else {
			alert("The doctor does not work on weekends. Please choose a day between Monday and Friday! ")
			return;
		}
		
		// Create new form data object and append values to it
		const data = new FormData();
		data.append("patientName", patientName);
		data.append("patientEmail", patientEmail);
		data.append("patientPhone", patientPhone);
		data.append("doctor", doctor);
		data.append("dateAndTime", dateAndTime);
		
		// Send a POST request to the MakeAnAppointment Servlet
		fetch('http://localhost:8080/MedAppointHub/MakeAnAppointment', {
			method: 'POST',
			body: new URLSearchParams(data),
			headers: {
				"Content-Type": "application/x-www-form-urlencoded",
			},
			responseType: 'json'
		}).then(res => res.json())
			.then(data => alert(data.message))
			.catch(err => console.log(err))

	})

})
