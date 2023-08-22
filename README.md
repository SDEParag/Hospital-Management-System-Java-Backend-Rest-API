# Hospital-Management-System-Java-Backend-Rest-API
  I designed components for a website's application healthcare administration system. These modules covered patient information, appointments, billing, and medical records, resulting in better administrative efficiency and simpler data administration. Implementing CRUD API methods. 

# Tech-Stack –
* Core Java
* Java 8 features
* Hibernate JPA 
* Spring Boot 
* Spring validation
* Pagination
* JWT  token
* Spring Security 
* IntelliJ Idea 
* MySQL Workbench.

# **** Set up HMS  project using Spring Initializer online ****
* I follow below steps:
* Visited the Spring Initializer website at https://start.spring.io.
* Providing the necessary project details:
* Project- Maven and language- Java.
* Spring boot Version 
* Set the project's group name to "com.hms".
* Set the artifact name to "hospital_management_system".
* Choose the appropriate project metadata and description.
* Packaging Jar and Set the Java version 8.
* Adding below dependencies:
* Add "Spring Data JPA" dependency.
* Add "Spring Web" dependency.
* Add "Spring Boot DevTools" dependency.
* Add "MySQL Driver" dependency.
* Add "Lombok" dependency.
* Add "ModelMapper" dependency.
* Add "Spring Security" dependency.

# Click on the "Generate" button to download the project zip file.

* Extract the downloaded zip file to the desired location on the computer folder.
* Opened IntelliJ IDEA IDE.
* Import the project as a Maven project:
* Select "Import Project" from the IDE's welcome screen or "File" -> "New" -> "Project from Existing Sources" if already open.
* Browse to the extracted project folder and select the "pom.xml" file.
* Click "OK" to import the project.
* Select "Import Maven Projects".
* Wait for the IDE to resolve dependencies and build the project.
* Configure the MySQL database connection:
* Open Mysql create database with any name i creating with “hm_system”
* Open the application.properties file located in the src/main/resources directory.
* Modify the spring.datasource.url, spring.datasource.username, and spring.datasource.password properties to match your MySQL database 
  configuration.
* Start the MySQL server using MySQL Workbench and Run the project:
* Find the main class, typically annotated with @SpringBootApplication.
* Right-click on the main class and select "Run" or "Debug" to start the application.

# Endpoints

# Endpoints The following endpoints are available: 

* - [POST /api/patients](#post-apipatients) - Create a new patient
* - [GET /api/appointment/{id}](#get-api appointment id) - Get appointment by ID.
* - [GET /api/appointment](#get-api appointment) - Get a list of appointments.
* - [GET /api/billing/{id}](#get-api billing id) - Get billing by ID.
* - [DELETE /api/appointment/{id}](#delete-api appointment id) - Delete an appointment.
* - [GET /api/medical-history/{id}](#get-api medical-history id) - Get medical history by ID.
* - [GET /api/appointment?pageNo={pageNo}&pageSize={pageSize}](#get-api appointment page no pagesize pagesize) - Get paginated 
     appointments.
* - [PUT /api/billing/{id}](#put-api billing id) - Update billing information.
* - [POST /api/patients](#post-api patients-1) - Create a new patient (alternative).
* - [GET /api/medical-history/{id}](#get-api medical-history id-1) - Get medical history by ID (alternative).
* - [POST /api/auth/signin](#post-api auth signin) - User authentication.

# Create Patient

* I am using Postman with the postman data that goes to the mysql database using JSON format.
*  URL: http://localhost:8080/api/patients
* Method: POST
* Request Body:
* Json structure
{
"name": "Christopher Brown",
"dateOfBirth": "1987-06-05",
"gender": "male",
"medicalHistory": {
"allergies": "cat dander",
"previousIllnesses": "high cholesterol",
"currentMedications": "atorvastatin"
},
"appointments": [
{
"appointmentDate": "2022-06-02T15:30:00",
"reasonForVisit": "cholesterol check"
},
{
"appointmentDate": "2022-07-20T09:15:00",
"reasonForVisit": "cat allergy"
}
],
"billing": {
"insuranceProvider": "VWX Insurance",
"policyNumber": "678901",
"totalAmount": 130.00  }
}

   Status: 200 OK.


* Get Appointment by ID
* Retrieves an appointment by ID.
* URL: http://localhost:8080/api/appointment/{id}
* Method: GET
* URL Parameters:
* ‘id’ : The ID of the appointment
* Response:
For id = 13, URL: http://localhost:8080/api/appointment/13
Json Structure
{
    "id": 13,
    "patient": {
        "id": 7,
        "name": "Christopher Brown",
        "dateOfBirth": "1987-06-05",
        "gender": "male"
    },
    "appointmentDate": "2022-06-02T15:30:00",
    "reasonForVisit": "cholesterol check"  }


* Get Appointments
* Retrieves a list of appointments.
* URL: http://localhost:8080/api/appointment
* Method: GET
* Response:
* All appointment 

* Json Structure
{
    "reasonForVisit": [
        {
            "appointmentDate": "2024-05-01T09:00:00",
            "reasonForVisit": "annual checkup",
            "patientId": 1
        },
        {
            "appointmentDate": "2024-06-15T14:00:00",
            "reasonForVisit": "sore throat",
            "patientId": 1
        },
        {
            "appointmentDate": "2022-05-01T09:00:00",
            "reasonForVisit": "annual checkup",
            "patientId": 2
        },
        {
            "appointmentDate": "2022-06-15T14:00:00",
            "reasonForVisit": "sore throat",
            "patientId": 2
        },
        {
            "appointmentDate": "2022-03-05T13:15:00",
            "reasonForVisit": "blood sugar test",
            "patientId": 3
        },
        {
            "appointmentDate": "2022-04-18T10:30:00",
            "reasonForVisit": "foot pain",
            "patientId": 3
        },
        {
            "appointmentDate": "2022-09-25T16:30:00",
            "reasonForVisit": "headache",
            "patientId": 4
        },
        {
            "appointmentDate": "2022-10-30T09:45:00",
            "reasonForVisit": "check allergy symptoms",
            "patientId": 4
        },
        {
            "appointmentDate": "2022-11-15T10:00:00",
            "reasonForVisit": "thyroid check",
            "patientId": 5
        },
        {
            "appointmentDate": "2022-12-20T14:15:00",
            "reasonForVisit": "fatigue",
            "patientId": 5
        }
    ],
    "pageNo": 0,
    "pageSize": 10,
    "totalElements": 14,
    "totalPages": 2,
    "last": false
}











* Get Billing by ID
* Retrieves billing details by ID.
* URL: http://localhost:8080/api/billing/{id}
* Method: GET
* URL Parameters:
* id: The ID of the billing
* Response:
* GET:  http://localhost:8080/api/billing/7
* Json structure
{
    "id": 7,
    "patient": {
        "id": 7,
        "name": "Christopher Brown",
        "dateOfBirth": "1987-06-05",
        "gender": "male"
    },
    "insuranceProvider": "VWX Insurance",
    "policyNumber": "678901",
    "totalAmount": 130.0
}




* Delete Appointment
* Deletes an appointment.
* URL: http://localhost:8080/api/appointment/{id}
* Method: DELETE
* URL Parameters:
* id: The ID of the appointment

* Get Medical History by ID
* Retrieves the medical history of a patient by ID.
* URL: http://localhost:8080/api/medical-history/{id}
* Method: GET
* URL Parameters:
* id: The ID of the medical history
* For id =7 , GET: http://localhost:8080/api/medical-history/7
* Status: 200 OK 

* Response:
* Json structure
{
    "id": 7,
    "patient": {
        "id": 7,
        "name": "Christopher Brown",
        "dateOfBirth": "1987-06-05",
        "gender": "male"
    },
    "allergies": "cat dander",
    "previousIllnesses": "high cholesterol",
    "currentMedications": "atorvastatin"
}


* Get Billing
* Retrieves the medical history of a patient.
* URL: http://localhost:8080/api/billing/{id}
* Method: GET
* URL Parameters:
* id: The ID of the patient
* Response:  
* For id =7 , GET: http://localhost:8080/api/billing/7
* Status: 200 OK
* Json Structure:
{
    "id": 7,
    "patient": {
        "id": 7,
        "name": "Christopher Brown",
        "dateOfBirth": "1987-06-05",
        "gender": "male"  },
    "insuranceProvider": "VWX Insurance",
    "policyNumber": "678901",
    "totalAmount": 130.0    }
  
* Get Appointments with Pagination
* Retrieves a paginated list of appointments.
* URL: http://localhost:8080/api/appointment?pageNo={pageNo}&pageSize={pageSize}
* Method: GET
* URL Parameters:
* PageNo: This attribute represents the current page number. In this case, it is set to 0, which typically indicates the first page.
* PageSize: It represents the number of elements or items to be displayed per page. In this case, it is set to 10, meaning that each 
   page will contain a maximum of 10 elements.
* TotalElement: It denotes the total number of elements in the collection. Here, it is set to 14, indicating that there are a total of 
    14 elements in the collection.
* Total Page: This attribute signifies the total number of pages required to display all the elements based on the specified page size. 
 in this case, it is set to 2, meaning that it will take two pages to display all 14 elements with a page size of 10.
* Last: This attribute is a boolean (true/false) value indicating whether the current page is the last page in the collection. In this 
   case, it is set to false, implying that there is at least one more page remaining to display all the elements.
* Sortby and SortDir = Ascending order
* Sortby and SortDir = Descending order
  
* GET:http://localhost:8080/api/appointment?pageNo=0&pageSize=10&sortBy&sorDir=Asec
* Response:
* Json Structure:
{
    "reasonForVisit": [
        {
            "appointmentDate": "2024-05-01T09:00:00",
            "reasonForVisit": "annual checkup",
            "patientId": 1
        },
        {
            "appointmentDate": "2024-06-15T14:00:00",
            "reasonForVisit": "sore throat",
            "patientId": 1
        },
        {
            "appointmentDate": "2022-05-01T09:00:00",
            "reasonForVisit": "annual checkup",
            "patientId": 2
        },
        {
            "appointmentDate": "2022-06-15T14:00:00",
            "reasonForVisit": "sore throat",
            "patientId": 2
        },
        {
            "appointmentDate": "2022-03-05T13:15:00",
            "reasonForVisit": "blood sugar test",
            "patientId": 3
        },
        {
            "appointmentDate": "2022-04-18T10:30:00",
            "reasonForVisit": "foot pain",
            "patientId": 3
        },
        {
            "appointmentDate": "2022-09-25T16:30:00",
            "reasonForVisit": "headache",
            "patientId": 4
        },
        {
            "appointmentDate": "2022-10-30T09:45:00",
            "reasonForVisit": "check allergy symptoms",
            "patientId": 4
        },
        {
            "appointmentDate": "2022-11-15T10:00:00",
            "reasonForVisit": "thyroid check",
            "patientId": 5
        },
        {
            "appointmentDate": "2022-12-20T14:15:00",
            "reasonForVisit": "fatigue",
            "patientId": 5
        }
    ],
    "pageNo": 0,
    "pageSize": 10,
    "totalElements": 14,
    "totalPages": 2,
    "last": false
}

* Status : 200 OK


* For Descending
* GET: http://localhost:8080/api/appointment?pageNo=0&pageSize=10&sortBy&sorDir=Dsec
{
    "reasonForVisit": [
        {
            "appointmentDate": "2024-05-01T09:00:00",
            "reasonForVisit": "annual checkup",
            "patientId": 1
        },
        {
            "appointmentDate": "2024-06-15T14:00:00",
            "reasonForVisit": "sore throat",
            "patientId": 1
        },
        {
            "appointmentDate": "2022-05-01T09:00:00",
            "reasonForVisit": "annual checkup",
            "patientId": 2
        },
        {
            "appointmentDate": "2022-06-15T14:00:00",
            "reasonForVisit": "sore throat",
            "patientId": 2
        },
        {
            "appointmentDate": "2022-03-05T13:15:00",
            "reasonForVisit": "blood sugar test",
            "patientId": 3
        },
        {
            "appointmentDate": "2022-04-18T10:30:00",
            "reasonForVisit": "foot pain",
            "patientId": 3
        },
        {
            "appointmentDate": "2022-09-25T16:30:00",
            "reasonForVisit": "headache",
            "patientId": 4
        },
        {
            "appointmentDate": "2022-10-30T09:45:00",
            "reasonForVisit": "check allergy symptoms",
            "patientId": 4
        },
        {
            "appointmentDate": "2022-11-15T10:00:00",
            "reasonForVisit": "thyroid check",
            "patientId": 5
        },
        {
            "appointmentDate": "2022-12-20T14:15:00",
            "reasonForVisit": "fatigue",
            "patientId": 5
        }
    ],
    "pageNo": 0,
    "pageSize": 10,
    "totalElements": 14,
    "totalPages": 2,
    "last": false  }

* Update Billing
* Updates the billing information.
* URL: http://localhost:8080/api/billing/{id}
* Method: PUT
* URL Parameters:
* id: The ID of the billing
* Request Body:
* Json{
}

* Create Patient (Alternative)
* Creates a new patient.
* URL: http://localhost:8080/api/patients
* Method: POST
* Request Body:
* Json {
}

* User Authentication
* Authenticates the user and returns an access token.
* URL: http://localhost:8080/api/auth/signin
* Method: POST
* Request Body:
* Json
   {
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwYXJhZ0BnbWFpbC5jb20iLCJpYXQiOjE2ODkxMDQ0NzUsImV4cCI6MTY4OTcwOTI3NH0.3g7p_IK-EYFcguk-rfDFhDUaD7A9jORjNZnGBO0vQbqQJ7UYQ9SJx57j7kaKiAnm28huFvf3LkoZ97u1gjUZ7w",
  "tokenType": "Bearer"

   }

* Status : 200 OK
