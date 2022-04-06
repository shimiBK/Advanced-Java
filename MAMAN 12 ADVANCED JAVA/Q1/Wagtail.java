public class Wagtail extends Bird{


    public Wagtail(String name , String color , int age)
    {
        super(name,color,age);
    }

    @Override
    public void fly(){

        System.out.println("and He can fly");

    }
    @Override
    public void eat(){
       System.out.println(this.getName() + " Eats Worms and Humans Leftovers");
    }
    @Override
    public void sleep(){
        super.sleep();
    }
    @Override
    public String toString() {
        return "This is a Wagtail which " + super.toString();
    }




}
