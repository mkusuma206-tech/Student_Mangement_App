import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=====Student Management System=====");
            System.out.println("1. Add student");
            System.out.println("2. View students");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the Student Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        studentList.add(new Student(id, name, age, course));
    }

    public static void viewStudents() {
        for (Student student : studentList) {
            student.display();
            System.out.println();
        }
    }

    public static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        for (Student student : studentList) {
            if (student.id == id) {
                System.out.print("Enter new Name: ");
                student.name = sc.nextLine();
                System.out.print("Enter new Age: ");
                student.age = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter new Course: ");
                student.course = sc.nextLine();
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        for (Student student : studentList) {
            if (student.id == id) {
                studentList.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}