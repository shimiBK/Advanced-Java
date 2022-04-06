public class Penguin extends Bird{

    public Penguin(String name , String color , int age)
    {
        super(name,color,age);
    }

    public void fly(){

       System.out.println("But penguins Cant fly");

    }
    @Override
    public void eat(){
        System.out.println(this.getName() + " Eats Mollusca and fish.");
    }
    @Override
    public void sleep(){
        super.sleep();
    }
    @Override
    public String toString() {
        return "This is a Penguin which " + super.toString();
    }



}
