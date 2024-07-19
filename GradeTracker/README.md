Grade Tracker

Overview
The Grade Tracker application is a command-line tool for managing student grades. It allows users to add students, view student details, add grades, and track grade trends. This application demonstrates object-oriented programming principles and exception handling in Java.

Directory Structure
GradeTracker/
│
├── src/
│   └── com/
│       └── example/
│           ├── CustomExceptions.java
│           ├── Grade.java
│           ├── Gradeable.java
│           ├── GradeTracker.java
│           ├── HelperFunctions.java
│           ├── Main.java
│           ├── Student.java
│           └── UIUtil.java
│
├── build/
│   └── GradeTracker.jar
│
└── README.md


Classes and Interfaces
Main.java: The main entry point for the application. Handles the main menu and user input.
CustomExceptions.java: Defines custom exceptions for the application.
InvalidInputException: Thrown when an invalid input is provided.
StudentNotFoundException: Thrown when a student is not found.
InvalidGradeException: Thrown when an invalid grade is provided.
Grade.java: Represents a grade with a subject, score, and date.
Gradeable.java: An interface defining methods for adding grades and calculating statistics.
GradeTracker.java: Manages the collection of students and their grades.
HelperFunctions.java: Contains helper functions for adding students, viewing students, and managing grades.
Student.java: Represents a student with a first name, last name, and a list of grades.
UIUtil.java: Utility class for printing headers, footers, menus, and messages to the console.


Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher
Running the Application
Clone the repository:
git clone https://github.com/yourusername/GradeTracker.git
Navigate to the build directory:
cd GradeTracker/build
Run the JAR file:
java -jar GradeTracker.jar


Usage
Main Menu
Enter a New Student: Add a new student by entering their first name and last name.
View Students: View a list of all students and select a student to view or modify their details.
Exit: Exit the application.


Student Menu
Add Grades: Add grades for the selected student by specifying the subject, score, and date. The score must be between 0 and 100.
Print Details: Print the details of the selected student, including their grades and statistics.
View Grade Trends: View the grade trends for the selected student by subject. The trends indicate improvement (+) or decline (-) in grades over time.
Return to Main Menu: Return to the main menu.
Features
Grade Trends: The application analyzes grade trends for each subject. Trends are indicated as follows:

+: Improvement in grade compared to the previous grade in the same subject.
-: Decline in grade compared to the previous grade in the same subject.
++: Significant improvement (difference greater than 10).
--: Significant decline (difference less than -10).
Student Statistics: The application calculates various statistics for each student, including:

Average Grade: The average grade of all subjects combined.
Lowest Grade: The lowest grade received.
Highest Grade: The highest grade received.
Subject-Specific Statistics: Average, lowest, and highest grades for each subject.
Detailed Student Report: The application provides a detailed report for each student, including:

List of grades with date, subject, and score.
Overall statistics (average, lowest, highest).
Subject-specific statistics and trends.
Exception Handling
The application uses custom exceptions to handle various error conditions, such as invalid input, student not found, and invalid grades. These exceptions ensure that the application provides meaningful error messages and handles errors gracefully.

Contributing
Fork the repository.
Create a feature branch.
Commit your changes.
Push to the branch.
Create a new Pull Request.
License
This project is licensed under the MIT License.

Authors
Prince Melane
Acknowledgements
Java Documentation
Stack Overflow Community
CodSoft
For more information, visit the repository.