package project;

import java.util.*;

class Student {
    int id;
    String name;
    String course;

    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Course: " + course;
    }
}

class Teacher {
    int id;
    String name;
    String subject;

    Teacher(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher ID: " + id + ", Name: " + name + ", Subject: " + subject;
    }
}

class Course {
    String code;
    String title;

    Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course Code: " + code + ", Title: " + title;
    }
}

public class CollegeManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== College Management System =====");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Manage Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: manageStudents();
                case 2: manageTeachers();
                case 3: manageCourses();
                case 4 : System.out.println("Exiting... Thank you!");
                default : System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }

    // ---------------- STUDENTS -----------------
    static void manageStudents() {
        int ch;
        do {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> removeStudent();
                case 4 -> System.out.println("Returning...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 4);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        students.add(new Student(id, name, course));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty())
            System.out.println("No students found!");
        else
            students.forEach(System.out::println);
    }

    static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.id == id);
        System.out.println(removed ? " Student removed!" : " Student not found!");
    }

    // ---------------- TEACHERS -----------------
    static void manageTeachers() {
        int ch;
        do {
            System.out.println("\n--- Teacher Menu ---");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teachers");
            System.out.println("3. Remove Teacher");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> addTeacher();
                case 2 -> viewTeachers();
                case 3 -> removeTeacher();
                case 4 -> System.out.println("Returning...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 4);
    }   

    static void addTeacher() {
        System.out.print("Enter Teacher ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();
        teachers.add(new Teacher(id, name, subject));
        System.out.println(" Teacher added successfully!");
    }

    static void viewTeachers() {
        if (teachers.isEmpty())
            System.out.println("No teachers found!");
        else
            teachers.forEach(System.out::println);
    }

    static void removeTeacher() {
        System.out.print("Enter Teacher ID to remove: ");
        int id = sc.nextInt();
        boolean removed = teachers.removeIf(t -> t.id == id);
        System.out.println(removed ? " Teacher removed!" : " Teacher not found!");
    }

    // ---------------- COURSES -----------------
    static void manageCourses() {
        int ch;
        do {
            System.out.println("\n--- Course Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Remove Course");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> addCourse();
                case 2 -> viewCourses();
                case 3 -> removeCourse();
                case 4 -> System.out.println("Returning...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 4);
    }

    static void addCourse() {
        sc.nextLine();
        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();
        System.out.print("Enter Course Title: ");
        String title = sc.nextLine();
        courses.add(new Course(code, title));
        System.out.println("Course added successfully!");
    }

    static void viewCourses() {
        if (courses.isEmpty())
            System.out.println("No courses found!");
        else
            courses.forEach(System.out::println);
    }

    static void removeCourse() {
        sc.nextLine();
        System.out.print("Enter Course Code to remove: ");
        String code = sc.nextLine();
        boolean removed = courses.removeIf(c -> c.code.equalsIgnoreCase(code));
        System.out.println(removed ? "Course removed!" : "Course not found!");
    }
}
