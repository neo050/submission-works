package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

public  class Carnivore extends Animal implements IDiet {

    public Carnivore(String name, Point point)
    {
        super(name,point);

    }
    public boolean canEat(EFoodType food)
    {
        return food==EFoodType.MEAT;
    }
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodtype()))
        {

            return 0.1*animal.getWeight();
        }
        return 0;
    }

    public void makeSound()
    {
        this.roar();

    }

    @Override
    public  String toString()
    {
        return "[Carnivore]:" +getName() ;
    }

    public void roar()
    {
        MessageUtility.logSound(getName(),"roar");
    }

}
