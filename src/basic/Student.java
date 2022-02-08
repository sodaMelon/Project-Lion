package basic;

public class Student extends AbstractPerson {

    public Student(String name, int age) {
        super(name, age);
    }

    public void speak(){
        System.out.println(this.getName() + "/" + this.getAge()+"세 의 신분정보는?");
        System.out.println("학생입니다");
    }
}
