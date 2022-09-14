package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

public class Giraffe extends Herbivore {
    private double neckLength;
    public Giraffe(String name )
    {
        super(name,new Point(50,0));
        MessageUtility.logConstractor("Giraffe",name);
        super.setDiet(this);
        super.setWeight(450);
        setNeckLength(1.5);



    }
    public Giraffe(String name ,double trunkLength)
    {
        super(name,new Point(50,0));
        MessageUtility.logConstractor("Giraffe",name);
        super.setDiet(this);
        super.setWeight(450);
        if(!setNeckLength(trunkLength))
            setNeckLength(1.5);




    }
    public Giraffe(String name ,Point point)
    {
        super(name,point);
        MessageUtility.logConstractor("Giraffe",name);
        super.setDiet(this);
        super.setWeight(450);
        setNeckLength(1.5);

    }
    public Giraffe(String name ,Point point,double neckLength)
    {
        super(name,point);
        MessageUtility.logConstractor("Giraffe",name);
        super.setDiet(this);
        super.setWeight(450);
        if(!setNeckLength(neckLength))
            setNeckLength(1.5);

    }
    public boolean setNeckLength(double neckLength)
    {
        if (neckLength>=1&&neckLength<=2.5) {
            this.neckLength = neckLength;
            MessageUtility.logSetter(getName(),"setNeckLength",neckLength,true);
            return true;
        }
        MessageUtility.logSetter(getName(),"setNeckLength",neckLength,false);
        return  false;
    }
    public double getNeckLength()
    {
        MessageUtility.logGetter(getName(),"getNeckLength",neckLength);
        return this.neckLength;
    }
    public  String toString()
    {
        return "[Giraffe]:" +getName() ;
    }
}
