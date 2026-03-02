public class Student {

    private int id;
    private String name;
    private double grade;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
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
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Grade: " + grade);
    }
}