package basic;

public class Lecturer extends AbstractPerson {

    public Lecturer(String name, int age) {
        super(name, age);
    }

    public void speak(){
        System.out.println(this.getName() + "/" + this.getAge()+"세 의 신분정보는?");
        System.out.println("강사입니다");
    }
}
