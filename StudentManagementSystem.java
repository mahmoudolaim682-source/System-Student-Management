import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();

        while (true) {
            System.out.println("\nWelcome to Student Management System");
            System.out.println("------------------------------------");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Record Grade");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(input.nextLine());

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    admin.addStudent(new Student(id, name));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    admin.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Course Code: ");
                    String code = input.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = input.nextLine();

                    admin.addCourse(new Course(code, courseName));
                    System.out.println("Course added successfully!");
                    break;

                case 4:
                    admin.viewAllCourses();
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int studentId = Integer.parseInt(input.nextLine());

                    System.out.print("Enter Grade: ");
                    double grade = Double.parseDouble(input.nextLine());

                    admin.recordGrade(studentId, grade);
                    System.out.println("Grade recorded successfully!");
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}