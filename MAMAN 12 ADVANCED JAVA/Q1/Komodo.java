public class Komodo extends Reptile{
    public Komodo(String name , String color , int age)
    {
        super(name,color,age);
    }


    @Override
    public void crawl(){
        System.out.println("But Komodo's doesnt crawl");
    }

    @Override
    public void eat(){
        System.out.println(this.getName() + " Eats Meat");
    }
    @Override
    public void sleep(){
        super.sleep();
    }
    @Override
    public String toString() {
        return "This is a Komodo which " + super.toString();
    }

}
