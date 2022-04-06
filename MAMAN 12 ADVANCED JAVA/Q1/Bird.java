public abstract class Bird extends Animal implements Cloneable {
    public Bird(){}

    public Bird(String color, String name , int age){
        super(color,name,age);
    }

    abstract void fly();

    @Override
    public void eat(){
        System.out.println(this.getName() + " Eats Seeds,Worms,Meat,Fish and Mollusca");
    }
    @Override
    public void sleep(){
        System.out.println("I must sleep");
    }
    public String toString() {
        return "Belongs to Birds." + super.toString();
    }
    @Override
    protected Object clone()throws CloneNotSupportedException {
        Bird cloned = (Bird)super.clone();
        return cloned;
    }




    }
