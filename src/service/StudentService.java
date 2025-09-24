package service;

import model.Student;
import repository.StudentRepository;
import java.util.List;

public class StudentService {
    private final StudentRepository repository;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(int id, String firstName, String lastName, int age, int semester) {
        if (repository.getStudentById(id) != null) {
            throw new IllegalArgumentException("Student with ID " + id + " already exists.");
        }
        repository.addStudent(new Student(id, firstName, lastName, age, semester));
    }


}
