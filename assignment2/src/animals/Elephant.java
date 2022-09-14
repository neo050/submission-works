package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

import javax.swing.*;

public class Elephant extends Herbivore {
    private double trunkLength;
    public Elephant(String name )
    {
        super(name,new Point(50,90));
        MessageUtility.logConstractor("Elephant",name);
        super.setDiet(this);
        super.setWeight(500);
        setTrunkLength(1);

    }
    public Elephant(String name ,double trunkLength)
    {
        super(name,new Point(50,90));
        MessageUtility.logConstractor("Elephant",name);
        super.setDiet(this);
        super.setWeight(500);
        if(!setTrunkLength(trunkLength))
            setTrunkLength(1);
    }
    public Elephant(String name , Point point, String col, int size, JPanel pan, int horSpeed, int verSpeed)
    {
        super("elf",new Point(50,90),col,size,pan,horSpeed,verSpeed);
        MessageUtility.logConstractor("Elephant",name);
        super.setDiet(this);
        super.setWeight(size*10);
        setTrunkLength(1);
    }
    public Elephant(String name ,Point point)
    {
        super(name,point);
        MessageUtility.logConstractor("Elephant",name);
        super.setDiet(this);
        super.setWeight(500);
        setTrunkLength(1);

    }
    public Elephant(String name ,Point point,double trunkLength)
    {
        super(name,point);
        MessageUtility.logConstractor("Elephant",name);
        super.setDiet(this);
        super.setWeight(500);
        if(!setTrunkLength(trunkLength))
            setTrunkLength(1);

    }
    public boolean setTrunkLength(double trunkLength)
    {
            if (trunkLength>=0.5&&trunkLength<=3) {
                this.trunkLength = trunkLength;
                MessageUtility.logSetter(getName(),"setTrunkLength",trunkLength,true);

                return true;
            }
        MessageUtility.logSetter(getName(),"setTrunkLength",trunkLength,false);
        return  false;
    }
    public double getTrunkLength()
    {
        MessageUtility.logGetter(getName(),"getTrunkLength",trunkLength);
        return this.trunkLength;
    }

    public  String toString()
    {
        return "[Elephant]:" +getName() ;
    }
}
