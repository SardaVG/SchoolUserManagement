package repository;

import model.Student;
import java.util.List;

// This interface defines how we'll manage the Student entity, this is what "InMemory" is currently following.
// We have our basic CRUD operations.
// It's what operations can be done but how is defined elsewhere.

public interface StudentRepository {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
    Student getStudentById(int id);
    List<Student> getAllStudents();
}
