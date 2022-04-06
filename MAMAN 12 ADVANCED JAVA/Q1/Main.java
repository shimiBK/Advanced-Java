

public class Main{

    public static void main(String[] args) throws CloneNotSupportedException {

        /*Start of 2nd clause*/

        Pension pension = new Pension(); // define Pension

        Owner owner = new Owner("Shimi","0542662045");

        Cat c1 = new Cat("Chumpy","White",3,owner);
        Dog d1 = new Dog("Snow","White",3,owner);
        Penguin p1 = new Penguin("Pingu","Black",5);
        Wagtail w1 = new Wagtail("Eli","Gray",2);
        Turtle t1 = new Turtle("Donatelo","Green",100);
        Komodo k1 = new Komodo("Khaleesi","Gray",25);

        pension.addAnimal(c1);
        pension.addAnimal(d1);
        pension.addAnimal(p1);
        pension.addAnimal(w1);
        pension.addAnimal(t1);
        pension.addAnimal(k1);



        for(int i=0;i<pension.getSize();i++)
        {
            System.out.println(pension.getAnimals().get(i).toString());
            pension.getAnimals().get(i).eat();
            if(pension.getAnimals().get(i) instanceof Mammals)
            {
                ((Mammals) pension.getAnimals().get(i)).makeSound();
                System.out.println("--------------------------------");

            }
            else if(pension.getAnimals().get(i) instanceof Bird)
            {
                ((Bird) pension.getAnimals().get(i)).fly();
                System.out.println("--------------------------------");

            }
            else if(pension.getAnimals().get(i) instanceof Reptile)
            {
                ((Reptile) pension.getAnimals().get(i)).crawl();
                System.out.println("--------------------------------");

            }
        }
        /*End of 2nd clause*/

        /*Start of 3rd clause*/

        // We will use Chumpy the cat from the previous clause.


        Cat c2 = (Cat)c1.clone(); // clone animal with owner.
        System.out.println("--BEFORE THE CHANGE--\n" + "Original - " +  c1 + "\n" + "Cloned - " + c2);
        c2.getOwner().setOwnerName("David");
        c2.getOwner().setOwnerPhone("0509927374");
        System.out.println("--AFTER THE CHANGE--\n" + "Original - " +  c1 + "\n" + "Cloned - " + c2);

        /*End of 3rd clause*/

    }

}
