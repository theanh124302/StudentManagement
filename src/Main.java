import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();

        loadStudentsFromFile(studentManagement, "student.txt", "index.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Find Student by Name");
            System.out.println("5. Sort Students by Average Score");
            System.out.println("6. Sort Students by Name");
            System.out.println("7. Display Students");
            System.out.println("8. Write to File");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            int id = 0;
            String name = null;
            String gender = null;
            int age = 0;
            double mathScore = 0.0;
            double physicsScore = 0.0;
            double chemistryScore = 0.0;
            switch (option) {
                case 1:
                    System.out.print("Enter student's name: ");
                    name = scanner.nextLine();
//                    System.out.print("Enter student's gender: ");
//                    gender = scanner.nextLine();
//                    System.out.print("Enter student's age: ");
//                    age = scanner.nextInt();
//                    System.out.print("Enter student's math score: ");
//                    mathScore = scanner.nextDouble();
//                    System.out.print("Enter student's physics score: ");
//                    physicsScore = scanner.nextDouble();
//                    System.out.print("Enter student's chemistry score: ");
//                    chemistryScore = scanner.nextDouble();
                    do {
                        System.out.print("Enter student's gender (male/female): ");
                        gender = scanner.nextLine();
                    } while (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"));

                    do {
                        System.out.print("Enter student's age: ");
                        age = scanner.nextInt();
                    } while (age <= 0);

                    do {
                        System.out.print("Enter student's math score (0-10): ");
                        mathScore = scanner.nextDouble();
                    } while (mathScore < 0 || mathScore > 10);

                    do {
                        System.out.print("Enter student's physics score (0-10): ");
                        physicsScore = scanner.nextDouble();
                    } while (physicsScore < 0 || physicsScore > 10);

                    do {
                        System.out.print("Enter student's chemistry score (0-10): ");
                        chemistryScore = scanner.nextDouble();
                    } while (chemistryScore < 0 || chemistryScore > 10);

                    studentManagement.addStudent(new Student(name, gender, age, mathScore, physicsScore, chemistryScore));
                    break;
                case 2:
                    System.out.print("Enter student's ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student's name: ");
                    name = scanner.nextLine();
//                    System.out.print("Enter student's gender: ");
//                    gender = scanner.nextLine();
//                    System.out.print("Enter student's age: ");
//                    age = scanner.nextInt();
//                    System.out.print("Enter student's math score: ");
//                    mathScore = scanner.nextDouble();
//                    System.out.print("Enter student's physics score: ");
//                    physicsScore = scanner.nextDouble();
//                    System.out.print("Enter student's chemistry score: ");
//                    chemistryScore = scanner.nextDouble();
                    do {
                        System.out.print("Enter student's gender (male/female): ");
                        gender = scanner.nextLine();
                    } while (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"));

                    do {
                        System.out.print("Enter student's age: ");
                        age = scanner.nextInt();
                    } while (age <= 0);

                    do {
                        System.out.print("Enter student's math score (0-10): ");
                        mathScore = scanner.nextDouble();
                    } while (mathScore < 0 || mathScore > 10);

                    do {
                        System.out.print("Enter student's physics score (0-10): ");
                        physicsScore = scanner.nextDouble();
                    } while (physicsScore < 0 || physicsScore > 10);

                    do {
                        System.out.print("Enter student's chemistry score (0-10): ");
                        chemistryScore = scanner.nextDouble();
                    } while (chemistryScore < 0 || chemistryScore > 10);
                    studentManagement.updateStudent(id, name, gender, age, mathScore, physicsScore, chemistryScore);
                    break;
                case 3:
                    System.out.print("Enter student's ID: ");
                    id = scanner.nextInt();
                    studentManagement.removeStudent(id);
                    break;
                case 4:
                    StudentManagement studentByName = new StudentManagement();
                    System.out.print("Enter student's name: ");
                    name = scanner.nextLine();
                    ArrayList<Student> foundStudents = studentManagement.findStudentByName(name);
                    for (Student student : foundStudents){
                        studentByName.addStudent(student);
                    }
                    if (!foundStudents.isEmpty()) {
                        studentByName.displayStudents();
//                        System.out.println("ID: " + foundStudent.getId() +
//                                ", Name: " + foundStudent.getName() +
//                                ", Gender: " + foundStudent.getGender() +
//                                ", Age: " + foundStudent.getAge() +
//                                ", Average Score: " + foundStudent.getAverageScore() +
//                                ", Academic Performance: " + foundStudent.getAcademicPerformance());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    studentManagement.sortByAverageScore();
                    break;
                case 6:
                    studentManagement.sortByName();
                    break;
                case 7:
                    studentManagement.displayStudents();
                    break;
                case 8:
                    studentManagement.writeToFile("student.txt", "index.txt");
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

//    private static void loadStudentsFromFile(StudentManagement studentManagement, String filename) {
//        try (Scanner scanner = new Scanner(new File(filename))) {
//            while (scanner.hasNextLine()) {
//                String[] data = scanner.nextLine().split(",");
//                String name = data[1];
//                String gender = data[2];
//                int age = Integer.parseInt(data[3]);
//                double mathScore = Double.parseDouble(data[4]);
//                double physicsScore = Double.parseDouble(data[5]);
//                double chemistryScore = Double.parseDouble(data[6]);
//                studentManagement.addStudent(new Student(name, gender, age, mathScore, physicsScore, chemistryScore));
//            }
//            System.out.println("Data has been loaded from file successfully.");
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: " + e.getMessage());
//        }
//    }

    private static void loadStudentsFromFile(StudentManagement studentManagement, String filename, String indexFilename) {
        File file = new File(filename);
        File indexFile = new File(indexFilename);

        if (!indexFile.exists()) {
            studentManagement.loadIndex(1);
            return;
        }else {
            try (Scanner scanner = new Scanner(indexFile)) {
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(",");
                    int index = Integer.parseInt(data[0]);
                    studentManagement.loadIndex(index);
                }
                System.out.println("Index has been loaded from file successfully.");
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String gender = data[2];
                int age = Integer.parseInt(data[3]);
                double mathScore = Double.parseDouble(data[4]);
                double physicsScore = Double.parseDouble(data[5]);
                double chemistryScore = Double.parseDouble(data[6]);
                studentManagement.addStudent(new Student(id, name, gender, age, mathScore, physicsScore, chemistryScore));
            }
            System.out.println("Data has been loaded from file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }


}
