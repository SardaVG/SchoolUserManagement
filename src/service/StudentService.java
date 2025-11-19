package service;

import model.Student;
import repository.StudentRepository;
import java.util.List;

/**
 * StudentService: Business logic layer connecting UI and repository.
 * Keeps business rules (validations, transformations) separate from persistence logic.
 */

/** This is labeled as New because it might change when we change to SpringBoot */

public class StudentService {
    private final StudentRepository repository;

    // Constructor injection: we can plug in any repository (InMemory or JDBC)
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(int id, String firstName, String lastName, int age, int semester) {
        if (repository.getStudentById(id) != null) {
            throw new IllegalArgumentException("Student with ID " + id + " already exists.");
        }

        Student student = new Student(id, firstName, lastName, age, semester);
        repository.addStudent(student);
    }

    public void updateStudent(int id, String firstName, String lastName, int age, int semester) {
        Student existing = repository.getStudentById(id);
        if (existing == null) {
            throw new IllegalArgumentException("Student not found.");
        }

        existing.setFirstName(firstName);
        existing.setLastName(lastName);
        existing.setAge(age);
        existing.setSemester(semester);

        repository.updateStudent(existing);
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }

    public Student getStudentById(int id) {
        return repository.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }
}
