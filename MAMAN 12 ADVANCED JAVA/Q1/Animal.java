abstract class Animal{

    private String color;
    private String name;
    private int age;


    public Animal(){}

    public Animal(String name,String color,  int age){
        this.color = color;
        this.name = name;
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor()
    {
        return this.color;

    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }


    public abstract void eat();

    public abstract void sleep();

    @Override
    public String toString() {
        return "This animal name is " + this.name + " " + "its color is " + this.color + "," +  "its age is " + this.age ;
    }

    @Override
    public boolean equals(Object obj) {
        final Animal other = (Animal) obj;
        if(obj == null)
            return false;

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!this.name.equals(other.name) ||!this.color.equals(other.color) || this.age!=other.age) {
            return false;
        }

        return true;
    }

}