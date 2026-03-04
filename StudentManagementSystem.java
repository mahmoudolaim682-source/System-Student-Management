import java.util.Scanner;

public class StudentManagementSystem {
    private static final Scanner input = new Scanner(System.in);
    private static final Admin admin = new Admin();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to Student Management System");
            System.out.println("------------------------------------");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Update Student");
            System.out.println("5. Add Course");
            System.out.println("6. View Courses");
            System.out.println("7. Record Grade");
            System.out.println("8. Exit");

            int choice = readIntSafe("Choose an option: ");

            try {
                switch (choice) {
                    case 1 -> handleAddStudent();
                    case 2 -> admin.viewAllStudents();
                    case 3 -> handleRemoveStudent();
                    case 4 -> handleUpdateStudent();
                    case 5 -> handleAddCourse();
                    case 6 -> admin.viewAllCourses();
                    case 7 -> handleRecordGrade();
                    case 8 -> {
                        System.out.println("Exiting System... Goodbye");
                        input.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice Please select (1-8)");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleAddStudent() {
        int id = readIntSafe("Enter Student ID: ");
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        admin.addStudent(new Student(id, name));
    }

    private static void handleRemoveStudent() {
        int id = readIntSafe("Enter Student ID to remove: ");
        admin.removeStudent(id);
    }

    private static void handleUpdateStudent() {
        int id = readIntSafe("Enter Student ID to update: ");
        System.out.print("Enter new name: ");
        String newName = input.nextLine();
        admin.updateStudent(id, newName);
    }

    private static void handleAddCourse() {
        System.out.print("Enter Course Code: ");
        String code = input.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = input.nextLine();
        admin.addCourse(new Course(code, courseName));
    }

    private static void handleRecordGrade() {
        int id = readIntSafe("Enter Student ID: ");
        double grade = readDoubleSafe("Enter Grade (0-100): ");
        if (grade < 0 || grade > 100) {
            System.out.println("Grade must be between (0-100)");
            return;
        }
        admin.recordGrade(id, grade);
    }

    private static int readIntSafe(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input Please enter a valid number");
            }
        }
    }

    private static double readDoubleSafe(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input Please enter a valid decimal number");
            }
        }
    }
}