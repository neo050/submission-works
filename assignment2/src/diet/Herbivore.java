


package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import javax.swing.*;

public  class Herbivore extends Animal implements IDiet {

    public Herbivore(String name, Point point)
    {
        super(name,point);

    }
    public Herbivore(String name , Point point, String col, int size, JPanel pan, int horSpeed, int verSpeed)
    {
        super( name,point,col,size,pan,horSpeed,verSpeed);
    }
    public boolean canEat(EFoodType food)
    {
        return food==EFoodType.VEGETABLE;
    }
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodtype()))
        {
                return 0.07*animal.getWeight();
            //            if(animal.calcDistance(new Point(plant.getLocation().getX(),0))<animal.getEAT_DISTANCE()&&animal.calcDistance(new Point(0,plant.getLocation().getY()))<animal.getEAT_DISTANCE())
        }
        return 0;
    }

    public void makeSound()
    {
        this.chew();

    }

    public void chew()
    {
        MessageUtility.logSound(getName(),"chew");
    }
    public  String toString()
    {
        return "[Herbivore]:" +getName() ;
    }
}

