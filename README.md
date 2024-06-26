# Medical Appointment Hub

![Demo GIF](https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExcTVtYTFqenYyNnA1cXl1cHRuZzJmN3F2ZjV5cHdsb2FwcW5uOXo2aSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/I5LdhdtPd8IhLDdHNQ/giphy.gif) 

## Description

It is a web application designed to facilitate appointment scheduling between patients and doctors. It allows patients to search for doctors based on specialty, view doctor availability, and send appointment requests online.

**This project is a first-year undergraduate student project in the computer science department.**

## Technology Stack

| Prerequisites                                          |
|--------------------------------------------------------|
| Eclipse IDE for Enterprise Java and Web Developers     |
| Java Development Kit 17 or newer                       | 
| MySQL Workbench                                        |
| MySQL Shell                                            |
| MySQL Server                                           |
| Apache Tomcat v10.1 or newer                           | 


| Project Properties      |    
|-------------------------|
| Dynamic Web Module 6.0  |
| Servlet 5.0             | 
| Jakarta EE 9            |
| JSTL 2.0                | 
| Apache Tomcat 10.1      |
| JavaScript 1.0          | 


| Libraries                               |    
|-----------------------------------------|
| jakarta.servlet.jsp.jstl-2.0.0.jar      |
| jakarta.servlet.jsp.jstl-api-2.0.0.jar  | 
| mysql-connector-java-8.2.0.jar          |


## Installations of the Project:
- Make sure MySQL Workbench, MySQL Server and MySQL Shell are installed on your computer!

**1. Clone the Database Repository:**
- Clone the database repository locally. Run this command (Terminal on Mac or Git Bash on Windows:If you don’t already have Git Bash, you’ll have to download it to complete this process.):
```
git clone https://github.com/nurmahsereci/DB-MedAppointHub.git
```

**2. Create a Local Server:**
- Open MySQL Workbench
- Set up a new connection: In MySQL Workbench, click on the "+" icon next to "MySQL Connections" to set up a new connection. Enter the necessary connection details as connection name, hostname ("localhost"), port ("3306"), username ("root"), and the password you set during MySQL installation.

**3. Import Database Schema:**
- Import the provided SQL script named as 'project_database' into your MySQL Workbench by following path: Server > Data Import > Import From Self-Contained File (Browse the project_database.sql file where you downloaded) > Start Import.

<details> 
<summary> Notes:</summary>
    
* There is relatively little data in the database, so a large amount of data can be imported.
* DoctorAvailability table includes the dates until end of the May 2024, so in order for the website to work after May, the DoctorAvailability table in the database must be updated.
</details>

**4. Clone the Project Repository:**
- First, ensure that Git is installed on your computer. You can download Git from here (https://git-scm.com/downloads).
- Open a terminal or command line tool such as Git Bash.
- Clone the project repository by entering the following command:
```
git clone https://github.com/nurmahsereci/MedAppointmentHub.git
```

**5. Import Project into IDE:**
- Open Eclipse IDE.
- From the menu bar in Eclipse, select File > Import.
- In the window that appears, select Existing Projects into Workspace under General.
- Click Next.
- Check the Select root directory option and click Browse to choose the folder of the project.
- Select the project folder and click Open.
- Once the project is selected, click Finish.

## Running the Project:
1. After successfully importing the project, Configure the Project's Database Connection:
- Update the 26th line in the 'DbConnection.java' class in the database package with your MySQL server credentials (If you have defined the username of your new local server as 'root' in MySQL Workbench, just update your password in this line of code):
```
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project" , "root","password");
```

2. Define a New Server:
- Download Apache Tomcat v10.1 as a zip file and extract the downloaded folder. (You can download it using this link: https://tomcat.apache.org/download-10.cgi)
- Define a new server in Eclipse IDE as follows:
File > New > Other > Server > Apache > Tomcat v10.1 Server
- Browse the installation directory and then download & install the server.
- Click 'Next' and configure the project on the server by adding it from the 'Available' section to the 'Configured' section.
- Complete this step by clicking 'Finish'.

3. Set up Tomcat Server:
- In Eclipse, double click on the project and go to the Properties, and then go to the "Java Build Path", select "Libraries".
- Double click on "Server Runtime[Apache Tomcat v10.1] unbound" and select your server as runtime environment.
- Click finish.
- Click 'Apply and Close'

4. Deploy the Application:
- Go to the "Servers" view.
- Right-click on the project in Eclipse IDE.
- Select "Run As" > "Run on Server".
- Choose your configured Tomcat server and click "Finish".

## Usage:
**1. Access the Homepage:**
- Open your web browser and navigate to:
      http://localhost:8080/MedAppointHub/

**2. Interact with the Application:**
- Search for doctors: Select a specialty from the dropdown menu to view doctor's name lists based on that specialty.
- Choose a doctor: Choose a doctor from the doctor name list based on the selected specialty.
- Provide necessary details: Choose a date&time and write name, email, phone.
- Make an Appointment: Click 'Make appointment' button to send an appointment request online.

<details> 
<summary> Notes:</summary>
   
* The working days are weekdays (Monday, Tuesday, Wednesday, Thursday and Friday), and the working hours are due every hour on the hour from 8 a.m. to 5 p.m.
* Doctors' schedules may vary.
* Doctors are only available for March, April, and May of 2024.
* Font size and theme can be changed according to personal preferences.
</details>

## Features I Hope to Implement in the Future:
- Registration and Login Functionalities
- Email notifications

## Contact Information 
- Author: Nur Mahsereci
- Email: nurmahsereci@gmail.com
- **These instructions should guide you through setting up and running this application smoothly. If you encounter any issues during the setup process or while running the application, feel free to ask for further assistance!**
#
