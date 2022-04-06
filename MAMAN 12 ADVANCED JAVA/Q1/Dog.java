public class Dog extends Mammals{
    public Dog(String name , String color , int age,Owner owner)
    {
        super(name,color,age,owner);
    }


    @Override
    public void makeSound(){
        System.out.println("And he Makes Woof Woof sound.");
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
        return "This is a dog which " + super.toString();
    }



}
