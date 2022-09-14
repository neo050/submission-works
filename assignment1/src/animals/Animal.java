package animals;

import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

public abstract class Animal extends Mobile implements IEdible {
    private String name;
    private double weight;
    private IDiet diet;
    public Animal(String name , Point point)
    {
        super(point);
        MessageUtility.logConstractor("Animal",name);
        this.name =name;
    }

     public abstract void makeSound();


    public boolean eat(IEdible food)
    {
        double more =getDiet().eat(this,food);
        if(more>0)
        {
            setWeight(getWeight()+more);
            makeSound();
            return true;
        }
        return false;
    }
    public EFoodType getFoodtype()
    {
        MessageUtility.logGetter(name,"getFoodtype",EFoodType.MEAT);
        return EFoodType.MEAT;
    }
    protected boolean setDiet(IDiet diet)
    {
        MessageUtility.logSetter(name,"setDiet",diet ,true);
        this.diet=diet;
        return true;
    }
    protected IDiet getDiet()
    {
        MessageUtility.logGetter(name,"getDiet",diet);
        return this.diet ;
    }
    public boolean setWeight(double newWeight)
    {
        MessageUtility.logSetter(name,"setWeight",newWeight ,true);
        this.weight=newWeight;
        return true;
    }
    public double getWeight()
    {
        MessageUtility.logGetter(name,"setWeight",weight);
        return this.weight;
    }
    public String getName()
    {
        MessageUtility.logGetter(name,"getName",name);
        return name;
    }
    public boolean setName(String newName)
    {
        MessageUtility.logSetter(newName,"setName",newName ,true);
         this.name=newName;
         return true;
    }
    public double move(Point point )
    {
        double distance =super.move(point);
        setWeight(getWeight() -(distance*getWeight()*00025.0));
        return distance;

    }
    public abstract String toString();

}
