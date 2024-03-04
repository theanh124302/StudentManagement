public class PriorityStudent extends Student{
    public PriorityStudent(String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore) {
        super(name, gender, age, mathScore+1, physicsScore+1, chemistryScore+1);
    }
    public PriorityStudent(int id, String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore){
        super(id, name, gender, age, mathScore+1, physicsScore+1, chemistryScore+1);
    }
}
