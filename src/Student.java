
/*Mỗi đối tượng sinh viên có các thuộc tính sau: id, tên, giới tính, tuổi, điểm toán, điểm lý, điểm hóa, điểm trung bình và học lực.
Id là mã sinh viên tự động tăng.
Khi khởi tạo, chương trình sẽ đọc file "student.txt" để lấy ra danh sách sinh viên đã được lưu trước đó.
Điểm trung bình là giá trị trung bình của 3 môn toán, lý và hóa.
Học lực được tính như sau:
Giỏi: nếu điểm trung bình lớn hơn hoặc bằng 8.
Khá: nếu điểm trung bình nhỏ hơn 8 và lớn hơn hoặc bằng 6.5.
Trung Bình: nếu điểm trung bình nhỏ hơn 6.5 và lớn hơn hoặc bằng 5.
Yếu: nếu điểm trung bình nhỏ hơn 5.
Yêu cầu: tạo ra một menu với các chức năng sau:

1. Thêm sinh viên.
2. Cập nhật thông tin sinh viên bởi ID.
3. Xóa sinh viên bởi ID.
4. Tìm kiếm sinh viên theo tên.
5. Sắp xếp sinh viên theo điểm trung bình (GPA).
6. Sắp xếp sinh viên theo tên.
7. Hiển thị danh sách sinh vien.
8. Ghi danh sách sinh viên vào file "student.txt" .*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private static int nextId = 1;

    private final int id;
    private String name;
    private String gender;
    private int age;
    private double mathScore;
    private double physicsScore;
    private double chemistryScore;
    private double averageScore;
    private String academicPerformance;

    public Student(String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore) {
        this.id = nextId++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
        this.averageScore = (mathScore + physicsScore + chemistryScore) / 3;
        this.setAcademicPerformance();
    }

    public Student(int id, String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
        this.averageScore = (mathScore + physicsScore + chemistryScore) / 3;
        this.setAcademicPerformance();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public void setPhysicsScore(double physicsScore) {
        this.physicsScore = physicsScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public static int getNextId(){
        return nextId;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getMathScore() {
        return mathScore;
    }

    public double getPhysicsScore() {
        return physicsScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance() {
        if (this.averageScore >= 8) {
            this.academicPerformance = "Excellent";
        } else if (averageScore >= 6.5) {
            this.academicPerformance = "Good";
        } else if (averageScore >= 5) {
            this.academicPerformance = "Average";
        } else {
            this.academicPerformance = "Weak";
        }
    }

    public static void setNextId(int nextID){
        nextId = nextID;
    }

}

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
