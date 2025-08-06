import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private String course;
    private double marks;

    public Student(int rollNumber, String name, String course, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void displayStudent() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("------------------------------------");
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(roll, name, course, marks);
        students.add(s);
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                s.displayStudent();
            }
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                s.displayStudent();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    static void updateStudent() {
        System.out.print("Enter Roll Number to update: ");
        int roll = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();
                System.out.print("Enter new Course: ");
                String course = sc.nextLine();
                System.out.print("Enter new Marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setCourse(course);
                s.setMarks(marks);

                System.out.println("Student record updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();
        boolean removed = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == roll) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found.");
        }
    }
}
