import java.util.ArrayList;

public class Admin {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public Admin() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            s.displayInfo();
        }
    }

    public void updateStudent(int id, String name){
        for(Student student : students){
            if(student.getId() == id){
                student.setName(name);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void viewAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course c : courses) {
            c.displayCourseInfo();
        }
    }

    public void recordGrade(int id, double grade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(grade);
                return;
            }
        }
        System.out.println("Student not found!");
    }
}