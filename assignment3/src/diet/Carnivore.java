package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import javax.swing.*;

public  class Carnivore extends Animal implements IDiet {

    public Carnivore(String name, Point point)
    {
        super(name,point);

    }
    public Carnivore(String name , Point point, String col, int size, JPanel pan, int horSpeed, int verSpeed)
    {
        super( name,point,col,size,pan,horSpeed,verSpeed);
    }
    public boolean canEat(EFoodType food)
    {
        return food==EFoodType.MEAT;
    }
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodtype()))
        {

            //if(animal.calcDistance(new Point(meat.getLocation().getX(),0))<animal.getEAT_DISTANCE()&&animal.calcDistance(new Point(0,meat.getLocation().getY()))<animal.getEAT_DISTANCE())
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
