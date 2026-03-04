import java.util.Objects;

public class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Course code cannot be null or empty");
        }
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Course name cannot be null or empty");
        }
        
        this.courseCode = courseCode.trim().toUpperCase();
        this.courseName = courseName.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + " Course Name: " + courseName;
    }

    public void displayCourseInfo() {
        System.out.println(this.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}