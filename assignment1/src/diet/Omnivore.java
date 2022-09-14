package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import mobility.Point;


public  class Omnivore extends Animal implements IDiet {

    private Carnivore carnivore;
    private Herbivore herbivore;
    public Omnivore(String name, Point point) {
        super(name, point);
        carnivore=new Carnivore(name, point);
        herbivore=new Herbivore(name, point);

    }

    public boolean canEat(EFoodType food) {
        return carnivore.canEat(food)||herbivore.canEat(food);
    }

    public double eat(Animal animal, IEdible food) {

            return carnivore.eat(animal,food)+herbivore.eat(animal,food);
    }

    public void makeSound() {
        carnivore.makeSound();

    }

    public  String toString()
    {
        return "[Omnivore]:" +getName() ;
    }


}