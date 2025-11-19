package service;

import model.Student;
import repository.StudentRepository;
import java.util.List;

// This is the business logic layer (it connects the repository (data access layer) with the UI stuff or the stuff the Users interact with)
// In short, the Repository handles just how the data is worked and handled, and the service works the data itself that the repository then stores.


public class OldStudentService {
    private final StudentRepository repository;


    public OldStudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(int id, String firstName, String lastName, int age, int semester) {
        if (repository.getStudentById(id) != null) {
            throw new IllegalArgumentException("Student with ID " + id + " already exists.");
        }
        repository.addStudent(new Student(id, firstName, lastName, age, semester));
    }

    public void updateStudent(int id, String firstName, String lastName, int age, int semester) {
        Student student = repository.getStudentById(id);
        if(student == null) {
            throw new IllegalArgumentException("Student not found.");
        }
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setSemester(semester);

        repository.updateStudent(student);
    }

    public void deleteStudent(int id){
        repository.deleteStudent(id);
    }

    public Student getStudentById(int id){
        return repository.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }


}
