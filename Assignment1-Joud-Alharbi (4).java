/*
 * Name: Joud Alharbi  
 * Assignment 1: Grading and Absence Managment System for Students
 */

import java.util.Scanner;

public class Assignment1_Joud_Alharbi {

    public static void main(String[] args) {
        // to read the choices and information from user 
        Scanner input = new Scanner(System.in);

        // variable declaration
        String choice;
        String courseName;
        int NumOfStudents;

        printWelcomeMsg(); // displayed only one time 
        while (true) {

            displayMenu();
            choice = input.next().toLowerCase();
            switch (choice) {
                case "grades":
                    System.out.println("\n    **Grades of Students**");
                    System.out.print("Please enter the name of your course (ex: MATH-110): ");
                    courseName = input.next();
                    System.out.print("Please enter the No. of students in " + courseName + ": ");
                    NumOfStudents = input.nextInt();
                    grades(NumOfStudents);
                    System.exit(0);
                    break;
                case "absences":
                    System.out.println("\n    **Number of Absences for Students**");
                    System.out.print("Please enter the name of your course (ex: MATH-110): ");
                    courseName = input.next();
                    System.out.print("Please enter the No. of students in " + courseName + ": ");
                    NumOfStudents = input.nextInt();
                    absences(NumOfStudents);
                    System.exit(0);
                    break;
                case "exit":
                    quit();
                    break;
                default:
                    System.out.println("\nWrong Selection!, Please try again.\n");
            }

        }

    }

    // to print the header "welcome message"
    public static void printWelcomeMsg() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("   Welcome to the Grading and Absence Managment System for students");
        System.out.println("----------------------------------------------------------------------");
    }

    // to print the menue
    public static void displayMenu() {
        System.out.println("Enter \"Grades\" for Adding Grades of Students");
        System.out.println("Enter \"Absences\" for Adding Number of Absences for Students");
        System.out.println("Enter \"Exit\" for exiting from the System");
        System.out.print("        Please enter your choice: ");
    }

    // choice #1 
    public static void grades(int NumOfStudents) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= NumOfStudents; i++) {
            System.out.println("Student " + i);
            System.out.print("Enter Student ID: ");
            String ID = input.next();
            System.out.println("Enter Student Grades:");
            System.out.print("        Enter the grade of the first exam, seconed exam, and final exam: ");
            input = new Scanner(System.in);
            String[] grades = input.nextLine().split(" ");
            double finalGrade = calculateFinalGrade(grades);
            char Symbol = getGradeSymbol(finalGrade);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Student ID: " + ID);
            System.out.println("Final Grade: " + finalGrade + " (" + Symbol + "), has been added to the system.");
            System.out.println("---------------------------------------------------------------------------");

        }

    }

    // input: String[] grades
    // output: double finalGrade
    public static double calculateFinalGrade(String[] grades) {
        // intiate the finalGrade
        double finalGrade = 0;

        for (int i = 0; i < grades.length; i++) {

            // convert the string to double
            double grade = Double.parseDouble(grades[i].trim());

            if (grade < 0 || grade > 30) {
                // invalid input, grade must be grater than zero and less than thirty
                System.out.println("\nInvalid input!(must be between 0 and 30)");

                // exit
                System.exit(0);
            } else {

                // add the grade to total grades
                finalGrade += grade;

            }
        }

        return finalGrade;
    }

    // input: double finalGrade
    // output: char Symbol
    public static char getGradeSymbol(double finalGrade) {
        // intiate the Synbol
        char Symbol = ' ';

        if (finalGrade == 90) {
            Symbol = 'A'; // equal 90 ==> A
        } else if (finalGrade > 80) {
            Symbol = 'B'; // above 80 ==> B
        } else if (finalGrade > 70) {
            Symbol = 'C'; // above 70 ==> C
        } else if (finalGrade > 60) {
            Symbol = 'D'; // above 60 ==> D
        } else if (finalGrade < 60) {
            Symbol = 'F'; // below 60 ==> F
        }

        return Symbol;
    }

    // choice #2
    static void absences(int NumOfStudents) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= NumOfStudents; i++) {
            System.out.println("Student " + i);
            System.out.print("Enter Student ID: ");
            int ID = input.nextInt();
            System.out.print("Enter No. of Absences: ");
            int absences = input.nextInt();
            // check validity
            if (absences < 0) {
                // invalid input, absences must be greater or equal to zero
                System.out.println("\nInvalid input!(must be >=0)");
                System.out.println("Please try again.");

                // exit
                System.exit(0);

            }
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Student ID: " + ID);
            String warning = getMsgOfWarning(absences);
            System.out.println("No. of Absences: " + absences + " (" + warning + "), has been added to the system.");
            System.out.println("---------------------------------------------------------------------------");

        }

    }

    // input: int absences
    // output: String warning
    public static String getMsgOfWarning(int absences) {
        String warning = "";
        if (absences < 8) {
            // below 8 ==> without warning
            warning = "Without Warning";
        } else if (absences == 8) {
            // equal 8 ==> first warning
            warning = "First Warning";
        } else if (absences >= 10) {
            // 10 or above ==> second warning
            warning = "Second Warning";
        }
        return warning;
    }

    // choice #3
    public static void quit() {

        System.out.println("\n        Thanks for Using This System");
        System.exit(0);

    }
}
