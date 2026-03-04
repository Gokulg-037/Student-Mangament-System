import java.util.*;

class Student {
    String name;
    int[] marks = new int[5];
    int total;
    double average;
    String grade;
    String result;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateResult();
    }

    void calculateResult() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }

        average = total / 5.0;

        if (average >= 80)
            grade = "A";
        else if (average >= 60)
            grade = "B";
        else if (average >= 40)
            grade = "C";
        else
            grade = "D";

        result = (average >= 40) ? "PASS" : "FAIL";
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nTotal: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Result: " + result);
        System.out.println("---------------------------");
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Performance Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

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
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int[] marks = new int[5];
        System.out.println("Enter 5 Subject Marks:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student s = new Student(name, marks);
        students.add(s);

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Student Name to Search: ");
        String searchName = sc.nextLine();

        for (Student s : students) {
            if (s.name.equalsIgnoreCase(searchName)) {
                System.out.println("Student Found!");
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found!");
    }
}