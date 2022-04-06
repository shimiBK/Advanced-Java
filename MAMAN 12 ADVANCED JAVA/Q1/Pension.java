import java.util.ArrayList;

public class Pension {

    ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal)
    {
        this.animals.add(animal);
    }

    public ArrayList<Animal> getAnimals()
    {
        return this.animals;
    }

    public int getSize(){
        return this.animals.size();
    }

}
