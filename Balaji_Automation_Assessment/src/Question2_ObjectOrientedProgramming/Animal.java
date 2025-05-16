package Question2_ObjectOrientedProgramming;

public class Animal {
    String name;
    String sound;
public void animalSound()
{
    System.out.println(name +" Makes Sound Like "+sound);
}
    public static void main(String[] args)
    {
        Animal[] zooAnimal =new Animal[3];
        zooAnimal[0]=new Bird();
        ((Bird)zooAnimal[0]).bird();
        zooAnimal[1]=new Mammal();
        ((Mammal)zooAnimal[1]).mammal();
        zooAnimal[2]=new Reptile();
        ((Reptile)zooAnimal[2]).reptile();
        for(Animal animal: zooAnimal)
        {
            animal.animalSound();
        }

    }
}
