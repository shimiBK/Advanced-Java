public abstract class Mammals extends Animal implements Cloneable{

    private Owner owner;
    public Mammals(){}

    public Mammals(String color, String name , int age , Owner owner){
        super(color,name,age);
        this.owner = owner;
    }

    public Owner getOwner()
    {
        return this.owner;
    }

    public void setOwner(Owner owner)
    {
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Belongs to Mammals." + super.toString() + " and he has a owner named " + this.owner.getOwnerName() + " the owners phone is " + this.owner.getOwnerPhone() ;
    }

    abstract void makeSound();

    @Override
    public void eat()
    {
        System.out.println(" Eats Mommy's Milk");
    }
    @Override
    public void sleep(){
        System.out.println("I must Sleep");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Mammals cloned = (Mammals)super.clone();
        cloned.setOwner((Owner)cloned.getOwner().clone());
        return cloned;
    }

}
