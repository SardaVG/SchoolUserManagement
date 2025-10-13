package model;

// Our class from which we'll define the properties of a Student Object.
public class Student {
    //Student variables, private since we're following encapsulation principle.
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int semester;

    // Constructor that initializes a new student object with all the parameters.
    public Student(int id, String firstName, String lastName, int age, int semester) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.semester = semester;
    }

    //Get and set methods
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    // This one made the next two a little bit useless, but we'll keep them just in case.
    public String getFullName() {return firstName + " " + lastName;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public int getSemester() {return semester;}
    public void setSemester(int semester) {this.semester = semester;}

    // We're overriding the method to provide a readable representation of the object instead of just a pointer to where it's stored.
    @Override
    public String toString() {
        return "model.Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', age='" + age + "', semester=" + semester + "}";
    }
}
