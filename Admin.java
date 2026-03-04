import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Student> students;
    private List<Course> courses;

    public Admin() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            System.out.println("Error: Cannot add a null student");
            return false;
        }
        if (findStudentById(student.getId()) != null) {
            System.out.println("Error: Student with ID " + student.getId() + " already exists");
            return false;
        }
        students.add(student);
        System.out.println("Success: Student added successfully");
        return true;
    }

    public boolean removeStudent(int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("Success: Student removed successfully");
        } else {
            System.out.println("Error: Student with ID " + id + " not found");
        }
        return removed;
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Student s : students) {
            s.displayInfo();
        }
    }

    public boolean updateStudent(int id, String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Invalid name provided");
            return false;
        }
        
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(name.trim());
            System.out.println("Success: Student updated successfully");
            return true;
        }
        
        System.out.println("Error: Student with ID " + id + " not found");
        return false;
    }

    public boolean addCourse(Course course) {
        if (course == null) {
            System.out.println("Error: Cannot add a null course");
            return false;
        }
        if (courses.contains(course)) {
            System.out.println("Error: Course already exists");
            return false;
        }
        courses.add(course);
        System.out.println("Success: Course added successfully");
        return true;
    }

    public void viewAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found");
            return;
        }
        for (Course c : courses) {
            c.displayCourseInfo();
        }
    }

    public boolean recordGrade(int id, double grade) {
        if (grade < 0.0 || grade > 100.0) {
            System.out.println("Error: Invalid grade. Must be between 0 and 100");
            return false;
        }
        
        Student student = findStudentById(id);
        if (student != null) {
            student.setGrade(grade);
            System.out.println("Success: Grade recorded successfully");
            return true;
        }
        
        System.out.println("Error: Student with ID " + id + " not found");
        return false;
    }
}