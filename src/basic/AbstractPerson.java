package basic;

public abstract  class AbstractPerson implements Person {
    private String name;
    private int age;

    abstract public void speak();

    public AbstractPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
