package repository;

import model.Student;
import java.util.List;

public interface StudentRepository {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
    Student getStudentById(int id);
    List<Student> getAllStudents();
}
