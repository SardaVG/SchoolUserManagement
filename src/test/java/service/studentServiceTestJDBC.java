package service;

import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.JDBCStudentRepository;

import static org.junit.jupiter.api.Assertions.*;

class studentServiceTestJDBC {
    private StudentService service;

    @BeforeEach
    void setUp() {
        service = new StudentService(new JDBCStudentRepository());
    }

    @Test
    void testAddStudent() {
        service.addStudent(1, "Victor", "Garcia", 20, 5);
        Student student = service.getStudentById(1);
        assertNotNull(student);
        assertEquals("Victor Garcia", student.getFullName());
    }

    @Test
    void testAddDuplicateStudentThrowsError() {
        service.addStudent(123, "Victor", "Garcia", 22, 2);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addStudent(123, "Bob", "Smith", 22, 2);
        });
        assertEquals("Student with ID 123 already exists.", exception.getMessage());
    }

    @Test
    void testUpdateStudent() {
        service.addStudent(9, "Victor", "Garcia", 21, 2);
        service.updateStudent(9, "Victor", "Updated", 22, 2);
        Student student = service.getStudentById(9);
        assertEquals("Victor Updated", student.getFullName());
        assertEquals(22, student.getAge());
    }

    @Test
    void testUpdateNonExistentStudentThrowsError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateStudent(999, "Ghost", "Non-Existing", 999, 999);
        });
        assertEquals("Student not found.", exception.getMessage());
    }

    @Test
    void testDeleteStudent() {
        service.addStudent(10, "Adrian", "Lopez" ,19, 1);
        service.deleteStudent(10);
        assertNull(service.getStudentById(10));
    }

    @Test
    void testGetAllStudents() {
        service.addStudent(123, "Victor", "Garcia", 22, 2);
        service.addStudent(997, "Ghost", "Non-Existing", 999, 999);
        assertEquals(14, service.getAllStudents().size());
    }
}