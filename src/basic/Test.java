package basic;

public class Test {
    public static void main(String[] args) {
    Student studentA = new Student("박학생", 22);
    checkInformationAbout(studentA);

    Lecturer lecturerB = new Lecturer("김강사", 35);
    checkInformationAbout(lecturerB);
    }

    public static void checkInformationAbout(Person person){
        person.speak();
    }
}
