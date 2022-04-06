public abstract class Reptile extends Animal implements Cloneable {

    public Reptile(){}

    public Reptile(String color, String name , int age){
        super(color,name,age);
    }

   abstract void crawl();



    @Override
    public void eat(){
        System.out.println(this.getName() + " Eats Meat,Plants and Insects");
    }
    @Override
    public void sleep(){
        System.out.println("I must sleep");
    }
    public String toString() {
        return "Belongs to Reptiles." + super.toString();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Reptile cloned = (Reptile)super.clone();
        return cloned;
    }
}
