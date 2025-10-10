package model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int semester;

    public Student(int id, String firstName, String lastName, int age, int semester) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.semester = semester;
    }

    //Get and set
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getFullName() {return firstName + " " + lastName;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public int getSemester() {return semester;}
    public void setSemester(int semester) {this.semester = semester;}

    @Override
    public String toString() {
        return "model.Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', age='" + age + "', semester=" + semester + "}";
    }
}
