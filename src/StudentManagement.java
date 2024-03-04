import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    public void loadIndex(int index){
        Student.setNextId(index);
    }
    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int id, String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setGender(gender);
                student.setAge(age);
                student.setMathScore(mathScore);
                student.setPhysicsScore(physicsScore);
                student.setChemistryScore(chemistryScore);
                student.setAverageScore((mathScore + physicsScore + chemistryScore) / 3);
                student.setAcademicPerformance();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> studentsByName = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                studentsByName.add(student);
            }
        }
        return studentsByName;
    }

    public void sortByAverageScore() {
        Collections.sort(students, Comparator.comparingDouble(Student::getAverageScore).reversed());
    }

    public void sortByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("ID: " + student.getId() +
                    ", Name: " + student.getName() +
                    ", Gender: " + student.getGender() +
                    ", Age: " + student.getAge() +
                    ", Average Score: " + student.getAverageScore() +
                    ", Academic Performance: " + student.getAcademicPerformance());
        }
    }

    public void writeToFile(String filename, String indexFilename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.getId() + "," +
                        student.getName() + "," +
                        student.getGender() + "," +
                        student.getAge() + "," +
                        student.getMathScore() + "," +
                        student.getChemistryScore() + "," +
                        student.getPhysicsScore() + "," +
                        student.getAverageScore() + "," +
                        student.getAcademicPerformance());
            }
            System.out.println("Data has been written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(indexFilename))) {
            writer.println(Student.getNextId());
            System.out.println("Last Index has been written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    public void writeNextIdToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(Student.getNextId());
            System.out.println("Last Index has been written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

}

