import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private double age;
    private String id;

    public Person( String name, String id,double age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }



    @Override
    public int compareTo(Person p) {
        return this.id.compareTo(p.id);
    }
    public String toString() {
        return name;
    }

}
