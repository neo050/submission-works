package animals;

import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import javax.swing.*;
import java.util.Random;

public class Lion extends Carnivore
{
    private int scarCount;
    public Lion(String name )
    {
        super(name,new Point(20,0));
        MessageUtility.logConstractor("Lion",name);
        super.setDiet(this);
        super.setWeight(408.2);
        scarCount=0;


    }
    public Lion(String name ,Point point)
    {
        super(name,point);
        MessageUtility.logConstractor("Lion",name);
        super.setDiet(this);
        super.setWeight(408.2);
        scarCount=0;
    }
    public  Lion(String name , Point point, String col, int size, JPanel pan, int horSpeed, int verSpeed)
    {
        super("lio",new Point(20,0),col,size,pan,horSpeed,verSpeed);
        MessageUtility.logConstractor("Lion",name);
        super.setDiet(this);
        super.setWeight(size*0.8);
        scarCount=0;
    }
    public int getScarCount()
    {

        MessageUtility.logGetter(getName(),"getScarCount",scarCount);
        return scarCount;
    }
    public boolean setScarCount(int scarCount)
    {
        if (scarCount>=0) {
            this.scarCount = scarCount;
            MessageUtility.logSetter(getName(),"setScarCount",scarCount,true);
            return true;
        }
        else
            MessageUtility.logSetter(getName(),"setScarCount",scarCount,false);
        return false;
    }

    protected void incscarCount()
    {
        scarCount+=1;
    }



    @Override
    public boolean eat(IEdible food) {
        if (super.eat(food))
        {
            Random rand=new Random();
            if ( rand.nextInt(0,2) ==1)
                incscarCount();
            return true;

        }
       return false;

    }
    public EFoodType getFoodtype()
    {
        MessageUtility.logGetter(getName(),"getFoodtype",EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }
    public  String toString()
    {
        return "[Lion]:" +getName() ;
    }
}
