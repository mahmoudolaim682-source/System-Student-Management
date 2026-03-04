import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private double grade;

    public Student(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Error: ID must be a positive number");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Name cannot be null or empty");
        }
        this.id = id;
        this.name = name.trim();
        this.grade = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public void setGrade(double grade) {
        if (grade < 0.0 || grade > 100.0) {
            throw new IllegalArgumentException("Error: Grade must be between (0-100)");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Grade: " + grade;
    }
    
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}