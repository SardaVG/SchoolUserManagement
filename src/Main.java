import model.Student;
import repository.InMemoryStudentRepository;
import repository.JDBCStudentRepository;
import service.StudentService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService(new JDBCStudentRepository());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student by ID");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();




            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter semester: ");
                    int semester = scanner.nextInt();
                    scanner.nextLine();


                    try {
                        service.addStudent(id, firstName, lastName, age, semester);
                        System.out.println("Student added successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter semester: ");
                    int semester = scanner.nextInt();
                    scanner.nextLine();


                    try {
                        service.updateStudent(id, firstName, lastName, age, semester);
                        System.out.println("Student updated successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = scanner.nextInt();
                    service.deleteStudent(id);
                    System.out.println("Student deleted successfully.");
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    Student student = service.getStudentById(id);
                    System.out.println(student != null ? student : "Student not found.");
                }
                case 5 -> {
                    System.out.println("All Students:");
                    service.getAllStudents().forEach(System.out::println);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }



        }

    }

}
