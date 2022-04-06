public class Cat extends Mammals{


    public Cat(String name , String color , int age,Owner owner)
    {
        super(name,color,age,owner);
    }

    @Override
    public void makeSound(){
        System.out.println("and he Makes MEOW sound.");
    }

    @Override
    public void eat(){
        System.out.println(this.getName() + " Eats Mommy's Milk");
    }
    @Override
    public void sleep(){
        super.sleep();
    }
    @Override
    public String toString() {
        return "This is a cat which " + super.toString();
    }


}