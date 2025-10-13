package repository;

import model.Student;
import java.util.ArrayList;
import java.util.List;


// These are the only methods to interact with the data stored.
// Now this is currently called "InMemory" because there's no database functionality implemented... yet.
// All data operations are done strictly through the repository methods.
// These separatees business logic from data access logic.

public class InMemoryStudentRepository implements StudentRepository{
    private final List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return;
            }
        }

    }

    @Override
    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    @Override
    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
