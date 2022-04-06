public class Turtle extends Reptile {

    public Turtle(String name , String color , int age)
    {
        super(name,color,age);
    }

    @Override
    public void crawl(){
        System.out.println("But Turtles doesnt crawl");
    }
    @Override
    public void eat(){
        System.out.println(this.getName()  + " Eats Plants");
    }
    @Override
    public void sleep(){
        super.sleep();
    }
    @Override
    public String toString() {
        return "This is a Turtle which " + super.toString();
    }

}
